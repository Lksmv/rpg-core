package View;

import javax.swing.*;
import java.awt.*;

public class Menu{
    private final MainView mainView;

    public Menu(MainView mainView) {
        this.mainView = mainView;
    }

    public JPanel criarPainelMenu() {
        JPanel painelFundo = new JPanel(new GridBagLayout());
        painelFundo.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel titulo = new JLabel("<html><font color='white'>Legends of Zelda</font></html>");
        titulo.setFont(new Font("Arial", Font.BOLD, 48));
        gbc.gridy = 0;
        painelFundo.add(titulo, gbc);

        gbc.gridy = 1;
        JButton botaoJogar = new JButton("Jogar");
        mainView.configurarBotao(botaoJogar);
        painelFundo.add(botaoJogar, gbc);

        gbc.gridy = 2;
        JButton botaoSair = new JButton("Sair");
        mainView.configurarBotao(botaoSair);
        painelFundo.add(botaoSair, gbc);

        botaoJogar.addActionListener(e -> mainView.mostrarPainel("selecao"));
        botaoSair.addActionListener(e -> System.exit(0));

        return painelFundo;
    }
}
