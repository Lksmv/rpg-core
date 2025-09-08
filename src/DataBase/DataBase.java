package DataBase;

import Entitys.Consumivel;
import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Item;
import Entitys.Habilidade;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {

    // Cores principais
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


    // CAPÍTULO FINAL: Vitória
    Capitulo finalHeroico = new Capitulo(
            "O Fim Heroico",
            new ArrayList<>(),
            Arrays.asList(
                    new Frase(RED + "Você ergue sua arma em triunfo."),
                    new Frase(RED + "As terras voltam a florescer, livres da escuridão.")
            ),
            Arrays.asList(
                    new Frase(RED +"Seu nome será lembrado por gerações." + ""),
                    new Frase(RED +"Fim da sua jornada." + "")
            ),
            new ArrayList<>()
    );

    // CAPÍTULO FINAL: Derrota
    Capitulo finalTragico = new Capitulo(
            "A Queda do Herói",
            new ArrayList<>(),
            Arrays.asList(
                    new Frase(BLUE + "Você cai de joelhos, derrotado." + ""),
                    new Frase(BLUE + "A escuridão engole tudo." + "")
            ),
            Arrays.asList(
                    new Frase(BLUE + "Ninguém lembrará do seu sacrifício." + ""),
                    new Frase(BLUE + "Fim da sua jornada." + "")
            ),
            new ArrayList<>()
    );

    // ----------------------
    // CAPÍTULOS INTERMEDIÁRIOS
    // ----------------------

    Capitulo cap20 = new Capitulo(
            "A Coroa Perdida",
            Arrays.asList(finalHeroico, finalTragico),
            Arrays.asList(new Frase(GREEN +"O Rei Corrompido surge diante de você." + "")),
            Arrays.asList(new Frase(GREEN +"Sua decisão final mudará tudo." + "")),
            new ArrayList<>()
    );

    Capitulo cap19 = new Capitulo(
            "O Necromante",
            Arrays.asList(cap20),
            Arrays.asList(new Frase(YELLOW +"No coração da caverna, o Necromante o aguarda." + "")),
            Arrays.asList(new Frase(YELLOW +"Sua risada ecoa nas paredes de pedra." + "")),
            new ArrayList<>()
    );

    Capitulo cap18 = new Capitulo(
            "O Julgamento",
            Arrays.asList(cap19),
            Arrays.asList(new Frase(PURPLE +"Você chega ao salão do julgamento sagrado." + "")),
            Arrays.asList(new Frase(PURPLE +"Somente os dignos podem seguir adiante." + "")),
            new ArrayList<>()
    );

    Capitulo cap17 = new Capitulo(
            "A Floresta dos Sussurros",
            Arrays.asList(cap18, cap19),
            Arrays.asList(new Frase(CYAN +"A floresta murmura segredos antigos." + "")),
            Arrays.asList(new Frase(CYAN +"Sombras observam cada passo seu." + "")),
            new ArrayList<>()
    );

    Capitulo cap16 = new Capitulo(
            "O Refúgio Secreto",
            Arrays.asList(cap17),
            Arrays.asList(new Frase(SILVER +"Você descobre um santuário escondido." + "")),
            Arrays.asList(new Frase(SILVER +"Aqui, antigas magias o fortalecem." + "")),
            new ArrayList<>()
    );

    Capitulo cap15 = new Capitulo(
            "A Ponte Quebrada",
            Arrays.asList(cap16, cap17),
            Arrays.asList(new Frase(ORANGE +"A ponte suspensa range sob seu peso." + "")),
            Arrays.asList(new Frase(ORANGE +"Você sente que não há volta." + "")),
            new ArrayList<>()
    );

    Capitulo cap14 = new Capitulo(
            "Os Bandidos da Estrada",
            Arrays.asList(cap15, cap16),
            Arrays.asList(new Frase(PINK +"Um grupo de bandidos bloqueia sua passagem." + "")),
            Arrays.asList(new Frase(PINK +"Eles exigem todo seu ouro." + "")),
            new ArrayList<>()
    );

    Capitulo cap13 = new Capitulo(
            "A Vila Abandonada",
            Arrays.asList(cap14, cap15),
            Arrays.asList(new Frase(TEAL +"Casas destruídas e silêncio mortal." + "")),
            Arrays.asList(new Frase(TEAL +"Algo sinistro aconteceu aqui." + "")),
            new ArrayList<>()
    );

    Capitulo cap12 = new Capitulo(
            "O Lago Misterioso",
            Arrays.asList(cap13, cap14),
            Arrays.asList(new Frase(GOLD +"As águas refletem estrelas que não existem no céu." + "")),
            Arrays.asList(new Frase(GOLD +"Você sente uma força mágica." + "")),
            new ArrayList<>()
    );

    Capitulo cap11 = new Capitulo(
            "A Torre do Vigia",
            Arrays.asList(cap12, cap13),
            Arrays.asList(new Frase(BROWN +"No alto da colina, uma torre vigia todo o vale." + "")),
            Arrays.asList(new Frase(BROWN +"Você encontra inscrições antigas nas paredes." + "")),
            new ArrayList<>()
    );

    Capitulo cap10 = new Capitulo(
            "A Encruzilhada",
            Arrays.asList(cap11, cap12),
            Arrays.asList(new Frase(LIME +"Duas estradas se abrem diante de você." + "")),
            Arrays.asList(new Frase(LIME +"O destino depende da sua escolha." + "")),
            new ArrayList<>()
    );

    Capitulo cap9 = new Capitulo(
            "A Gruta Oculta",
            Arrays.asList(cap10, cap11),
            Arrays.asList(new Frase(MAGENTA +"Um rio subterrâneo leva a uma gruta reluzente." + "")),
            Arrays.asList(new Frase(MAGENTA +"Você sente que algo o observa nas sombras." + "")),
            new ArrayList<>()
    );

    Capitulo cap8 = new Capitulo(
            "O Campo de Batalha Antigo",
            Arrays.asList(cap9, cap10),
            Arrays.asList(new Frase(RED + "Espadas enferrujadas estão cravadas no chão." + "")),
            Arrays.asList(new Frase(RED + "As almas dos mortos parecem inquietas." + "")),
            new ArrayList<>()
    );

    Capitulo cap7 = new Capitulo(
            "A Caverna Escura",
            Arrays.asList(cap8, cap9),
            Arrays.asList(new Frase(BLUE +"Você entra em uma caverna úmida e sombria." + "")),
            Arrays.asList(new Frase(BLUE +"O som de garras ecoa nas profundezas." + "")),
            new ArrayList<>()
    );

    Capitulo cap6 = new Capitulo(
            "A Biblioteca Esquecida",
            Arrays.asList(cap7, cap8),
            Arrays.asList(new Frase(GREEN +"Livros empoeirados falam de heróis antigos." + "")),
            Arrays.asList(new Frase(GREEN +"Você encontra um mapa rasgado." + "")),
            new ArrayList<>()
    );

    Capitulo cap5 = new Capitulo(
            "O Castelo em Ruínas",
            Arrays.asList(cap6, cap7),
            Arrays.asList(new Frase(YELLOW +"Um castelo destruído pelo tempo se ergue diante de você." + "")),
            Arrays.asList(new Frase(YELLOW +"Sombras vagueiam pelos corredores." + "")),
            new ArrayList<>()
    );

    Capitulo cap4 = new Capitulo(
            "A Taberna do Corvo",
            Arrays.asList(cap5, cap6),
            Arrays.asList(new Frase(PURPLE +"Na taberna, viajantes contam lendas antigas." + "")),
            Arrays.asList(new Frase(PURPLE +"Você ouve sobre a 'Coroa Perdida'." + "")),
            new ArrayList<>()
    );

    Capitulo cap3 = new Capitulo(
            "O Bosque Inicial",
            Arrays.asList(cap4, cap5),
            Arrays.asList(new Frase(CYAN +"Você caminha por um bosque iluminado pelo sol." + "")),
            Arrays.asList(new Frase(CYAN +"Pássaros cantam, mas o ar parece pesado." + "")),
            new ArrayList<>()
    );

    Capitulo cap2 = new Capitulo(
            "A Estrada Antiga",
            Arrays.asList(cap3, cap4),
            Arrays.asList(new Frase(SILVER +"Você segue por uma estrada esquecida." + "")),
            Arrays.asList(new Frase(SILVER +"Pegadas estranhas marcam a terra." + "")),
            new ArrayList<>()
    );

    Capitulo cap1 = new Capitulo(
            "O Chamado da Aventura",
            Arrays.asList(cap2, cap3),
            Arrays.asList(
                    new Frase(ORANGE +"Você desperta com o som distante de sinos."),
                    new Frase(ORANGE +"O sol entra pela janela, dourando as paredes de madeira."),
                    new Frase(ORANGE +"A aldeia parece calma, mas você sente que algo está errado." + ""),
                    new Frase(ORANGE +"Pássaros voam apressados, como se fugissem de algo invisível." + ""),
                    new Frase(ORANGE +"Crianças brincam nas ruas, sem imaginar o perigo que se aproxima." + ""),
                    new Frase(ORANGE +"Um velho camponês o cumprimenta com um olhar cansado." + ""),
                    new Frase(ORANGE +"Ele murmura algo sobre uma sombra que ronda as colinas." + ""),
                    new Frase(ORANGE +"Na praça central, comerciantes discutem preços de tecidos." + ""),
                    new Frase(ORANGE +"Um menestrel toca uma melodia melancólica." + ""),
                    new Frase(ORANGE +"O cheiro de pão fresco invade o ar." + ""),
                    new Frase(ORANGE +"Você escuta cochichos sobre soldados desaparecidos." + ""),
                    new Frase(ORANGE +"Um grupo de caçadores retorna, mas sem sua caça habitual." + ""),
                    new Frase(ORANGE +"As pessoas olham para o horizonte com desconfiança." + ""),
                    new Frase(ORANGE +"O vento sopra forte, trazendo um frio repentino." + ""),
                    new Frase(ORANGE +"Um mensageiro chega montado em um cavalo exausto." + ""),
                    new Frase(ORANGE +"Ele desmaia na frente da taverna, com um pergaminho nas mãos." + ""),
                    new Frase(ORANGE +"Você corre até ele e vê um selo real quebrado." + ""),
                    new Frase(ORANGE +"O pergaminho fala de uma coroa perdida e um reino em ruínas." + ""),
                    new Frase(ORANGE +"A mensagem pede por heróis dispostos a enfrentar a escuridão." + ""),
                    new Frase(ORANGE +"Os aldeões recuam, com medo até de ler as palavras." + ""),
                    new Frase(ORANGE +"Você sente seu coração acelerar." + ""),
                    new Frase(ORANGE +"Será esse o destino que sempre aguardou?" + ""),
                    new Frase(ORANGE +"Seu nome parece ecoar na mente, como um chamado." + ""),
                    new Frase(ORANGE +"Um corvo pousa em uma cerca próxima e o encara fixamente." + ""),
                    new Frase(ORANGE +"Seus olhos brilham em vermelho por um instante." + ""),
                    new Frase(ORANGE +"O menestrel interrompe a música abruptamente." + ""),
                    new Frase(ORANGE +"As crianças param de brincar, assustadas." + ""),
                    new Frase(ORANGE +"Um silêncio pesado cai sobre a aldeia." + ""),
                    new Frase(ORANGE +"Você segura o pergaminho com firmeza." + ""),
                    new Frase(ORANGE +"O vento parece sussurrar: 'Escolha o seu caminho'." + ""),
                    new Frase(ORANGE +"O ferreiro se aproxima e lhe entrega uma adaga antiga." + ""),
                    new Frase(ORANGE +"“Se for partir, leve isso. Pertenceu a meu pai.”" + ""),
                    new Frase(ORANGE +"Um grupo de aldeões se reúne ao seu redor." + ""),
                    new Frase(ORANGE +"Eles pedem que você represente sua gente." + ""),
                    new Frase(ORANGE +"Uma criança segura sua mão e diz: “Volte vivo, por favor.”" + ""),
                    new Frase(ORANGE +"O coração se enche de determinação." + ""),
                    new Frase(ORANGE +"Você decide aceitar o chamado." + ""),
                    new Frase(ORANGE +"No horizonte, o sol começa a se pôr." + ""),
                    new Frase(ORANGE +"As sombras se alongam pelas colinas." + ""),
                    new Frase(ORANGE +"Um lobo uiva ao longe." + ""),
                    new Frase(ORANGE +"O sino da igreja toca novamente." + ""),
                    new Frase(ORANGE +"Um frio percorre sua espinha." + ""),
                    new Frase(ORANGE +"Você respira fundo." + ""),
                    new Frase(ORANGE +"O destino não espera." + ""),
                    new Frase(ORANGE +"Agora é a sua vez." + ""),
                    new Frase(ORANGE +"O pergaminho queima em sua mão como fogo." + ""),
                    new Frase(ORANGE +"Você dá o primeiro passo rumo à aventura." + ""),
                    new Frase(ORANGE +"O chão parece tremer sob seus pés." + ""),
                    new Frase(ORANGE +"O corvo voa para o norte, como um guia."),
                    new Frase(ORANGE +"A estrada está diante de você." + ""),
                    new Frase(ORANGE +"O chamado foi aceito." + ""),
                    new Frase(ORANGE +"Sua jornada começa agora." + "")
            ),
            new ArrayList<>(),
            new ArrayList<>()
    );

    Historia historia = new Historia(cap1);

    public Historia getHistoria() {
        return historia;
    }

    //Arma do Cavaleiro
    public Item espada0 = new Item("Espada de Ferro Enferrujada", 0, 10, 0, 0, 0, 5,10);
    public Item espada1 = new Item("Lâmina de Batalha", 0, 12, 0, 0, 1, 10,10);
    public Item espada2 = new Item("Fatiadora de Recompensas", 0, 16, 0, 0, 2, 15,10);
    public Item espada3 = new Item("Estilhaço de Estrela", 0, 18, 0, 0, 3, 20,10);
    public Item espada4 = new Item("Whisper of the Shadows", 0, 22, 0, 0, 4, 25,10);

    //Armadura Cavaleiro
    public Item armaduraCavaleiro0 = new Item("Traje de Couro Gasto", 5, 0, 3, 0, 0, 0,10);
    public Item armaduraCavaleiro1 = new Item("Loriga do Defensor", 8, 0, 6, 2, 1, 0,10);
    public Item armaduraCavaleiro2 = new Item("Peitoral do Colosso", 15, 0, 8, 7, 2, 0,10);
    public Item armaduraCavaleiro3 = new Item("Escamas de Obsidiana", 19, 0, 11, 7, 3, 0,10);
    public Item armaduraCavaleiro4 = new Item("Armor of the Fallen Angel", 25, 0, 15, 10, 4, 0,10);

    //Arma do Arqueiro
    public Item arco0 = new Item("Arco abandonado", 0, 10, 0, 0, 0, 5,1);
    public Item arco1 = new Item("Besta Leve", 0, 14, 0, 0, 1, 10,1);
    public Item arco2 = new Item("Arco do Espreitador Silvestre", 0, 18, 0, 0, 2, 20,1);
    public Item arco3 = new Item("Sopro cintilante", 0, 23, 0, 0, 3, 30,1);
    public Item arco4 = new Item("Dragonbone bow", 0, 23, 0, 0, 4, 50,1);

    //Armadura Arqueiro
    public Item armaduraArqueiro0 = new Item("Armadura Leve", 2, 0, 2, 0, 0, 0,1);
    public Item armaduraArqueiro1 = new Item("Armadura de Malha de Ferro", 4, 0, 4, 0, 1, 0,1);
    public Item armaduraArqueiro2 = new Item("Armadura Lamelar do Batedor", 6, 0, 6, 0, 2, 0,1);
    public Item armaduraArqueiro3 = new Item("Peitoral do Olho de Águia", 8, 0, 8, 0, 3, 0,1);
    public Item armaduraArqueiro4 = new Item("Shadows of The Immortal Predator", 8, 0, 8, 0, 3, 0,1);

    //Cajado do Mago
    public Item cajadoMago0 = new Item("Cajado do Aprendiz", 0, 10, 0, 0, 0, 5,1);
    public Item cajadoMago1 = new Item("Cajado do Escavador", 0, 15, 0, 0, 1, 10,1);
    public Item cajadoMago2 = new Item("Cajado de Cristal", 0, 20, 0, 0, 2, 20,1);
    public Item cajadoMago3 = new Item("Cajado de Lâmina Brilhante", 0, 25, 0, 0, 3, 30,1);
    public Item cajadoMago4 = new Item("Prince of Death's Staff", 0, 30, 0, 0, 4, 50,1);

    //Mantos do Mago
    public Item mantoMago0 = new Item("Manto de Lã de cordeiro", 0, 0, 0, 2, 0, 0,1);
    public Item mantoMago1 = new Item("Manto do Círculo Interno", 3, 0, 1, 4, 1, 0,1);
    public Item mantoMago2 = new Item("Manto da Chama Eterna", 5, 0, 3, 6, 2, 0,1);
    public Item mantoMago3 = new Item("Capa do Sábio Emérito", 7, 0, 5, 7, 3, 0,1);
    public Item mantoMago4 = new Item("Cloak of the Starry Void", 10, 0, 8, 10, 4, 0,1);

    //Poções
    public Consumivel pocaoDeCura1 = new Consumivel("Poção de Cura(Leve)", 10, 0, 5);
    public Consumivel pocaoDeCura2 = new Consumivel("Poção de Cura(Intermediária)", 20, 0, 10);
    public Consumivel pocaoDeCura3 = new Consumivel("Poção de Cura(Avançada)", 30, 0, 15);

    public Consumivel pocaoDeMana1 = new Consumivel("Poção de Mana(Leve)", 0, 10, 5);
    public Consumivel pocaoDeMana2 = new Consumivel("Poção de Mana(Intermediário)", 0, 20, 10);
    public Consumivel pocaoDeMana3 = new Consumivel("Poção de Mana(Avançada)", 0, 30, 15);
}


