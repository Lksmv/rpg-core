package DataBase;

import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Inimigo;
import Entitys.Item;
import Entitys.Habilidade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    // =================================================================
    // 1. DECLARAÇÃO DAS VARIÁVEIS
    // =================================================================

    // Itens
    public Item espada0, espada1, espada2, espada3, espada4;
    public Item armaduraCavaleiro0, armaduraCavaleiro1, armaduraCavaleiro2, armaduraCavaleiro3, armaduraCavaleiro4;
    public Item arco0, arco1, arco2, arco3, arco4;
    public Item armaduraArqueiro0, armaduraArqueiro1, armaduraArqueiro2, armaduraArqueiro3, armaduraArqueiro4;
    public Item cajadoMago0, cajadoMago1, cajadoMago2, cajadoMago3, cajadoMago4;
    public Item mantoMago0, mantoMago1, mantoMago2, mantoMago3, mantoMago4;

    // Inimigos
    public Inimigo inimigo1;

    // Capítulos e História
    public Capitulo cap1, cap2, cap3, cap4, cap5, cap6, cap7, cap8, cap9, cap10, cap11, cap12, cap13, cap14, cap15, cap16, cap17, cap18, cap19, cap20, finalHeroico, finalTragico;
    private Historia historia;

    // Cores
    private static final String RED = "";
    private static final String GREEN = "";
    private static final String YELLOW = "";
    private static final String BLUE = "";
    private static final String PURPLE = "";
    private static final String CYAN = "";
    private static final String ORANGE = "";
    private static final String PINK = "";
    private static final String TEAL = "";
    private static final String GOLD = "";
    private static final String SILVER = "";
    private static final String BROWN = "";
    private static final String LIME = "";
    private static final String MAGENTA = "";

    // =================================================================
    // 2. CONSTRUTOR (ONDE TUDO É CRIADO E MONTADO)
    // =================================================================
    public DataBase() {

        // --- CRIAÇÃO DOS ITENS ---
        espada0 = new Item("Espada de Ferro Enferrujada", 0, 10, 0, 0, 0, 5, 10);
        espada1 = new Item("Lâmina de Batalha", 0, 12, 0, 0, 1, 10, 10);
        espada2 = new Item("Fatiadora de Recompensas", 0, 16, 0, 0, 2, 15, 10);
        espada3 = new Item("Estilhaço de Estrela", 0, 18, 0, 0, 3, 20, 10);
        espada4 = new Item("Whisper of the Shadows", 0, 22, 0, 0, 4, 25, 10);
        armaduraCavaleiro0 = new Item("Traje de Couro Gasto", 5, 0, 3, 0, 0, 0, 10);
        armaduraCavaleiro1 = new Item("Loriga do Defensor", 8, 0, 6, 2, 1, 0, 10);
        armaduraCavaleiro2 = new Item("Peitoral do Colosso", 15, 0, 8, 7, 2, 0, 10);
        armaduraCavaleiro3 = new Item("Escamas de Obsidiana", 19, 0, 11, 7, 3, 0, 10);
        armaduraCavaleiro4 = new Item("Armor of the Fallen Angel", 25, 0, 15, 10, 4, 0, 10);
        arco0 = new Item("Arco abandonado", 0, 10, 0, 0, 0, 5, 1);
        arco1 = new Item("Besta Leve", 0, 14, 0, 0, 1, 10, 1);
        arco2 = new Item("Arco do Espreitador Silvestre", 0, 18, 0, 0, 2, 20, 1);
        arco3 = new Item("Sopro cintilante", 0, 23, 0, 0, 3, 30, 1);
        arco4 = new Item("Dragonbone bow", 0, 23, 0, 0, 4, 50, 1);
        armaduraArqueiro0 = new Item("Armadura Leve", 2, 0, 2, 0, 0, 0, 1);
        armaduraArqueiro1 = new Item("Armadura de Malha de Ferro", 4, 0, 4, 0, 1, 0, 1);
        armaduraArqueiro2 = new Item("Armadura Lamelar do Batedor", 6, 0, 6, 0, 2, 0, 1);
        armaduraArqueiro3 = new Item("Peitoral do Olho de Águia", 8, 0, 8, 0, 3, 0, 1);
        armaduraArqueiro4 = new Item("Shadows of The Immortal Predator", 8, 0, 8, 0, 3, 0, 1);
        cajadoMago0 = new Item("Cajado do Aprendiz", 0, 10, 0, 0, 0, 5, 1);
        cajadoMago1 = new Item("Cajado do Escavador", 0, 15, 0, 0, 1, 10, 1);
        cajadoMago2 = new Item("Cajado de Cristal", 0, 20, 0, 0, 2, 20, 1);
        cajadoMago3 = new Item("Cajado de Lâmina Brilhante", 0, 25, 0, 0, 3, 30, 1);
        cajadoMago4 = new Item("Prince of Death's Staff", 0, 30, 0, 0, 4, 50, 1);
        mantoMago0 = new Item("Manto de Lã de cordeiro", 0, 0, 0, 2, 0, 0, 1);
        mantoMago1 = new Item("Manto do Círculo Interno", 3, 0, 1, 4, 1, 0, 1);
        mantoMago2 = new Item("Manto da Chama Eterna", 5, 0, 3, 6, 2, 0, 1);
        mantoMago3 = new Item("Capa do Sábio Emérito", 7, 0, 5, 7, 3, 0, 1);
        mantoMago4 = new Item("Cloak of the Starry Void", 10, 0, 8, 10, 4, 0, 1);

        // --- A PARTE QUE VOCÊ PEDIU PARA MUDAR ---
        List<Item> lootDoZumbi = new ArrayList<>();
        lootDoZumbi.add(espada0);

        inimigo1 = new Inimigo(
                "Zumbi", 100, 10, 10, 10, 10, 10, 10,
                new Habilidade("Tapa", "", 0, 15, false),
                lootDoZumbi
        );
        // --- FIM DA MUDANÇA ---

        // --- CRIAÇÃO DOS CAPÍTULOS E HISTÓRIA ---
        finalHeroico = new Capitulo("O Fim Heroico", new ArrayList<>(), Arrays.asList(new Frase(RED + "Você ergue sua arma em triunfo."), new Frase(RED + "As terras voltam a florescer, livres da escuridão.")), Arrays.asList(new Frase(RED + "Seu nome será lembrado por gerações."), new Frase(RED + "Fim da sua jornada.")), new ArrayList<>());
        finalTragico = new Capitulo("A Queda do Herói", new ArrayList<>(), Arrays.asList(new Frase(BLUE + "Você cai de joelhos, derrotado."), new Frase(BLUE + "A escuridão engole tudo.")), Arrays.asList(new Frase(BLUE + "Ninguém lembrará do seu sacrifício."), new Frase(BLUE + "Fim da sua jornada.")), new ArrayList<>());

        cap20 = new Capitulo("A Coroa Perdida", Arrays.asList(finalHeroico, finalTragico), Arrays.asList(new Frase(GREEN + "O Rei Corrompido surge diante de você.")), Arrays.asList(new Frase(GREEN + "Sua decisão final mudará tudo.")), new ArrayList<>());
        cap19 = new Capitulo("O Necromante", Arrays.asList(cap20), Arrays.asList(new Frase(YELLOW + "No coração da caverna, o Necromante o aguarda.")), Arrays.asList(new Frase(YELLOW + "Sua risada ecoa nas paredes de pedra.")), new ArrayList<>());
        cap18 = new Capitulo("O Julgamento", Arrays.asList(cap19), Arrays.asList(new Frase(PURPLE + "Você chega ao salão do julgamento sagrado.")), Arrays.asList(new Frase(PURPLE + "Somente os dignos podem seguir adiante.")), new ArrayList<>());
        cap17 = new Capitulo("A Floresta dos Sussurros", Arrays.asList(cap18, cap19), Arrays.asList(new Frase(CYAN + "A floresta murmura segredos antigos.")), Arrays.asList(new Frase(CYAN + "Sombras observam cada passo seu.")), new ArrayList<>());
        cap16 = new Capitulo("O Refúgio Secreto", Arrays.asList(cap17), Arrays.asList(new Frase(SILVER + "Você descobre um santuário escondido.")), Arrays.asList(new Frase(SILVER + "Aqui, antigas magias o fortalecem.")), new ArrayList<>());
        cap15 = new Capitulo("A Ponte Quebrada", Arrays.asList(cap16, cap17), Arrays.asList(new Frase(ORANGE + "A ponte suspensa range sob seu peso.")), Arrays.asList(new Frase(ORANGE + "Você sente que não há volta.")), new ArrayList<>());
        cap14 = new Capitulo("Os Bandidos da Estrada", Arrays.asList(cap15, cap16), Arrays.asList(new Frase(PINK + "Um grupo de bandidos bloqueia sua passagem.")), Arrays.asList(new Frase(PINK + "Eles exigem todo seu ouro.")), new ArrayList<>());
        cap13 = new Capitulo("A Vila Abandonada", Arrays.asList(cap14, cap15), Arrays.asList(new Frase(TEAL + "Casas destruídas e silêncio mortal.")), Arrays.asList(new Frase(TEAL + "Algo sinistro aconteceu aqui.")), new ArrayList<>());
        cap12 = new Capitulo("O Lago Misterioso", Arrays.asList(cap13, cap14), Arrays.asList(new Frase(GOLD + "As águas refletem estrelas que não existem no céu.")), Arrays.asList(new Frase(GOLD + "Você sente uma força mágica.")), new ArrayList<>());
        cap11 = new Capitulo("A Torre do Vigia", Arrays.asList(cap12, cap13), Arrays.asList(new Frase(BROWN + "No alto da colina, uma torre vigia todo o vale.")), Arrays.asList(new Frase(BROWN + "Você encontra inscrições antigas nas paredes.")), new ArrayList<>());
        cap10 = new Capitulo("A Encruzilhada", Arrays.asList(cap11, cap12), Arrays.asList(new Frase(LIME + "Duas estradas se abrem diante de você.")), Arrays.asList(new Frase(LIME + "O destino depende da sua escolha.")), new ArrayList<>());
        cap9 = new Capitulo("A Gruta Oculta", Arrays.asList(cap10, cap11), Arrays.asList(new Frase(MAGENTA + "Um rio subterrâneo leva a uma gruta reluzente.")), Arrays.asList(new Frase(MAGENTA + "Você sente que algo o observa nas sombras.")), new ArrayList<>());
        cap8 = new Capitulo("O Campo de Batalha Antigo", Arrays.asList(cap9, cap10), Arrays.asList(new Frase(RED + "Espadas enferrujadas estão cravadas no chão.")), Arrays.asList(new Frase(RED + "As almas dos mortos parecem inquietas.")), new ArrayList<>());
        cap7 = new Capitulo("A Caverna Escura", Arrays.asList(cap8, cap9), Arrays.asList(new Frase(BLUE + "Você entra em uma caverna úmida e sombria.")), Arrays.asList(new Frase(BLUE + "O som de garras ecoa nas profundezas.")), new ArrayList<>());
        cap6 = new Capitulo("A Biblioteca Esquecida", Arrays.asList(cap7, cap8), Arrays.asList(new Frase(GREEN + "Livros empoeirados falam de heróis antigos.")), Arrays.asList(new Frase(GREEN + "Você encontra um mapa rasgado.")), new ArrayList<>());
        cap5 = new Capitulo("O Castelo em Ruínas", Arrays.asList(cap6, cap7), Arrays.asList(new Frase(YELLOW + "Um castelo destruído pelo tempo se ergue diante de você.")), Arrays.asList(new Frase(YELLOW + "Sombras vagueiam pelos corredores.")), new ArrayList<>());
        cap4 = new Capitulo("A Taberna do Corvo", Arrays.asList(cap5, cap6), Arrays.asList(new Frase(PURPLE + "Na taberna, viajantes contam lendas antigas.")), Arrays.asList(new Frase(PURPLE + "Você ouve sobre a 'Coroa Perdida'." + "")), new ArrayList<>());
        cap3 = new Capitulo("O Bosque Inicial", Arrays.asList(cap4, cap5), Arrays.asList(new Frase(CYAN + "Você caminha por um bosque iluminado pelo sol.")), Arrays.asList(new Frase(CYAN + "Pássaros cantam, mas o ar parece pesado.")), new ArrayList<>());

        cap2 = new Capitulo("A Estrada Antiga", Arrays.asList(cap3, cap4), Arrays.asList(new Frase(SILVER + "Você segue por uma estrada esquecida.")), Arrays.asList(new Frase(SILVER + "Pegadas estranhas marcam a terra.")), Arrays.asList(inimigo1));

        cap1 = new Capitulo("O Chamado da Aventura", Arrays.asList(cap2, cap3), Arrays.asList(new Frase(ORANGE + "Você desperta com o som distante de sinos."), new Frase(ORANGE + "O sol entra pela janela, dourando as paredes de madeira."), new Frase(ORANGE + "O chamado foi aceito."), new Frase(ORANGE + "Sua jornada começa agora.")), new ArrayList<>(), new ArrayList<>());

        this.historia = new Historia(cap1);
    }

    // =================================================================
    // 3. MÉTODO PARA O JOGO ACESSAR A HISTÓRIA
    // =================================================================
    public Historia getHistoria() {
        return this.historia;
    }
}