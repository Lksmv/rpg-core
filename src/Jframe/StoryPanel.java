package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StoryPanel extends JPanel {

    enum Scene {
        INTRO_1, CAMINHO_1_ESCOLHA, FLORESTA_ESCOLHA, MIMICO_EVENTO, CASTELO_ENTRADA, POS_REI, FINAL
    }

    private final GameState state;
    private final JFrame frame;
    private final JTextArea text;
    private final JButton btnA, btnB, btnC;

    public StoryPanel(GameState state, JFrame frame, Scene scene) {
        this.state = state;
        this.frame = frame;
        setLayout(new BorderLayout());

        text = new JTextArea();
        text.setEditable(false);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        text.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
        btnA = new JButton();
        btnB = new JButton();
        btnC = new JButton();
        buttons.add(btnA);
        buttons.add(btnB);
        buttons.add(btnC);

        add(new JScrollPane(text), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        render(scene);
    }

    private void switchTo(JComponent panel, String name) {
        frame.getContentPane().add(panel, name);
        ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), name);
    }

    private void render(Scene scene) {
        btnC.setVisible(true);
        switch (scene) {
            case INTRO_1 -> {
                text.setText("""
                  Em meio a terras prósperas, um rei ganancioso selou um pacto com um demônio e perdeu sua princesa recém‑nascida.
                  Anos depois, arrependido, ele chama %s e oferece barras de ouro para desfazer o erro.
                  Nos portões do castelo, o pequeno herói vê que a aventura não será simples: inimigos o aguardam.
                  """.formatted(state.heroi.nome));
                btnA.setText("Enfrentar inimigos (batalha rápida)");
                btnB.setText("Voltar (não recomendado)");
                btnC.setVisible(false);
                btnA.addActionListener((ActionEvent e) -> {
                    CombatPanel c = new CombatPanel(state, frame, state.criarInimigoFacil(), () -> {
                        // após batalha inicial -> escolha de caminhos 1
                        StoryPanel sp = new StoryPanel(state, frame, Scene.CAMINHO_1_ESCOLHA);
                        switchTo(sp, "CAMINHO_1");
                    }, true);
                    switchTo(c, "COMBAT_INICIAL");
                });
                btnB.addActionListener(ev -> JOptionPane.showMessageDialog(frame, "Coragem, herói!"));
            }
            case CAMINHO_1_ESCOLHA -> {
                text.setText("""
                  Parte 1 — Escolha um caminho:
                  1) Lojinha para comprar itens e, depois, monstros um pouco mais difíceis.
                  2) Seguir por um caminho com monstros padrões, sem loja.
                  """);
                btnA.setText("Caminho 1 (Lojinha)");
                btnB.setText("Caminho 2 (Monstros padrões)");
                btnC.setVisible(false);
                btnA.addActionListener(e -> {
                    ShopPanel shop = new ShopPanel(state, frame, () -> {
                        // Após a loja, uma batalha média
                        CombatPanel c = new CombatPanel(state, frame, state.criarInimigoMedio(), () -> {
                            StoryPanel sp = new StoryPanel(state, frame, Scene.FLORESTA_ESCOLHA);
                            switchTo(sp, "FLORESTA");
                        }, true);
                        switchTo(c, "COMBAT_MEDIO");
                    });
                    switchTo(shop, "SHOP");
                });
                btnB.addActionListener(e -> {
                    CombatPanel c = new CombatPanel(state, frame, state.criarInimigoFacil(), () -> {
                        StoryPanel sp = new StoryPanel(state, frame, Scene.FLORESTA_ESCOLHA);
                        switchTo(sp, "FLORESTA");
                    }, true);
                    switchTo(c, "COMBAT_PADRAO");
                });
            }
            case FLORESTA_ESCOLHA -> {
                text.setText("""
                  Parte 2 — Três caminhos diante da floresta:
                  1) Esquerda: floresta comum (monstros padrões).
                  2) Meio: caminho escuro com placa — “Castelo do majestoso rei demônio a 500 m” (sem monstros).
                  3) Direi                  ta: caminho belo e florido (monstros mais difíceis).
                  """);
                btnA.setText("Esquerda (lutar)");
                btnB.setText("Meio (seguir ao castelo)");
                btnC.setText("Direita (luta difícil + chance de mímico)");
                btnA.addActionListener(e -> {
                    CombatPanel c = new CombatPanel(state, frame, state.criarInimigoFacil(), () -> {
                        StoryPanel sp = new StoryPanel(state, frame, Scene.MIMICO_EVENTO);
                        switchTo(sp, "MIMICO");
                    }, true);
                    switchTo(c, "COMBAT_FLORESTA");
                });
                btnB.addActionListener(e -> {
                    StoryPanel sp = new StoryPanel(state, frame, Scene.CASTELO_ENTRADA);
                    switchTo(sp, "CASTELO");
                });
                btnC.addActionListener(e -> {
                    CombatPanel c = new CombatPanel(state, frame, state.criarInimigoDificil(), () -> {
                        StoryPanel sp = new StoryPanel(state, frame, Scene.MIMICO_EVENTO);
                        switchTo(sp, "MIMICO");
                    }, true);
                    switchTo(c, "COMBAT_DIFICIL");
                });
            }
            case MIMICO_EVENTO -> {
                text.setText("""
                  No caminho, você encontra ruínas silenciosas. Um baú brilhante repousa no centro...
                  Quando se aproxima — SURPRESA! É um MÍMICO!
                  """);
                btnA.setText("Lutar contra o Mímico");
                btnB.setText("Ignorar e seguir");
                btnC.setVisible(false);
                btnA.addActionListener(e -> {
                    Enemy mimic = new Enemy("Mímico", 30, 7, 2);
                    mimic.isMimic = true;
                    CombatPanel c = new CombatPanel(state, frame, mimic, () -> {
                        state.ouro += 30;
                        state.pocao += 1;
                        StoryPanel sp = new StoryPanel(state, frame, Scene.CASTELO_ENTRADA);
                        switchTo(sp, "CASTELO");
                    }, true);
                    switchTo(c, "COMBAT_MIMIC");
                });
                btnB.addActionListener(e -> {
                    StoryPanel sp = new StoryPanel(state, frame, Scene.CASTELO_ENTRADA);
                    switchTo(sp, "CASTELO");
                });
            }
            case CASTELO_ENTRADA -> {
                text.setText("""
                  Você chega a um grande castelo. O céu está limpo, o sol radiante.
                  Com um chute, a porta se abre. O Rei Demônio segura a mão da princesa, o rosto pintado.
                  %s saca sua arma. O Rei prepara-se para lutar.
                  """.formatted(state.heroi.nome));
                btnA.setText("Batalha contra o Rei Demônio");
                btnB.setVisible(false);
                btnC.setVisible(false);
                btnA.addActionListener(e -> {
                    CombatPanel c = new CombatPanel(state, frame, state.criarReiDemOnio(), () -> {
                        StoryPanel sp = new StoryPanel(state, frame, Scene.POS_REI);
                        switchTo(sp, "POS_REI");
                    }, false);
                    switchTo(c, "BOSS_REI");
                });
            }
            case POS_REI -> {
                text.setText("""
                    O Rei Demônio cai ao chão. A princesa, em fúria, parte contra o herói!
                    Prepare-se para a segunda batalha.
                    """);
                btnA.setText("Enfrentar a Princesa");
                btnB.setVisible(false);
                btnC.setVisible(false);
                btnA.addActionListener(e -> {
                    CombatPanel c = new CombatPanel(state, frame, state.criarPrincesa(), () -> {
                        StoryPanel sp = new StoryPanel(state, frame, Scene.FINAL);
                        switchTo(sp, "FINAL");
                    }, false);
                    switchTo(c, "BOSS_PRINCESA");
                });
            }
            case FINAL -> {
                text.setText("""
                                      O que um dia foi um herói, agora vaga sem rumo em busca de novas aventuras.
                  Ele nunca retornará ao castelo daquele que o enviou.
                  FIM.
                  """);
                btnA.setText("Jogar de novo");
                btnB.setText("Sair");
                btnC.setVisible(false);
                btnA.addActionListener(e -> {
                    // reset simples
                    state.heroi.hp = state.heroi.maxHp;
                    state.ouro = 0;
                    state.pocao = 1;
                    StoryPanel sp = new StoryPanel(state, frame, Scene.INTRO_1);
                    switchTo(sp, "INTRO_1_RE");
                });
                btnB.addActionListener(e -> System.exit(0));
            }
        }
    }
}
