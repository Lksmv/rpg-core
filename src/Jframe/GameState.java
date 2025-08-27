package Jframe;

import java.util.Random;

public class GameState {
    public Hero heroi;
    public int pocao = 1;
    public int ouro = 0;

    public Random rng = new Random();

    // Simple factory for enemies per scene
    public Enemy criarInimigoFacil() { return new Enemy("Goblin", 20, 5, 1); }
    public Enemy criarInimigoMedio() { return new Enemy("Lobo Sombrio", 28, 6, 2); }
    public Enemy criarInimigoDificil() { return new Enemy("Guardião Florido", 35, 7, 3); }
    public Enemy criarReiDemOnio() { return new Enemy("Rei Demônio", 45, 8, 2); }
    public Enemy criarPrincesa() { return new Enemy("Princesa Furiosa", 35, 9, 4); }

    public void curarComPocao() {
        if (pocao > 0) {
            pocao--;
            heroi.hp = Math.min(heroi.maxHp, heroi.hp + 20);
        }
    }
}
