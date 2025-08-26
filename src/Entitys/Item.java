package Entitys;

public class Item {

    private String nome;
    private int pontosVida;
    private int forca;
    private int defesa;
    private int defesaMagica;
    private int raridade;
    private int chanceCritico;
    private int valor;

    public Item(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int raridade, int chanceCritico, int valor) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.defesaMagica = defesaMagica;
        this.raridade = raridade;
        this.chanceCritico = chanceCritico;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getDefesaMagica() {
        return defesaMagica;
    }

    public void setDefesaMagica(int defesaMagica) {
        this.defesaMagica = defesaMagica;
    }

    public int getRaridade() {
        return raridade;
    }

    public void setRaridade(int raridade) {
        this.raridade = raridade;
    }

    public int getChanceCritico() {
        return chanceCritico;
    }

    public void setChanceCritico(int chanceCritico) {
        this.chanceCritico = chanceCritico;
    }


}
