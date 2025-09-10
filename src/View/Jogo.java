package View;

import DataBase.DataBase;
import Entitys.Habilidade;
import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Personagem;
import Interfaces.FugaInterface; // <-- ADIÇÃO: Importação necessária para fugir
import View.Component.AudioPlayer;
import View.Component.RoundedBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Jogo {
    private JPanel painelJogo;
    private JTextArea areaTexto;
    private MainView mainView;
    private Personagem jogador;
    private List<Personagem> inimigosDaBatalha;
    private Capitulo capituloAtual;
    private JLabel labelInstrucao;

    private final Semaphore semaphore = new Semaphore(0);

    private JPanel painelRodape;
    private JPanel painelBotoesCombate;
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
        areaTexto.setFont(new Font("Georgia", Font.PLAIN, 20));
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

        labelInstrucao = new JLabel("(Pressione Enter ou clique para continuar...)");
        labelInstrucao.setForeground(Color.LIGHT_GRAY);
        labelInstrucao.setHorizontalAlignment(SwingConstants.CENTER);
        labelInstrucao.setFont(new Font("Consolas", Font.ITALIC, 14));
        labelInstrucao.setBorder(new EmptyBorder(20, 0, 10, 0));
        labelInstrucao.setVisible(false);

        painelRodape.add(labelInstrucao, BorderLayout.SOUTH);

        addListeners();
    }

    private void addListeners() {
        areaTexto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                semaphore.release();
            }
        });

        painelJogo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    semaphore.release();
                }
            }
        });

        painelJogo.setFocusable(true);
    }

    private void narrarCapitulo(Capitulo capitulo, Personagem personagem) {
        labelInstrucao.setVisible(true);
        areaTexto.setText("");
        this.jogador = personagem;
        this.capituloAtual = capitulo;

        SwingUtilities.invokeLater(() -> painelJogo.requestFocusInWindow());

        SwingWorker<Void, String> narrador = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (Frase frase : capitulo.getPeriodoInicial()) {
                    publish(frase.getConteudo());
                    semaphore.acquire();
                }
                return null;
            }

            @Override
            protected void process(List<String> frases) {
                for (String f : frases) {
                    areaTexto.append(f + "\n\n");
                }
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            }

            @Override
            protected void done() {
                labelInstrucao.setVisible(false);
                if (capitulo.getInimigos() != null && !capitulo.getInimigos().isEmpty()) {
                    areaTexto.append("!!! HORA DA BATALHA !!!\n");
                    executarCombate(personagem, capitulo.getInimigos(), capitulo);
                } else {
                    continuarNarracao();
                }
            }
        };
        narrador.execute();
    }

    private void continuarNarracao() {
        labelInstrucao.setVisible(true);
        SwingWorker<Void, String> narradorPosCombate = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                for (Frase frase : capituloAtual.getPeriodoFinal()) {
                    publish(frase.getConteudo());
                    semaphore.acquire();
                }
                return null;
            }

            @Override
            protected void process(List<String> frases) {
                for (String f : frases) {
                    areaTexto.append(f + "\n\n");
                }
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            }

            @Override
            protected void done() {
                labelInstrucao.setVisible(false);
                mostrarEscolhas(capituloAtual.getProximosCapitulos(), jogador);
            }
        };
        narradorPosCombate.execute();
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

    // --- ALTERAÇÃO: Método criarBotoesCombate atualizado ---
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

            // Ação do botão Habilidade (existente)
            botaoHabilidade.addActionListener(e -> escolherHabilidade());

            // Ação do botão Item (nova)
            botaoItem.addActionListener(e -> escolherItem());

            // Ação do botão Fugir (nova)
            botaoFugir.addActionListener(e -> tentarFugir());

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
        new AudioPlayer().tocarAudio("/resources/ambientSound.wav", -50.0f);
        narrarCapitulo(historia.getInicio(), personagem);
    }

    private void executarCombate(Personagem personagem, List<Personagem> inimigos, Capitulo capitulo) {
        this.jogador = personagem;
        this.inimigosDaBatalha = inimigos;
        this.capituloAtual = capitulo;
        SwingUtilities.invokeLater(() -> {
            StringBuilder sb = new StringBuilder("Você enfrenta: \n");
            for (Personagem inimigo : inimigosDaBatalha) {
                sb.append("- ").append(inimigo.getNome()).append(" (Vida: ").append(inimigo.getPontosVida()).append(")\n");
            }
            areaTexto.append(sb.toString());
            areaTexto.append("\nO que você faz?\n");
            mostrarBotoesCombate();
        });
    }

    private void mostrarEscolhas(List<Capitulo> proximos, Personagem personagem) {
        if (proximos == null || proximos.isEmpty()) {
            areaTexto.append("Fim da jornada...\n");
            // Aqui pode ser implementado o botão de voltar ao menu/sair que discutimos
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
        List<Habilidade> habilidades = jogador.getHabilidades();
        if (habilidades.isEmpty()) {
            areaTexto.append("Você não tem habilidades para usar!\n");
            return;
        }
        String[] nomesHabilidades = habilidades.stream().map(Habilidade::getNome).toArray(String[]::new);
        String habilidadeEscolhida = (String) JOptionPane.showInputDialog(mainView, "Escolha uma habilidade:", "Habilidades", JOptionPane.QUESTION_MESSAGE, null, nomesHabilidades, nomesHabilidades[0]);
        if (habilidadeEscolhida != null) {
            Habilidade habilidadeUsada = habilidades.stream().filter(h -> h.getNome().equals(habilidadeEscolhida)).findFirst().orElse(null);
            Personagem alvo = inimigosDaBatalha.stream().filter(i -> i.getPontosVida() > 0).findFirst().orElse(null);
            if (habilidadeUsada != null && alvo != null) {
                jogador.usarHabilidade(habilidadeUsada, alvo);
                areaTexto.append("\n> Você usou " + habilidadeUsada.getNome() + " em " + alvo.getNome() + "!\n");
                areaTexto.append("  " + alvo.getNome() + " agora tem " + alvo.getPontosVida() + " de vida.\n");
                if (!verificarFimDeCombate()) {
                    turnoDosInimigos();
                }
            }
        }
    }

    // --- ADIÇÃO: Novo método para usar itens ---
    private void escolherItem() {
        List<Entitys.Consumivel> consumiveis = jogador.getConsumiveis();
        if (consumiveis == null || consumiveis.isEmpty()) {
            areaTexto.append("Você não possui itens para usar!\n");
            return;
        }
        String[] nomesItens = consumiveis.stream().map(Entitys.Consumivel::getNome).toArray(String[]::new);
        String itemEscolhido = (String) JOptionPane.showInputDialog(mainView, "Escolha um item para usar:", "Inventário de Consumíveis", JOptionPane.QUESTION_MESSAGE, null, nomesItens, nomesItens[0]);
        if (itemEscolhido != null) {
            Entitys.Consumivel consumivelUsado = consumiveis.stream().filter(c -> c.getNome().equals(itemEscolhido)).findFirst().orElse(null);
            if (consumivelUsado != null) {
                jogador.utilizarConsumivel(consumivelUsado);
                areaTexto.append("\n> Você usou " + consumivelUsado.getNome() + "!\n");
                areaTexto.append("  Sua vida agora é: " + jogador.getPontosVida() + "\n");
                if (!verificarFimDeCombate()) {
                    turnoDosInimigos();
                }
            }
        }
    }

    // --- ADIÇÃO: Novo método para tentar fugir ---
    private void tentarFugir() {
        if (jogador instanceof FugaInterface fugitivo) {
            boolean sucesso = fugitivo.fugir(inimigosDaBatalha);
            if (sucesso) {
                areaTexto.append("\n> Você conseguiu escapar!\n");
                esconderBotoesCombate();
                continuarNarracao();
            } else {
                areaTexto.append("\n> A fuga falhou! Você perdeu sua vez.\n");
                turnoDosInimigos();
            }
        } else {
            areaTexto.append("\nSeu personagem não sabe como fugir!\n");
        }
    }

    private void turnoDosInimigos() {
        painelBotoesCombate.setVisible(false);
        for (Personagem inimigo : inimigosDaBatalha) {
            if (inimigo.getPontosVida() > 0) {
                Habilidade habilidadeInimiga = inimigo.getHabilidades().getFirst();
                inimigo.usarHabilidade(habilidadeInimiga, jogador);
                areaTexto.append("> " + inimigo.getNome() + " usou " + habilidadeInimiga.getNome() + " em você!\n");
                areaTexto.append("  Sua vida: " + jogador.getPontosVida() + "\n");
                if (verificarFimDeCombate()) {
                    return;
                }
            }
        }
        areaTexto.append("\nSua vez! O que você faz?\n");
        painelBotoesCombate.setVisible(true);
    }

    private boolean verificarFimDeCombate() {
        if (jogador.getPontosVida() <= 0) {
            areaTexto.append("\n--- VOCÊ FOI DERROTADO! ---\n");
            esconderBotoesCombate();
            JOptionPane.showMessageDialog(mainView, "Fim de Jogo!");
            System.exit(0);
            return true;
        }
        boolean todosInimigosMortos = inimigosDaBatalha.stream().allMatch(i -> i.getPontosVida() <= 0);
        if (todosInimigosMortos) {
            areaTexto.append("\n--- VITÓRIA! ---\n");
            esconderBotoesCombate();
            continuarNarracao();
            return true;
        }
        return false;
    }
}