package Entitys;

import Interfaces.HabilidadeInterface;

import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem implements HabilidadeInterface {

    public Inimigo(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int nivel, int experiencia, int chanceCritico, Habilidade habilidade) {
        super(nome, pontosVida, forca, defesa, defesaMagica, nivel, experiencia, chanceCritico,0);
        super.addHabilidade(habilidade);
    }

}

