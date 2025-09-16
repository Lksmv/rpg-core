package View;

import javax.swing.*;
import java.awt.*;

public class Menu {
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

        // Carregar a imagem da logo
        ImageIcon logoOriginal = new ImageIcon(getClass().getResource("/resources/logo-obg.png"));

        // Redimensionar a imagem
        Image imagem = logoOriginal.getImage(); // Obtemos a imagem do ImageIcon
        Image imagemRedimensionada = imagem.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Novo tamanho (300x300 pixels)

        // Criar um novo ImageIcon com a imagem redimensionada
        ImageIcon logoRedimensionada = new ImageIcon(imagemRedimensionada);

        // Usar o ImageIcon redimensionado no JLabel
        JLabel titulo = new JLabel(logoRedimensionada);

        // Definir o layout para o título (Imagem)
        gbc.gridy = 0;
        painelFundo.add(titulo, gbc);

        // Botões "Jogar" e "Sair"
        gbc.gridy = 1;
        JButton botaoJogar = mainView.criarBotao("Jogar",new Color(185,73,71,255), new Color(90, 60, 30));
        painelFundo.add(botaoJogar, gbc);

        gbc.gridy = 2;
        JButton botaoSair = mainView.criarBotao("Sair",new Color(185,73,71,255), new Color(90, 60, 30));
        painelFundo.add(botaoSair, gbc);

        botaoJogar.addActionListener(e -> mainView.mostrarPainel("nome"));
        botaoSair.addActionListener(e -> System.exit(0));

        return painelFundo;
    }
}
