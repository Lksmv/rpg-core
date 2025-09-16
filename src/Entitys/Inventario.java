package Entitys;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Item> itens;

    public Inventario() {
        // O inventário começa como uma lista vazia
        this.itens = new ArrayList<>();
    }

    // Adiciona um item à lista
    public void adicionarItem(Item item) {
        this.itens.add(item);
        // Mensagem para o jogador saber o que ganhou
        System.out.println(">> Você obteve: [" + item.getNome() + "]!");
    }

    // Remove um item da lista
    public void removerItem(Item item) {
        this.itens.remove(item);
    }

    // Mostra os itens de forma organizada
    public void mostrarInventario() {
        System.out.println("\n--- SEU INVENTÁRIO ---");
        if (itens.isEmpty()) {
            System.out.println("    (Vazio)");
        } else {
            // Usamos um contador para numerar os itens
            int contador = 1;
            for (Item item : itens) {
                // Aqui você pode customizar como o item aparece.
                // Por enquanto, vamos mostrar só o nome.
                System.out.println(contador + ". " + item.getNome());
                contador++;
            }
        }
        System.out.println("----------------------\n");
    }
}