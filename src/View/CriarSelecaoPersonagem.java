package View;

import Entitys.Arqueiro;
import Entitys.Lutador;
import Entitys.Mago;
import Entitys.Personagem;

import javax.swing.*;
import java.awt.*;

public class CriarSelecaoPersonagem {
    private final MainView mainView;
    private String nomePersonagem;
    private Personagem personagem;

    public CriarSelecaoPersonagem(MainView mainView) {
        this.mainView = mainView;
    }

    public JPanel criarPainelSelecaoPersonagem() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        gbc.gridy = 0;
        JButton botaoMago = new JButton("Mago");
        mainView.configurarBotao(botaoMago);
        painel.add(botaoMago, gbc);

        gbc.gridy = 1;
        JButton botaoLutador = new JButton("Lutador");
        mainView.configurarBotao(botaoLutador);
        painel.add(botaoLutador, gbc);

        gbc.gridy = 2;
        JButton botaoArqueiro = new JButton("Arqueiro");
        mainView.configurarBotao(botaoArqueiro);
        painel.add(botaoArqueiro, gbc);

        botaoMago.addActionListener(e -> {
            this.personagem = new Mago(nomePersonagem);
            mainView.mostrarPainel("personagem");
        });

        botaoArqueiro.addActionListener(e -> {
            this.personagem = new Arqueiro(nomePersonagem);
            mainView.mostrarPainel("personagem");
        });

        botaoLutador.addActionListener(e -> {
            this.personagem = new Lutador(nomePersonagem);
            mainView.mostrarPainel("personagem");
        });

        return painel;
    }

    public JPanel criarPainelPersonagem() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        JButton botaoConfirmar = new JButton("Confirmar");
        mainView.configurarBotao(botaoConfirmar);
        gbc.gridy = 0;
        painel.add(botaoConfirmar, gbc);

        JButton botaoVoltar = new JButton("Voltar");
        mainView.configurarBotao(botaoVoltar);
        gbc.gridy = 1;
        painel.add(botaoVoltar, gbc);

        botaoConfirmar.addActionListener(e -> mainView.mostrarPainel("nome"));
        botaoVoltar.addActionListener(e -> mainView.mostrarPainel("selecao"));

        return painel;
    }

    public JPanel criarPainelNomePersonagem() {
        JPanel painelNomePersonagem = new JPanel(new GridBagLayout());
        painelNomePersonagem.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel labelNome = new JLabel("Digite o nome do seu personagem:");
        labelNome.setForeground(Color.WHITE);
        labelNome.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0;
        painelNomePersonagem.add(labelNome, gbc);

        JTextField campoNome = new JTextField(20);
        campoNome.setForeground(Color.WHITE);
        campoNome.setFont(new Font("Arial", Font.BOLD, 20));
        campoNome.setBackground(Color.BLACK);
        campoNome.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridy = 1;
        painelNomePersonagem.add(campoNome, gbc);

        JButton botaoConfirmar = new JButton("Confirmar");
        mainView.configurarBotao(botaoConfirmar);
        gbc.gridy = 2;
        painelNomePersonagem.add(botaoConfirmar, gbc);

        botaoConfirmar.addActionListener(e -> {
            nomePersonagem = campoNome.getText();
            System.out.println("Nome do personagem definido como: " + nomePersonagem);
            mainView.mostrarPainel("jogo");
        });

        return painelNomePersonagem;
    }
}
