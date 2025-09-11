package Entitys;

import Interfaces.FugaInterface;
import Interfaces.HabilidadeInterface;
import Interfaces.ItemInterface;

import java.util.List;
import java.util.Random;

public class Lutador extends Personagem implements FugaInterface, HabilidadeInterface {

    public Lutador(String nome) {
        super(nome, 100, 10, 10, 20, 1, 0, 0,0);
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


}
