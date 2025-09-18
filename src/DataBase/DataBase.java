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
    public Item mantoMago0, mantoMago1, mantoMago2, mantoMago3, mantoMago4;

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
        mantoMago4 = new Item("Cloak of the Starry Void", 10, 0, 8, 10, 4, 0, 1);

        // --- A PARTE QUE VOCÊ PEDIU PARA MUDAR ---
        List<Item> lootDoZumbi = new ArrayList<>();
        lootDoZumbi.add(espada0);
        List<Item> lootDoEsqueleto = new ArrayList<>();
        lootDoEsqueleto.add(espada1);

//        inimigo1 = new Inimigo(
//                "Zumbi", 100, 10, 10, 10, 10, 10, 10,
//                new Habilidade("Tapa", "", 0, 15, false),
//                lootDoZumbi
//        );
//
//        Inimigo inimigo2 = new Inimigo(
//                "Esqueleto", 100, 10, 10, 10, 10, 10, 10,
//                new Habilidade("Tapa", "", 0, 15, false),
//                lootDoEsqueleto
//        );
        // --- FIM DA MUDANÇA ---

        // --- CRIAÇÃO DOS CAPÍTULOS E HISTÓRIA ---

        Capitulo capitulo1 = new Capitulo("O Reino da Ganância");

        List<Frase> cap1 = Arrays.asList(
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
        capitulo1.setPeriodoInicial(cap1);

        Capitulo capitulo2 = new Capitulo("O Pacto Sombrio");

        List<Frase> cap2 = Arrays.asList(
                new Frase("Em uma noite sem lua, o rei convocou rituais proibidos."),
                new Frase("Magos foram chamados, e sacerdotes silenciados à força."),
                new Frase("Os salões do castelo tremeram com cânticos sombrios."),
                new Frase("O ar cheirava a enxofre e sangue derramado."),
                new Frase("O chão se abriu em fendas ardentes."),
                new Frase("De lá, emergiu o demônio, envolto em chamas."),
                new Frase("Seus olhos eram buracos negros cheios de fome."),
                new Frase("Sua voz ecoou como trovão subterrâneo."),
                new Frase("\"O que deseja, humano miserável?\", perguntou."),
                new Frase("O rei, sem hesitar, pediu riquezas infinitas."),
                new Frase("O demônio sorriu, como se já esperasse."),
                new Frase("\"E o que me darás em troca?\", zombou."),
                new Frase("O silêncio dominou o salão por segundos."),
                new Frase("O rei ofereceu sua filha recém-nascida."),
                new Frase("O demônio gargalhou, satisfeito com a perversidade."),
                new Frase("O pacto foi selado em sangue."),
                new Frase("A criança foi levada nas sombras."),
                new Frase("Em seu lugar, montanhas de ouro surgiram."),
                new Frase("O rei contemplou a fortuna e se calou."),
                new Frase("Mas o eco do choro da filha nunca o deixou.")
        );

        capitulo2.setPeriodoInicial(cap2);

        Capitulo capitulo3 = new Capitulo("Riquezas e Arrependimento");

        List<Frase> cap3 = Arrays.asList(
                new Frase("Os anos passaram, e o castelo transbordava riquezas."),
                new Frase("Ouro cobria corredores e salões."),
                new Frase("Festas intermináveis enchiam noites inteiras."),
                new Frase("Nobres riam em meio ao excesso."),
                new Frase("O povo, embora mais rico, sofria em silêncio."),
                new Frase("O rei estava sempre cercado por banquetes."),
                new Frase("Seu corpo engordava, mas sua alma esvaziava."),
                new Frase("No fundo, ele lembrava da filha perdida."),
                new Frase("A culpa corroía seu coração envelhecido."),
                new Frase("O pacto o fazia poderoso, mas também escravo."),
                new Frase("Pesadelos o perseguiam a cada noite."),
                new Frase("Ele via o rosto da criança envolto em trevas."),
                new Frase("O ouro já não tinha gosto de vitória."),
                new Frase("Apenas de maldição."),
                new Frase("Tomado pelo arrependimento, o rei decidiu agir."),
                new Frase("Não podia mais viver sob aquela sombra."),
                new Frase("Decidiu quebrar o pacto a qualquer custo."),
                new Frase("E para isso, ofereceu uma fortuna."),
                new Frase("Ao homem que ousasse desafiar o demônio."),
                new Frase("Assim nasceu o chamado ao herói.")
        );

        capitulo3.setPeriodoInicial(cap3);

        Capitulo capitulo4 = new Capitulo("O Chamado do Herói");

        List<Frase> cap4 = Arrays.asList(
                new Frase("O chamado ecoou por todo o reino."),
                new Frase("Cartazes foram pregados em tavernas e vilarejos."),
                new Frase("Homens ambiciosos tentaram a sorte."),
                new Frase("Mas todos sumiram sem deixar rastro."),
                new Frase("O medo se espalhou rapidamente."),
                new Frase("Diziam que o demônio devorava suas almas."),
                new Frase("Outros acreditavam que o ouro era apenas uma armadilha."),
                new Frase("Mesmo assim, aventureiros continuaram tentando."),
                new Frase("A recompensa era irresistível."),
                new Frase("Entre eles surgiu um jovem aventureiro."),
                new Frase("Ele não buscava o ouro."),
                new Frase("Seu objetivo era a justiça."),
                new Frase("Tinha ouvido sobre a criança perdida."),
                new Frase("E decidiu que iria resgatá-la."),
                new Frase("Carregava apenas sua coragem."),
                new Frase("Partiu sozinho rumo ao castelo."),
                new Frase("O povo observava em silêncio."),
                new Frase("Alguns o chamaram de tolo."),
                new Frase("Outros o chamaram de herói."),
                new Frase("E assim começou sua jornada.")
        );

        Capitulo capitulo5 = new Capitulo("Preparativos e Decisão");

        List<Frase> cap5 = Arrays.asList(
                new Frase("O guerreiro entrou no castelo do rei."),
                new Frase("As paredes estavam cobertas de ouro."),
                new Frase("O brilho ofuscava os olhos."),
                new Frase("Mas também revelava decadência."),
                new Frase("Servos andavam cabisbaixos."),
                new Frase("Os nobres se embriagavam sem parar."),
                new Frase("Era um palácio de luxo e tristeza."),
                new Frase("O rei o recebeu no trono dourado."),
                new Frase("Seu olhar era cansado."),
                new Frase("E sua voz, quase um sussurro."),
                new Frase("Ele confessou a verdade ao guerreiro."),
                new Frase("Contou sobre o pacto e o demônio."),
                new Frase("E sobre a filha entregue às trevas."),
                new Frase("O herói escutou em silêncio."),
                new Frase("Não julgou o rei, mas sentiu repulsa."),
                new Frase("Jurou encontrar a criança."),
                new Frase("E, se possível, quebrar o pacto."),
                new Frase("O rei entregou a ele um amuleto antigo."),
                new Frase("Era a chave para abrir os portões do inferno."),
                new Frase("E também a sentença de seu destino.")
        );

        Capitulo capitulo6 = new Capitulo("A Jornada Começa");

        List<Frase> cap6 = Arrays.asList(
                new Frase("O guerreiro deixou o castelo ao amanhecer."),
                new Frase("O sol iluminava sua armadura simples."),
                new Frase("O amuleto brilhava em suas mãos."),
                new Frase("Seu caminho o levaria até as montanhas."),
                new Frase("Ali, diziam estar os portões do inferno."),
                new Frase("A estrada era longa e perigosa."),
                new Frase("Bestas selvagens rondavam as florestas."),
                new Frase("Bandidos saqueavam viajantes indefesos."),
                new Frase("Mas o guerreiro não hesitava."),
                new Frase("Cada batalha era apenas um teste."),
                new Frase("Cada ferida o tornava mais forte."),
                new Frase("Na sua mente, apenas um objetivo."),
                new Frase("Salvar a filha perdida."),
                new Frase("E destruir o demônio."),
                new Frase("Numa noite estrelada, sonhou com ela."),
                new Frase("Uma criança acorrentada em chamas."),
                new Frase("Chamava por socorro."),
                new Frase("O herói acordou suando."),
                new Frase("Sabia que o tempo estava se esgotando."),
                new Frase("E que o inferno já o esperava.")
        );

        Capitulo capitulo7 = new Capitulo("Floresta dos Sussurros");

        List<Frase> cap7 = Arrays.asList(
                new Frase("O herói adentrou a Floresta dos Sussurros."),
                new Frase("As árvores pareciam vivas, movendo-se com o vento."),
                new Frase("Ramos longos e sombrios arranhavam seu rosto."),
                new Frase("O silêncio era pesado, quase sufocante."),
                new Frase("Sombras dançavam entre as folhas."),
                new Frase("Criaturas desconhecidas espreitavam na penumbra."),
                new Frase("O chão estava coberto de raízes que pareciam mãos."),
                new Frase("Cada passo exigia atenção redobrada."),
                new Frase("O herói sentiu olhos invisíveis sobre ele."),
                new Frase("Sons estranhos ecoavam entre os troncos."),
                new Frase("Um uivo distante fez seu coração acelerar."),
                new Frase("O herói sacou sua espada, pronto para qualquer ataque."),
                new Frase("Mas a floresta testava mais sua mente que seu corpo."),
                new Frase("Sussurros diziam seu nome, confundindo-o."),
                new Frase("Ele precisou respirar fundo e se concentrar."),
                new Frase("Seguiu adiante com passos firmes."),
                new Frase("Ao longe, uma bifurcação se revelou."),
                new Frase("Três caminhos: um comum, um belo e um sombrio."),
                new Frase("Cada um prometia desafios diferentes."),
                new Frase("O herói escolheu seguir pelo caminho que parecia mais seguro.")
        );


        Capitulo capitulo8 = new Capitulo("Ruínas e Mímicos");

        List<Frase> cap8 = Arrays.asList(
                new Frase("O caminho comum trouxe monstros previsíveis."),
                new Frase("Lobos corrompidos e guerreiros mortos-vivos."),
                new Frase("A batalha foi rápida, mas exaustiva."),
                new Frase("O herói continuava firme, mesmo ferido."),
                new Frase("O suor escorria pelo seu rosto."),
                new Frase("A espada parecia pesar o dobro."),
                new Frase("Cada golpe era uma dança de vida ou morte."),
                new Frase("Ele lembrava da princesa a cada ataque."),
                new Frase("Isso fortalecia sua determinação."),
                new Frase("Após derrotar os monstros, o caminho se abriu para ruínas antigas."),
                new Frase("Uma cabana destruída se destacava entre árvores."),
                new Frase("Dentro dela, um baú reluzia com ouro."),
                new Frase("Ao se aproximar, o baú revelou-se um Mímico."),
                new Frase("A criatura atacou com dentes e tentáculos."),
                new Frase("O herói desviou, esquivando-se rapidamente."),
                new Frase("Um golpe certeiro derrotou o monstro."),
                new Frase("Ele pegou o que conseguiu do baú sem confiar em nada."),
                new Frase("O caminho à frente continuava sinuoso e perigoso."),
                new Frase("Mas ele não podia parar."),
                new Frase("O inferno aguardava, e a princesa também.")
        );

        Capitulo capitulo9 = new Capitulo("O Caminho do Medo");

        List<Frase> cap9 = Arrays.asList(
                new Frase("O herói entrou na trilha sombria, onde uma placa o advertia."),
                new Frase("\"Castelo do Majestoso, Digníssimo, Maravilhoso Rei Demônio – 500 metros.\""),
                new Frase("O ar ficou mais frio, e a luz do sol desapareceu."),
                new Frase("Ele sentiu a presença do mal se aproximando."),
                new Frase("Não havia monstros visíveis, mas a sensação de perigo era constante."),
                new Frase("Cada passo parecia mais pesado que o anterior."),
                new Frase("O silêncio da floresta era quebrado apenas por seus passos."),
                new Frase("O coração do herói batia acelerado."),
                new Frase("Pensou em quantos haviam tentado e falhado."),
                new Frase("Mas desistir não era uma opção."),
                new Frase("O amuleto em suas mãos parecia pulsar."),
                new Frase("Ele seguia um caminho que levava direto ao castelo do demônio."),
                new Frase("A ansiedade crescia a cada metro percorrido."),
                new Frase("Sussurros pareciam vir da própria terra."),
                new Frase("Ele apertou o cabo da espada."),
                new Frase("Cada respiração era um esforço calculado."),
                new Frase("O destino da princesa estava próximo."),
                new Frase("E também a batalha mais difícil de sua vida."),
                new Frase("Ele podia sentir o poder do demônio se aproximando."),
                new Frase("Mas nada desviaria o herói de sua missão.")
        );

        Capitulo capitulo10 = new Capitulo("Campo Ilusório");

        List<Frase> cap10 = Arrays.asList(
                new Frase("O caminho se abriu para um campo florido e ilusório."),
                new Frase("Flores de cores intensas pareciam brilhar com luz própria."),
                new Frase("Mas a beleza escondia perigo."),
                new Frase("Borboletas demoníacas voavam silenciosas."),
                new Frase("Serpentes aladas rastejavam entre os arbustos."),
                new Frase("O herói avançava com cautela, atento a cada movimento."),
                new Frase("Mesmo o vento parecia murmurar ameaças."),
                new Frase("Um passo em falso poderia ser fatal."),
                new Frase("Criaturas atacavam de surpresa, exigindo reflexos rápidos."),
                new Frase("Ele desviava, atacava e continuava firme."),
                new Frase("Cada vitória reforçava sua determinação."),
                new Frase("Mas o cansaço começava a pesar em seus ombros."),
                new Frase("O sol já se punha, tingindo o céu de vermelho."),
                new Frase("O herói respirava fundo, mantendo a mente clara."),
                new Frase("Ele pensava na princesa e na missão."),
                new Frase("O campo parecia interminável."),
                new Frase("Sombras se alongavam pelo chão."),
                new Frase("O frio da noite chegava rápido."),
                new Frase("Mas ele não podia parar."),
                new Frase("O castelo do demônio estava mais próximo a cada passo.")
        );

        Capitulo capitulo11 = new Capitulo("O Silêncio do Castelo");

        List<Frase> cap11 = Arrays.asList(
                new Frase("A noite caiu completamente, e a lua iluminava a estrada."),
                new Frase("O herói avançava entre árvores retorcidas e pedras pontiagudas."),
                new Frase("Cada som parecia amplificado pelo silêncio."),
                new Frase("Ele ouviu rosnados e passos que não podia ver."),
                new Frase("O medo era constante, mas não o paralisava."),
                new Frase("Ele lembrava do amuleto e do pacto do rei."),
                new Frase("Tudo estava ligado a uma única missão: salvar a princesa."),
                new Frase("Criaturas invisíveis o cercavam, testando sua coragem."),
                new Frase("Ele atacava sem hesitar, mesmo sem ver o inimigo."),
                new Frase("O ar estava pesado e carregado de magia negra."),
                new Frase("O herói sentiu a proximidade do castelo."),
                new Frase("As árvores se abriam para revelar colinas sombrias."),
                new Frase("O vento soprava trazendo sussurros de advertência."),
                new Frase("Ele respirou fundo e continuou a marcha."),
                new Frase("A determinação não deixava espaço para dúvida."),
                new Frase("A cada passo, lembrava da criança em perigo."),
                new Frase("Não havia volta, nem escolha segura."),
                new Frase("O inferno se aproximava em silêncio."),
                new Frase("E ele precisava enfrentá-lo de frente."),
                new Frase("A batalha mais importante ainda não tinha começado.")
        );
        capitulo11.setPeriodoInicial(cap11);

        Capitulo capitulo12 = new Capitulo("O Encontro com o Demônio");

        List<Frase> cap12 = Arrays.asList(
                new Frase("O herói finalmente avistou o castelo do demônio."),
                new Frase("Torres negras se erguiam contra o céu estrelado."),
                new Frase("O portão principal estava fechado e imponente."),
                new Frase("Mas o amuleto começou a brilhar, indicando a entrada."),
                new Frase("Ele empurrou as portas com força."),
                new Frase("O rangido ecoou pelo salão vazio."),
                new Frase("O cheiro de enxofre e podridão tomou conta do ambiente."),
                new Frase("O herói sacou a espada, pronto para qualquer emboscada."),
                new Frase("O silêncio do castelo era quase ensurdecedor."),
                new Frase("Cada passo ressoava nas pedras frias."),
                new Frase("Ele subiu as escadas e sentiu o poder do demônio crescer."),
                new Frase("O salão principal estava decorado com riquezas absurdas."),
                new Frase("E no centro, o rei demônio segurava a princesa."),
                new Frase("Para surpresa do herói, o demônio estava maquiado de forma grotesca."),
                new Frase("Batom borrado, blush exagerado e sombras coloridas."),
                new Frase("A cena era ridícula, mas o perigo era real."),
                new Frase("O herói respirou fundo, mantendo o foco."),
                new Frase("O demônio percebeu sua presença e sorriu."),
                new Frase("Perguntou de forma zombeteira o que ele fazia ali."),
                new Frase("Sem responder, o herói avançou para o combate final.")
        );


        Capitulo capitulo13 = new Capitulo("Batalha Final com o Rei Demônio");

        List<Frase> cap13 = Arrays.asList(
                new Frase("O combate começou com um estrondo que sacudiu o salão."),
                new Frase("O herói atacava com golpes precisos e ágeis."),
                new Frase("O demônio desviava com movimentos sobrenaturais."),
                new Frase("Chamas surgiam do chão, queimando pedras e tapeçarias."),
                new Frase("O cheiro de enxofre e magia negra era sufocante."),
                new Frase("O herói esquivava e contra-atacava sem cessar."),
                new Frase("Cada golpe desferido era um teste de resistência."),
                new Frase("O demônio ria de forma grotesca a cada ataque falho."),
                new Frase("Mas o guerreiro não vacilava."),
                new Frase("Ele lembrava da criança que precisava salvar."),
                new Frase("E isso fortalecia sua determinação."),
                new Frase("As paredes do castelo tremiam a cada impacto."),
                new Frase("Fragmentos de ouro e pedra caíam sobre o chão."),
                new Frase("O demônio tentava intimidar o herói com ilusões."),
                new Frase("Rostos horríveis surgiam ao redor, mas ele não se desviava."),
                new Frase("O sangue do herói escorria, mas ele continuava a lutar."),
                new Frase("Finalmente, com um golpe certeiro, perfurou o peito do demônio."),
                new Frase("O rei caiu com um grito que ecoou pelo castelo."),
                new Frase("A princesa caiu no chão, liberta do aperto do demônio."),
                new Frase("Mas algo estranho ainda pairava no ar.")
        );

        Capitulo capitulo14 = new Capitulo("A Ira da Princesa");

        List<Frase> cap14 = Arrays.asList(
                new Frase("A princesa levantou-se com fúria nos olhos."),
                new Frase("Em vez de gratidão, havia ódio e raiva."),
                new Frase("Ela atacou o herói sem aviso."),
                new Frase("O que era para ser resgate tornou-se pesadelo."),
                new Frase("O guerreiro recuou para se defender."),
                new Frase("A princesa atacava com força surpreendente."),
                new Frase("Cada golpe dela era rápido e mortal."),
                new Frase("O herói desviava e tentava dialogar."),
                new Frase("Mas suas palavras não tinham efeito."),
                new Frase("A batalha tornou-se inevitável."),
                new Frase("Eles lutavam entre corredores e salões quebrados."),
                new Frase("Fragmentos de móveis voavam com os golpes."),
                new Frase("O suor escorria e o coração batia acelerado."),
                new Frase("O herói tentava conter a força da princesa."),
                new Frase("Ela parecia movida por uma energia obscura."),
                new Frase("A cada ataque, sua fúria crescia."),
                new Frase("Ele precisava vencê-la sem matá-la, se possível."),
                new Frase("Mas a batalha parecia não ter fim."),
                new Frase("O silêncio do castelo era cortado pelos gritos e choques."),
                new Frase("O destino da princesa e do herói estava em jogo.")
        );

        Capitulo capitulo15 = new Capitulo("O Desfecho da Confrontação");

        List<Frase> cap15 = Arrays.asList(
                new Frase("O confronto continuava intenso."),
                new Frase("O herói finalmente encontrou uma abertura."),
                new Frase("Usou toda sua força e habilidade."),
                new Frase("Desarmou a princesa, mas sem feri-la gravemente."),
                new Frase("Ela caiu no chão, exausta e enfurecida."),
                new Frase("O herói respirou fundo, tentando recuperar o fôlego."),
                new Frase("O castelo parecia ainda mais silencioso agora."),
                new Frase("O perigo imediato havia terminado."),
                new Frase("Mas a tensão ainda pairava no ar."),
                new Frase("O herói se aproximou da princesa com cautela."),
                new Frase("Ela olhou para ele com desconfiança e raiva."),
                new Frase("Palavras poderiam reconciliá-los, mas o medo era grande."),
                new Frase("Ele manteve a guarda, sabendo que qualquer movimento errado seria fatal."),
                new Frase("O sol começava a nascer por entre as torres quebradas."),
                new Frase("A luz iluminava o castelo e as cicatrizes da batalha."),
                new Frase("O herói olhou para o céu, pensando no que ainda estava por vir."),
                new Frase("Sua jornada não havia terminado, apenas mudara de direção."),
                new Frase("Ele sabia que precisaria continuar buscando aventuras."),
                new Frase("E que jamais retornaria ao castelo do rei que o enviou."),
                new Frase("A história deles estava apenas começando, mesmo após a batalha final.")
        );

        Capitulo capitulo16 = new Capitulo("A Partida do Castelo");

        List<Frase> cap16 = Arrays.asList(
                new Frase("O herói deixou o castelo ao amanhecer."),
                new Frase("O silêncio após a batalha era pesado."),
                new Frase("A princesa caminhava alguns passos atrás, ainda desconfiada."),
                new Frase("As ruínas do castelo pareciam chorar o passado."),
                new Frase("O vento soprava levando poeira e fragmentos de pedra."),
                new Frase("O herói lembrava do rei demônio e da loucura da maquiagem."),
                new Frase("Ele sorriu brevemente, apesar da tensão."),
                new Frase("O caminho à frente era desconhecido."),
                new Frase("Mas a liberdade da princesa lhe dava esperança."),
                new Frase("Eles seguiram por trilhas quebradas e campos devastados."),
                new Frase("O herói permanecia vigilante, temendo armadilhas remanescentes."),
                new Frase("A princesa olhava o horizonte com expressão incerta."),
                new Frase("O dia prometia calor e desafios."),
                new Frase("Eles precisavam recuperar forças."),
                new Frase("Árvores antigas ofereciam sombra e proteção."),
                new Frase("O herói refletia sobre sua jornada até então."),
                new Frase("Cada batalha, cada monstro, cada perigo tinha moldado sua coragem."),
                new Frase("Mas ele sabia que aventuras futuras o aguardavam."),
                new Frase("O mundo era vasto, e os desafios nunca cessariam."),
                new Frase("Ele apertou o amuleto, lembrando do pacto quebrado.")
        );

        Capitulo capitulo17 = new Capitulo("Ameaças na Estrada");

        capitulo16.setPeriodoInicial(cap16);

        List<Frase> cap17 = Arrays.asList(
                new Frase("Enquanto caminhavam, surgiram novas ameaças."),
                new Frase("Bandidos tentaram emboscá-los em uma trilha estreita."),
                new Frase("O herói enfrentou-os com destreza."),
                new Frase("A princesa observava, ainda reticente."),
                new Frase("Alguns bandidos eram habilidosos, mas o herói era mais rápido."),
                new Frase("Ele derrubou-os um a um sem hesitar."),
                new Frase("O perigo constante fortalecia sua determinação."),
                new Frase("Cada vitória reforçava sua confiança."),
                new Frase("O herói sabia que o mundo estava cheio de sombras."),
                new Frase("E que nem toda batalha terminava com glória."),
                new Frase("Porém, ele sentia que nada podia detê-lo."),
                new Frase("A princesa, lentamente, começou a confiar um pouco mais."),
                new Frase("Ainda desconfiada, mas menos hostil."),
                new Frase("Eles continuaram a jornada por florestas e montanhas."),
                new Frase("O céu alternava entre nuvens e raios de sol."),
                new Frase("O vento trazia cheiros de flores e terra molhada."),
                new Frase("O herói sentia que estavam mais próximos de casa."),
                new Frase("Mas a lembrança do pacto e do demônio nunca o abandonava."),
                new Frase("Era um fardo que carregaria para sempre."),
                new Frase("Mesmo assim, seguia firme, pronto para qualquer desafio.")
        );
        capitulo17.setPeriodoInicial(cap17);

        Capitulo capitulo18 = new Capitulo("Ruínas Antigas e Tesouros");

        List<Frase> cap18 = Arrays.asList(
                new Frase("Certa manhã, encontraram ruínas antigas à beira de um lago."),
                new Frase("Dentro, um Mímico escondia tesouros ilusórios."),
                new Frase("O herói se aproximou cautelosamente."),
                new Frase("O Mímico saltou, revelando dentes afiados e língua longa."),
                new Frase("O combate foi rápido e brutal."),
                new Frase("O herói atacou com precisão e inteligência."),
                new Frase("O Mímico caiu derrotado, deixando o tesouro real exposto."),
                new Frase("Ele pegou apenas o necessário, evitando ambições."),
                new Frase("A princesa observava, admirada e cautelosa."),
                new Frase("Eles continuaram a explorar as ruínas em busca de pistas."),
                new Frase("As pedras antigas contavam histórias esquecidas."),
                new Frase("Runas e inscrições indicavam batalhas passadas."),
                new Frase("O herói estudava cada detalhe com atenção."),
                new Frase("A princesa começou a aprender com ele."),
                new Frase("A jornada também era um aprendizado."),
                new Frase("Cada desafio revelava algo novo sobre coragem e confiança."),
                new Frase("O sol se punha, tingindo as ruínas de dourado."),
                new Frase("Eles acamparam ali, preparando-se para o dia seguinte."),
                new Frase("O mundo continuava perigoso, mas eles se sentiam mais fortes."),
                new Frase("E o herói sabia que a estrada ainda reservava surpresas.")
        );
        capitulo18.setPeriodoInicial(cap18);

        Capitulo capitulo19 = new Capitulo("O Penúltimo Dia da Jornada");

        List<Frase> cap19 = Arrays.asList(
                new Frase("O penúltimo dia da jornada trouxe calmaria e tensão."),
                new Frase("O herói sentia que o fim se aproximava."),
                new Frase("A princesa ainda o observava com desconfiança, mas menos agressiva."),
                new Frase("Eles atravessaram campos, florestas e pequenos vilarejos."),
                new Frase("Alguns aldeões reconheciam o herói e agradeciam."),
                new Frase("Mas outros permaneciam cautelosos, lembrando das histórias do demônio."),
                new Frase("O herói continuava vigilante, atento a qualquer sinal de perigo."),
                new Frase("O céu estava limpo, com nuvens esparsas."),
                new Frase("O vento soprava suave, trazendo o cheiro de flores e ervas."),
                new Frase("Eles descansaram sob árvores antigas e sombrias."),
                new Frase("O herói refletia sobre todas as batalhas enfrentadas."),
                new Frase("Cada monstro, cada sombra, cada perigo moldou sua força."),
                new Frase("A princesa começou a confiar mais, mas ainda hesitava."),
                new Frase("O silêncio entre eles era confortável, mas carregado de expectativa."),
                new Frase("Eles estavam próximos do fim da jornada."),
                new Frase("O herói sabia que precisaria de toda sua habilidade para o último desafio."),
                new Frase("O mundo parecia respirar junto com eles."),
                new Frase("Cada passo os aproximava do destino final."),
                new Frase("A coragem era agora a única guia."),
                new Frase("E a determinação era o que os manteria vivos.")
        );

        Capitulo capitulo20 = new Capitulo("Novo Horizonte");

        List<Frase> cap20 = Arrays.asList(
                new Frase("No último dia, chegaram a uma estrada aberta e iluminada."),
                new Frase("O castelo onde tudo começou surgia à distância."),
                new Frase("O sol brilhava forte, refletindo nas torres quebradas."),
                new Frase("O herói apertou o amuleto em sua mão."),
                new Frase("Ele se lembrava do pacto, do demônio e da filha perdida."),
                new Frase("A princesa caminhava ao seu lado, agora menos hostil."),
                new Frase("Eles entraram no castelo pela porta principal com cautela."),
                new Frase("O silêncio reinava, mas o perigo ainda existia."),
                new Frase("Eles percorreram salões e corredores danificados."),
                new Frase("O herói sentia a presença de algo que ainda poderia atacar."),
                new Frase("Mas a batalha final já havia acontecido."),
                new Frase("O rei demônio estava derrotado, a princesa liberta."),
                new Frase("O herói sabia que sua missão havia sido cumprida."),
                new Frase("Eles saíram do castelo, respirando o ar da liberdade."),
                new Frase("O mundo lá fora parecia mais vasto e cheio de possibilidades."),
                new Frase("O herói estava pronto para novas aventuras."),
                new Frase("A princesa olhou para ele, finalmente em paz."),
                new Frase("O passado sombrio do castelo ficava para trás."),
                new Frase("E o futuro se abria como uma estrada infinita."),
                new Frase("O herói seguiu adiante, sabendo que seu destino era escrever novas histórias.")
        );

//        finalHeroico = new Capitulo("O Fim Heroico", new ArrayList<>(), Arrays.asList(new Frase(RED + "Você ergue sua arma em triunfo."), new Frase(RED + "As terras voltam a florescer, livres da escuridão.")), Arrays.asList(new Frase(RED + "Seu nome será lembrado por gerações."), new Frase(RED + "Fim da sua jornada.")), new ArrayList<>());
//        finalTragico = new Capitulo("A Queda do Herói", new ArrayList<>(), Arrays.asList(new Frase(BLUE + "Você cai de joelhos, derrotado."), new Frase(BLUE + "A escuridão engole tudo.")), Arrays.asList(new Frase(BLUE + "Ninguém lembrará do seu sacrifício."), new Frase(BLUE + "Fim da sua jornada.")), new ArrayList<>());
//
//        cap20 = new Capitulo("A Coroa Perdida", Arrays.asList(finalHeroico, finalTragico), Arrays.asList(new Frase(GREEN + "O Rei Corrompido surge diante de você.")), Arrays.asList(new Frase(GREEN + "Sua decisão final mudará tudo.")), new ArrayList<>());
//        cap19 = new Capitulo("O Necromante", Arrays.asList(cap20), Arrays.asList(new Frase(YELLOW + "No coração da caverna, o Necromante o aguarda.")), Arrays.asList(new Frase(YELLOW + "Sua risada ecoa nas paredes de pedra.")), new ArrayList<>());
//        cap18 = new Capitulo("O Julgamento", Arrays.asList(cap19), Arrays.asList(new Frase(PURPLE + "Você chega ao salão do julgamento sagrado.")), Arrays.asList(new Frase(PURPLE + "Somente os dignos podem seguir adiante.")), new ArrayList<>());
//        cap17 = new Capitulo("A Floresta dos Sussurros", Arrays.asList(cap18, cap19), Arrays.asList(new Frase(CYAN + "A floresta murmura segredos antigos.")), Arrays.asList(new Frase(CYAN + "Sombras observam cada passo seu.")), new ArrayList<>());
//        cap16 = new Capitulo("O Refúgio Secreto", Arrays.asList(cap17), Arrays.asList(new Frase(SILVER + "Você descobre um santuário escondido.")), Arrays.asList(new Frase(SILVER + "Aqui, antigas magias o fortalecem.")), new ArrayList<>());
//        cap15 = new Capitulo("A Ponte Quebrada", Arrays.asList(cap16, cap17), Arrays.asList(new Frase(ORANGE + "A ponte suspensa range sob seu peso.")), Arrays.asList(new Frase(ORANGE + "Você sente que não há volta.")), new ArrayList<>());
//        cap14 = new Capitulo("Os Bandidos da Estrada", Arrays.asList(cap15, cap16), Arrays.asList(new Frase(PINK + "Um grupo de bandidos bloqueia sua passagem.")), Arrays.asList(new Frase(PINK + "Eles exigem todo seu ouro.")), new ArrayList<>());
//        cap13 = new Capitulo("A Vila Abandonada", Arrays.asList(cap14, cap15), Arrays.asList(new Frase(TEAL + "Casas destruídas e silêncio mortal.")), Arrays.asList(new Frase(TEAL + "Algo sinistro aconteceu aqui.")), new ArrayList<>());
//        cap12 = new Capitulo("O Lago Misterioso", Arrays.asList(cap13, cap14), Arrays.asList(new Frase(GOLD + "As águas refletem estrelas que não existem no céu.")), Arrays.asList(new Frase(GOLD + "Você sente uma força mágica.")), new ArrayList<>());
//        cap11 = new Capitulo("A Torre do Vigia", Arrays.asList(cap12, cap13), Arrays.asList(new Frase(BROWN + "No alto da colina, uma torre vigia todo o vale.")), Arrays.asList(new Frase(BROWN + "Você encontra inscrições antigas nas paredes.")), new ArrayList<>());
//        cap10 = new Capitulo("A Encruzilhada", Arrays.asList(cap11, cap12), Arrays.asList(new Frase(LIME + "Duas estradas se abrem diante de você.")), Arrays.asList(new Frase(LIME + "O destino depende da sua escolha.")), new ArrayList<>());
//        cap9 = new Capitulo("A Gruta Oculta", Arrays.asList(cap10, cap11), Arrays.asList(new Frase(MAGENTA + "Um rio subterrâneo leva a uma gruta reluzente.")), Arrays.asList(new Frase(MAGENTA + "Você sente que algo o observa nas sombras.")), new ArrayList<>());
//        cap8 = new Capitulo("O Campo de Batalha Antigo", Arrays.asList(cap9, cap10), Arrays.asList(new Frase(RED + "Espadas enferrujadas estão cravadas no chão.")), Arrays.asList(new Frase(RED + "As almas dos mortos parecem inquietas.")), new ArrayList<>());
//        cap7 = new Capitulo("A Caverna Escura", Arrays.asList(cap8, cap9), Arrays.asList(new Frase(BLUE + "Você entra em uma caverna úmida e sombria.")), Arrays.asList(new Frase(BLUE + "O som de garras ecoa nas profundezas.")), new ArrayList<>());
//        cap6 = new Capitulo("A Biblioteca Esquecida", Arrays.asList(cap7, cap8), Arrays.asList(new Frase(GREEN + "Livros empoeirados falam de heróis antigos.")), Arrays.asList(new Frase(GREEN + "Você encontra um mapa rasgado.")), new ArrayList<>());
//        cap5 = new Capitulo("O Castelo em Ruínas", Arrays.asList(cap6, cap7), Arrays.asList(new Frase(YELLOW + "Um castelo destruído pelo tempo se ergue diante de você.")), Arrays.asList(new Frase(YELLOW + "Sombras vagueiam pelos corredores.")), new ArrayList<>());
//        cap4 = new Capitulo("A Taberna do Corvo", Arrays.asList(cap5, cap6), Arrays.asList(new Frase(PURPLE + "Na taberna, viajantes contam lendas antigas.")), Arrays.asList(new Frase(PURPLE + "Você ouve sobre a 'Coroa Perdida'." + "")), new ArrayList<>());
//        cap3 = new Capitulo("O Bosque Inicial", Arrays.asList(cap4, cap5), Arrays.asList(new Frase(CYAN + "Você caminha por um bosque iluminado pelo sol.")), Arrays.asList(new Frase(CYAN + "Pássaros cantam, mas o ar parece pesado.")), Arrays.asList(inimigo2));
//
//        cap2 = new Capitulo("A Estrada Antiga", Arrays.asList(cap3, cap4), Arrays.asList(new Frase(SILVER + "Você segue por uma estrada esquecida.")), Arrays.asList(new Frase(SILVER + "Pegadas estranhas marcam a terra.")), Arrays.asList(inimigo1));
//
//        cap1 = new Capitulo("O Chamado da Aventura", Arrays.asList(cap2, cap3), Arrays.asList(new Frase(ORANGE + "Você desperta com o som distante de sinos."), new Frase(ORANGE + "O sol entra pela janela, dourando as paredes de madeira."), new Frase(ORANGE + "O chamado foi aceito."), new Frase(ORANGE + "Sua jornada começa agora.")), new ArrayList<>(), new ArrayList<>());
//
        this.historia = new Historia(capitulo1);
    }


    public Historia getHistoria() {
        return this.historia;
    }
}