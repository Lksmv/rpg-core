package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CombatPanel extends JPanel {

    private final GameState state;
    private final JFrame frame;
    private final Enemy enemy;
    private final Runnable onWin;
    private final boolean podeFugir;

    private final JProgressBar hpHero;
    private final JProgressBar hpEnemy;
    private final JTextArea log;
    private final JButton btnAtacar, btnPocao, btnFugir;

    public CombatPanel(GameState state, JFrame frame, Enemy enemy, Runnable onWin, boolean podeFugir) {
        this.state = state;
        this.frame = frame;
        this.enemy = enemy;
        this.onWin = onWin;
        this.podeFugir = podeFugir;

        setLayout(new BorderLayout(8,8));
        setBorder(BorderFactory.createEmptyBorder(12,12,12,12));

        JPanel tops = new JPanel(new GridLayout(2,1,8,8));
        hpHero = new JProgressBar(0, state.heroi.maxHp);
        hpHero.setValue(state.heroi.hp);
        hpHero.setStringPainted(true);
        hpHero.setString("HP " + state.heroi.hp + "/" + state.heroi.maxHp);

        hpEnemy = new JProgressBar(0, enemy.maxHp);
        hpEnemy.setValue(enemy.hp);
        hpEnemy.setStringPainted(true);
        hpEnemy.setString(enemy.nome + " " + enemy.hp + "/" + enemy.maxHp);

        tops.add(hpHero);
        tops.add(hpEnemy);

        log = new JTextArea();
        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAtacar = new JButton("Atacar");
        btnPocao = new JButton("Usar Poção (" + state.pocao + ")");
        btnFugir = new JButton(podeFugir ? "Fugir" : "Sem fuga");
        btnFugir.setEnabled(podeFugir);

        actions.add(btnAtacar);
        actions.add(btnPocao);
        actions.add(btnFugir);

        add(tops, BorderLayout.NORTH);
        add(new JScrollPane(log), BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);

        // handlers
        btnAtacar.addActionListener(this::doAtacar);
        btnPocao.addActionListener(this::doPocao);
        btnFugir.addActionListener(this::doFugir);

        // pequena intro
        log.append("Um " + enemy.nome + " apareceu!\n");
        if (enemy.isMimic) log.append("O baú era um MÍMICO!\n");
    }

    private int rolarDano(int atk, int def) {
        int base = Math.max(1, atk - def);
        int var = state.rng.nextInt(4); // 0..3
        return Math.max(1, base + var);
    }

    private void atualizarBarras() {
        hpHero.setValue(state.heroi.hp);
        hpHero.setString("HP " + state.heroi.hp + "/" + state.heroi.maxHp);
        hpEnemy.setValue(enemy.hp);
        hpEnemy.setString(enemy.nome + " " + enemy.hp + "/" + enemy.maxHp);
        btnPocao.setText("Usar Poção (" + state.pocao + ")");
    }

    private void encerrarVitoria() {
        state.ouro += 10;
        log.append("Vitória! Você ganhou 10 ouro.\n");
        Timer t = new Timer(800, e -> onWin.run());
        t.setRepeats(false);
        t.start();
    }

    private void encerrarDerrota() {
        JOptionPane.showMessageDialog(frame, "Você caiu em batalha. Jogo reiniciado.");
        state.heroi.hp = state.heroi.maxHp;
        state.ouro = 0;
        state.pocao = 1;
        StoryPanel sp = new StoryPanel(state, frame, StoryPanel.Scene.INTRO_1);
        ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "INTRO_1");
        frame.getContentPane().add(sp, "INTRO_1");
    }

    private void turnoInimigo() {
        if (enemy.hp <= 0) return;
        int dano = rolarDano(enemy.atk, state.heroi.def);
        state.heroi.hp = Math.max(0, state.heroi.hp - dano);
        log.append(enemy.nome + " atacou e causou " + dano + " de dano.\n");
        atualizarBarras();
        if (state.heroi.hp <= 0) {
            encerrarDerrota();
        }
    }

    private void doAtacar(ActionEvent e) {
        int dano = rolarDano(state.heroi.atk, enemy.def);
        enemy.hp = Math.max(0, enemy.hp - dano);
        log.append("Você atacou e causou " + dano + " de dano.\n");
        atualizarBarras();
        if (enemy.hp <= 0) {
            encerrarVitoria();
        } else {
            turnoInimigo();
        }
    }

    private void doPocao(ActionEvent e) {
        if (state.pocao > 0) {
            state.curarComPocao();
            log.append("Você bebeu uma poção. HP restaurado parcialmente.\n");
            atualizarBarras();
            turnoInimigo();
        } else {
            log.append("Sem poções.\n");
        }
    }

    private void doFugir(ActionEvent e) {
        if (!podeFugir) return;
        if (state.rng.nextBoolean()) {
            log.append("Você conseguiu fugir!\n");
            Timer t = new Timer(600, ev -> {
                StoryPanel sp = new StoryPanel(state, frame, StoryPanel.Scene.FLORESTA_ESCOLHA);
                frame.getContentPane().add(sp, "FLORESTA");
                ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "FLORESTA");
            });
            t.setRepeats(false);
            t.start();
        } else {
            log.append("Falhou ao fugir!\n");
            turnoInimigo();
        }
    }
}
