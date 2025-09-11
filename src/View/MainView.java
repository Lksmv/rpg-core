package View;

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
    private Jogo jogo; // ALTERADO: Não inicializa mais aqui

    public MainView() {
        criarJframe();
        iniciarNovoJogo(); // NOVO: Inicia a primeira instância do jogo
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

        // Panéis que não mudam
        JPanel painelMenu = menu.criarPainelMenu();
        JPanel painelClassePersonagem = selecao.painelEscolherClasse();
        JPanel painelNomePersonagem = selecao.criarPainelNomePersonagem();

        addPanel("menu", painelMenu);
        addPanel("nome", painelNomePersonagem);
        addPanel("classe", painelClassePersonagem);

        setVisible(true);
    }

    // NOVO: Método para criar e configurar uma nova instância do jogo
    public void iniciarNovoJogo() {
        // Remove o painel antigo se ele existir
        if (jogo != null) {
            cardPanel.remove(jogo.getPainelJogo());
        }
        // Cria um novo jogo e adiciona ao painel
        jogo = new Jogo(this);
        addPanel("jogo", jogo.getPainelJogo());
    }


    public void configurarBotao(JButton botao) {
        botao.setPreferredSize(new Dimension(170, 40));
        botao.setFocusPainted(false);
        botao.setFont(new Font("Consolas", Font.BOLD, 14));
        botao.setBackground(new Color(50, 50, 50));
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBorder(new View.Component.RoundedBorder(20));
        botao.setContentAreaFilled(false);
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
}