package DataBase;

import Entitys.Habilidade;
import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Personagem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    // Cores principais
    private static final String RED = "\u001B[91m";
    private static final String GREEN = "\u001B[92m";
    private static final String YELLOW = "\u001B[93m";
    private static final String BLUE = "\u001B[94m";
    private static final String PURPLE = "\u001B[95m";
    private static final String CYAN = "\u001B[96m";
    private static final String ORANGE = "\u001B[38;5;208m";
    private static final String PINK = "\u001B[38;5;213m";
    private static final String TEAL = "\u001B[38;5;37m";
    private static final String GOLD = "\u001B[38;5;220m";
    private static final String SILVER = "\u001B[38;5;7m";
    private static final String BROWN = "\u001B[38;5;94m";
    private static final String LIME = "\u001B[38;5;118m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String RESET = "\u001B[0m";


    // CAPÍTULO FINAL: Vitória
    Capitulo finalHeroico = new Capitulo(
            "O Fim Heroico",
            new ArrayList<>(),
            Arrays.asList(
                    new Frase(RED + "Você ergue sua arma em triunfo." + RESET),
                    new Frase(RED + "As terras voltam a florescer, livres da escuridão." + RESET)
            ),
            Arrays.asList(
                    new Frase(RED +"Seu nome será lembrado por gerações." + RESET),
                    new Frase(RED +"Fim da sua jornada." + RESET)
            ),
            new ArrayList<>()
    );

    // CAPÍTULO FINAL: Derrota
    Capitulo finalTragico = new Capitulo(
            "A Queda do Herói",
            new ArrayList<>(),
            Arrays.asList(
                    new Frase(BLUE + "Você cai de joelhos, derrotado." + RESET),
                    new Frase(BLUE + "A escuridão engole tudo." + RESET)
            ),
            Arrays.asList(
                    new Frase(BLUE + "Ninguém lembrará do seu sacrifício." + RESET),
                    new Frase(BLUE + "Fim da sua jornada." + RESET)
            ),
            new ArrayList<>()
    );

    // ----------------------
    // CAPÍTULOS INTERMEDIÁRIOS
    // ----------------------

    Capitulo cap20 = new Capitulo(
            "A Coroa Perdida",
            Arrays.asList(finalHeroico, finalTragico),
            Arrays.asList(new Frase(GREEN +"O Rei Corrompido surge diante de você." + RESET)),
            Arrays.asList(new Frase(GREEN +"Sua decisão final mudará tudo." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap19 = new Capitulo(
            "O Necromante",
            Arrays.asList(cap20),
            Arrays.asList(new Frase(YELLOW +"No coração da caverna, o Necromante o aguarda." + RESET)),
            Arrays.asList(new Frase(YELLOW +"Sua risada ecoa nas paredes de pedra." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap18 = new Capitulo(
            "O Julgamento",
            Arrays.asList(cap19),
            Arrays.asList(new Frase(PURPLE +"Você chega ao salão do julgamento sagrado." + RESET)),
            Arrays.asList(new Frase(PURPLE +"Somente os dignos podem seguir adiante." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap17 = new Capitulo(
            "A Floresta dos Sussurros",
            Arrays.asList(cap18, cap19),
            Arrays.asList(new Frase(CYAN +"A floresta murmura segredos antigos." + RESET)),
            Arrays.asList(new Frase(CYAN +"Sombras observam cada passo seu." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap16 = new Capitulo(
            "O Refúgio Secreto",
            Arrays.asList(cap17),
            Arrays.asList(new Frase(SILVER +"Você descobre um santuário escondido." + RESET)),
            Arrays.asList(new Frase(SILVER +"Aqui, antigas magias o fortalecem." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap15 = new Capitulo(
            "A Ponte Quebrada",
            Arrays.asList(cap16, cap17),
            Arrays.asList(new Frase(ORANGE +"A ponte suspensa range sob seu peso." + RESET)),
            Arrays.asList(new Frase(ORANGE +"Você sente que não há volta." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap14 = new Capitulo(
            "Os Bandidos da Estrada",
            Arrays.asList(cap15, cap16),
            Arrays.asList(new Frase(PINK +"Um grupo de bandidos bloqueia sua passagem." + RESET)),
            Arrays.asList(new Frase(PINK +"Eles exigem todo seu ouro." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap13 = new Capitulo(
            "A Vila Abandonada",
            Arrays.asList(cap14, cap15),
            Arrays.asList(new Frase(TEAL +"Casas destruídas e silêncio mortal." + RESET)),
            Arrays.asList(new Frase(TEAL +"Algo sinistro aconteceu aqui." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap12 = new Capitulo(
            "O Lago Misterioso",
            Arrays.asList(cap13, cap14),
            Arrays.asList(new Frase(GOLD +"As águas refletem estrelas que não existem no céu." + RESET)),
            Arrays.asList(new Frase(GOLD +"Você sente uma força mágica." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap11 = new Capitulo(
            "A Torre do Vigia",
            Arrays.asList(cap12, cap13),
            Arrays.asList(new Frase(BROWN +"No alto da colina, uma torre vigia todo o vale." + RESET)),
            Arrays.asList(new Frase(BROWN +"Você encontra inscrições antigas nas paredes." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap10 = new Capitulo(
            "A Encruzilhada",
            Arrays.asList(cap11, cap12),
            Arrays.asList(new Frase(LIME +"Duas estradas se abrem diante de você." + RESET)),
            Arrays.asList(new Frase(LIME +"O destino depende da sua escolha." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap9 = new Capitulo(
            "A Gruta Oculta",
            Arrays.asList(cap10, cap11),
            Arrays.asList(new Frase(MAGENTA +"Um rio subterrâneo leva a uma gruta reluzente." + RESET)),
            Arrays.asList(new Frase(MAGENTA +"Você sente que algo o observa nas sombras." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap8 = new Capitulo(
            "O Campo de Batalha Antigo",
            Arrays.asList(cap9, cap10),
            Arrays.asList(new Frase(RED + "Espadas enferrujadas estão cravadas no chão." + RESET)),
            Arrays.asList(new Frase(RED + "As almas dos mortos parecem inquietas." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap7 = new Capitulo(
            "A Caverna Escura",
            Arrays.asList(cap8, cap9),
            Arrays.asList(new Frase(BLUE +"Você entra em uma caverna úmida e sombria." + RESET)),
            Arrays.asList(new Frase(BLUE +"O som de garras ecoa nas profundezas." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap6 = new Capitulo(
            "A Biblioteca Esquecida",
            Arrays.asList(cap7, cap8),
            Arrays.asList(new Frase(GREEN +"Livros empoeirados falam de heróis antigos." + RESET)),
            Arrays.asList(new Frase(GREEN +"Você encontra um mapa rasgado." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap5 = new Capitulo(
            "O Castelo em Ruínas",
            Arrays.asList(cap6, cap7),
            Arrays.asList(new Frase(YELLOW +"Um castelo destruído pelo tempo se ergue diante de você." + RESET)),
            Arrays.asList(new Frase(YELLOW +"Sombras vagueiam pelos corredores." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap4 = new Capitulo(
            "A Taberna do Corvo",
            Arrays.asList(cap5, cap6),
            Arrays.asList(new Frase(PURPLE +"Na taberna, viajantes contam lendas antigas." + RESET)),
            Arrays.asList(new Frase(PURPLE +"Você ouve sobre a 'Coroa Perdida'." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap3 = new Capitulo(
            "O Bosque Inicial",
            Arrays.asList(cap4, cap5),
            Arrays.asList(new Frase(CYAN +"Você caminha por um bosque iluminado pelo sol." + RESET)),
            Arrays.asList(new Frase(CYAN +"Pássaros cantam, mas o ar parece pesado." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap2 = new Capitulo(
            "A Estrada Antiga",
            Arrays.asList(cap3, cap4),
            Arrays.asList(new Frase(SILVER +"Você segue por uma estrada esquecida." + RESET)),
            Arrays.asList(new Frase(SILVER +"Pegadas estranhas marcam a terra." + RESET)),
            new ArrayList<>()
    );

    Capitulo cap1 = new Capitulo(
            "O Chamado da Aventura",
            Arrays.asList(cap2, cap3),
            Arrays.asList(
                    new Frase(ORANGE +"Você desperta com o som distante de sinos." + RESET),
                    new Frase(ORANGE +"O sol entra pela janela, dourando as paredes de madeira." + RESET),
                    new Frase(ORANGE +"A aldeia parece calma, mas você sente que algo está errado." + RESET),
                    new Frase(ORANGE +"Pássaros voam apressados, como se fugissem de algo invisível." + RESET),
                    new Frase(ORANGE +"Crianças brincam nas ruas, sem imaginar o perigo que se aproxima." + RESET),
                    new Frase(ORANGE +"Um velho camponês o cumprimenta com um olhar cansado." + RESET),
                    new Frase(ORANGE +"Ele murmura algo sobre uma sombra que ronda as colinas." + RESET),
                    new Frase(ORANGE +"Na praça central, comerciantes discutem preços de tecidos." + RESET),
                    new Frase(ORANGE +"Um menestrel toca uma melodia melancólica." + RESET),
                    new Frase(ORANGE +"O cheiro de pão fresco invade o ar." + RESET),
                    new Frase(ORANGE +"Você escuta cochichos sobre soldados desaparecidos." + RESET),
                    new Frase(ORANGE +"Um grupo de caçadores retorna, mas sem sua caça habitual." + RESET),
                    new Frase(ORANGE +"As pessoas olham para o horizonte com desconfiança." + RESET),
                    new Frase(ORANGE +"O vento sopra forte, trazendo um frio repentino." + RESET),
                    new Frase(ORANGE +"Um mensageiro chega montado em um cavalo exausto." + RESET),
                    new Frase(ORANGE +"Ele desmaia na frente da taverna, com um pergaminho nas mãos." + RESET),
                    new Frase(ORANGE +"Você corre até ele e vê um selo real quebrado." + RESET),
                    new Frase(ORANGE +"O pergaminho fala de uma coroa perdida e um reino em ruínas." + RESET),
                    new Frase(ORANGE +"A mensagem pede por heróis dispostos a enfrentar a escuridão." + RESET),
                    new Frase(ORANGE +"Os aldeões recuam, com medo até de ler as palavras." + RESET),
                    new Frase(ORANGE +"Você sente seu coração acelerar." + RESET),
                    new Frase(ORANGE +"Será esse o destino que sempre aguardou?" + RESET),
                    new Frase(ORANGE +"Seu nome parece ecoar na mente, como um chamado." + RESET),
                    new Frase(ORANGE +"Um corvo pousa em uma cerca próxima e o encara fixamente." + RESET),
                    new Frase(ORANGE +"Seus olhos brilham em vermelho por um instante." + RESET),
                    new Frase(ORANGE +"O menestrel interrompe a música abruptamente." + RESET),
                    new Frase(ORANGE +"As crianças param de brincar, assustadas." + RESET),
                    new Frase(ORANGE +"Um silêncio pesado cai sobre a aldeia." + RESET),
                    new Frase(ORANGE +"Você segura o pergaminho com firmeza." + RESET),
                    new Frase(ORANGE +"O vento parece sussurrar: 'Escolha o seu caminho'." + RESET),
                    new Frase(ORANGE +"O ferreiro se aproxima e lhe entrega uma adaga antiga." + RESET),
                    new Frase(ORANGE +"“Se for partir, leve isso. Pertenceu a meu pai.”" + RESET),
                    new Frase(ORANGE +"Um grupo de aldeões se reúne ao seu redor." + RESET),
                    new Frase(ORANGE +"Eles pedem que você represente sua gente." + RESET),
                    new Frase(ORANGE +"Uma criança segura sua mão e diz: “Volte vivo, por favor.”" + RESET),
                    new Frase(ORANGE +"O coração se enche de determinação." + RESET),
                    new Frase(ORANGE +"Você decide aceitar o chamado." + RESET),
                    new Frase(ORANGE +"No horizonte, o sol começa a se pôr." + RESET),
                    new Frase(ORANGE +"As sombras se alongam pelas colinas." + RESET),
                    new Frase(ORANGE +"Um lobo uiva ao longe." + RESET),
                    new Frase(ORANGE +"O sino da igreja toca novamente." + RESET),
                    new Frase(ORANGE +"Um frio percorre sua espinha." + RESET),
                    new Frase(ORANGE +"Você respira fundo." + RESET),
                    new Frase(ORANGE +"O destino não espera." + RESET),
                    new Frase(ORANGE +"Agora é a sua vez." + RESET),
                    new Frase(ORANGE +"O pergaminho queima em sua mão como fogo." + RESET),
                    new Frase(ORANGE +"Você dá o primeiro passo rumo à aventura." + RESET),
                    new Frase(ORANGE +"O chão parece tremer sob seus pés." + RESET),
                    new Frase(ORANGE +"O corvo voa para o norte, como um guia."),
                    new Frase(ORANGE +"A estrada está diante de você." + RESET),
                    new Frase(ORANGE +"O chamado foi aceito." + RESET),
                    new Frase(ORANGE +"Sua jornada começa agora." + RESET)
            ),
            new ArrayList<>(),
            new ArrayList<>()
    );

    Historia historia = new Historia(cap1);

    public Historia getHistoria() {
        return historia;
    }

}

//Arma do Cavaleiro
    public Item espada0 = new Item("Espada de Ferro Enferrujada", 0, 10, 0, 0, 0, 5);
    public Item espada1 = new Item("Lâmina de Batalha", 0, 12, 0, 0, 1, 10);
    public Item espada2 = new Item("Fatiadora de Recompensas", 0, 16, 0, 0, 2, 15);
    public Item espada3 = new Item("Estilhaço de Estrela", 0, 18, 0, 0, 3, 20);
    public Item espada4 = new Item("Whisper of the Shadows", 0, 22, 0, 0, 4, 25);

    //Armadura Cavaleiro
    public Item armaduraCavaleiro0 = new Item("Traje de Couro Gasto", 5, 0, 3, 0, 0, 0);
    public Item armaduraCavaleiro1 = new Item("Loriga do Defensor", 8, 0, 6, 2, 1, 0);
    public Item armaduraCavaleiro2 = new Item("Peitoral do Colosso", 15, 0, 8, 7, 2, 0);
    public Item armaduraCavaleiro3 = new Item("Escamas de Obsidiana", 19, 0, 11, 7, 3, 0);
    public Item armaduraCavaleiro4 = new Item("Armor of the Fallen Angel", 25, 0, 15, 10, 4, 0);

    //Arma do Arqueiro
    public Item arco0 = new Item("Arco abandonado", 0, 10, 0, 0, 0, 5);
    public Item arco1 = new Item("Besta Leve", 0, 14, 0, 0, 1, 10);
    public Item arco2 = new Item("Arco do Espreitador Silvestre", 0, 18, 0, 0, 2, 20);
    public Item arco3 = new Item("Sopro cintilante", 0, 23, 0, 0, 3, 30);
    public Item arco4 = new Item("Dragonbone bow", 0, 23, 0, 0, 4, 50);

    //Armadura Arqueiro
    public Item armaduraArqueiro0 = new Item("Armadura Leve", 2, 0, 2, 0, 0, 0);
    public Item armaduraArqueiro1 = new Item("Armadura de Malha de Ferro", 4, 0, 4, 0, 1, 0);
    public Item armaduraArqueiro2 = new Item("Armadura Lamelar do Batedor", 6, 0, 6, 0, 2, 0);
    public Item armaduraArqueiro3 = new Item("Peitoral do Olho de Águia", 8, 0, 8, 0, 3, 0);
    public Item armaduraArqueiro4 = new Item("Shadows of The Immortal Predator", 8, 0, 8, 0, 3, 0);

    //Cajado do Mago
    public Item cajadoMago0 = new Item("Cajado do Aprendiz", 0, 10, 0, 0, 0, 5);
    public Item cajadoMago1 = new Item("Cajado do Escavador", 0, 15, 0, 0, 1, 10);
    public Item cajadoMago2 = new Item("Cajado de Cristal", 0, 20, 0, 0, 2, 20);
    public Item cajadoMago3 = new Item("Cajado de Lâmina Brilhante", 0, 25, 0, 0, 3, 30);
    public Item cajadoMago4 = new Item("Prince of Death's Staff", 0, 30, 0, 0, 4, 50);

    //Mantos do Mago
    public Item mantoMago0 = new Item("Manto de Lã de cordeiro", 0, 0, 0, 2, 0, 0);
    public Item mantoMago1 = new Item("Manto do Círculo Interno", 3, 0, 1, 4, 1, 0);
    public Item mantoMago2 = new Item("Manto da Chama Eterna", 5, 0, 3, 6, 2, 0);
    public Item mantoMago3 = new Item("Capa do Sábio Emérito", 7, 0, 5, 7, 3, 0);
    public Item mantoMago4 = new Item("Cloak of the Starry Void", 10, 0, 8, 10, 4, 0);

    //Poções
    public Consumivel pocaoDeCura1 = new Consumivel("Poção de Cura(Leve)", 10, 0, 5);
    public Consumivel pocaoDeCura2 = new Consumivel("Poção de Cura(Intermediária)", 20, 0, 10);
    public Consumivel pocaoDeCura3 = new Consumivel("Poção de Cura(Avançada)", 30, 0, 15);

    public Consumivel pocaoDeMana1 = new Consumivel("Poção de Mana(Leve)", 0, 10, 5);
    public Consumivel pocaoDeMana2 = new Consumivel("Poção de Mana(Intermediário)", 0, 20, 10);
    public Consumivel pocaoDeMana3 = new Consumivel("Poção de Mana(Avançada)", 0, 30, 15);

}
