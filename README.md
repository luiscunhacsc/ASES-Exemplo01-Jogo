# JavaQuest - Explorando a Programação Orientada a Objetos ☕🏰

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

O **JavaQuest** é um jogo simples em 2D desenvolvido nativamente em Java (com `Java Swing`) que serve como projeto educativo. O seu objetivo primordial é demonstrar, de forma acessível e visual, os quatro pilares da Programação Orientada a Objetos (POO) a estudantes iniciantes:

* **Encapsulamento**
* **Herança**
* **Polimorfismo**
* **Abstração**

O projeto é acompanhado de um relatório explícito descrevendo a arquitetura completa em PlantUML e documentando a lógica implementada.

## 🛠 Pré-Requisitos (Preparar o Computador)

Para editares, compilares e correres este jogo na tua máquina, recomendamos utilizares o **Visual Studio Code (VS Code)**, que é o padrão da indústria.

### 1. Instalação do Editor VS Code
1. Acede a [code.visualstudio.com](https://code.visualstudio.com/) e descarrega a versão para o teu ambiente de trabalho.
2. Abre o instalador. **⚠️ ATENÇÃO BASTANTE IMPORTANTE:** Quando chegares ao ecrã "Select Additional Tasks" (Selecionar Tarefas Adicionais), certifica-te de que as opções que costumam vir *desmarcadas por omissão* ficam **ATIVAS**:
   * ✅ *Add "Open with Code" action to Windows Explorer file context menu*
   * ✅ *Add "Open with Code" action to Windows Explorer directory context menu*
   > *Dica: Estas duas opções ajudam imenso, pois passam a permitir que cliques com o botão direito do rato na pasta do jogo ou num ficheiro solto e escolhas abrir diretamente esse código sem truques adicionais.*
   * ✅ *Register Code as an editor for supported file types*
   * ✅ *Add to PATH (requires shell restart)* - (Esta geralmente já vem ativa, mas confere!)

### 2. Instalação da Extensão Java (que já inclui o JDK)
Depois de leres estas instruções, abre a tua nova pasta de projeto (`Jogo/`) no VS Code:
1. Clica no menu vertical esquerdo de Extensões do VS Code (ou pressiona o atalho mágico `Ctrl+Shift+X`).
2. Pesquisa por **"Extension Pack for Java"** (Publicado pela *Microsoft*). É um pacote de 6 ferramentas fundamentais para programar bem em POO. Clica em instalar.
3. Se tu (como muitos alunos) **não** tens o clássico JDK de desenvolvimento do Java pré-instalado na tua máquina, não te preocupes: o VS Code irá exibir um pop-up útil perto da zona inferior direita a avisar que te falta um JDK ativo, oferecendo-se para instalar um. Confirma e deixa o ecossistema configurar automaticamente o teu compilador!

Para confirmares que ambos estão instalados e a funcionar com o teu terminar moderno, abre o terminal do próprio VS Code (menu Superior `Terminal -> New Terminal`) e escreve:
```bash
java -version
```
```bash
javac -version
```
Se receberes uma resposta com o número da instalação e não um erro em vermelho, estás pronto!

## 🚀 Como Compilar e Jogar no VS Code

Agora que tens o teu ambiente com o **VS Code** e as **Extensões Java** montadas, executar a aplicação torna-se magia de um clique e não precisas daquela linha de comandos clássica! Segue estes três passos simples:

1. **Abre o ponto de partida:** No explorador de ficheiros à tua esquerda (na barra lateral de cima a baixo do VS Code), navega pela estrutura de pacotes `src > pt > javaquest` e abre com um clique duplo o ficheiro **`Main.java`**.
2. **Deixa o Java acordar:** Repara na barra de baixo direito do teu editor. O VS Code pode mostrar um ícone de carregamento circular ("*thumbs up*" ou um relógio/ícone rotativo) indicando que a Extensão de Java está a carregar o teu projeto. Aguarda uns segundos.
3. **Clica em "Run" (Executar):** Procura o clássico método `psvm`! Em Java, toda a vida de uma aplicação começa neste método principal:
   ```java
   public static void main(String[] args)
   ```
   Assim que o ambiente Java estiver totalmento carregado através do "Extension Pack", o VS Code é muito inteligente e vai magicamente fazer aparecer uma palavra que diz **`Run | Debug`** diretamente acima desta linha `main`. 

Carrega simplesmente em **Run**. O teu compilador e o VS Code farão todo o trabalho de compilar as dezenas de classes e interligá-las para que a janela gráfica do **JavaQuest** apareça no teu ecrã com as instruções em menos de dois segundos!

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
