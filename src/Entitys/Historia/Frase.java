package Entitys.Historia;

public class Frase {

    private int intervalo;
    private String conteudo;

    public Frase(String conteudo) {
        this.conteudo = conteudo;
        int numPalavras = conteudo.split("\\s+").length;
        this.intervalo = (int) (numPalavras * 0.3 * 1.2); // 0,3s por palavra
        if (this.intervalo < 1) this.intervalo = 1; // pelo menos 1s
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
