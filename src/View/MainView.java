package View;

import Entitys.Personagem;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Personagem personagem;
    private final Map<String, JPanel> paineis = new HashMap<>();

    public MainView() {
        criarJframe();
    }

    private void criarJframe() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        Menu menu = new Menu(this);
        CriarSelecaoPersonagem selecao = new CriarSelecaoPersonagem(this);
        Jogo jogo = new Jogo(this);

        JPanel painelMenu = menu.criarPainelMenu();
        JPanel painelSelecaoPersonagem = selecao.criarPainelSelecaoPersonagem();
        JPanel painelNomePersonagem = selecao.criarPainelNomePersonagem();
        JPanel painelPersonagem = selecao.criarPainelPersonagem();
        JPanel painelJogo = jogo.getPainelJogo();

        paineis.put("menu", painelMenu);
        paineis.put("selecao", painelSelecaoPersonagem);
        paineis.put("nome", painelNomePersonagem);
        paineis.put("personagem", painelPersonagem);
        paineis.put("jogo", painelJogo);

        cardPanel.add(painelMenu, "menu");
        cardPanel.add(painelSelecaoPersonagem, "selecao");
        cardPanel.add(painelNomePersonagem, "nome");
        cardPanel.add(painelPersonagem, "personagem");
        cardPanel.add(painelJogo, "jogo");

        setTitle("LZ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void configurarBotao(JButton botao) {
        botao.setPreferredSize(new Dimension(200, 50));
        botao.setBorder(null);
        botao.setFocusPainted(false);
        botao.setBackground(new Color(50, 50, 50));
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mostrarPainel(String nomePainel) {
        cardLayout.show(cardPanel, nomePainel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}