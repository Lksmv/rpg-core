package DataBase;

import Entitys.Historia.Capitulo;
import Entitys.Historia.Frase;
import Entitys.Historia.Historia;
import Entitys.Inimigo;
import Entitys.Item;
import Entitys.Habilidade;
import Entitys.Personagem;

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

        List<Item> lootDoGuerreiroEnferrujado = new ArrayList<>();
        lootDoGuerreiroEnferrujado.add(espada0);
        Inimigo inimigo3 = new Inimigo(
                "Guerreiro Enferrujado", 120, 15, 10, 8, 10, 12, 10,
                new Habilidade("Corte Enferrujado", "", 0, 20, false),
                lootDoGuerreiroEnferrujado
        );

        List<Item> lootDoGladiador = new ArrayList<>();
        lootDoGladiador.add(espada1);
        Inimigo inimigo4 = new Inimigo(
                "Gladiador da Arena", 150, 18, 12, 10, 12, 15, 12,
                new Habilidade("Investida", "", 0, 25, false),
                lootDoGladiador
        );

        List<Item> lootDoCaçadorDeRecompensas = new ArrayList<>();
        lootDoCaçadorDeRecompensas.add(espada2);
        Inimigo inimigo5 = new Inimigo(
                "Caçador de Recompensas", 180, 20, 14, 12, 14, 18, 12,
                new Habilidade("Golpe Preciso", "", 0, 28, false),
                lootDoCaçadorDeRecompensas
        );

        List<Item> lootDoAstroQuebrado = new ArrayList<>();
        lootDoAstroQuebrado.add(espada3);
        Inimigo inimigo6 = new Inimigo(
                "Astro Quebrado", 200, 22, 16, 14, 16, 20, 14,
                new Habilidade("Corte Estelar", "", 0, 30, false),
                lootDoAstroQuebrado
        );

        List<Item> lootDoAssassinoSombrio = new ArrayList<>();
        lootDoAssassinoSombrio.add(espada4);
        Inimigo inimigo7 = new Inimigo(
                "Assassino das Sombras", 230, 25, 18, 16, 18, 25, 15,
                new Habilidade("Sussurro Mortal", "", 0, 35, false),
                lootDoAssassinoSombrio
        );


