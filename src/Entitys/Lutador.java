package Entitys;

import Interfaces.FugaInterface;
import Interfaces.HabilidadeInterface;
import Interfaces.ItemInterface;

import java.util.List;
import java.util.Random;

public class Lutador extends Personagem implements FugaInterface, HabilidadeInterface {

    public Lutador(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int nivel, int experiencia, int chanceCritico) {
        super(nome, pontosVida, forca, defesa, defesaMagica, nivel, experiencia, chanceCritico);
        super.addHabilidade(new Habilidade("Corte rapido", "Corta o inimigo rapidamente", 0, 12, false));
        super.addItem(new Item("Espada simples", 0, 9, 0, 0, 0, 5, 100));
    }

    @Override
    public boolean fugir(List<Personagem> inimigos) {

        int chanceDeFuga = 50;

        for (Personagem inimigo : inimigos) {
            chanceDeFuga -= (inimigo.getNivel() - this.getNivel()) * 5;
        }

        int random = new Random().nextInt(101);
        if (chanceDeFuga >= random) {
            return true;
        } else {
            return false;
        }
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
