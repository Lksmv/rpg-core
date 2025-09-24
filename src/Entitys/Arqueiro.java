package Entitys;

import Interfaces.FugaInterface;
import Interfaces.HabilidadeInterface;
import Interfaces.ItemInterface;

import java.util.List;
import java.util.Random;

public class Arqueiro extends Personagem implements FugaInterface, HabilidadeInterface, ItemInterface {

    public Arqueiro(String nome) {
        super(nome, 200, 10, 10, 20, 1, 0, 25,10);
        super.addHabilidade(new Habilidade("Tiro rapido", "Uma tiro de arco rapido.", 0, 20, false));
        super.addItem(new Item("Arco longo", 0, 20, 0, 0, 1, 20, 100));
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