// ---- INIMIGOS PARA ARMADURAS DE CAVALEIRO ----
        List<Item> lootDoBandido = new ArrayList<>();
        lootDoBandido.add(armaduraCavaleiro0);
        Inimigo inimigo8 = new Inimigo(
                "Bandido de Estrada", 120, 12, 8, 6, 8, 10, 10,
                new Habilidade("Soco Forte", "", 0, 18, false),
                lootDoBandido
        );

        List<Item> lootDoDefensor = new ArrayList<>();
        lootDoDefensor.add(armaduraCavaleiro1);
        Inimigo inimigo9 = new Inimigo(
                "Defensor da Fortaleza", 150, 15, 12, 8, 10, 12, 12,
                new Habilidade("Bloqueio de Ferro", "", 0, 22, false),
                lootDoDefensor
        );

        List<Item> lootDoColosso = new ArrayList<>();
        lootDoColosso.add(armaduraCavaleiro2);
        Inimigo inimigo10 = new Inimigo(
                "Colosso de Pedra", 200, 18, 15, 12, 12, 15, 14,
                new Habilidade("Pisada Sísmica", "", 0, 28, false),
                lootDoColosso
        );

        List<Item> lootDaCriaturaObsidiana = new ArrayList<>();
        lootDaCriaturaObsidiana.add(armaduraCavaleiro3);
        Inimigo inimigo11 = new Inimigo(
                "Criatura Obsidiana", 240, 20, 18, 14, 15, 18, 15,
                new Habilidade("Chicote Obsidiano", "", 0, 32, false),
                lootDaCriaturaObsidiana
        );

        List<Item> lootDoAnjoCaido = new ArrayList<>();
        lootDoAnjoCaido.add(armaduraCavaleiro4);
        Inimigo inimigo12 = new Inimigo(
                "Anjo Caído", 280, 25, 20, 16, 18, 20, 18,
                new Habilidade("Espada Celestial", "", 0, 40, false),
                lootDoAnjoCaido
        );

        // ======================= ESPADAS =======================
        List<Item> lootDoGuerreiroEnferrujado2 = new ArrayList<>();
        lootDoGuerreiroEnferrujado2.add(espada0);
        Inimigo inimigo13 = new Inimigo(
                "Guerreiro Enferrujado", 120, 15, 10, 8, 10, 12, 10,
                new Habilidade("Corte Enferrujado", "", 0, 20, false),
                lootDoGuerreiroEnferrujado2
        );

        List<Item> lootDoGladiador2 = new ArrayList<>();
        lootDoGladiador2.add(espada1);
        Inimigo inimigo14 = new Inimigo(
                "Gladiador da Arena", 150, 18, 12, 10, 12, 15, 12,
                new Habilidade("Investida", "", 0, 25, false),
                lootDoGladiador2
        );

        List<Item> lootDoCacadorDeRecompensas = new ArrayList<>();
        lootDoCacadorDeRecompensas.add(espada2);
        Inimigo inimigo15 = new Inimigo(
                "Caçador de Recompensas", 180, 20, 14, 12, 14, 18, 12,
                new Habilidade("Golpe Preciso", "", 0, 28, false),
                lootDoCacadorDeRecompensas
        );

        List<Item> lootDoAstroQuebrado2 = new ArrayList<>();
        lootDoAstroQuebrado2.add(espada3);
        Inimigo inimigo16 = new Inimigo(
                "Astro Quebrado", 200, 22, 16, 14, 16, 20, 14,
                new Habilidade("Corte Estelar", "", 0, 30, false),
                lootDoAstroQuebrado2
        );

        List<Item> lootDoAssassinoSombrio2 = new ArrayList<>();
        lootDoAssassinoSombrio2.add(espada4);
        Inimigo inimigo17 = new Inimigo(
                "Assassino das Sombras", 230, 25, 18, 16, 18, 25, 15,
                new Habilidade("Sussurro Mortal", "", 0, 35, false),
                lootDoAssassinoSombrio2
        );


        List<Item> lootDoBandido2 = new ArrayList<>();
        lootDoBandido2.add(armaduraCavaleiro0);
        Inimigo inimigo18 = new Inimigo(
                "Bandido de Estrada", 120, 12, 8, 6, 8, 10, 10,
                new Habilidade("Soco Forte", "", 0, 18, false),
                lootDoBandido2
        );

        List<Item> lootDoDefensor2 = new ArrayList<>();
        lootDoDefensor2.add(armaduraCavaleiro1);
        Inimigo inimigo19 = new Inimigo(
                "Defensor da Fortaleza", 150, 15, 12, 8, 10, 12, 12,
                new Habilidade("Bloqueio de Ferro", "", 0, 22, false),
                lootDoDefensor2
        );

        List<Item> lootDoColosso2 = new ArrayList<>();
        lootDoColosso2.add(armaduraCavaleiro2);
        Inimigo inimigo20 = new Inimigo(
                "Colosso de Pedra", 200, 18, 15, 12, 12, 15, 14,
                new Habilidade("Pisada Sísmica", "", 0, 28, false),
                lootDoColosso2
        );

        List<Item> lootDaCriaturaObsidiana2 = new ArrayList<>();
        lootDaCriaturaObsidiana2.add(armaduraCavaleiro3);
        Inimigo inimigo21 = new Inimigo(
                "Criatura Obsidiana", 240, 20, 18, 14, 15, 18, 15,
                new Habilidade("Chicote Obsidiano", "", 0, 32, false),
                lootDaCriaturaObsidiana2
        );

        List<Item> lootDoAnjoCaido2 = new ArrayList<>();
        lootDoAnjoCaido2.add(armaduraCavaleiro4);
        Inimigo inimigo22 = new Inimigo(
                "Anjo Caído", 280, 25, 20, 16, 18, 20, 18,
                new Habilidade("Espada Celestial", "", 0, 40, false),
                lootDoAnjoCaido2
        );

        List<Item> lootDoCaçadorPerdido = new ArrayList<>();
        lootDoCaçadorPerdido.add(arco0);
        Inimigo inimigo23 = new Inimigo(
                "Caçador Perdido", 110, 12, 10, 10, 8, 12, 8,
                new Habilidade("Flechada Rápida", "", 0, 20, false),
                lootDoCaçadorPerdido
        );

        List<Item> lootDoAtirador = new ArrayList<>();
        lootDoAtirador.add(arco1);
        Inimigo inimigo24 = new Inimigo(
                "Atirador de Elite", 140, 15, 12, 12, 10, 15, 10,
                new Habilidade("Disparo Preciso", "", 0, 25, false),
                lootDoAtirador
        );

        List<Item> lootDoEspreitador = new ArrayList<>();
        lootDoEspreitador.add(arco2);
        Inimigo inimigo25 = new Inimigo(
                "Espreitador Silvestre", 170, 18, 14, 12, 12, 18, 12,
                new Habilidade("Chuva de Flechas", "", 0, 28, false),
                lootDoEspreitador
        );

        List<Item> lootDoArqueiroBrilhante = new ArrayList<>();
        lootDoArqueiroBrilhante.add(arco3);
        Inimigo inimigo26 = new Inimigo(
                "Arqueiro Brilhante", 200, 20, 16, 14, 15, 20, 14,
                new Habilidade("Disparo Luminoso", "", 0, 32, false),
                lootDoArqueiroBrilhante
        );

        List<Item> lootDoArqueiroDraconico = new ArrayList<>();
        lootDoArqueiroDraconico.add(arco4);
        Inimigo inimigo27 = new Inimigo(
                "Arqueiro Dracônico", 240, 25, 18, 16, 18, 25, 16,
                new Habilidade("Flecha Dracônica", "", 0, 38, false),
                lootDoArqueiroDraconico
        );

        List<Item> lootDoBatedor = new ArrayList<>();
        lootDoBatedor.add(armaduraArqueiro0);
        Inimigo inimigo28 = new Inimigo(
                "Batedor da Floresta", 100, 10, 8, 6, 6, 10, 8,
                new Habilidade("Golpe Rápido", "", 0, 18, false),
                lootDoBatedor
        );

        List<Item> lootDoArqueiroDeFerro = new ArrayList<>();
        lootDoArqueiroDeFerro.add(armaduraArqueiro1);
        Inimigo inimigo29 = new Inimigo(
                "Arqueiro de Ferro", 130, 12, 10, 8, 8, 12, 10,
                new Habilidade("Tiro Defensivo", "", 0, 22, false),
                lootDoArqueiroDeFerro
        );

        List<Item> lootDoLamelar = new ArrayList<>();
        lootDoLamelar.add(armaduraArqueiro2);
        Inimigo inimigo30 = new Inimigo(
                "Batedor Lamelar", 160, 15, 12, 10, 10, 15, 12,
                new Habilidade("Tiro Ágil", "", 0, 26, false),
                lootDoLamelar
        );

        List<Item> lootDoOlhoDeAgua = new ArrayList<>();
        lootDoOlhoDeAgua.add(armaduraArqueiro3);
        Inimigo inimigo31 = new Inimigo(
                "Olho de Águia", 200, 18, 14, 12, 12, 18, 14,
                new Habilidade("Disparo Mortal", "", 0, 32, false),
                lootDoOlhoDeAgua
        );

        List<Item> lootDoPredadorImortal = new ArrayList<>();
        lootDoPredadorImortal.add(armaduraArqueiro4);
        Inimigo inimigo32 = new Inimigo(
                "Predador Imortal", 250, 20, 16, 14, 14, 20, 16,
                new Habilidade("Sombra Caçadora", "", 0, 38, false),
                lootDoPredadorImortal
        );


        List<Item> lootDoAprendiz = new ArrayList<>();
        lootDoAprendiz.add(cajadoMago0);
        Inimigo inimigo33 = new Inimigo(
                "Aprendiz Sombrio", 100, 10, 6, 12, 8, 10, 10,
                new Habilidade("Bola de Fogo", "", 0, 20, true),
                lootDoAprendiz
        );

        List<Item> lootDoEscavador = new ArrayList<>();
        lootDoEscavador.add(cajadoMago1);
        Inimigo inimigo34 = new Inimigo(
                "Escavador Arcano", 140, 12, 8, 14, 10, 12, 12,
                new Habilidade("Explosão Mágica", "", 0, 25, true),
                lootDoEscavador
        );

        List<Item> lootDoCristalino = new ArrayList<>();
        lootDoCristalino.add(cajadoMago2);
        Inimigo inimigo35 = new Inimigo(
                "Cristalino Ancião", 180, 15, 10, 16, 12, 15, 12,
                new Habilidade("Rajada de Cristal", "", 0, 30, true),
                lootDoCristalino
        );

        List<Item> lootDoSábio = new ArrayList<>();
        lootDoSábio.add(cajadoMago3);
        Inimigo inimigo36 = new Inimigo(
                "Sábio das Lâminas", 220, 18, 12, 18, 14, 18, 14,
                new Habilidade("Corte Arcano", "", 0, 34, true),
                lootDoSábio
        );

        List<Item> lootDoPríncipeMorte = new ArrayList<>();
        lootDoPríncipeMorte.add(cajadoMago4);
        Inimigo inimigo37 = new Inimigo(
                "Príncipe da Morte", 260, 22, 14, 20, 16, 22, 16,
                new Habilidade("Ceifa da Alma", "", 0, 42, true),
                lootDoPríncipeMorte
        );

        List<Item> lootDoCordeiro = new ArrayList<>();
        lootDoCordeiro.add(mantoMago0);
        Inimigo inimigo38 = new Inimigo(
                "Iniciado das Sombras", 90, 8, 6, 10, 10, 8, 8,
                new Habilidade("Rajada Sombria", "", 0, 18, true),
                lootDoCordeiro
        );

        List<Item> lootDoCirculoInterno = new ArrayList<>();
        lootDoCirculoInterno.add(mantoMago1);
        Inimigo inimigo39 = new Inimigo(
                "Guardião do Círculo", 130, 12, 8, 14, 14, 12, 10,
                new Habilidade("Escudo Arcano", "", 0, 24, true),
                lootDoCirculoInterno
        );

        List<Item> lootDaChamaEterna = new ArrayList<>();
        lootDaChamaEterna.add(mantoMago2);
        Inimigo inimigo40 = new Inimigo(
                "Invocador da Chama", 170, 15, 10, 16, 16, 15, 12,
                new Habilidade("Chamas Eternas", "", 0, 30, true),
                lootDaChamaEterna
        );

        List<Item> lootDoSabioEmerito = new ArrayList<>();
        lootDoSabioEmerito.add(mantoMago3);
        Inimigo inimigo41 = new Inimigo(
                "Sábio Emérito", 210, 18, 12, 18, 18, 18, 14,
                new Habilidade("Luz Divina", "", 0, 36, true),
                lootDoSabioEmerito
        );


        Capitulo capitulo1 = new Capitulo("O Reino da Ganância");

        List<Frase> cap1PeriodoInicial = Arrays.asList(
                new Frase("Havia um reino rico e próspero, onde o povo vivia em paz."),
                new Frase("Os campos eram férteis e os rios brilhavam sob o sol."),
                new Frase("Comerciantes de terras distantes vinham negociar seus produtos."),
                new Frase("Todos acreditavam que estavam sob a proteção de um rei sábio."),
                new Frase("As muralhas altas e o castelo dourado reforçavam essa imagem."),
                new Frase("Mas por trás do trono reluzente havia segredos obscuros."),
                new Frase("O rei, embora admirado, nunca se sentia satisfeito."),
                new Frase("Quanto mais riquezas acumulava, mais desejava."),
                new Frase("Seu coração era uma fornalha de cobiça."),
                new Frase("Nenhuma festa bastava, nenhum tesouro o preenchia."),
                new Frase("Até os conselheiros notaram sua inquietação."),
                new Frase("Ele não ouvia alertas nem advertências."),
                new Frase("Apenas buscava formas de aumentar seu poder."),
                new Frase("O reino prosperava, mas o rei adoecia de ambição."),
                new Frase("No fundo, todos os sorrisos eram sustentados por medo."),
                new Frase("O medo de perder aquilo que parecia eterno."),
                new Frase("O rei começava a cogitar caminhos proibidos."),
                new Frase("Caminhos que desafiavam a própria ordem do mundo."),
                new Frase("E assim, a semente da tragédia foi plantada.")
        );

        capitulo1.setPeriodoInicial(cap1PeriodoInicial);

        Capitulo capitulo2 = new Capitulo("A Maldição do Desejo");
        capitulo1.addProximoCapitulo(capitulo2);

        List<Frase> cap2PeriodoInicial = Arrays.asList(
                new Frase("O rei, consumido pela ganância, voltou-se para magias antigas."),
                new Frase("Sussurros de feiticeiros exilados chegavam até seus ouvidos."),
                new Frase("Promessas de poder eterno o instigavam cada vez mais."),
                new Frase("Sacerdotes advertiam sobre o preço da ambição desmedida."),
                new Frase("Mas o rei já havia feito sua escolha."),
                new Frase("Ele buscava um artefato que poderia lhe dar o mundo."),
                new Frase("Chamado de Coração de Trevas, ele era tão temido quanto desejado."),
                new Frase("Dizia-se que o artefato podia dobrar a realidade."),
                new Frase("Mas também corrompia a alma de quem o possuísse."),
                new Frase("Ainda assim, o rei ordenou que seus homens o encontrassem."),
                new Frase("Expedições foram enviadas a todos os cantos do reino."),
                new Frase("Os cofres começaram a esvaziar, sustentando essa busca insana."),
                new Frase("Famílias inteiras sofreram com a exploração e os impostos."),
                new Frase("O povo, antes leal, começava a murmurar nas sombras."),
                new Frase("O brilho de prosperidade apagava-se lentamente."),
                new Frase("Tudo em nome de um desejo sem limites."),
                new Frase("Era o início da queda do reino da ganância.")
        );

        capitulo2.setPeriodoInicial(cap2PeriodoInicial);

        Capitulo capitulo3 = new Capitulo("A Escuridão que se Aproxima");
        capitulo2.addProximoCapitulo(capitulo3);

        List<Frase> cap3PeriodoInicial = Arrays.asList(
                new Frase("O reino, outrora próspero, começava a definhar."),
                new Frase("Vilarejos inteiros eram abandonados em silêncio."),
                new Frase("As colheitas secavam, e a fome se espalhava."),
                new Frase("Rumores de criaturas rondando as estradas cresciam a cada dia."),
                new Frase("Homens que saíam para caçar nunca mais retornavam."),
                new Frase("Mulheres sussurravam sobre olhos que as observavam no escuro."),
                new Frase("O medo se tornava parte da rotina de todos."),
                new Frase("E nas cidades, a desconfiança corroía os corações."),
                new Frase("O rei permanecia cego, obcecado por sua busca."),
                new Frase("Mas os sinais eram claros: algo despertava nas sombras."),
                new Frase("Forças além da compreensão humana se agitavam."),
                new Frase("Era como se o próprio mundo se contorcesse em dor."),
                new Frase("Sacerdotes falavam de profecias esquecidas."),
                new Frase("E cada verso anunciava a mesma verdade terrível."),
                new Frase("A era da luz chegava ao fim."),
                new Frase("Uma escuridão inevitável aproximava-se do reino.")
        );

        capitulo3.setPeriodoInicial(cap3PeriodoInicial);

        Capitulo capitulo4 = new Capitulo("O Herói Desperta");
        capitulo3.addProximoCapitulo(capitulo4);

        List<Frase> cap4PeriodoInicial = Arrays.asList(
                new Frase("Em uma pequena aldeia esquecida, um jovem vivia em paz."),
                new Frase("Sua rotina era simples: ajudar os pais e cuidar dos afazeres do campo."),
                new Frase("Mas algo em seu coração sempre lhe dizia que havia mais além das montanhas."),
                new Frase("Certa noite, ele sonhou com um campo em chamas."),
                new Frase("E no centro dele, uma voz ecoava em sua mente."),
                new Frase("\"Você é a chave... o último fio de esperança.\""),
                new Frase("O jovem despertou suado, sem compreender o significado."),
                new Frase("Nos dias seguintes, presságios se tornaram frequentes."),
                new Frase("Animais fugiam da floresta, como se algo os expulsasse."),
                new Frase("As pessoas da aldeia falavam sobre sombras andando sob a lua."),
                new Frase("E então, o inevitável aconteceu."),
                new Frase("Criaturas estranhas surgiram perto da fronteira da vila."),
                new Frase("Era apenas o início de uma jornada que mudaria seu destino.")
        );

        capitulo4.setPeriodoInicial(cap4PeriodoInicial);


        // Capítulo 5 — "O Primeiro Encontro" (com combate)
        Capitulo capitulo5 = new Capitulo("O Primeiro Encontro");
        capitulo4.addProximoCapitulo(capitulo5);

        List<Frase> cap5PeriodoInicial = Arrays.asList(
                new Frase("O silêncio da noite foi quebrado por um grunhido grotesco."),
                new Frase("Das sombras, uma figura cambaleante se aproximava."),
                new Frase("Sua pele apodrecida deixava claro: não era mais um homem."),
                new Frase("O jovem herói, tomado pelo instinto, ergueu sua arma."),
                new Frase("Diante dele estava um Zumbi faminto, pronto para atacar.")
        );
        capitulo5.setPeriodoInicial(cap5PeriodoInicial);

        List<Personagem> cap5Inimigos = new ArrayList<>();
        cap5Inimigos.add(inimigo1);
        capitulo5.setInimigos(cap5Inimigos);

        List<Frase> cap5PeriodoFinal = Arrays.asList(
                new Frase("O corpo do monstro caiu inerte ao chão."),
                new Frase("O herói respirava ofegante, ainda sem acreditar no que enfrentara."),
                new Frase("Mas algo em seu íntimo dizia que aquilo era apenas o começo."),
                new Frase("As trevas haviam despertado, e ele agora fazia parte da luta.")
        );
        capitulo5.setPeriodoFinal(cap5PeriodoFinal);


        Capitulo capitulo6 = new Capitulo("O Ataque na Estrada");
        capitulo5.addProximoCapitulo(capitulo6);

        List<Frase> cap6PeriodoInicial = Arrays.asList(
                new Frase("Enquanto seguia pela estrada, o herói sentiu olhos o observando."),
                new Frase("Ramos se mexiam, sombras se alongavam e o vento trazia um cheiro estranho."),
                new Frase("De repente, um esqueleto surgiu entre as árvores, brandindo uma lâmina enferrujada."),
                new Frase("O guerreiro empunhou sua espada, pronto para enfrentar a criatura morta-viva.")
        );
        capitulo6.setPeriodoInicial(cap6PeriodoInicial);

        List<Personagem> cap6Inimigos = new ArrayList<>();
        cap6Inimigos.add(inimigo2); // Esqueleto com loot espada1
        capitulo6.setInimigos(cap6Inimigos);

        List<Frase> cap6PeriodoFinal = Arrays.asList(
                new Frase("O esqueleto caiu em ossos quebrados pelo chão."),
                new Frase("O herói olhou em volta, ainda em alerta."),
                new Frase("Sabia que outros perigos poderiam surgir a qualquer momento."),
                new Frase("A estrada se dividiu e se tornava mais traiçoeira, mas ele sabe que deveria seguir firme em sua missão.")
        );
        capitulo6.setPeriodoFinal(cap6PeriodoFinal);

        Capitulo capitulo7 = new Capitulo("A Floresta Sombria");

        List<Frase> cap7PeriodoInicial = Arrays.asList(
                new Frase("O herói adentrou a floresta densa, onde a luz do sol mal penetrava."),
                new Frase("Ramos retorcidos se moviam como se tivessem vida própria."),
                new Frase("Um uivo distante fez seu coração acelerar, e algo se movia entre as sombras."),
                new Frase("De repente, um zumbi avançou com passos lentos, mas ameaçadores.")
        );
        capitulo7.setPeriodoInicial(cap7PeriodoInicial);

        List<Personagem> cap7Inimigos = new ArrayList<>();
        cap7Inimigos.add(inimigo1); // Zumbi com loot espada0
        capitulo7.setInimigos(cap7Inimigos);

        List<Frase> cap7PeriodoFinal = Arrays.asList(
                new Frase("O zumbi caiu no chão com um baque pesado."),
                new Frase("O herói respirou fundo, limpando o suor do rosto."),
                new Frase("A floresta permanecia silenciosa, mas a sensação de perigo ainda persistia."),
                new Frase("Seguiu adiante, sabendo que a missão exigiria toda sua atenção e coragem.")
        );
        capitulo7.setPeriodoFinal(cap7PeriodoFinal);



        Capitulo capitulo8 = new Capitulo("Arena do Coliseu");
        capitulo6.addProximoCapitulo(capitulo7);
        capitulo6.addProximoCapitulo(capitulo8);

        List<Frase> cap8PeriodoInicial = Arrays.asList(
                new Frase("O herói entrou na arena, cercado por milhares de espectadores."),
                new Frase("O chão de areia tremia a cada passo dos combatentes."),
                new Frase("Do outro lado, o Gladiador da Arena surgiu, brandindo sua espada com confiança."),
                new Frase("Em seguida, o Caçador de Recompensas se posicionou, mirando com precisão letal.")
        );
        capitulo8.setPeriodoInicial(cap8PeriodoInicial);

        List<Personagem> cap8Inimigos = Arrays.asList(inimigo4, inimigo5); // Gladiador da Arena e Caçador de Recompensas
        capitulo8.setInimigos(cap8Inimigos);

        List<Frase> cap8PeriodoFinal = Arrays.asList(
                new Frase("O Gladiador caiu derrotado, levantando apenas uma nuvem de poeira."),
                new Frase("O Caçador de Recompensas recuou, ferido, mas finalmente sucumbiu."),
                new Frase("O herói respirou fundo, sentindo o olhar de toda a arena sobre si."),
                new Frase("O caminho adiante estava aberto, mas desafios ainda maiores o aguardavam.")
        );
        capitulo8.setPeriodoFinal(cap8PeriodoFinal);


        Capitulo capitulo9 = new Capitulo("Floresta do Arqueiro");
        capitulo8.addProximoCapitulo(capitulo9);

        List<Frase> cap9PeriodoInicial = Arrays.asList(
                new Frase("O herói adentrou a floresta densa, onde a luz do sol mal penetrava."),
                new Frase("Galhos rangiam com o vento, anunciando que não estava sozinho."),
                new Frase("Do alto das árvores, o Caçador Perdido preparava suas flechas."),
                new Frase("Logo, Atirador de Elite surgiu de entre as sombras, mirando com precisão mortal.")
        );
        capitulo9.setPeriodoInicial(cap9PeriodoInicial);

        List<Personagem> cap9Inimigos = Arrays.asList(inimigo23, inimigo24, inimigo25); // Caçador Perdido, Atirador de Elite, Espreitador Silvestre
        capitulo9.setInimigos(cap9Inimigos);

        List<Frase> cap9PeriodoFinal = Arrays.asList(
                new Frase("O Caçador Perdido caiu de uma árvore, derrotado pelo herói."),
                new Frase("O Atirador de Elite recuou, mas foi alcançado e vencido."),
                new Frase("O Espreitador Silvestre tentou fugir, mas não havia onde se esconder."),
                new Frase("A floresta ficou silenciosa, e o herói continuou sua jornada adiante.")
        );
        capitulo9.setPeriodoFinal(cap9PeriodoFinal);


        Capitulo capitulo10 = new Capitulo("Fortaleza dos Cavaleiros");
        capitulo7.addProximoCapitulo(capitulo10);

        List<Frase> cap10PeriodoInicial = Arrays.asList(
                new Frase("O herói chegou à imponente fortaleza, com muros altos e torres ameaçadoras."),
                new Frase("Bandidos de Estrada surgiram nas portas, testando suas habilidades."),
                new Frase("Defensor da Fortaleza bloqueava cada avanço, defendendo seu território com firmeza."),
                new Frase("O Colosso de Pedra se aproximava, fazendo o chão tremer a cada passo."),
                new Frase("Finalmente, a Criatura Obsidiana e o Anjo Caído surgiram como guardiões finais.")
        );
        capitulo10.setPeriodoInicial(cap10PeriodoInicial);

        List<Personagem> cap10Inimigos = Arrays.asList(inimigo8, inimigo9, inimigo10, inimigo11, inimigo12);
        capitulo10.setInimigos(cap10Inimigos);

        List<Frase> cap10PeriodoFinal = Arrays.asList(
                new Frase("O herói derrotou o Bandido de Estrada com um golpe certeiro."),
                new Frase("O Defensor da Fortaleza caiu após um ataque estratégico."),
                new Frase("O Colosso de Pedra foi vencido, apesar de sua força titânica."),
                new Frase("A Criatura Obsidiana não suportou a investida final e tombou."),
                new Frase("O Anjo Caído foi derrotado, liberando a passagem para o interior da fortaleza.")
        );
        capitulo10.setPeriodoFinal(cap10PeriodoFinal);


        Capitulo capitulo11 = new Capitulo("Torre do Arqueiro Avançado");
        capitulo9.addProximoCapitulo(capitulo11);
        capitulo10.addProximoCapitulo(capitulo11);


        List<Frase> cap11PeriodoInicial = Arrays.asList(
                new Frase("O herói adentrou a torre, onde o silêncio era cortado apenas pelo sibilo das flechas."),
                new Frase("Caçador Perdido surgia nas sombras, atento a cada movimento."),
                new Frase("Atirador de Elite mirava com precisão, pronto para atacar a qualquer descuido."),
                new Frase("Espreitador Silvestre se escondia entre vigas e pilares, preparado para emboscadas."),
                new Frase("Arqueiro Brilhante e Arqueiro Dracônico aguardavam no topo, controlando toda a torre."),
                new Frase("Batedores e Predadores completavam a defesa, tornando a subida da torre perigosa a cada andar.")
        );
        capitulo11.setPeriodoInicial(cap11PeriodoInicial);

        List<Personagem> cap11Inimigos = Arrays.asList(
                inimigo23, inimigo24, inimigo25, inimigo26, inimigo27,
                inimigo28, inimigo29, inimigo30, inimigo31, inimigo32
        );
        capitulo11.setInimigos(cap11Inimigos);

        List<Frase> cap11PeriodoFinal = Arrays.asList(
                new Frase("O Caçador Perdido caiu após uma rápida investida."),
                new Frase("O Atirador de Elite foi derrotado com precisão e estratégia."),
                new Frase("Espreitador Silvestre não conseguiu escapar da vigilância do herói."),
                new Frase("O Arqueiro Brilhante caiu diante de um ataque combinado."),
                new Frase("O Arqueiro Dracônico foi finalmente abatido no topo da torre."),
                new Frase("Batedores e Predadores foram derrotados, garantindo acesso ao último andar.")
        );
        capitulo11.setPeriodoFinal(cap11PeriodoFinal);


        Capitulo capitulo12 = new Capitulo("Círculo Arcano");
        capitulo11.addProximoCapitulo(capitulo12);

        List<Frase> cap12PeriodoInicial = Arrays.asList(
                new Frase("O herói entrou na sala mística, onde runas brilhavam nas paredes."),
                new Frase("Aprendiz Sombrio surgiu lançando bolas de fogo."),
                new Frase("Escavador Arcano conjurava explosões mágicas do chão."),
                new Frase("Cristalino Ancião atacava com rajadas de cristal afiadas."),
                new Frase("Sábio das Lâminas invocava cortes arcanos mortais."),
                new Frase("Príncipe da Morte aguardava no centro, cercado pelos iniciados das sombras e guardiões do círculo.")
        );
        capitulo12.setPeriodoInicial(cap12PeriodoInicial);

        List<Personagem> cap12Inimigos = Arrays.asList(
                inimigo33, inimigo34, inimigo35, inimigo36, inimigo37,
                inimigo38, inimigo39, inimigo40, inimigo41
        );
        capitulo12.setInimigos(cap12Inimigos);

        List<Frase> cap12PeriodoFinal = Arrays.asList(
                new Frase("O Aprendiz Sombrio foi derrotado após intenso duelo."),
                new Frase("O Escavador Arcano sucumbiu às estratégias do herói."),
                new Frase("O Cristalino Ancião caiu diante da magia combinada do herói."),
                new Frase("Sábio das Lâminas foi vencido com perícia."),
                new Frase("O Príncipe da Morte finalmente tombou, encerrando a ameaça."),
                new Frase("Os iniciados e guardiões restantes foram dispersos, liberando o Círculo Arcano.")
        );
        capitulo12.setPeriodoFinal(cap12PeriodoFinal);



        Capitulo capitulo13 = new Capitulo("Torre do Guerreiro");
        capitulo11.addProximoCapitulo(capitulo13);

        List<Frase> cap13PeriodoInicial = Arrays.asList(
                new Frase("O herói adentrou a Torre do Guerreiro, escadas rangendo sob seus pés."),
                new Frase("Zumbi e Esqueleto surgiram do corredor escuro, prontos para atacar."),
                new Frase("Guerreiro Enferrujado avançou com sua espada corroída."),
                new Frase("Gladiador da Arena preparou uma investida poderosa."),
                new Frase("Caçador de Recompensas e Astro Quebrado cercaram o herói."),
                new Frase("Assassino das Sombras observava do alto, pronto para desferir um golpe mortal."),
                new Frase("Bandido de Estrada e Defensor da Fortaleza bloquearam o caminho."),
                new Frase("Colosso de Pedra e Criatura Obsidiana esmagavam qualquer intruso."),
                new Frase("Anjo Caído apareceu no topo da torre, irradiando poder divino.")
        );
        capitulo13.setPeriodoInicial(cap13PeriodoInicial);

        List<Personagem> cap13Inimigos = Arrays.asList(
                inimigo1, inimigo2, inimigo3, inimigo4, inimigo5, inimigo6, inimigo7,
                inimigo8, inimigo9, inimigo10, inimigo11, inimigo12
        );
        capitulo13.setInimigos(cap13Inimigos);

        List<Frase> cap13PeriodoFinal = Arrays.asList(
                new Frase("Zumbi e Esqueleto foram rapidamente derrotados."),
                new Frase("Guerreiro Enferrujado caiu após sucessivos golpes precisos."),
                new Frase("Gladiador da Arena foi vencido com estratégia e habilidade."),
                new Frase("Caçador de Recompensas e Astro Quebrado não resistiram ao poder do herói."),
                new Frase("Assassino das Sombras tentou escapar, mas foi derrotado."),
                new Frase("Bandido de Estrada e Defensor da Fortaleza sucumbiram."),
                new Frase("Colosso de Pedra e Criatura Obsidiana foram derrubados."),
                new Frase("O Anjo Caído finalmente caiu, encerrando a tirania na torre.")
        );
        capitulo13.setPeriodoFinal(cap13PeriodoFinal);

        Capitulo capitulo14 = new Capitulo("Floresta dos Arqueiros");
        capitulo12.addProximoCapitulo(capitulo14);

        List<Frase> cap14PeriodoInicial = Arrays.asList(
                new Frase("O herói entrou na densa Floresta dos Arqueiros, o vento sussurrando entre as árvores."),
                new Frase("Caçador Perdido e Atirador de Elite surgiram das sombras, flechas prontas."),
                new Frase("Espreitador Silvestre e Arqueiro Brilhante se posicionaram em pontos estratégicos."),
                new Frase("Arqueiro Dracônico observava de um galho alto, suas flechas brilhando com magia."),
                new Frase("Batedor da Floresta e Arqueiro de Ferro cercaram o herói."),
                new Frase("Batedor Lamelar e Olho de Águia preparavam disparos certeiros."),
                new Frase("Predador Imortal surgia, silencioso, pronto para eliminar qualquer inimigo.")
        );
        capitulo14.setPeriodoInicial(cap14PeriodoInicial);

        List<Personagem> cap14Inimigos = Arrays.asList(
                inimigo23, inimigo24, inimigo25, inimigo26, inimigo27,
                inimigo28, inimigo29, inimigo30, inimigo31, inimigo32
        );
        capitulo14.setInimigos(cap14Inimigos);


        List<Frase> cap14PeriodoFinal = Arrays.asList(
                new Frase("Caçador Perdido e Atirador de Elite caíram rapidamente."),
                new Frase("Espreitador Silvestre e Arqueiro Brilhante foram derrotados."),
                new Frase("Arqueiro Dracônico não resistiu aos golpes precisos do herói."),
                new Frase("Batedor da Floresta e Arqueiro de Ferro sucumbiram."),
                new Frase("Batedor Lamelar e Olho de Águia foram vencidos."),
                new Frase("O Predador Imortal caiu silenciosamente, encerrando a ameaça na floresta.")
        );
        capitulo14.setPeriodoFinal(cap14PeriodoFinal);


        Capitulo capitulo15 = new Capitulo("Torre dos Magos");
        capitulo13.addProximoCapitulo(capitulo15);

        List<Frase> cap15PeriodoInicial = Arrays.asList(
                new Frase("O herói chegou à Torre dos Magos, um local cheio de mistérios e magia."),
                new Frase("Aprendiz Sombrio lançou sua primeira bola de fogo."),
                new Frase("Escavador Arcano começou a invocar explosões mágicas ao redor."),
                new Frase("Cristalino Ancião ergueu cristais para atacar."),
                new Frase("Sábio das Lâminas avançava com cortes de energia arcana."),
                new Frase("Príncipe da Morte preparava sua Ceifa da Alma."),
                new Frase("Iniciado das Sombras e Guardião do Círculo atacavam em conjunto."),
                new Frase("Invocador da Chama criou chamas que percorriam o salão."),
                new Frase("Sábio Emérito iluminava a torre com magia devastadora.")
        );
        capitulo15.setPeriodoInicial(cap15PeriodoInicial);

