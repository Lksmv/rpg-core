package Entitys;

import Interfaces.ItemInterface;

import java.util.ArrayList;
import java.util.Random;

public class Personagem implements ItemInterface {

    private String nome;
    private int pontosVida;
    private int vidaMaxima;
    private int forca;
    private int defesa;
    private int defesaMagica;
    private int nivel;
    private int experiencia;
    private int chanceCritico;
    private int moedas;
    private int mana;
    private int manaMaxima;
    private int qntPocaoVida;
    private int qntPocaoMana;

    private ArrayList<Item> inventario;
    private ArrayList<Habilidade> habilidades;


    public Personagem(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int nivel, int experiencia, int chanceCritico,int mana) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.vidaMaxima = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.defesaMagica = defesaMagica;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.chanceCritico = chanceCritico;
        this.inventario = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.mana = mana;
        this.manaMaxima = mana;
        this.moedas = 25;
        this.qntPocaoVida = 5;
        this.qntPocaoMana = 5;
    }

    public int getQntPocaoMana() {
        return qntPocaoMana;
    }

    public void setQntPocaoMana(int qntPocaoMana) {
        this.qntPocaoMana = qntPocaoMana;
    }

    public int getQntPocaoVida() {
        return qntPocaoVida;
    }

    public void setQntPocaoVida(int qntPocaoVida) {
        this.qntPocaoVida = qntPocaoVida;
    }

    public int getMoedas() {
        return moedas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getDefesaMagica() {
        return defesaMagica;
    }

    public void setDefesaMagica(int defesaMagica) {
        this.defesaMagica = defesaMagica;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getChanceCritico() {
        return chanceCritico;
    }

    public void setChanceCritico(int chanceCritico) {
        this.chanceCritico = chanceCritico;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void addItem(Item item) {
        inventario.add(item);
        this.pontosVida += item.getPontosVida();
        this.forca += item.getForca();
        this.defesa += item.getDefesa();
        this.defesaMagica += item.getDefesaMagica();
        this.chanceCritico += item.getChanceCritico();
    }

    public void removeItem(Item item) {
        inventario.removeIf(item1 -> item1.getNome().equals(item.getNome()));
        this.pontosVida -= item.getPontosVida();
        this.forca -= item.getForca();
        this.defesa -= item.getDefesa();
        this.defesaMagica -= item.getDefesaMagica();
        this.chanceCritico -= item.getChanceCritico();
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void addHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

    public void removeHabilidade(Habilidade habilidade) {
        habilidades.removeIf(habilidade1 -> habilidade1.getNome().equals(habilidade.getNome()));
    }

    public boolean validarCritico() {
        int rdn = new Random().nextInt(100);
        return rdn <= chanceCritico;
    }

    @Override
    public boolean comprar(Item item) {
        if (item.getValor() <= moedas) {
            addItem(item);
            moedas -= item.getValor();
            return true;
        } else {
            return false;
        }
    }


    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    public boolean usarHabilidade(Habilidade habilidade, Personagem personagem) {
        boolean foiCritico = validarCritico();
        int critico = foiCritico ? 2 : 1;

        int danoFinal;
        if (habilidade.isDanoMagico()) {
            danoFinal = (habilidade.getDano() * critico) - personagem.getDefesaMagica();
        } else {
            danoFinal = (habilidade.getDano() * critico) - personagem.getDefesa();
        }

        if (danoFinal < 0) {
            danoFinal = 0;
        }

        personagem.setPontosVida(personagem.getPontosVida() - danoFinal);
        return foiCritico;
    }
}
