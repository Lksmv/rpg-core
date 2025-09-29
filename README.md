# 🎮 RPG Core – Java Swing

Este projeto é um **RPG com interface gráfica em Java Swing**, desenvolvido para fins acadêmicos e profissionais.
O foco principal está na aplicação dos **princípios da Programação Orientada a Objetos (POO)**, juntamente com boas práticas de organização de código e modularização.

---

## 📌 Objetivos do Projeto
- Aplicar os quatro pilares da **POO**: Abstração, Encapsulamento, Herança e Polimorfismo.
- Desenvolver uma aplicação desktop em **Java Swing**.
- Estruturar o projeto em **camadas bem definidas** (Entities, View, Interfaces, Database).
- Criar um sistema interativo com **personagens, habilidades, itens, batalhas e história**.

---

## 📂 Estrutura do Projeto
```bash
src/
 ├── DataBase/             # Camada de persistência e banco de dados
 │   ├── DataBase.java
 │   └── Ilustrations/
 │
 ├── Entitys/              # Entidades do domínio do jogo
 │   ├── Historia/           # Narrativa e elementos de enredo
 │   │   ├── Capitulo.java
 │   │   ├── Frase.java
 │   │   └── Historia.java
 │   ├── Arqueiro.java
 │   ├── Habilidade.java
 │   ├── Inimigo.java
 │   ├── Inventario.java
 │   ├── Item.java
 │   ├── Lutador.java
 │   ├── Mago.java
 │   └── Personagem.java
 │
 ├── Interfaces/           # Interfaces para contratos de comportamento
 │   ├── FugaInterface.java
 │   ├── HabilidadeInterface.java
 │   └── ItemInterface.java
 │
 ├── resources/            # Recursos visuais e sonoros
 │   ├── ambientSound.wav
 │   ├── logo-obg.png
 │   ├── logo-wo-name.png
 │   └── PressStart2P-Regular.ttf
 │
 ├── View/                 # Camada de interface gráfica (Swing)
 │   ├── Component/
 │   │   ├── AudioPlayer.java
 │   │   └── RoundedBorder.java
 │   ├── InventarioDialog.java
 │   ├── Jogo.java
 │   ├── MainView.java
 │   ├── Menu.java
 │   └── ViewCriacaoPersonagem.java
 │
 └── Main/                 # Classe principal
     └── Main.java
```
## 🛠️ Tecnologias Utilizadas
- Java 17+
- Swing (GUI Desktop)
- Paradigma Orientado a Objetos (POO)

## 📖 Conceitos de POO Aplicados
- **Abstração**: Classes genéricas como Personagem e Historia representam conceitos gerais.
- **Encapsulamento**: Controle de acesso com atributos privados e métodos getters/setters.
- **Herança**: Classes como Arqueiro, Mago e Lutador herdam de Personagem.
- **Polimorfismo**: Implementações específicas de métodos sobrescritos em personagens e inimigos.

## ⚙️ Como Executar
Instale o Java 17+.
Clone este repositório:
```Bash

git clone https://github.com/seu-usuario/rpg-core.git](https://github.com/seu-usuario/rpg-core.git
```
Compile o projeto:

```Bash

javac -d out src/**/*.java
```
Execute o jogo:

```Bash

java -cp out Main.Main
```
## 📈 Resultados Obtidos
- Sistema modular e escalável.
- Interface gráfica funcional com áudio, fontes personalizadas e imagens.
- Estrutura que permite a expansão com novos personagens, capítulos e recursos.

👨‍💻 Autores
Davi Augusto
Lucas Miguel Vieira
Ana Clara Coutinho
Gabriela 
