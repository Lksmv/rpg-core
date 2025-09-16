package Entitys;

import Interfaces.HabilidadeInterface;

import java.util.List; // <-- IMPORTANTE: Adicionar este import
import java.util.Random;

public class Inimigo extends Personagem implements HabilidadeInterface {

    private List<Item> loot; // <-- MUDANÇA 1: Adicionamos a lista para guardar o loot

    // MUDANÇA 2: Adicionamos "List<Item> loot" como último parâmetro do construtor
    public Inimigo(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int nivel, int experiencia, int chanceCritico, Habilidade habilidade, List<Item> loot) {
        super(nome, pontosVida, forca, defesa, defesaMagica, nivel, experiencia, chanceCritico, 0);
        super.addHabilidade(habilidade);
        this.loot = loot; // E guardamos a lista recebida no nosso atributo
    }

    public List<Item> getLoot() {
        return this.loot;
    }
}