package Jframe;

import javax.swing.*;
import java.awt.*;

public class SimpleRPGLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("RPG Simples - Resgate da Princesa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new CardLayout());

            GameState state = new GameState();
            // Ask player name once
            String nome = JOptionPane.showInputDialog(frame, "Qual é o nome do herói?", "Nome do Herói", JOptionPane.QUESTION_MESSAGE);
            if (nome == null || nome.trim().isEmpty()) nome = "Herói";
            state.heroi = new Hero(nome.trim(), 60, 8, 3);

            // Panels
            StoryPanel intro = new StoryPanel(state, frame, StoryPanel.Scene.INTRO_1);
            frame.add(intro, "INTRO_1");

            // show
            frame.setVisible(true);
        });
    }
}