// Inimigos do capítulo
        List<Personagem> cap15Inimigos = Arrays.asList(
                inimigo33, inimigo34, inimigo35, inimigo36, inimigo37,
                inimigo38, inimigo39, inimigo40, inimigo41
        );
        capitulo15.setInimigos(cap15Inimigos);

// Narrativa depois do combate
        List<Frase> cap15PeriodoFinal = Arrays.asList(
                new Frase("Aprendiz Sombrio caiu derrotado após uma sequência de ataques."),
                new Frase("Escavador Arcano e Cristalino Ancião não resistiram à ofensiva do herói."),
                new Frase("Sábio das Lâminas e Príncipe da Morte foram vencidos."),
                new Frase("Iniciado das Sombras e Guardião do Círculo sucumbiram."),
                new Frase("Invocador da Chama e Sábio Emérito caíram, encerrando a batalha mágica na torre.")
        );
        capitulo15.setPeriodoFinal(cap15PeriodoFinal);


        Capitulo capitulo16 = new Capitulo("O Confronto Final");
        capitulo15.addProximoCapitulo(capitulo16);
        capitulo14.addProximoCapitulo(capitulo16);

// Narrativa antes do combate
        List<Frase> cap16PeriodoInicial = Arrays.asList(
                new Frase("O herói finalmente chegou ao Salão do Confronto Final."),
                new Frase("Anjo Caído flutuava imponente, sua espada celestial brilhando."),
                new Frase("Predador Imortal surgiu das sombras da arena."),
                new Frase("Arqueiro Dracônico lançou flechas imbuidas com energia dracônica."),
                new Frase("Príncipe da Morte preparava sua magia mais mortal."),
                new Frase("A tensão era palpável, e o destino do reino dependia dessa batalha.")
        );
        capitulo16.setPeriodoInicial(cap16PeriodoInicial);

        List<Personagem> cap16Inimigos = Arrays.asList(
                inimigo12, // Anjo Caído
                inimigo22, // Anjo Caído (versão armadura)
                inimigo27, // Arqueiro Dracônico
                inimigo32, // Predador Imortal
                inimigo37  // Príncipe da Morte
        );
        capitulo16.setInimigos(cap16Inimigos);

