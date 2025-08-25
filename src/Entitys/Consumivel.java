package Entitys;

public class Consumivel{
    private String nome;
    private int vida;
    private int mana;
    private double valor;

    public Consumivel(String nome, int vida, int mana, double valor) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
