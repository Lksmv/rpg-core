package Jframe;

public class Hero {
    public final String nome;
    public final int maxHp;
    public int hp;
    public int atk;
    public int def;

    public Hero(String nome, int maxHp, int atk, int def) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
    }
}
