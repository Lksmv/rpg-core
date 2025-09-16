package Entitys;

import Interfaces.FugaInterface;
import Interfaces.HabilidadeInterface;
import Interfaces.ItemInterface;

import java.util.List;
import java.util.Random;

public class Mago extends Personagem implements FugaInterface, HabilidadeInterface {


    public Mago(String nome) {
        super(nome, 100, 10, 10, 20, 1, 0, 0, 10);
        super.addHabilidade(new Habilidade("Bola de fogo", "É uma bola de fogo.", 6, 25, true));
        super.addItem(new Item("Cajado de fogo", 0, 20, 0, 1, 0, 0, 100));
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
        if (getMana() <= 0 || getMana() < habilidade.getCustoMana()) {
            return false;
        }

        setMana(getMana() - habilidade.getCustoMana());
        return super.usarHabilidade(habilidade, personagem);
    }




}
