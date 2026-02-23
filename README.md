# JavaQuest - Explorando a Programação Orientada a Objetos ☕🏰

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

O **JavaQuest** é um jogo simples em 2D desenvolvido nativamente em Java (com `Java Swing`) que serve como projeto educativo. O seu objetivo primordial é demonstrar, de forma acessível e visual, os quatro pilares da Programação Orientada a Objetos (POO) a estudantes iniciantes:

* **Encapsulamento**
* **Herança**
* **Polimorfismo**
* **Abstração**

O projeto é acompanhado de um relatório explícito descrevendo a arquitetura completa em PlantUML e documentando a lógica implementada.

## 🛠 Pré-Requisitos

Para compilares e correres este jogo na tua máquina, só precisas do Java Development Kit (JDK) instalado (versão 8 ou superior).

* [Download do JDK (Oracle)](https://www.oracle.com/java/technologies/downloads/) ou OpenJDK.

Para confirmar se tens o Java instalado de forma correta, abre uma Consola do Windows ou Terminal e escreve:
```bash
java -version
```
```bash
javac -version
```

## 🚀 Como Compilar e Jogar

Para poderes compilar o código fonte que se encontra distribuído por pacotes na pasta `src/pt/javaquest`, segue os seguintes passos:

1. **Abre a linha de comandos** na pasta principal deste repositório (`Jogo/`).
2. **Cria uma pasta chamada `bin`** (se ainda não existir):
   ```bash
   mkdir bin
   ```
3. **Compila o jogo** através do compilador do Java, reencaminhando as classes para a pasta `bin`:
   *(Para Windows - Linha de Comandos)*
   ```bash
   javac -d bin src\pt\javaquest\entities\*.java src\pt\javaquest\engine\*.java src\pt\javaquest\ui\*.java src\pt\javaquest\Main.java
   ```
   *(Para macOS/Linux ou Bash Shell)*
   ```bash
   javac -d bin src/pt/javaquest/entities/*.java src/pt/javaquest/engine/*.java src/pt/javaquest/ui/*.java src/pt/javaquest/Main.java
   ```

4. **Executa o jogo** informando o Java do "*classpath*" (`-cp`):
   ```bash
   java -cp bin pt.javaquest.Main
   ```

A parede gráfica abrir-se-á, com direito a instruções e o jogo inicia logo em seguida.

## 🎮 Como Jogar? (Mecânicas e Estratégia)

O ecrã constitui uma grelha contendo várias instâncias dos objetos desenhados via Polimorfismo.

* **O Herói (Tu):** Quadrado **Azul**.
* **Movimento:** Podes usar as teclas Direcionais (Cima, Baixo, Esquerda, Direita) ou as populares teclas de movimento `W, A, S, D`.

### ⚔️ Combate

Todos os combates no JavaQuest são automáticos por impacto. Para atacar um **Inimigo (Quadrado Vermelho)**, basta moveres-te contra ele. Recebes dano em troca até que o derrotes! Fica atento ao teu log de combate sempre.

### 🎒 Inventário Visual (Itens)

* **Poção de Cura (Bola Rosa):** Recolher este objeto restaura *50 Pontos de Saúde* ao Herói.
* **Espada AFIADA (Desenho de espada Cinzenta):** Recolher esta arma aumenta o teu Poder de Ataque permanentemente para os próximos combates. *Recomendado antes de combater o inimigo especial "Boss Singleton"!*

## 📚 Ensinamentos da Versão Final (Para os alunos!)

Ao explorares o código nas pastas de `entities/` e `engine/`, repara que:

* O Motor usa listas de `Item` (classe Genérica/Abstrata) para desenhar o tabuleiro em vez de estar à procura de `Potion` ou `Sword`. Isso é **Amorfismo (Polimorfismo)**!
* Os inimigos são controlados através de `.takeDamage(dano)` invocados internamente. O motor do jogo não desconta valor à vida do Inimigo sem consultar as barreiras programadas – **Encapsulamento**.
* Sem quereres, percebes como os videojoros antigos eram idealizados e testados com base nos primitivos da computação, que tu próprio poderás modificar e estender usando o Princípio de Herança: Cria os teus próprios Inimigos e Itens criando novas subclasses!
