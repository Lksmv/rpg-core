package Entitys;

import Interfaces.HabilidadeInterface;

import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem implements HabilidadeInterface {

    public Inimigo(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int nivel, int experiencia, int chanceCritico) {
        super(nome, pontosVida, forca, defesa, defesaMagica, nivel, experiencia, chanceCritico);
    }


    @Override
    public boolean usarHabilidade(Habilidade habilidade, Personagem personagem) {

        int critico = validarCritico() ? 2 : 1;
        if (critico == 2) {
            System.out.println("Critou! a Habilidade vai causar o dobro de dano!");
        }
        if (habilidade.isDanoMagico()) {
            personagem.setPontosVida(personagem.getPontosVida() - ((habilidade.getDano() * critico) - personagem.getDefesaMagica()));
        } else {
            personagem.setPontosVida(personagem.getPontosVida() - ((habilidade.getDano() * critico) - personagem.getDefesa()));
        }
        return true;
    }


}

