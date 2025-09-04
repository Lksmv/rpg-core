package View;

import DataBase.DataBase;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    JPanel painelJogo = new JPanel();
    private MainView mainView;

    public Jogo(MainView mainView) {
        this.mainView = mainView;
        criarPainelJogo();

        JPanel painelRodape = new JPanel(new BorderLayout());
        painelRodape.setOpaque(false);

        botoesCombate(painelRodape);
    }

    public JPanel criarPainelJogo() {
        painelJogo.setLayout(new BorderLayout());
        painelJogo.setBackground(Color.BLACK);
        JLabel labelNome = new JLabel("Digite o nome do seu personagem:");
        painelJogo.add(labelNome);
        return painelJogo;
    }

    public void configurarBotaoBaixo(JButton botao) {
        botao.setPreferredSize(new Dimension(120, 40));
        botao.setBorder(null);
        botao.setFocusPainted(false);
        botao.setBackground(new Color(50, 50, 50));
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void botoesCombate(JPanel painelRodape) {
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painelBotoes.setBackground(Color.BLACK);

        JButton botaoAtacar = new JButton("Atacar");
        configurarBotaoBaixo(botaoAtacar);

        JButton botaoUsarHabilidade = new JButton("Usar Habilidade");
        configurarBotaoBaixo(botaoUsarHabilidade);

        JButton botaoDefender = new JButton("Defender");
        configurarBotaoBaixo(botaoDefender);

        JButton botaoFugir = new JButton("Fugir");
        configurarBotaoBaixo(botaoFugir);

        painelBotoes.add(botaoAtacar);
        painelBotoes.add(botaoUsarHabilidade);
        painelBotoes.add(botaoDefender);
        painelBotoes.add(botaoFugir);

        painelRodape.add(painelBotoes, BorderLayout.CENTER);
    }


    public JPanel getPainelJogo() {
        return painelJogo;
    }

//    public void narrar() {
//
//        DataBase db = new DataBase();
//        Historia h = db.getHistoria();
//        //                                         FORMATO: CONTEXTO INICIAL > COMBATE > NARRATIVA FINAL
//        //                                         DA P MUDAR PARA CONTEXTO INICIAL > COMBATE
//        //                                         ISSO É APENAS 1 TURNO, PEQUENA PARTE DE TODA A HISTORIA.
//        try {
//
//            for (Frase frase : h.getInicio().getPeriodoInicial()) {
//                System.out.println(frase.getConteudo());
//                Thread.sleep(frase.getIntervalo() * 1000);
//            }
//
//            //PARTE DE COMBATE - A FAZER
//
//            //PARTE FINAL
//
//            for (Frase frase : periodoFinal) {
//                System.out.println(frase.getConteudo());
//                Thread.sleep(frase.getIntervalo() * 1000);
//            }
//
//            if (proximosCapitulos.isEmpty()) {
//                System.out.println("--------------------");
//            } else if (proximosCapitulos.size() == 1) {
//                proximosCapitulos.get(0).narrar();
//            } else {
//                Scanner scan = new Scanner(System.in);
//                while (true) {
//                    System.out.println("Escolha para qual lugar voce deseja ir:");
//                    for (int i = 1; i <= proximosCapitulos.size(); i++) {
//                        System.out.println(i + " - " + proximosCapitulos.get(i - 1).getTitulo());
//                    }
//                    try {
//                        int opcao = scan.nextInt();
//                        if (proximosCapitulos.get(opcao - 1) == null) {
//                            throw new InputMismatchException();
//                        } else {
//                            proximosCapitulos.get(opcao - 1).narrar();
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Opcao invalida!");
//                    }
//                }
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
