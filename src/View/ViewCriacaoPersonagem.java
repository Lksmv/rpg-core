package View;

import Entitys.Arqueiro;
import Entitys.Lutador;
import Entitys.Mago;
import Entitys.Personagem;
import View.Component.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class ViewCriacaoPersonagem {
    private final MainView mainView;
    private String nomePersonagem;
    private Personagem personagem;

    public ViewCriacaoPersonagem(MainView mainView) {
        this.mainView = mainView;
    }

    public JPanel criarPainelNomePersonagem() {
        JPanel painelNomePersonagem = new JPanel(new GridBagLayout());
        painelNomePersonagem.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel labelNome = new JLabel("Digite o nome do seu personagem:");
        labelNome.setForeground(Color.WHITE);
        labelNome.setFont(new Font("Consolas", Font.BOLD, 14));
        gbc.gridy = 0;
        painelNomePersonagem.add(labelNome, gbc);

        JTextField campoNome = new JTextField(20);
        campoNome.setForeground(Color.WHITE);
        campoNome.setFont(new Font("Consolas", Font.BOLD, 14));
        campoNome.setBackground(Color.BLACK);
        campoNome.setHorizontalAlignment(JTextField.CENTER);
        campoNome.setMinimumSize(new Dimension(450, 35));
        campoNome.setBorder(new RoundedBorder(10));
        gbc.gridy = 1;
        painelNomePersonagem.add(campoNome, gbc);

        JButton botaoConfirmar = new JButton("Confirmar");
        mainView.configurarBotao(botaoConfirmar);
        gbc.gridy = 2;
        painelNomePersonagem.add(botaoConfirmar, gbc);

        botaoConfirmar.addActionListener(e -> {
            nomePersonagem = campoNome.getText().trim();

            if (nomePersonagem.isEmpty()) {
                JOptionPane.showMessageDialog(mainView, "Digite um nome válido!");
                return;
            }

            System.out.println("Nome do personagem definido como: " + nomePersonagem);
            mainView.mostrarPainel("classe");
        });

        return painelNomePersonagem;
    }

    public JPanel painelEscolherClasse() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        gbc.gridy = 0;
        JButton botaoMago = new JButton("Mago");
        mainView.configurarBotao(botaoMago);
        botaoMago.setForeground(Color.BLUE);
        painel.add(botaoMago, gbc);

        gbc.gridy = 1;
        JButton botaoLutador = new JButton("Lutador");
        mainView.configurarBotao(botaoLutador);
        botaoLutador.setForeground(Color.RED);
        painel.add(botaoLutador, gbc);

        gbc.gridy = 2;
        JButton botaoArqueiro = new JButton("Arqueiro");
        mainView.configurarBotao(botaoArqueiro);
        botaoArqueiro.setForeground(Color.GREEN);
        painel.add(botaoArqueiro, gbc);

        botaoMago.addActionListener(e -> criarPersonagemFinal("Mago"));
        botaoLutador.addActionListener(e -> criarPersonagemFinal("Lutador"));
        botaoArqueiro.addActionListener(e -> criarPersonagemFinal("Arqueiro"));

        return painel;
    }

    private void criarPersonagemFinal(String classe) {
        switch (classe) {
            case "Mago" -> personagem = new Mago(nomePersonagem);
            case "Lutador" -> personagem = new Lutador(nomePersonagem);
            case "Arqueiro" -> personagem = new Arqueiro(nomePersonagem);
        }

        System.out.println("Personagem " + personagem.getNome().toUpperCase() + " criado, com a classe " + classe.toUpperCase());

        mainView.mostrarPainel("jogo");
        mainView.getJogo().narrar(personagem);
    }

    public Personagem getPersonagem() {
        return personagem;
    }
}