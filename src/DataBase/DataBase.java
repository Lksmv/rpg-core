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

    public Item espada0, espada1, espada2, espada3, espada4;
    public Item armaduraCavaleiro0, armaduraCavaleiro1, armaduraCavaleiro2, armaduraCavaleiro3, armaduraCavaleiro4;
    public Item arco0, arco1, arco2, arco3, arco4;
    public Item armaduraArqueiro0, armaduraArqueiro1, armaduraArqueiro2, armaduraArqueiro3, armaduraArqueiro4;
    public Item cajadoMago0, cajadoMago1, cajadoMago2, cajadoMago3, cajadoMago4;
    public Item mantoMago0, mantoMago1, mantoMago2, mantoMago3, mantoManto4;

    private Historia historia;

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
        List<Item> lootDoZumbi = new ArrayList<>();
        lootDoZumbi.add(espada0);
        List<Item> lootDoEsqueleto = new ArrayList<>();
        lootDoEsqueleto.add(espada1);

        Inimigo inimigo1 = new Inimigo(
                "Zumbi", 100, 10, 10, 10, 10, 10, 10,
                new Habilidade("Tapa", "", 0, 15, false),
                lootDoZumbi
        );

        Inimigo inimigo2 = new Inimigo(
                "Esqueleto", 100, 10, 10, 10, 10, 10, 10,
                new Habilidade("Tapa", "", 0, 15, false),
                lootDoEsqueleto
        );


        // --- CRIAÇÃO DOS CAPÍTULOS E HISTÓRIA ---

        Capitulo finalHeroico = new Capitulo("O Fim Heroico", new ArrayList<>(), Arrays.asList(new Frase("Você ergue sua arma em triunfo."), new Frase("As terras voltam a florescer, livres da escuridão.")), Arrays.asList(new Frase("Seu nome será lembrado por gerações."), new Frase("Fim da sua jornada.")), new ArrayList<>());
        Capitulo finalTragico = new Capitulo("A Queda do Herói", new ArrayList<>(), Arrays.asList(new Frase("Você cai de joelhos, derrotado."), new Frase("A escuridão engole tudo.")), Arrays.asList(new Frase("Ninguém lembrará do seu sacrifício."), new Frase("Fim da sua jornada.")), new ArrayList<>());

        Capitulo capitulo20 = new Capitulo("A Coroa Perdida", Arrays.asList(finalHeroico, finalTragico), Arrays.asList(new Frase("O Rei Corrompido surge diante de você.")), Arrays.asList(new Frase("Sua decisão final mudará tudo.")), new ArrayList<>());
        Capitulo capitulo19 = new Capitulo("O Necromante", Arrays.asList(capitulo20), Arrays.asList(new Frase("No coração da caverna, o Necromante o aguarda.")), Arrays.asList(new Frase("Sua risada ecoa nas paredes de pedra.")), new ArrayList<>());
        Capitulo capitulo18 = new Capitulo("O Julgamento", Arrays.asList(capitulo19), Arrays.asList(new Frase("Você chega ao salão do julgamento sagrado.")), Arrays.asList(new Frase("Somente os dignos podem seguir adiante.")), new ArrayList<>());
        Capitulo capitulo17 = new Capitulo("A Floresta dos Sussurros", Arrays.asList(capitulo18, capitulo19), Arrays.asList(new Frase("A floresta murmura segredos antigos.")), Arrays.asList(new Frase("Sombras observam cada passo seu.")), new ArrayList<>());
        Capitulo capitulo16 = new Capitulo("O Refúgio Secreto", Arrays.asList(capitulo17), Arrays.asList(new Frase("Você descobre um santuário escondido.")), Arrays.asList(new Frase("Aqui, antigas magias o fortalecem.")), new ArrayList<>());
        Capitulo capitulo15 = new Capitulo("A Ponte Quebrada", Arrays.asList(capitulo16, capitulo17), Arrays.asList(new Frase("A ponte suspensa range sob seu peso.")), Arrays.asList(new Frase("Você sente que não há volta.")), new ArrayList<>());
        Capitulo capitulo14 = new Capitulo("Os Bandidos da Estrada", Arrays.asList(capitulo15, capitulo16), Arrays.asList(new Frase("Um grupo de bandidos bloqueia sua passagem.")), Arrays.asList(new Frase("Eles exigem todo seu ouro.")), new ArrayList<>());
        Capitulo capitulo13 = new Capitulo("A Vila Abandonada", Arrays.asList(capitulo14, capitulo15), Arrays.asList(new Frase("Casas destruídas e silêncio mortal.")), Arrays.asList(new Frase("Algo sinistro aconteceu aqui.")), new ArrayList<>());
        Capitulo capitulo12 = new Capitulo("O Lago Misterioso", Arrays.asList(capitulo13, capitulo14), Arrays.asList(new Frase("As águas refletem estrelas que não existem no céu.")), Arrays.asList(new Frase("Você sente uma força mágica.")), new ArrayList<>());
        Capitulo capitulo11 = new Capitulo("A Torre do Vigia", Arrays.asList(capitulo12, capitulo13), Arrays.asList(new Frase("No alto da colina, uma torre vigia todo o vale.")), Arrays.asList(new Frase("Você encontra inscrições antigas nas paredes.")), new ArrayList<>());
        Capitulo capitulo10 = new Capitulo("A Encruzilhada", Arrays.asList(capitulo11, capitulo12), Arrays.asList(new Frase("Duas estradas se abrem diante de você.")), Arrays.asList(new Frase("O destino depende da sua escolha.")), new ArrayList<>());
        Capitulo capitulo9 = new Capitulo("A Gruta Oculta", Arrays.asList(capitulo10, capitulo11), Arrays.asList(new Frase("Um rio subterrâneo leva a uma gruta reluzente.")), Arrays.asList(new Frase("Você sente que algo o observa nas sombras.")), new ArrayList<>());
        Capitulo capitulo8 = new Capitulo("O Campo de Batalha Antigo", Arrays.asList(capitulo9, capitulo10), Arrays.asList(new Frase("Espadas enferrujadas estão cravadas no chão.")), Arrays.asList(new Frase("As almas dos mortos parecem inquietas.")), new ArrayList<>());
        Capitulo capitulo7 = new Capitulo("A Caverna Escura", Arrays.asList(capitulo8, capitulo9), Arrays.asList(new Frase("Você entra em uma caverna úmida e sombria.")), Arrays.asList(new Frase("O som de garras ecoa nas profundezas.")), new ArrayList<>());
        Capitulo capitulo6 = new Capitulo("A Biblioteca Esquecida", Arrays.asList(capitulo7, capitulo8), Arrays.asList(new Frase("Livros empoeirados falam de heróis antigos.")), Arrays.asList(new Frase("Você encontra um mapa rasgado.")), new ArrayList<>());
        Capitulo capitulo5 = new Capitulo("O Castelo em Ruínas", Arrays.asList(capitulo6, capitulo7), Arrays.asList(new Frase("Um castelo destruído pelo tempo se ergue diante de você.")), Arrays.asList(new Frase("Sombras vagueiam pelos corredores.")), new ArrayList<>());
        Capitulo capitulo4 = new Capitulo("A Taberna do Corvo", Arrays.asList(capitulo5, capitulo6), Arrays.asList(new Frase("Na taberna, viajantes contam lendas antigas.")), Arrays.asList(new Frase("Você ouve sobre a 'Coroa Perdida'.")), new ArrayList<>());
        Capitulo capitulo3 = new Capitulo("O Bosque Inicial", Arrays.asList(capitulo4, capitulo5), Arrays.asList(new Frase("Você caminha por um bosque iluminado pelo sol.")), Arrays.asList(new Frase("Pássaros cantam, mas o ar parece pesado.")), Arrays.asList(inimigo2));
        Capitulo capitulo2 = new Capitulo("A Estrada Antiga", Arrays.asList(capitulo3, capitulo4), Arrays.asList(new Frase("Você segue por uma estrada esquecida.")), Arrays.asList(new Frase("Pegadas estranhas marcam a terra.")), Arrays.asList(inimigo1));
        Capitulo capitulo1 = new Capitulo("O Chamado da Aventura", Arrays.asList(capitulo2, capitulo3), Arrays.asList(new Frase("Você desperta com o som distante de sinos."), new Frase("O sol entra pela janela, dourando as paredes de madeira."), new Frase("O chamado foi aceito."), new Frase("Sua jornada começa agora.")), new ArrayList<>(), new ArrayList<>());

        this.historia = new Historia(capitulo1);
    }


    public Historia getHistoria() {
        return this.historia;
    }
}