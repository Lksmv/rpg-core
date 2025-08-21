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

    public void setProximosCapitulos(List<Capitulo> proximosCapitulos) {
        this.proximosCapitulos = proximosCapitulos;
    }

    public void narrar() {
        //                                         FORMATO: CONTEXTO INICIAL > COMBATE > NARRATIVA FINAL
        //                                         DA P MUDAR PARA CONTEXTO INICIAL > COMBATE
        //                                         ISSO É APENAS 1 TURNO, PEQUENA PARTE DE TODA A HISTORIA.
        try {

            for (Frase frase : periodoInicial) {
                System.out.println(frase.getConteudo());
                Thread.sleep(frase.getIntervalo() * 1000);
            }

            //PARTE DE COMBATE - A FAZER

            //PARTE FINAL

            for (Frase frase : periodoFinal) {
                System.out.println(frase.getConteudo());
                Thread.sleep(frase.getIntervalo() * 1000);
            }

            if (proximosCapitulos.isEmpty()) {
                System.out.println("--------------------");
            } else if (proximosCapitulos.size() == 1) {
                proximosCapitulos.get(0).narrar();
            } else {
                Scanner scan = new Scanner(System.in);
                while (true) {
                    System.out.println("Escolha para qual lugar voce deseja ir:");
                    for (int i = 1; i <= proximosCapitulos.size(); i++) {
                        System.out.println(i + " - " + proximosCapitulos.get(i-1).getTitulo());
                    }
                    try {
                        int opcao = scan.nextInt();
                        if (proximosCapitulos.get(opcao-1) == null){
                            throw new InputMismatchException();
                        }else{
                            proximosCapitulos.get(opcao-1).narrar();
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Opcao invalida!");
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
