package View;

import DataBase.DataBase;
import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Personagem;
import View.Component.AudioPlayer;
import View.Component.RoundedBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class Jogo {
    private JPanel painelJogo;
    private JTextArea areaTexto;
    private MainView mainView;

    private JPanel painelRodape;
    private JPanel painelBotoesCombate; // botoes de combate
    private JPanel painelEscolhas;

    public Jogo(MainView mainView) {
        this.mainView = mainView;

        painelJogo = new JPanel(new BorderLayout());
        painelJogo.setBackground(Color.BLACK);
        painelJogo.setBorder(new EmptyBorder(20, 20, 20, 20));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 18));
        areaTexto.setBackground(new Color(18, 18, 18));
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setMargin(new Insets(15, 20, 15, 20));
        areaTexto.setBorder(new RoundedBorder(15));
        areaTexto.setCaretColor(Color.WHITE);

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        painelJogo.add(scroll, BorderLayout.CENTER);

        painelRodape = new JPanel(new BorderLayout());
        painelRodape.setOpaque(false);
        painelJogo.add(painelRodape, BorderLayout.SOUTH);
        criarBotoesCombate();
    }

    private void mostrarBotoesCombate() {
        if (painelBotoesCombate != null) {
            painelBotoesCombate.setVisible(true);
        }
    }

    private void esconderBotoesCombate() {
        if (painelBotoesCombate != null) {
            painelBotoesCombate.setVisible(false);
            painelRodape.revalidate();
            painelRodape.repaint();
        }
    }

    private void criarBotoesCombate() {
        if (painelBotoesCombate == null) {
            painelBotoesCombate = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
            painelBotoesCombate.setBackground(Color.BLACK);


            JButton botaoHabilidade = new JButton("Usar Habilidade");
            mainView.configurarBotao(botaoHabilidade);

            JButton botaoItem = new JButton("Usar Item");
            mainView.configurarBotao(botaoItem);

            JButton botaoFugir = new JButton("Fugir");
            mainView.configurarBotao(botaoFugir);

            painelBotoesCombate.add(botaoHabilidade);
            painelBotoesCombate.add(botaoItem);
            painelBotoesCombate.add(botaoFugir);

            painelRodape.add(painelBotoesCombate, BorderLayout.CENTER);
        }

        painelBotoesCombate.setVisible(false);
        painelRodape.revalidate();
        painelRodape.repaint();
    }

    public JPanel getPainelJogo() {
        return painelJogo;
    }

    public void narrar(Personagem personagem) {
        DataBase db = new DataBase();
        Historia historia = db.getHistoria();
        new AudioPlayer().tocarAudio("/resources/ambientSound.wav",-50.0f);

        narrarCapitulo(historia.getInicio(), personagem);
    }

    private void narrarCapitulo(Capitulo capitulo, Personagem personagem) {
        areaTexto.setText("");

        SwingWorker<Void, String> narrador = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Parte inicial
                for (Frase frase : capitulo.getPeriodoInicial()) {
                    publish(frase.getConteudo());
                    Thread.sleep(frase.getIntervalo() * 1000L);
                }

                // Combate
                publish(" Um combate começa!");
                executarCombate(personagem);
                esconderBotoesCombate();

                // Parte final
                for (Frase frase : capitulo.getPeriodoFinal()) {
                    publish(frase.getConteudo());
                    Thread.sleep(frase.getIntervalo() * 1000L);
                }

                return null;
            }

            @Override
            protected void process(List<String> frases) {
                for (String f : frases) {
                    areaTexto.append(f + "\n");
                }
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            }

            @Override
            protected void done() {
                mostrarEscolhas(capitulo.getProximosCapitulos(), personagem);
            }
        };

        narrador.execute();
    }

    private void executarCombate(Personagem personagem) {
        mostrarBotoesCombate();
        SwingUtilities.invokeLater(() -> {
            areaTexto.append("Você enfrenta um monstro terrível!\n");
        });
    }

    private void mostrarEscolhas(List<Capitulo> proximos, Personagem personagem) {
        if (proximos == null || proximos.isEmpty()) {
            areaTexto.append("Fim da jornada...\n");
            return;
        }

        if (painelEscolhas != null) {
            painelJogo.remove(painelEscolhas);
        }

        painelEscolhas = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        painelEscolhas.setBackground(Color.BLACK);
        painelEscolhas.setBorder(new EmptyBorder(10, 10, 10, 10));

        for (Capitulo cap : proximos) {
            JButton btn = new JButton(cap.getTitulo());
            mainView.configurarBotao(btn);

            btn.addActionListener(e -> {
                painelJogo.remove(painelEscolhas);
                painelJogo.revalidate();
                painelJogo.repaint();
                narrarCapitulo(cap, personagem);
            });

            painelEscolhas.add(btn);
        }

        painelJogo.add(painelEscolhas, BorderLayout.NORTH);
        painelJogo.revalidate();
        painelJogo.repaint();
    }



}
