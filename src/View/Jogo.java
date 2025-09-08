package View;

import DataBase.DataBase;
import Entitys.Habilidade;
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
    private Personagem jogador;
    private List<Personagem> inimigosDaBatalha;
    private Capitulo capituloAtual;
    private int inimigoAtualIndex = 0; // Para controlar qual inimigo ataca

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

            // AÇÃO DO BOTÃO HABILIDADE
            botaoHabilidade.addActionListener(e -> {
                escolherHabilidade();
            });

            // AÇÃO DO BOTÃO ITEM (Ainda a implementar)
            botaoItem.addActionListener(e -> {
                JOptionPane.showMessageDialog(mainView, "Função ainda não implementada!");
            });

            // AÇÃO DO BOTÃO FUGIR (Ainda a implementar)
            botaoFugir.addActionListener(e -> {
                JOptionPane.showMessageDialog(mainView, "Função ainda não implementada!");
            });


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
        this.jogador = personagem; // Garante que o jogador está sempre atualizado
        this.capituloAtual = capitulo; // Garante que o capítulo atual está definido

        SwingWorker<Void, String> narrador = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Parte inicial (antes do combate)
                for (Frase frase : capitulo.getPeriodoInicial()) {
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
                // Quando a narração inicial termina, verifica se há combate
                if (capitulo.getInimigos() != null && !capitulo.getInimigos().isEmpty()) {
                    areaTexto.append("\n!!! HORA DA BATALHA !!!\n");
                    executarCombate(personagem, capitulo.getInimigos(), capitulo);
                } else {
                    // Se não tem inimigos, continua a narração final e mostra as escolhas
                    continuarNarracao();
                }
            }
        };

        narrador.execute();
    }

    private void executarCombate(Personagem personagem, List<Personagem> inimigos, Capitulo capitulo) {
        this.jogador = personagem;
        this.inimigosDaBatalha = inimigos;
        this.capituloAtual = capitulo;
        this.inimigoAtualIndex = 0;

        // Limpa a tela e mostra informações iniciais
        SwingUtilities.invokeLater(() -> {
            areaTexto.append("Você enfrenta: \n");
            for (Personagem inimigo : inimigosDaBatalha) {
                areaTexto.append("- " + inimigo.getNome() + " (Vida: " + inimigo.getPontosVida() + ")\n");
            }
            areaTexto.append("\nO que você faz?\n");
            mostrarBotoesCombate();
        });
    }

    private void mostrarEscolhas(List<Capitulo> proximos, Personagem personagem) {
        if (proximos == null || proximos.isEmpty()) {
            areaTexto.append("\nFim da jornada...\n");
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

    private void escolherHabilidade() {
        // Pega as habilidades do jogador
        List<Habilidade> habilidades = jogador.getHabilidades();
        if (habilidades.isEmpty()) {
            areaTexto.append("Você não tem habilidades para usar!\n");
            return;
        }

        // Cria uma lista de nomes de habilidades para mostrar no dialogo
        String[] nomesHabilidades = habilidades.stream()
                .map(Habilidade::getNome)
                .toArray(String[]::new);

        // Mostra um dialogo para o jogador escolher a habilidade
        String habilidadeEscolhida = (String) JOptionPane.showInputDialog(
                mainView,
                "Escolha uma habilidade:",
                "Habilidades",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nomesHabilidades,
                nomesHabilidades[0]
        );

        // Se o jogador escolheu uma...
        if (habilidadeEscolhida != null) {
            // Pega a habilidade correspondente
            Habilidade habilidadeUsada = habilidades.stream()
                    .filter(h -> h.getNome().equals(habilidadeEscolhida))
                    .findFirst()
                    .orElse(null);

            // TODO: Deixar o jogador escolher o alvo se houver mais de um inimigo
            Personagem alvo = inimigosDaBatalha.stream().filter(i -> i.getPontosVida() > 0).findFirst().orElse(null);

            if (habilidadeUsada != null && alvo != null) {
                // Usa a habilidade
                jogador.usarHabilidade(habilidadeUsada, alvo);
                areaTexto.append("\n> Você usou " + habilidadeUsada.getNome() + " em " + alvo.getNome() + "!\n");
                areaTexto.append("  " + alvo.getNome() + " agora tem " + alvo.getPontosVida() + " de vida.\n");

                // Verifica se o combate acabou, senão, passa o turno
                if (!verificarFimDeCombate()) {
                    turnoDosInimigos();
                }
            }
        }
    }


    private void turnoDosInimigos() {
        // Desabilita os botões para o jogador não clicar
        painelBotoesCombate.setVisible(false);

        // Para cada inimigo vivo...
        for (Personagem inimigo : inimigosDaBatalha) {
            if (inimigo.getPontosVida() > 0) {
                // IA Simples: Usa a primeira habilidade no jogador
                Habilidade habilidadeInimiga = inimigo.getHabilidades().getFirst();
                inimigo.usarHabilidade(habilidadeInimiga, jogador);

                areaTexto.append("> " + inimigo.getNome() + " usou " + habilidadeInimiga.getNome() + " em você!\n");
                areaTexto.append("  Sua vida: " + jogador.getPontosVida() + "\n");

                // Verifica se o combate acabou após o ataque do inimigo
                if (verificarFimDeCombate()) {
                    return; // Se o combate acabou, para o turno dos inimigos
                }
            }
        }

        // Se o combate não acabou, é o turno do jogador de novo
        areaTexto.append("\nSua vez! O que você faz?\n");
        painelBotoesCombate.setVisible(true); // Reabilita os botões
    }

    private boolean verificarFimDeCombate() {
        // Verifica se o jogador foi derrotado
        if (jogador.getPontosVida() <= 0) {
            areaTexto.append("\n--- VOCÊ FOI DERROTADO! ---\n");
            esconderBotoesCombate();
            JOptionPane.showMessageDialog(mainView, "Fim de Jogo!");
            System.exit(0);
            return true;
        }

        // Verifica se todos os inimigos foram derrotados
        boolean todosInimigosMortos = inimigosDaBatalha.stream().allMatch(i -> i.getPontosVida() <= 0);
        if (todosInimigosMortos) {
            areaTexto.append("\n--- VITÓRIA! ---\n");
            esconderBotoesCombate();
            // Aqui você pode adicionar recompensas (XP, moedas, itens)

            // Continua a história
            continuarNarracao();
            return true;
        }

        return false;
    }

    private void continuarNarracao() {
        // Este método vai continuar o SwingWorker de onde parou.
        // Ele será chamado quando o combate terminar com vitória.

        SwingWorker<Void, String> narradorPosCombate = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Pausa para o jogador ler o resultado da batalha
                Thread.sleep(2000);

                // Parte final do capítulo
                for (Frase frase : capituloAtual.getPeriodoFinal()) {
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
                // Mostra as escolhas para o próximo capítulo
                mostrarEscolhas(capituloAtual.getProximosCapitulos(), jogador);
            }
        };

        narradorPosCombate.execute();
    }
}