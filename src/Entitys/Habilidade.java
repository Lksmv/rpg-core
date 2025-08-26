package Entitys;

public class Habilidade {

    private String nome;
    private String descricao;
    private int custoMana;
    private int dano;
    private boolean isDanoMagico;

    public Habilidade(String nome, String descricao, int custoMana, int dano, boolean isDanoMagico) {
        this.nome = nome;
        this.descricao = descricao;
        this.custoMana = custoMana;
        this.dano = dano;
        this.isDanoMagico = isDanoMagico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public void setCustoMana(int custoMana) {
        this.custoMana = custoMana;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public boolean isDanoMagico() {
        return isDanoMagico;
    }

    public void setDanoMagico(boolean danoMagico) {
        isDanoMagico = danoMagico;
    }
}
