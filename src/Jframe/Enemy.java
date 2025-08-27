package Jframe;

public class Enemy {
    public final String nome;
    public final int maxHp;
    public int hp;
    public int atk;
    public int def;
    public boolean isMimic = false;

    public Enemy(String nome, int maxHp, int atk, int def) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
    }
}
