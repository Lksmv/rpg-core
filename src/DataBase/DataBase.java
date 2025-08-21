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
    // CAPÍTULO FINAL: Vitória
    Capitulo finalHeroico = new Capitulo(
            "O Fim Heroico",
            new ArrayList<>(),
            Arrays.asList(
                    new Frase("Você ergue sua arma em triunfo."),
                    new Frase("As terras voltam a florescer, livres da escuridão.")
            ),
            Arrays.asList(
                    new Frase("Seu nome será lembrado por gerações."),
                    new Frase("Fim da sua jornada.")
            ),
            new ArrayList<>()
    );

    // CAPÍTULO FINAL: Derrota
    Capitulo finalTragico = new Capitulo(
            "A Queda do Herói",
            new ArrayList<>(),
            Arrays.asList(
                    new Frase("Você cai de joelhos, derrotado."),
                    new Frase("A escuridão engole tudo.")
            ),
            Arrays.asList(
                    new Frase("Ninguém lembrará do seu sacrifício."),
                    new Frase("Fim da sua jornada.")
            ),
            new ArrayList<>()
    );

    // ----------------------
    // CAPÍTULOS INTERMEDIÁRIOS
    // ----------------------

    Capitulo cap20 = new Capitulo(
            "A Coroa Perdida",
            Arrays.asList(finalHeroico, finalTragico),
            Arrays.asList(new Frase("O Rei Corrompido surge diante de você.")),
            Arrays.asList(new Frase("Sua decisão final mudará tudo.")),
            new ArrayList<>()
    );

    Capitulo cap19 = new Capitulo(
            "O Necromante",
            Arrays.asList(cap20),
            Arrays.asList(new Frase("No coração da caverna, o Necromante o aguarda.")),
            Arrays.asList(new Frase("Sua risada ecoa nas paredes de pedra.")),
            new ArrayList<>()
    );

    Capitulo cap18 = new Capitulo(
            "O Julgamento",
            Arrays.asList(cap19),
            Arrays.asList(new Frase("Você chega ao salão do julgamento sagrado.")),
            Arrays.asList(new Frase("Somente os dignos podem seguir adiante.")),
            new ArrayList<>()
    );

    Capitulo cap17 = new Capitulo(
            "A Floresta dos Sussurros",
            Arrays.asList(cap18, cap19),
            Arrays.asList(new Frase("A floresta murmura segredos antigos.")),
            Arrays.asList(new Frase("Sombras observam cada passo seu.")),
            new ArrayList<>()
    );

    Capitulo cap16 = new Capitulo(
            "O Refúgio Secreto",
            Arrays.asList(cap17),
            Arrays.asList(new Frase("Você descobre um santuário escondido.")),
            Arrays.asList(new Frase("Aqui, antigas magias o fortalecem.")),
            new ArrayList<>()
    );

    Capitulo cap15 = new Capitulo(
            "A Ponte Quebrada",
            Arrays.asList(cap16, cap17),
            Arrays.asList(new Frase("A ponte suspensa range sob seu peso.")),
            Arrays.asList(new Frase("Você sente que não há volta.")),
            new ArrayList<>()
    );

    Capitulo cap14 = new Capitulo(
            "Os Bandidos da Estrada",
            Arrays.asList(cap15, cap16),
            Arrays.asList(new Frase("Um grupo de bandidos bloqueia sua passagem.")),
            Arrays.asList(new Frase("Eles exigem todo seu ouro.")),
            new ArrayList<>()
    );

    Capitulo cap13 = new Capitulo(
            "A Vila Abandonada",
            Arrays.asList(cap14, cap15),
            Arrays.asList(new Frase("Casas destruídas e silêncio mortal.")),
            Arrays.asList(new Frase("Algo sinistro aconteceu aqui.")),
            new ArrayList<>()
    );

    Capitulo cap12 = new Capitulo(
            "O Lago Misterioso",
            Arrays.asList(cap13, cap14),
            Arrays.asList(new Frase("As águas refletem estrelas que não existem no céu.")),
            Arrays.asList(new Frase("Você sente uma força mágica.")),
            new ArrayList<>()
    );

    Capitulo cap11 = new Capitulo(
            "A Torre do Vigia",
            Arrays.asList(cap12, cap13),
            Arrays.asList(new Frase("No alto da colina, uma torre vigia todo o vale.")),
            Arrays.asList(new Frase("Você encontra inscrições antigas nas paredes.")),
            new ArrayList<>()
    );

    Capitulo cap10 = new Capitulo(
            "A Encruzilhada",
            Arrays.asList(cap11, cap12),
            Arrays.asList(new Frase("Duas estradas se abrem diante de você.")),
            Arrays.asList(new Frase("O destino depende da sua escolha.")),
            new ArrayList<>()
    );

    Capitulo cap9 = new Capitulo(
            "A Gruta Oculta",
            Arrays.asList(cap10, cap11),
            Arrays.asList(new Frase("Um rio subterrâneo leva a uma gruta reluzente.")),
            Arrays.asList(new Frase("Você sente que algo o observa nas sombras.")),
            new ArrayList<>()
    );

    Capitulo cap8 = new Capitulo(
            "O Campo de Batalha Antigo",
            Arrays.asList(cap9, cap10),
            Arrays.asList(new Frase("Espadas enferrujadas estão cravadas no chão.")),
            Arrays.asList(new Frase("As almas dos mortos parecem inquietas.")),
            new ArrayList<>()
    );

    Capitulo cap7 = new Capitulo(
            "A Caverna Escura",
            Arrays.asList(cap8, cap9),
            Arrays.asList(new Frase("Você entra em uma caverna úmida e sombria.")),
            Arrays.asList(new Frase("O som de garras ecoa nas profundezas.")),
            new ArrayList<>()
    );

    Capitulo cap6 = new Capitulo(
            "A Biblioteca Esquecida",
            Arrays.asList(cap7, cap8),
            Arrays.asList(new Frase("Livros empoeirados falam de heróis antigos.")),
            Arrays.asList(new Frase("Você encontra um mapa rasgado.")),
            new ArrayList<>()
    );

    Capitulo cap5 = new Capitulo(
            "O Castelo em Ruínas",
            Arrays.asList(cap6, cap7),
            Arrays.asList(new Frase("Um castelo destruído pelo tempo se ergue diante de você.")),
            Arrays.asList(new Frase("Sombras vagueiam pelos corredores.")),
            new ArrayList<>()
    );

    Capitulo cap4 = new Capitulo(
            "A Taberna do Corvo",
            Arrays.asList(cap5, cap6),
            Arrays.asList(new Frase("Na taberna, viajantes contam lendas antigas.")),
            Arrays.asList(new Frase("Você ouve sobre a 'Coroa Perdida'.")),
            new ArrayList<>()
    );

    Capitulo cap3 = new Capitulo(
            "O Bosque Inicial",
            Arrays.asList(cap4, cap5),
            Arrays.asList(new Frase("Você caminha por um bosque iluminado pelo sol.")),
            Arrays.asList(new Frase("Pássaros cantam, mas o ar parece pesado.")),
            new ArrayList<>()
    );

    Capitulo cap2 = new Capitulo(
            "A Estrada Antiga",
            Arrays.asList(cap3, cap4),
            Arrays.asList(new Frase("Você segue por uma estrada esquecida.")),
            Arrays.asList(new Frase("Pegadas estranhas marcam a terra.")),
            new ArrayList<>()
    );

    Capitulo cap1 = new Capitulo(
            "O Chamado da Aventura",
            Arrays.asList(cap2, cap3),
            Arrays.asList(
                    new Frase("Você desperta com o som distante de sinos."),
                    new Frase("O sol entra pela janela, dourando as paredes de madeira."),
                    new Frase("A aldeia parece calma, mas você sente que algo está errado."),
                    new Frase("Pássaros voam apressados, como se fugissem de algo invisível."),
                    new Frase("Crianças brincam nas ruas, sem imaginar o perigo que se aproxima."),
                    new Frase("Um velho camponês o cumprimenta com um olhar cansado."),
                    new Frase("Ele murmura algo sobre uma sombra que ronda as colinas."),
                    new Frase("Na praça central, comerciantes discutem preços de tecidos."),
                    new Frase("Um menestrel toca uma melodia melancólica."),
                    new Frase("O cheiro de pão fresco invade o ar."),
                    new Frase("Você escuta cochichos sobre soldados desaparecidos."),
                    new Frase("Um grupo de caçadores retorna, mas sem sua caça habitual."),
                    new Frase("As pessoas olham para o horizonte com desconfiança."),
                    new Frase("O vento sopra forte, trazendo um frio repentino."),
                    new Frase("Um mensageiro chega montado em um cavalo exausto."),
                    new Frase("Ele desmaia na frente da taverna, com um pergaminho nas mãos."),
                    new Frase("Você corre até ele e vê um selo real quebrado."),
                    new Frase("O pergaminho fala de uma coroa perdida e um reino em ruínas."),
                    new Frase("A mensagem pede por heróis dispostos a enfrentar a escuridão."),
                    new Frase("Os aldeões recuam, com medo até de ler as palavras."),
                    new Frase("Você sente seu coração acelerar."),
                    new Frase("Será esse o destino que sempre aguardou?"),
                    new Frase("Seu nome parece ecoar na mente, como um chamado."),
                    new Frase("Um corvo pousa em uma cerca próxima e o encara fixamente."),
                    new Frase("Seus olhos brilham em vermelho por um instante."),
                    new Frase("O menestrel interrompe a música abruptamente."),
                    new Frase("As crianças param de brincar, assustadas."),
                    new Frase("Um silêncio pesado cai sobre a aldeia."),
                    new Frase("Você segura o pergaminho com firmeza."),
                    new Frase("O vento parece sussurrar: 'Escolha o seu caminho'."),
                    new Frase("O ferreiro se aproxima e lhe entrega uma adaga antiga."),
                    new Frase("“Se for partir, leve isso. Pertenceu a meu pai.”"),
                    new Frase("Um grupo de aldeões se reúne ao seu redor."),
                    new Frase("Eles pedem que você represente sua gente."),
                    new Frase("Uma criança segura sua mão e diz: “Volte vivo, por favor.”"),
                    new Frase("O coração se enche de determinação."),
                    new Frase("Você decide aceitar o chamado."),
                    new Frase("No horizonte, o sol começa a se pôr."),
                    new Frase("As sombras se alongam pelas colinas."),
                    new Frase("Um lobo uiva ao longe."),
                    new Frase("O sino da igreja toca novamente."),
                    new Frase("Um frio percorre sua espinha."),
                    new Frase("Você respira fundo."),
                    new Frase("O destino não espera."),
                    new Frase("Agora é a sua vez."),
                    new Frase("O pergaminho queima em sua mão como fogo."),
                    new Frase("Você dá o primeiro passo rumo à aventura."),
                    new Frase("O chão parece tremer sob seus pés."),
                    new Frase("O corvo voa para o norte, como um guia."),
                    new Frase("A estrada está diante de você."),
                    new Frase("O chamado foi aceito."),
                    new Frase("Sua jornada começa agora.")
            ),
            new ArrayList<>(),
            new ArrayList<>()
    );

    Historia historia = new Historia(cap1);

    public Historia getHistoria() {
        return historia;
    }

}
