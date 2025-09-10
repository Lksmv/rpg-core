package Entitys;

import Interfaces.ItemInterface;

import java.util.ArrayList;
import java.util.Random;

public class Personagem implements ItemInterface {

    private String nome;
    private int pontosVida;
    private int forca;
    private int defesa;
    private int defesaMagica;
    private int nivel;
    private int experiencia;
    private int chanceCritico;
    private int moedas;
    private ArrayList<Item> inventario;
    private ArrayList<Consumivel> consumiveis;
    private ArrayList<Habilidade> habilidades;


    public Personagem(String nome, int pontosVida, int forca, int defesa, int defesaMagica, int nivel, int experiencia, int chanceCritico) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.defesaMagica = defesaMagica;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.chanceCritico = chanceCritico;
        this.inventario = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.consumiveis = new ArrayList<>(); // Adicione esta linha
        this.moedas = 25;
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


    public ArrayList<Consumivel> getConsumiveis() {
        return consumiveis;
    }

    public void addConsumivel(Consumivel consumivel) {
        consumiveis.add(consumivel);
    }

    public boolean utilizarConsumivel(Consumivel consumivel) {
        if (!consumiveis.contains(consumivel)) {
            return false;
        }
        this.pontosVida += consumivel.getVida();
        consumiveis.stream().filter(consumivel1 -> consumivel1.equals(consumivel.getNome())).toList().removeFirst();
        return true;
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
        int rdn = new Random().nextInt(101);
        return rdn <= chanceCritico;
    }

    @Override
    public boolean comprar(Item item) {
        if (item.getValor() <= moedas) {
            moedas -= item.getValor();
            return true;
        } else {
            return false;
        }
    }

    public boolean usarHabilidade(Habilidade habilidade, Personagem personagem) {
        int critico = validarCritico() ? 2 : 1;
        if (critico == 2) {
            System.out.println("Crítico! A habilidade causa o dobro de dano!");
        }

        int danoFinal;
        if (habilidade.isDanoMagico()) {
            danoFinal = (habilidade.getDano() * critico) - personagem.getDefesaMagica();
        } else {
            danoFinal = (habilidade.getDano() * critico) - personagem.getDefesa();
        }

        // Garante que o dano não seja negativo (não cure o inimigo)
        if (danoFinal < 0) {
            danoFinal = 0;
        }

        personagem.setPontosVida(personagem.getPontosVida() - danoFinal);
        return true;
    }
}