// Narrativa depois do combate
        List<Frase> cap16PeriodoFinal = Arrays.asList(
                new Frase("O Anjo Caído caiu após uma série de ataques precisos."),
                new Frase("O Predador Imortal foi derrotado após uma ofensiva combinada."),
                new Frase("O Arqueiro Dracônico não resistiu aos golpes do herói."),
                new Frase("O Príncipe da Morte tentou um último ataque, mas foi contido."),
                new Frase("Com a vitória, o herói garantiu a paz ao reino e encerrou sua jornada épica.")
        );
        capitulo16.setPeriodoFinal(cap16PeriodoFinal);

        Capitulo capitulo17 = new Capitulo("O Despertar do Herói");
        capitulo16.addProximoCapitulo(capitulo17);

        List<Frase> cap17PeriodoInicial = Arrays.asList(
                new Frase("Após a grande batalha, o herói se ergueu entre os escombros da arena."),
                new Frase("O céu clareava, iluminando o reino com uma nova esperança."),
                new Frase("As cicatrizes da luta permaneciam, mas a determinação do herói estava mais forte do que nunca."),
                new Frase("Os aliados se reuniram ao seu redor, celebrando a vitória e a paz restaurada."),
                new Frase("O herói olhou para o horizonte, ciente de que sua jornada estava apenas começando em um novo capítulo da vida.")
        );
        capitulo17.setPeriodoInicial(cap17PeriodoInicial);

        capitulo17.setInimigos(new ArrayList<>());

        List<Frase> cap17PeriodoFinal = Arrays.asList(
                new Frase("Com coragem e determinação, o herói inspirou todos ao redor."),
                new Frase("O reino floresceu sob sua proteção e sabedoria."),
                new Frase("As lendas sobre suas batalhas ecoariam por gerações."),
                new Frase("E assim, o herói encontrou seu verdadeiro propósito, tornando-se símbolo de esperança eterna."),
                new Frase("Fim da saga, mas o espírito do herói continuaria vivo no coração de todos.")
        );
        capitulo17.setPeriodoFinal(cap17PeriodoFinal);


        this.historia = new Historia(capitulo1);
    }


    public Historia getHistoria() {
        return this.historia;
    }
}