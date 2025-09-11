package View;

import DataBase.DataBase;
import Entitys.Habilidade;
import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Inimigo;
import Entitys.Mago;
import Entitys.Personagem;
import View.Component.AudioPlayer;
import View.Component.RoundedBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Jogo {
    private final JPanel painelJogo;
    private final JTextPane areaTexto;
    private final MainView mainView;
    private Personagem jogador;
    private List<Personagem> inimigosDaBatalha;
    private Capitulo capituloAtual;
    private final JLabel labelInstrucao;
    private final Semaphore semaphore = new Semaphore(0);
    private List<Personagem> inimigos;

    private final JPanel painelRodape;
    private JPanel painelBotoesCombate; // botoes de combate
    private JPanel painelEscolhas;
    private JPanel painelStatus;
    private JProgressBar barraVidaJogador;
    private JProgressBar barraManaJogador;


    public Jogo(MainView mainView) {
        this.mainView = mainView;

        painelJogo = new JPanel(new BorderLayout());
        painelJogo.setBackground(Color.BLACK);
        painelJogo.setBorder(new EmptyBorder(20, 20, 20, 20));

        areaTexto = new JTextPane();
        areaTexto.setEditable(false);
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

    private JButton criarBotaoEstilizado(String texto, Color corFundo, Color corHover) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setFont(new Font("Consolas", Font.BOLD, 14));
        botao.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(120, 120, 120), 2, true),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(corHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(corFundo);
            }
        });

        return botao;
    }

    private void criarBotoesCombate() {
        if (painelBotoesCombate == null) {
            painelBotoesCombate = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
            painelBotoesCombate.setBackground(new Color(15, 15, 15));

            JButton botaoHabilidade = criarBotaoEstilizado(" Usar Habilidade", new Color(70, 40, 40), new Color(120, 60, 60));
            JButton botaoItem = criarBotaoEstilizado(" Usar Item", new Color(40, 70, 40), new Color(60, 120, 60));
            JButton botaoFugir = criarBotaoEstilizado(" Fugir", new Color(40, 40, 70), new Color(60, 60, 120));

            botaoHabilidade.addActionListener(e -> escolherHabilidade());
            botaoItem.addActionListener(e -> usarItem());
            botaoFugir.addActionListener(e -> fugirDaBatalha());

            painelBotoesCombate.add(botaoHabilidade);
            painelBotoesCombate.add(botaoItem);
            painelBotoesCombate.add(botaoFugir);

            painelRodape.add(painelBotoesCombate, BorderLayout.CENTER);
        }

        painelBotoesCombate.setVisible(false);
    }

    public JPanel getPainelJogo() {
        return painelJogo;
    }

    public void narrar(Personagem personagem) {
        DataBase db = new DataBase();
        Historia historia = db.getHistoria();

        try {
            new AudioPlayer().tocarAudio("/resources/ambientSound.wav", -50.0f);
        } catch (Exception ex) {
            System.err.println("Aviso: erro ao tocar som de fundo: " + ex.getMessage());
        }

        narrarCapitulo(historia.getInicio(), personagem);
    }

    private void narrarCapitulo(Capitulo capitulo, Personagem personagem) {
        labelInstrucao.setVisible(true);
        areaTexto.setText("");
        this.jogador = personagem;
        this.capituloAtual = capitulo;
        criarPainelStatus();
        atualizarBarras();

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
                    appendColoredText(f + "\n", Color.WHITE);
                }
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            }

            @Override
            protected void done() {
                labelInstrucao.setVisible(false);
                if (capitulo.getInimigos() != null && !capitulo.getInimigos().isEmpty()) {
                    appendColoredText("\n!!! HORA DA BATALHA !!!\n", Color.WHITE);
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
                    appendColoredText(f + "\n", Color.WHITE);
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

    private void executarCombate(Personagem personagem, List<Personagem> inimigos, Capitulo capitulo) {
        this.jogador = personagem;
        this.inimigosDaBatalha = inimigos;
        this.capituloAtual = capitulo;

        this.inimigos = new ArrayList<>(inimigos);

        Map<String, Integer> contadorNomes = new HashMap<>();
        for (Personagem inimigo : inimigosDaBatalha) {
            String nomeBase = inimigo.getNome();
            int contagem = contadorNomes.getOrDefault(nomeBase, 0) + 1;
            contadorNomes.put(nomeBase, contagem);
            // Se houver mais de um com o mesmo nome, adiciona o número
            if (contadorNomes.keySet().stream().anyMatch(key -> contadorNomes.get(key) > 1)) {
                inimigo.setNome(nomeBase + " " + contagem);
            }
        }

        SwingUtilities.invokeLater(() -> {
            appendColoredText("Você enfrenta: \n", Color.WHITE);
            for (Personagem inimigo : inimigosDaBatalha) {
                appendColoredText("- " + inimigo.getNome() + " (Vida: " + inimigo.getPontosVida() + ")\n", Color.WHITE);
            }
            appendColoredText("\nO que você faz?\n", Color.WHITE);
            mostrarBotoesCombate();
        });
    }

    private void mostrarEscolhas(List<Capitulo> proximos, Personagem personagem) {
        if (proximos == null || proximos.isEmpty()) {
            appendColoredText("\nFim da jornada...\n", Color.WHITE);
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
        if (jogador == null) {
            appendColoredText("Erro: jogador não definido.\n", Color.WHITE);
            return;
        }

        List<Habilidade> habilidades = jogador.getHabilidades();
        if (habilidades == null || habilidades.isEmpty()) {
            appendColoredText("Você não tem habilidades para usar!\n", Color.WHITE);
            return;
        }

        String[] nomesHabilidades = habilidades.stream()
                .map(Habilidade::getNome)
                .toArray(String[]::new);

        String habilidadeEscolhida = (String) JOptionPane.showInputDialog(
                mainView,
                "Escolha uma habilidade:",
                "Habilidades",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nomesHabilidades,
                nomesHabilidades.length > 0 ? nomesHabilidades[0] : null
        );

        if (habilidadeEscolhida == null) return;

        // 2. Escolher o Alvo
        String[] nomesInimigosVivos = inimigos.stream().map(Personagem::getNome).toArray(String[]::new);
        if (nomesInimigosVivos.length == 0) return;

        String alvoEscolhido = (String) JOptionPane.showInputDialog(mainView, "Escolha um alvo:", "Alvos", JOptionPane.QUESTION_MESSAGE, null, nomesInimigosVivos, nomesInimigosVivos[0]);

        if (alvoEscolhido == null) return;

        // 3. Executar Ação
        Habilidade habilidadeUsada = habilidades.stream().filter(h -> h.getNome().equals(habilidadeEscolhida)).findFirst().orElse(null);
        Personagem alvo = inimigos.stream().filter(i -> i.getNome().equals(alvoEscolhido)).findFirst().orElse(null);

        if (habilidadeUsada != null && alvo != null) {
            int vidaAntes = alvo.getPontosVida();
            boolean foiCritico = jogador.usarHabilidade(habilidadeUsada, alvo);

            appendColoredText("\n> Você usou " + habilidadeUsada.getNome() + " em " + alvo.getNome() + "!\n", Color.WHITE);
            if (foiCritico) {
                appendColoredText("!!! ACERTO CRÍTICO !!!\n", Color.RED); // <-- ALTERADO PARA VERMELHO
            }
            appendColoredText("  " + alvo.getNome() + " agora tem " + alvo.getPontosVida() + " de vida.\n", Color.WHITE);

            if (alvo.getPontosVida() <= 0 && vidaAntes > 0) {
                appendColoredText("--- Derrotado " + alvo.getNome() + "! ---\n", Color.WHITE);
                inimigos.remove(alvo);
            }

            if (!verificarFimDeCombate()) {
                turnoDosInimigos();
            }
        }

    }

    private void turnoDoJogador() {
        areaTexto.setText(""); // limpa tela
        appendColoredText("=== Seu turno ===\n", Color.WHITE);
        appendColoredText("Sua vida: " + Math.max(0, jogador.getPontosVida()) + "\n\n", Color.WHITE);

        // Mostrar inimigos vivos
        appendColoredText("Inimigos:\n", Color.WHITE);
        for (Personagem inimigo : inimigosDaBatalha) {
            if (inimigo.getPontosVida() > 0) {
                appendColoredText(" - " + inimigo.getNome() + " (Vida: " + inimigo.getPontosVida() + ")\n", Color.WHITE);
            }
        }
        appendColoredText("\nO que você faz?\n", Color.WHITE);

        mostrarBotoesCombate();
    }

    private void turnoDosInimigos() {
        painelBotoesCombate.setVisible(false);
        for (Personagem inimigo : inimigosDaBatalha) {
            if (inimigo.getPontosVida() > 0) {

                if (inimigo.getHabilidades() != null && !inimigo.getHabilidades().isEmpty()) {
                    Habilidade habilidadeInimiga = inimigo.getHabilidades().getFirst();
                    boolean foiCritico = inimigo.usarHabilidade(habilidadeInimiga, jogador);

                    appendColoredText("> " + inimigo.getNome() + " usou " + habilidadeInimiga.getNome() + " em você!\n", Color.WHITE);
                    if (foiCritico) {
                        appendColoredText("!!! O INIMIGO ACERTOU UM GOLPE CRÍTICO !!!\n", Color.RED);
                    }

                } else {
                    int danoBasico = inimigo.getForca() - jogador.getDefesa();
                    if (danoBasico < 0) danoBasico = 0;
                    jogador.setPontosVida(jogador.getPontosVida() - danoBasico);
                    appendColoredText("> " + inimigo.getNome() + " usou um Ataque Básico!\n", Color.WHITE);
                }

                appendColoredText("  Sua vida: " + jogador.getPontosVida() + "\n", Color.WHITE);
                if (verificarFimDeCombate()) {
                    return;
                }

            }
            appendColoredText("\nSua vez! O que você faz?\n", Color.WHITE);
            atualizarBarras();
            painelBotoesCombate.setVisible(true);
        }
        turnoDoJogador();
    }

    private boolean verificarFimDeCombate() {
        if (jogador == null) return true;

        if (jogador.getPontosVida() <= 0) {
            appendColoredText("\n--- VOCÊ FOI DERROTADO! ---\n", Color.WHITE);
            esconderBotoesCombate();
            JOptionPane.showMessageDialog(mainView, "Fim de Jogo!");
            // não finalizo a JVM abruptamente; se quiser, descomente System.exit(0);
            // System.exit(0);
            return true;
        }

        boolean todosInimigosMortos = (inimigosDaBatalha == null) || inimigosDaBatalha.stream().allMatch(i -> i.getPontosVida() <= 0);
        if (todosInimigosMortos) {
            appendColoredText("\n--- VITÓRIA! ---\n", Color.WHITE);
            esconderBotoesCombate();
            continuarNarracao();
            return true;
        }

        return false;
    }

    private void usarItem() {
        String[] inventario = {"Poção de Cura (+30 HP)", "Elixir Mágico (+20 MP)"};

        String itemEscolhido = (String) JOptionPane.showInputDialog(
                mainView,
                "Escolha um item:",
                "Inventário",
                JOptionPane.QUESTION_MESSAGE,
                null,
                inventario,
                inventario[0]
        );

        if (itemEscolhido != null) {
            if (itemEscolhido.contains("Cura")) {
                jogador.setPontosVida(jogador.getPontosVida() + 30);
                appendColoredText("\n🧪 Você usou uma Poção de Cura! (+30 HP)\n", Color.WHITE);
                appendColoredText("  Sua vida: " + jogador.getPontosVida() + "\n", Color.WHITE);
            } else if (itemEscolhido.contains("Elixir")) {
                ((Mago) jogador).setMana(((Mago) jogador).getMana() + 20);
                appendColoredText("\n🧪 Você usou um Elixir Mágico! (+20 MP)\n", Color.WHITE);
                appendColoredText("  Sua mana: " + ((Mago) jogador).getMana() + "\n", Color.WHITE);
            }

            turnoDosInimigos();
        }
    }

    private void fugirDaBatalha() {
        int confirm = JOptionPane.showConfirmDialog(
                mainView,
                "Tem certeza que deseja fugir? Isso contará como derrota!",
                "Confirmar Fuga",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            appendColoredText("\n🏃 Você fugiu da batalha...\n", Color.CYAN);
            esconderBotoesCombate();
            JOptionPane.showMessageDialog(mainView, "Fim de Jogo! Você perdeu ao fugir.");
        }
    }


    private void criarPainelStatus() {
        if (painelStatus == null) { // cria apenas uma vez
            painelStatus = new JPanel(new GridLayout(2, 1));
            painelStatus.setBackground(Color.BLACK);
            painelStatus.setBorder(new EmptyBorder(10, 10, 10, 10));

            barraVidaJogador = new JProgressBar(0, jogador.getVidaMaxima());
            barraVidaJogador.setForeground(Color.RED);
            barraVidaJogador.setStringPainted(true);

            barraManaJogador = new JProgressBar(0, jogador.getManaMaxima());
            barraManaJogador.setForeground(Color.BLUE);
            barraManaJogador.setStringPainted(true);

            painelStatus.add(barraVidaJogador);
            painelStatus.add(barraManaJogador);

            painelRodape.add(painelStatus, BorderLayout.NORTH);
            painelRodape.revalidate();
            painelRodape.repaint();
        }
    }

    private void atualizarBarras() {
        if (jogador == null) return;

        barraVidaJogador.setMaximum(jogador.getVidaMaxima());
        barraVidaJogador.setValue(Math.max(0, jogador.getPontosVida()));
        barraVidaJogador.setString("HP: " + Math.max(0, jogador.getPontosVida()) + "/" + jogador.getVidaMaxima());

        if (jogador instanceof Mago) {
            Mago mago = (Mago) jogador;
            barraManaJogador.setMaximum(mago.getManaMaxima());
            barraManaJogador.setValue(Math.max(0, mago.getMana()));
            barraManaJogador.setString("MP: " + Math.max(0, mago.getMana()) + "/" + mago.getManaMaxima());
        } else {
            barraManaJogador.setValue(0);
            barraManaJogador.setString("MP: 0/0");
        }

        painelStatus.revalidate();
        painelStatus.repaint();
    }


    private void appendColoredText(String text, Color color) {
        // Pega o documento do JTextPane
        javax.swing.text.StyledDocument doc = areaTexto.getStyledDocument();
        // Cria um conjunto de atributos para a cor
        javax.swing.text.SimpleAttributeSet attr = new javax.swing.text.SimpleAttributeSet();
        javax.swing.text.StyleConstants.setForeground(attr, color);
        try {
            // Insere o texto com os atributos definidos
            doc.insertString(doc.getLength(), text, attr);
            // Garante que o scroll vá para o final
            areaTexto.setCaretPosition(doc.getLength());
        } catch (javax.swing.text.BadLocationException e) {
            e.printStackTrace();
        }
    }
}
