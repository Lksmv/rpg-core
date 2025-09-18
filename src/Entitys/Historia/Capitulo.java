package Entitys.Historia;

import Entitys.Personagem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Capitulo {

    private String titulo;
    private List<Capitulo> proximosCapitulos;
    private List<Frase> periodoInicial;
    private List<Frase> periodoFinal;
    private List<Personagem> inimigos;

    public Capitulo(String titulo) {
        this.titulo = titulo;
    }

    public Capitulo(String titulo, List<Capitulo> proximosCapitulos, List<Frase> periodoInicial, List<Frase> periodoFinal, List<Personagem> inimigos) {
        this.titulo = titulo;
        this.proximosCapitulos = proximosCapitulos;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.inimigos = inimigos;
    }

    public List<Frase> getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(List<Frase> periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public List<Frase> getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(List<Frase> periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public List<Personagem> getInimigos() {
        return inimigos;
    }

    public void setInimigos(List<Personagem> inimigos) {
        this.inimigos = inimigos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Capitulo> getProximosCapitulos() {
        return proximosCapitulos;
    }

    public void addProximoCapitulo(Capitulo proximoCapitulo) {
        this.proximosCapitulos.add((proximoCapitulo));
    }


}
