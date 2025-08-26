package Entitys;

import Interfaces.FugaInterface;
import Interfaces.HabilidadeInterface;
import Interfaces.ItemInterface;

import java.util.List;
import java.util.Random;

public class Mago extends Personagem implements FugaInterface, HabilidadeInterface {

    private int mana;

    public Mago(String nome) {
        super(nome, 100, 10, 10, 20, 1, 0, 0);
        this.mana = 10;
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

        if (mana <= 0 || mana < habilidade.getCustoMana()) {
            return false;
        }

        mana -= habilidade.getCustoMana();
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

    @Override
    public boolean utilizarConsumivel(Consumivel consumivel) {
        if (!super.getConsumiveis().contains(consumivel)) {
            return false;
        }
        super.setPontosVida(super.getPontosVida() + consumivel.getVida());
        mana = mana + consumivel.getMana();
        super.getConsumiveis().stream().filter(consumivel1 -> consumivel1.equals(consumivel.getNome())).toList().removeFirst();
        return true;
    }

}
