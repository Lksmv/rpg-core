package View;

import DataBase.DataBase;
import Entitys.Habilidade;
import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Mago;
import Entitys.Personagem;
import View.Component.RoundedBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Jogo {
    // Atributos da UI
    private final JPanel painelJogo;
    private final JTextPane areaTexto;
    private final MainView mainView;
    private final JLabel labelInstrucao;
    private final JPanel painelRodape;
    private JPanel painelEscolhas;
    private JPanel painelStatus;
    private JProgressBar barraVidaJogador;
    private JProgressBar barraManaJogador;

    // Atributos de Lógica de Jogo
    private Personagem jogador;
    private Capitulo capituloAtual;
    private final Semaphore semaphore = new Semaphore(0);
    private List<Personagem> inimigos;
    private Habilidade habilidadeSelecionada;

    // Atributos de Controle dos Painéis de Combate
    private final CardLayout layoutRodape;
    private final JPanel painelContainerBotoes;
    private final JPanel painelBotoesAcao;
    private final JPanel painelHabilidades;
    private final JPanel painelAlvos;

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
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        painelJogo.add(scroll, BorderLayout.CENTER);
        painelRodape = new JPanel(new BorderLayout());
        painelRodape.setOpaque(false);
        painelJogo.add(painelRodape, BorderLayout.SOUTH);
        layoutRodape = new CardLayout();
        painelContainerBotoes = new JPanel(layoutRodape);
        painelContainerBotoes.setOpaque(false);
        painelRodape.add(painelContainerBotoes, BorderLayout.CENTER);
        painelBotoesAcao = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        painelHabilidades = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        painelAlvos = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        criarPaineisDeCombate();
        labelInstrucao = new JLabel("(Pressione Enter ou clique para continuar...)");
        labelInstrucao.setForeground(Color.LIGHT_GRAY);
        labelInstrucao.setHorizontalAlignment(SwingConstants.CENTER);
        labelInstrucao.setFont(new Font("Consolas", Font.ITALIC, 14));
        labelInstrucao.setBorder(new EmptyBorder(20, 0, 10, 0));
        labelInstrucao.setVisible(false);
        painelRodape.add(labelInstrucao, BorderLayout.SOUTH);
        addUniversalListeners();
    }

    private void addUniversalListeners() {
        areaTexto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (labelInstrucao.isVisible()) {
                    semaphore.release();
                }
            }
        });
        painelJogo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && labelInstrucao.isVisible()) {
                    semaphore.release();
                }
            }
        });
        painelJogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                painelJogo.requestFocusInWindow();
            }
        });
        painelJogo.setFocusable(true);
    }

    private void mostrarPaineisCombate() { painelContainerBotoes.setVisible(true); }
    private void esconderPaineisCombate() { painelContainerBotoes.setVisible(false); }

    private JButton criarBotaoEstilizado(String texto, Color corFundo, Color corHover) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setFont(new Font("Consolas", Font.BOLD, 14));
        botao.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(120, 120, 120), 2, true), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { botao.setBackground(corHover); }
            public void mouseExited(java.awt.event.MouseEvent evt) { botao.setBackground(corFundo); }
        });
        return botao;
    }

    private void criarPaineisDeCombate() {
        painelBotoesAcao.setBackground(new Color(15, 15, 15));
        JButton botaoHabilidade = criarBotaoEstilizado("Usar Habilidade", new Color(70, 40, 40), new Color(120, 60, 60));
        JButton botaoItem = criarBotaoEstilizado("Usar Item", new Color(40, 70, 40), new Color(60, 120, 60));
        JButton botaoFugir = criarBotaoEstilizado("Fugir", new Color(40, 40, 70), new Color(60, 60, 120));
        botaoHabilidade.addActionListener(e -> iniciarSelecaoDeHabilidade());
        botaoItem.addActionListener(e -> usarItem());
        botaoFugir.addActionListener(e -> fugirDaBatalha());
        painelBotoesAcao.add(botaoHabilidade);
        painelBotoesAcao.add(botaoItem);
        painelBotoesAcao.add(botaoFugir);
        painelHabilidades.setBackground(new Color(15, 15, 15));
        painelAlvos.setBackground(new Color(15, 15, 15));
        painelContainerBotoes.add(painelBotoesAcao, "ACOES");
        painelContainerBotoes.add(painelHabilidades, "HABILIDADES");
        painelContainerBotoes.add(painelAlvos, "ALVOS");
        painelContainerBotoes.setVisible(false);
    }

    public JPanel getPainelJogo() { return painelJogo; }

    public void narrar(Personagem personagem) {
        narrarCapitulo(new DataBase().getHistoria().getInicio(), personagem);
    }

    private void narrarCapitulo(Capitulo capitulo, Personagem personagem) {
        labelInstrucao.setVisible(true);
        this.jogador = personagem;
        this.capituloAtual = capitulo;
        criarPainelStatus();
        atualizarBarras();
        SwingUtilities.invokeLater(() -> painelJogo.requestFocusInWindow());
        SwingWorker<Void, Map.Entry<Integer, String>> narrador = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                List<Frase> frases = capitulo.getPeriodoInicial();
                for (int i = 0; i < frases.size(); i++) {
                    publish(new AbstractMap.SimpleEntry<>(i, frases.get(i).getConteudo()));
                    semaphore.acquire();
                }
                return null;
            }
            @Override
            protected void process(List<Map.Entry<Integer, String>> chunks) {
                for (Map.Entry<Integer, String> entry : chunks) {
                    int index = entry.getKey();
                    String text = entry.getValue();
                    if (index == 0 || (index > 0 && index % 4 == 0)) {
                        areaTexto.setText("");
                    }
                    appendColoredText(text + "\n", Color.WHITE, true);
                }
            }
            @Override
            protected void done() {
                labelInstrucao.setVisible(false);
                if (capitulo.getInimigos() != null && !capitulo.getInimigos().isEmpty()) {
                    executarCombate(personagem, new ArrayList<>(capitulo.getInimigos()));
                } else {
                    continuarNarracao();
                }
            }
        };
        narrador.execute();
    }

    private void continuarNarracao() {
        labelInstrucao.setVisible(true);
        SwingWorker<Void, Map.Entry<Integer, String>> narrador = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                List<Frase> frases = capituloAtual.getPeriodoFinal();
                for (int i = 0; i < frases.size(); i++) {
                    publish(new AbstractMap.SimpleEntry<>(i, frases.get(i).getConteudo()));
                    semaphore.acquire();
                }
                return null;
            }
            @Override
            protected void process(List<Map.Entry<Integer, String>> chunks) {
                for (Map.Entry<Integer, String> entry : chunks) {
                    int index = entry.getKey();
                    String text = entry.getValue();
                    if (index == 0 || (index > 0 && index % 4 == 0)) {
                        areaTexto.setText("");
                    }
                    appendColoredText(text + "\n", Color.WHITE, true);
                }
            }
            @Override
            protected void done() {
                labelInstrucao.setVisible(false);
                mostrarEscolhas(capituloAtual.getProximosCapitulos(), jogador);
            }
        };
        narrador.execute();
    }

    private void fimDeJogo(String mensagem) {
        esconderPaineisCombate();
        Object[] options = {"Voltar ao Menu", "Sair do Jogo"};
        int escolha = JOptionPane.showOptionDialog(mainView, mensagem, "Fim da Jornada", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (escolha == JOptionPane.YES_OPTION) {
            mainView.iniciarNovoJogo();
            mainView.mostrarPainel("menu");
        } else {
            System.exit(0);
        }
    }

    private void mostrarEscolhas(List<Capitulo> proximos, Personagem personagem) {
        if (proximos == null || proximos.isEmpty()) {
            appendColoredText("\nFim da jornada...\n", Color.WHITE, true);
            Timer timer = new Timer(2000, e -> fimDeJogo("Parabéns, você completou sua jornada!"));
            timer.setRepeats(false);
            timer.start();
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

    private void executarCombate(Personagem personagem, List<Personagem> inimigos) {
        this.jogador = personagem;
        this.inimigos = new ArrayList<>(inimigos);
        Map<String, Integer> contadorNomes = new HashMap<>();
        for (Personagem inimigo : this.inimigos) {
            String nomeBase = inimigo.getNome();
            int contagem = contadorNomes.getOrDefault(nomeBase, 0) + 1;
            contadorNomes.put(nomeBase, contagem);
            if (contagem > 1) inimigo.setNome(nomeBase + " " + contagem);
        }
        appendColoredText("\n!!! HORA DA BATALHA !!!\n", Color.RED, true);
        Timer timer = new Timer(1500, e -> turnoDoJogador());
        timer.setRepeats(false);
        timer.start();
    }

    private void turnoDoJogador() {
        habilidadeSelecionada = null;
        appendColoredText("=== Seu turno ===\n", new Color(100, 150, 255), false);
        appendColoredText("Sua vida: " + Math.max(0, jogador.getPontosVida()) + "/" + jogador.getVidaMaxima() + "\n", Color.WHITE, true);
        if (jogador instanceof Mago) {
            appendColoredText("Sua mana: " + ((Mago) jogador).getMana() + "/" + ((Mago) jogador).getManaMaxima() + "\n\n", Color.CYAN, true);
        } else {
            appendColoredText("\n", Color.WHITE, true);
        }
        appendColoredText("Inimigos:\n", Color.LIGHT_GRAY, true);
        for (Personagem inimigo : inimigos) {
            if (inimigo.getPontosVida() > 0) {
                appendColoredText(" - " + inimigo.getNome() + " (Vida: " + inimigo.getPontosVida() + ")\n", Color.WHITE, true);
            }
        }
        appendColoredText("\nO que você faz?\n", Color.WHITE, true);
        layoutRodape.show(painelContainerBotoes, "ACOES");
        mostrarPaineisCombate();
    }

    private void iniciarSelecaoDeHabilidade() {
        List<Habilidade> habilidades = jogador.getHabilidades();
        if (habilidades == null || habilidades.isEmpty()) {
            appendColoredText("Você não tem habilidades para usar!\n", Color.YELLOW, true);
            return;
        }
        painelHabilidades.removeAll();
        for (Habilidade hab : habilidades) {
            JButton btnHab = criarBotaoEstilizado(hab.getNome(), new Color(70, 40, 40), new Color(120, 60, 60));
            btnHab.addActionListener(e -> iniciarSelecaoDeAlvo(hab));
            painelHabilidades.add(btnHab);
        }
        JButton btnVoltar = criarBotaoEstilizado("Voltar", new Color(80, 80, 80), new Color(110, 110, 110));
        btnVoltar.addActionListener(e -> turnoDoJogador());
        painelHabilidades.add(btnVoltar);
        appendColoredText("\nEscolha uma habilidade...\n", Color.CYAN, true);
        layoutRodape.show(painelContainerBotoes, "HABILIDADES");
        painelHabilidades.revalidate();
        painelHabilidades.repaint();
    }

    private void iniciarSelecaoDeAlvo(Habilidade habilidade) {
        if (jogador instanceof Mago && ((Mago) jogador).getMana() < habilidade.getCustoMana()) {
            appendColoredText("Mana insuficiente!\n", Color.RED, true);
            return;
        }
        this.habilidadeSelecionada = habilidade;
        painelAlvos.removeAll();
        for (Personagem inimigo : inimigos) {
            if (inimigo.getPontosVida() > 0) {
                JButton btnAlvo = criarBotaoEstilizado(inimigo.getNome(), new Color(90, 20, 20), new Color(140, 40, 40));
                btnAlvo.addActionListener(e -> executarAcaoDoJogador(inimigo));
                painelAlvos.add(btnAlvo);
            }
        }
        JButton btnVoltar = criarBotaoEstilizado("Voltar", new Color(80, 80, 80), new Color(110, 110, 110));
        btnVoltar.addActionListener(e -> iniciarSelecaoDeHabilidade());
        painelAlvos.add(btnVoltar);
        appendColoredText("\nEscolha um alvo...\n", Color.CYAN, true);
        layoutRodape.show(painelContainerBotoes, "ALVOS");
        painelAlvos.revalidate();
        painelAlvos.repaint();
    }

    private void executarAcaoDoJogador(Personagem alvo) {
        if (habilidadeSelecionada == null || alvo == null) return;
        esconderPaineisCombate();
        int vidaAntes = alvo.getPontosVida();
        boolean foiCritico = jogador.usarHabilidade(habilidadeSelecionada, alvo);
        appendColoredText("", Color.WHITE, false);
        appendColoredText("> Você usou " + habilidadeSelecionada.getNome() + " em " + alvo.getNome() + "!\n", Color.ORANGE, true);
        if (foiCritico) appendColoredText("!!! ACERTO CRÍTICO !!!\n", Color.RED, true);
        appendColoredText("  " + alvo.getNome() + " agora tem " + Math.max(0, alvo.getPontosVida()) + " de vida.\n", Color.LIGHT_GRAY, true);
        atualizarBarras();
        if (alvo.getPontosVida() <= 0 && vidaAntes > 0) {
            appendColoredText("\n--- Derrotado " + alvo.getNome() + "! ---\n", Color.GREEN, true);
            inimigos.remove(alvo);
        }
        habilidadeSelecionada = null;
        if (!verificarFimDeCombate()) {
            Timer timer = new Timer(2000, e -> turnoDosInimigos());
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void turnoDosInimigos() {
        esconderPaineisCombate();
        if (verificarFimDeCombate()) return;
        appendColoredText("\n=== Turno dos Inimigos ===\n", new Color(255, 80, 80), true);

        final int delayEntreAtaques = 1500;
        int i = 0;
        for (Personagem inimigo : new ArrayList<>(inimigos)) {
            if (inimigo.getPontosVida() > 0) {
                Timer timer = new Timer(delayEntreAtaques * i, e -> {
                    if (jogador.getPontosVida() > 0) {
                        Habilidade habilidadeInimiga = inimigo.getHabilidades().getFirst();
                        boolean foiCritico = inimigo.usarHabilidade(habilidadeInimiga, jogador);
                        appendColoredText("> " + inimigo.getNome() + " usou " + habilidadeInimiga.getNome() + " em você!\n", new Color(255, 100, 100), true);
                        if (foiCritico) {
                            appendColoredText("!!! O INIMIGO ACERTOU UM GOLPE CRÍTICO !!!\n", Color.RED, true);
                        }
                        appendColoredText("  Sua vida: " + Math.max(0, jogador.getPontosVida()) + "\n", Color.LIGHT_GRAY, true);
                        atualizarBarras();
                        verificarFimDeCombate();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                i++;
            }
        }

        Timer proximoTurnoTimer = new Timer(delayEntreAtaques * i + 500, e -> {
            if (!verificarFimDeCombate()) {
                turnoDoJogador();
            }
        });
        proximoTurnoTimer.setRepeats(false);
        proximoTurnoTimer.start();
    }

    private boolean verificarFimDeCombate() {
        if (jogador.getPontosVida() <= 0) {
            appendColoredText("\n--- VOCÊ FOI DERROTADO! ---\n", Color.RED, true);
            Timer timer = new Timer(1500, e -> fimDeJogo("Você foi derrotado!"));
            timer.setRepeats(false);
            timer.start();
            return true;
        }
        if (inimigos.stream().allMatch(i -> i.getPontosVida() <= 0)) {
            appendColoredText("\n--- VITÓRIA! ---\n", Color.GREEN, true);
            esconderPaineisCombate();
            Timer timer = new Timer(1500, e -> continuarNarracao());
            timer.setRepeats(false);
            timer.start();
            return true;
        }
        return false;
    }

    private void usarItem() {
        String pocaoVida = "Poção de Cura (+30 HP) x" + jogador.getQntPocaoVida();
        String pocaoMana = "Elixir Mágico (+20 MP) x" + jogador.getQntPocaoMana();
        String[] inventario = {pocaoVida, pocaoMana};
        String itemEscolhido = (String) JOptionPane.showInputDialog(mainView, "Escolha um item:", "Inventário", JOptionPane.QUESTION_MESSAGE, null, inventario, inventario[0]);
        if (itemEscolhido != null) {
            if (itemEscolhido.contains("Cura")) {
                if (jogador.getQntPocaoVida() > 0) {
                    jogador.setPontosVida(Math.min(jogador.getVidaMaxima(), jogador.getPontosVida() + 30));
                    jogador.setQntPocaoVida(jogador.getQntPocaoVida() - 1);
                    appendColoredText("\n🧪 Você usou uma Poção de Cura!\n", Color.GREEN, false);
                    finalizarAcaoAposItem();
                } else {
                    JOptionPane.showMessageDialog(mainView, "Você não tem mais Poções de Cura!");
                }
            } else if (itemEscolhido.contains("Elixir")) {
                if (jogador.getQntPocaoMana() > 0) {
                    if (jogador instanceof Mago) {
                        Mago mago = (Mago) jogador;
                        mago.setMana(Math.min(mago.getManaMaxima(), mago.getMana() + 20));
                        jogador.setQntPocaoMana(jogador.getQntPocaoMana() - 1);
                        appendColoredText("\n🧪 Você usou um Elixir Mágico!\n", Color.CYAN, false);
                        finalizarAcaoAposItem();
                    }
                } else {
                    JOptionPane.showMessageDialog(mainView, "Você não tem mais Elixires Mágicos!");
                }
            }
        }
    }

    private void finalizarAcaoAposItem() {
        esconderPaineisCombate();
        atualizarBarras();
        appendColoredText("Sua vida: " + jogador.getPontosVida() + "\n", Color.WHITE, true);
        if (jogador instanceof Mago) {
            appendColoredText("Sua mana: " + ((Mago) jogador).getMana() + "\n", Color.WHITE, true);
        }
        Timer timer = new Timer(2000, e -> turnoDosInimigos());
        timer.setRepeats(false);
        timer.start();
    }

    private void fugirDaBatalha() {
        int confirm = JOptionPane.showConfirmDialog(mainView, "Tem certeza que deseja fugir? Isso contará como derrota!", "Confirmar Fuga", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            esconderPaineisCombate();
            appendColoredText("\n🏃 Você fugiu da batalha...\n", Color.CYAN, false);
            Timer timer = new Timer(2000, e -> fimDeJogo("Você fugiu e perdeu a honra."));
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void criarPainelStatus() {
        if (painelStatus == null) {
            painelStatus = new JPanel();
            painelStatus.setLayout(new BoxLayout(painelStatus, BoxLayout.Y_AXIS));
            painelStatus.setBackground(Color.BLACK);
            painelStatus.setBorder(new EmptyBorder(10, 10, 10, 10));
            barraVidaJogador = new JProgressBar(0, 100);
            barraVidaJogador.setForeground(Color.RED);
            barraVidaJogador.setStringPainted(true);
            barraManaJogador = new JProgressBar(0, 100);
            barraManaJogador.setForeground(Color.BLUE);
            barraManaJogador.setStringPainted(true);
            painelStatus.add(barraVidaJogador);
            painelStatus.add(barraManaJogador);
            painelRodape.add(painelStatus, BorderLayout.NORTH);
        }
    }

    private void atualizarBarras() {
        if (jogador == null) return;
        barraVidaJogador.setMaximum(jogador.getVidaMaxima());
        barraVidaJogador.setValue(Math.max(0, jogador.getPontosVida()));
        barraVidaJogador.setString("HP: " + Math.max(0, jogador.getPontosVida()) + "/" + jogador.getVidaMaxima());
        boolean isMago = jogador instanceof Mago;
        barraManaJogador.setVisible(isMago);
        if (isMago) {
            Mago mago = (Mago) jogador;
            barraManaJogador.setMaximum(mago.getManaMaxima());
            barraManaJogador.setValue(Math.max(0, mago.getMana()));
            barraManaJogador.setString("MP: " + Math.max(0, mago.getMana()) + "/" + mago.getManaMaxima());
        }
    }

    private void appendColoredText(String text, Color color, boolean append) {
        if (!append) areaTexto.setText("");
        StyledDocument doc = areaTexto.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, color);
        try {
            doc.insertString(doc.getLength(), text, attr);
            areaTexto.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}