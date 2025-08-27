package Jframe;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {

    private final GameState state;
    private final JFrame frame;
    private final Runnable onExit;

    public ShopPanel(GameState state, JFrame frame, Runnable onExit) {
        this.state = state;
        this.frame = frame;
        this.onExit = onExit;

        setLayout(new BorderLayout(8,8));
        setBorder(BorderFactory.createEmptyBorder(12,12,12,12));

        JTextArea info = new JTextArea("""
          Bem-vindo à Lojinha!
          - Poção (cura 20 HP): 10 ouro
          - Afiar arma (+1 ATK permanente): 15 ouro
          """);
        info.setEditable(false);

        JButton buyPotion = new JButton("Comprar Poção (10 ouro) — Você tem " + state.pocao);
        JButton buySharpen = new JButton("Afiar Arma (+1 ATK, 15 ouro) — ATK atual: " + state.heroi.atk);
        JButton sair = new JButton("Sair da loja");

        buyPotion.addActionListener(e -> {
            if (state.ouro >= 10) {
                state.ouro -= 10;
                state.pocao += 1;
                buyPotion.setText("Comprar Poção (10 ouro) — Você tem " + state.pocao);
            } else {
                JOptionPane.showMessageDialog(frame, "Ouro insuficiente.");
            }
        });

        buySharpen.addActionListener(e -> {
            if (state.ouro >= 15) {
                state.ouro -= 15;
                state.heroi.atk += 1;
                buySharpen.setText("Afiar Arma (+1 ATK, 15 ouro) — ATK atual: " + state.heroi.atk);
            } else {
                JOptionPane.showMessageDialog(frame, "Ouro insuficiente.");
            }
        });

        sair.addActionListener(e -> onExit.run());

        add(new JScrollPane(info), BorderLayout.CENTER);
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        south.add(buyPotion);
        south.add(buySharpen);
        south.add(sair);
        add(south, BorderLayout.SOUTH);
    }
}
