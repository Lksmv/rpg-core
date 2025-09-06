package View;

import Entitys.Personagem;
import View.Component.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private final Map<String, JPanel> paineis = new HashMap<>();
    private Menu menu = new Menu(this);
    private ViewCriacaoPersonagem selecao = new ViewCriacaoPersonagem(this);
    private Jogo jogo = new Jogo(this);

    public MainView() {
        criarJframe();
    }

    private void criarJframe() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);
        setTitle("Rpg game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setFont(new Font("Consolas", Font.BOLD, 11));

        JPanel painelMenu = menu.criarPainelMenu();
        JPanel painelClassePersonagem = selecao.painelEscolherClasse();
        JPanel painelNomePersonagem = selecao.criarPainelNomePersonagem();
        JPanel painelJogo = jogo.getPainelJogo();

        addPanel("menu", painelMenu);
        addPanel("nome", painelNomePersonagem);
        addPanel("classe", painelClassePersonagem);
        addPanel("jogo", painelJogo);

        setVisible(true);
    }

    public void configurarBotao(JButton botao) {
        botao.setPreferredSize(new Dimension(170, 40));
        botao.setFocusPainted(false);
        botao.setFont(new Font("Consolas", Font.BOLD, 14));
        botao.setBackground(new Color(50, 50, 50));
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBorder(new RoundedBorder(20));
        botao.setContentAreaFilled(false);
    }

    public void mostrarPainel(String nomePainel) {
        cardLayout.show(cardPanel, nomePainel);
    }


    private void addPanel(String nome, JPanel painel) {
        paineis.put(nome, painel);
        cardPanel.add(painel, nome);
    }


    public Menu getMenu() {
        return menu;
    }

    public ViewCriacaoPersonagem getSelecao() {
        return selecao;
    }

    public Jogo getJogo() {
        return jogo;
    }
}