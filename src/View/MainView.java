package View;

import View.Component.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private final Map<String, JPanel> paineis = new HashMap<>();
    private Menu menu = new Menu(this);
    private ViewCriacaoPersonagem selecao = new ViewCriacaoPersonagem(this);
    private Jogo jogo;
    private static final Font FONTE_PADRAO = carregarFontePersonalizada();

    private static Font carregarFontePersonalizada() {
        try {
            InputStream is = MainView.class.getResourceAsStream("/resources/PressStart2P-Regular.ttf");
            if (is == null) {
                throw new IOException("Arquivo de fonte não encontrado");
            }
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(16f);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Consolas", Font.BOLD, 16); // fallback
        }
    }

    public static Font getFonteGlobal() {
        return FONTE_PADRAO;
    } // Fonte global

    public MainView() {
        criarJframe();
        iniciarNovoJogo();
    }

    private void criarJframe() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        ImageIcon logoOriginal = new ImageIcon(getClass().getResource("/resources/logo-wo-name.png"));
        Image imagemRedimensionada = logoOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);

        ImageIcon logoRedimensionada = new ImageIcon(imagemRedimensionada);

        add(cardPanel);
        setTitle("KING's Fall");
        setIconImage(imagemRedimensionada);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setFont(FONTE_PADRAO);

        JPanel painelMenu = menu.criarPainelMenu();
        JPanel painelClassePersonagem = selecao.painelEscolherClasse();
        JPanel painelNomePersonagem = selecao.criarPainelNomePersonagem();

        addPanel("menu", painelMenu);
        addPanel("nome", painelNomePersonagem);
        addPanel("classe", painelClassePersonagem);

        setVisible(true);
    }

    public void iniciarNovoJogo() {
        if (jogo != null) {
            cardPanel.remove(jogo.getPainelJogo());
        }
        jogo = new Jogo(this);
        addPanel("jogo", jogo.getPainelJogo());
    }


    public void mostrarPainel(String nomePainel) {
        cardLayout.show(cardPanel, nomePainel);
    }

    private void addPanel(String nome, JPanel painel) {
        paineis.put(nome, painel);
        cardPanel.add(painel, nome);
    }

    public Jogo getJogo() {
        return jogo;
    }

    public ViewCriacaoPersonagem getSelecao() {
        return selecao;
    }

    public JButton criarBotao(String texto, Color corNormal, Color corHover) {
        JButton botao = new JButton(texto);
        botao.setFocusPainted(false);

        // Define fonte e cor
        Font fonte = FONTE_PADRAO.deriveFont(18f); // Ajuste aqui se quiser outro tamanho
        botao.setFont(fonte);
        botao.setBackground(corNormal);
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Apenas padding interno + borda
        Color corBorda = new Color(180, 40, 40);
        botao.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(corBorda, 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // padding: top, left, bottom, right
        ));

        // Visual
        botao.setContentAreaFilled(true);
        botao.setOpaque(true);
        botao.setBorderPainted(true);

        // Efeito hover
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(corHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(corNormal);
            }
        });

        return botao;
    }



}
