package View;

import Entitys.Item;
import Entitys.Personagem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// JDialog é um tipo de janela pop-up
public class InventarioDialog extends JDialog {

    private JList<String> listaItensUI;
    private JTextArea areaDetalhesItem;
    private Personagem jogador;

    public InventarioDialog(JFrame parent, Personagem jogador) {
        super(parent, "Inventário", true); // true = a janela principal fica travada até esta fechar
        this.jogador = jogador;

        setSize(600, 400);
        setLocationRelativeTo(parent); // Centraliza na tela do jogo
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(30, 30, 30));

        // --- PAINEL DA ESQUERDA: LISTA DE ITENS ---
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Item item : jogador.getInventario()) {
            model.addElement(item.getNome());
        }

        listaItensUI = new JList<>(model);
        listaItensUI.setBackground(new Color(50, 50, 50));
        listaItensUI.setForeground(Color.WHITE);
        listaItensUI.setFont(new Font("Consolas", Font.PLAIN, 16));

        // Adiciona um listener para quando um item for selecionado
        listaItensUI.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mostrarDetalhesDoItem();
            }
        });

        JScrollPane scrollLista = new JScrollPane(listaItensUI);
        scrollLista.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), "Itens", 0, 0,
                new Font("Georgia", Font.BOLD, 14), Color.WHITE));


        // --- PAINEL DA DIREITA: DETALHES DO ITEM ---
        areaDetalhesItem = new JTextArea("Selecione um item para ver os detalhes...");
        areaDetalhesItem.setEditable(false);
        areaDetalhesItem.setBackground(new Color(50, 50, 50));
        areaDetalhesItem.setForeground(Color.WHITE);
        areaDetalhesItem.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaDetalhesItem.setMargin(new Insets(10, 10, 10, 10));
        areaDetalhesItem.setLineWrap(true);
        areaDetalhesItem.setWrapStyleWord(true);

        JScrollPane scrollDetalhes = new JScrollPane(areaDetalhesItem);
        scrollDetalhes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), "Detalhes", 0, 0,
                new Font("Georgia", Font.BOLD, 14), Color.WHITE));

        // --- JUNTANDO TUDO ---
        // JSplitPane cria uma barra divisória que pode ser movida
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollLista, scrollDetalhes);
        splitPane.setDividerLocation(200); // Posição inicial da barra
        splitPane.setOpaque(false);

        add(splitPane, BorderLayout.CENTER);

        // --- BOTÃO DE FECHAR ---
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.addActionListener(e -> dispose()); // dispose() fecha a janela
        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotao.setOpaque(false);
        painelBotao.add(botaoFechar);
        add(painelBotao, BorderLayout.SOUTH);
    }

    private void mostrarDetalhesDoItem() {
        int indexSelecionado = listaItensUI.getSelectedIndex();
        if (indexSelecionado != -1) {
            // Pega o objeto Item de verdade, com base na seleção da lista
            Item itemSelecionado = jogador.getInventario().get(indexSelecionado);

            // Monta o texto com todos os status do item
            StringBuilder detalhes = new StringBuilder();
            detalhes.append(itemSelecionado.getNome().toUpperCase()).append("\n");
            detalhes.append("----------------------------\n");
            if (itemSelecionado.getForca() > 0) detalhes.append("Força: +").append(itemSelecionado.getForca()).append("\n");
            if (itemSelecionado.getDefesa() > 0) detalhes.append("Defesa: +").append(itemSelecionado.getDefesa()).append("\n");
            if (itemSelecionado.getDefesaMagica() > 0) detalhes.append("Defesa Mágica: +").append(itemSelecionado.getDefesaMagica()).append("\n");
            if (itemSelecionado.getPontosVida() > 0) detalhes.append("Vida Máxima: +").append(itemSelecionado.getPontosVida()).append("\n");
            if (itemSelecionado.getChanceCritico() > 0) detalhes.append("Chance de Crítico: +").append(itemSelecionado.getChanceCritico()).append("%\n\n");

            detalhes.append("Valor: ").append(itemSelecionado.getValor()).append(" moedas\n");

            areaDetalhesItem.setText(detalhes.toString());
        }
    }
}