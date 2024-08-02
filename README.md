# Read Me
  
---

#### *Objetivo do Projeto*

Pretende-se desenvolver uma aplicação em linguagem Java (Horstmann, 2015), em grupo, aplicando conceitos da área da matemática.
Pretende-se também que elaborar um relatório que descreva a aplicação concebida,
o processo de desenvolvimento e que apresente e critique os resultados obtidos.

#### *Plano de Trabalho*

Teremos de implementar uma aplicação que permita estudar e avaliar a propagação de uma notícia falsa em determinadas
condições. Esta aplicação deve incluir um conjunto de módulos que permitam: ler e escrever dados
em ficheiros; implementar os métodos de Euler e Runge-Kutta de 4ª ordem, implementar, visualizar
e avaliar o modelo de propagação de uma notícia falsa (dado o estado inicial), utilizando os métodos
acima referidos.
   
---

## ***Modelo***

O modelo SIR para a biologia populacional de doenças infeciosas foi originalmente desenvolvido por
Kermack e McKendrick em 1927 (Kermack, 1991). Este modelo descreve a interação (dinâmica) de
três populações de indivíduos.

#### *Pressupostos*

Neste modelo assume-se que a notícia propagada numa dada população N é falsa e que, como no modelo
SIR, existem três populações, S, I e R, possíveis:

**S (suscetíveis)** - nesta fase o indivíduo está exposto à notícia falsa e pode ser sugestionado (ainda não ouviram a notícia falsa).  
**I (infetados)** - fase pela qual o indivíduo propaga notícia falsa aos suscetíveis mediante contactos (ouviram a notícia falsa e acreditaram).  
**R (recuperados)** - fase em que o indivíduo deixa a fase de acreditar na notícia falsa (ouviram a notícia falsa e não acreditam).

**β (beta)** - taxa de propagação, ou contágio, da população.  
**ρ (ró)** - taxa da população imune à notícia falsa quando a ouve.  
**γ (gama)** - taxa a que um indivíduo infetado rejeita a notícia falsa.  
**α (alpha)** - taxa de a população ser re-infetada.

A notícia falsa propaga-se via interação direta com o infetado e há uma quantidade **fixa** de pessoas no sistema:
**N = S + I + R**.

#### *Condições iniciais*

**O sistema de EDOs tem um conjunto de condições iniciais que é necessário conhecer:**

O tamanho **N** da população (eg. o número de estudantes do DEI).  
A propagação da notícia falsa é iniciada por 1 pessoa (**considera-se S = N - 1, I = 1, R = 0**).  
O **número de dias** para a previsão do modelo.  
Os paramêtros do modelo: **α, β, γ e ρ**.

#### *Análise comparativa*

Deve ser realizada uma análise comparativa dos resultados obtidos pelos métodos numéricos para
determinados valores de 0 < h ≤ 1. A aplicação deve incluir também um conjunto de funcionalidades
que **permitam realizar uma análise comparativa dos resultados obtidos para diferentes intervalos de
tempo (número de dias)**.  
A aplicação deve incluir duas funcionalidades que permitam:

**Comparar os resultados obtidos, para um dado conjunto de parâmetros, tamanho da população
N e número de dias, pelos métodos numéricos utilizados.
Comparar o comportamento do modelo SIR quando considerados diferentes conjuntos de parâmetros
do modelo (α, β, γ e ρ).**

**Os resultados devem ser guardados numa tabela, em ficheiro de texto, onde constem 4 colunas com
os valores correspondentes a: dia, S, I, R e N**.
  
---

## Product Backlog (tarefas a desenvolver)

No trabalho a realizar devem ser consideradas as tarefas seguintes:

• **Estudo/revisão de equações diferenciais de 1ª ordem, lecionadas na UC AMATA. Constatação
da existência de EDOs (e sistemas de EDOs) para as quais não se conhece um processo de
resolução analítica (exata)**.

•Necessidade de se recorrer a outros métodos de estudo, por exemplo
os métodos numéricos para obtenção de soluções aproximadas.

•Estudo dos algoritmos do método de Euler e do método de Runge-Kutta de 4ª ordem.  
Desenvolvimento de um **módulo, Euler(), em Java, que implemente o algoritmo de Euler para
resolução de EDOs**.

• Desenvolvimento de um **módulo, RK4(), em Java, que implemente o algoritmo de Runge-Kutta
de 4ª ordem para resolução de EDOs**.

• Desenvolver uma aplicação informática que **permita estudar a propagação de uma notícia falsa
numa população (na LEI-ISEP) de um dado tamanho (≃ 1000), para um número de dias e determinados
parâmetros, usando um método numérico (Euler ou RK4) e um passo de integração numérica (h)**.

• Desenvolver um **módulo que permita gerar a representação gráfica (formato png) das curvas S,
I, R para uma dada população ao longo do tempo (número de dias) e determinados parâmetros
do modelo**. Para implementar este módulo é **permitido apenas recorrer à aplicação gnuplot
(Williams & Kelley, 2010), classe java.lang.Runtime e classes utilizadas na unidade APROG**.Não é permitida a utilização de bibliotecas que implementem interfaces para a biblioteca gnuplot,
tais como as bibliotecas jgnuplot e JavaPlot.

• A aplicação deve permitir a execução de todas as funcionalidades através da execução de um
único comando. Neste comando serão especificados todos os parâmetros, o ficheiro de entrada
e o ficheiro de saída. Pretende-se dois tipos de ficheiros de saída:  
– Os ficheiros que representam as tabelas e os gráficos das curvas S, I, R. Sempre que visualiza
um gráfico, o utilizador deve ter a opção de gravar.
– Ficheiro de texto que resulta de executar a aplicação em modo não interativo.

**O nome do ficheiro de saída deve permitir identificar a operação realizada**. Os grupos que não
consigam gerar gráficos utilizando gnuplot devem gerar ficheiros de texto.

• Elaborar um relatório onde consta:

– Uma **breve introdução às equações diferenciais de 1ª ordem e sistemas SIR**;

– Uma **descrição dos métodos numéricos de Euler e RK4 (apresentando os respetivos algoritmos)**;

– Uma **descrição da metodologia de trabalho utilizada para desenvolver a aplicação**;

– Uma **descrição da implementação da aplicação, que deve incluir um diagrama que identifique claramente os módulos e suas dependências**;

– Uma **análise dos resultados**, onde devem ser apresentados e explorados os resultados obtidos
para dois casos de estudo: o **”Zé Seguro”** e **”Maria Bocas”** . Deve ser analisada a evolução da
propagação da notícia falsa no período de dias e tamanho da população pedidos. Devem
apresentar e comentar os respetivos resultados apresentados em tabelas e graficamente
(dando atenção à variação do passo h). Serão disponibilizados no Moodle os ficheiros
contendo os dados necessários ao estudo. Todos os resultados apresentados devem ser
obtidos recorrendo à aplicação desenvolvida pelo grupo.

## Outros requisitos

• A aplicação deve ser desenvolvida em linguagem Java e estruturada e organizada em módulos.
**Será valorizada uma correta decomposição modular e o reaproveitamento de módulos**. No final do trabalho deve resultar um **ÚNICO** projeto.

• A aplicação deve ter uma **interface simples e intuitiva que permita ao utilizador interagir com
a aplicação de forma rápida e minimizando os erros**. A interface da aplicação será em **modo
de texto e deverá incluir um conjunto de menus que permita aceder às funcionalidades de
forma rápida**. A interface da aplicação também deve **permitir parametrizar cada uma das
funcionalidades selecionadas, de acordo com o que é apresentado nos objetivos do projeto**. Os
parâmetros relativos ao modelo **devem ser lidos de um ficheiro de texto** (encontram um exemplo
no Moodle).

• A aplicação pode ser executada em modo interativo ou sem interação por parte do utilizador.  
– No **modo interativo**, a aplicação deverá ser chamada da linha de comandos utilizando um
comando que será disponibilizado no Moodle.  
– No **modo não interativo**, o utilizador especifica todos os parâmetros necessários à execução
da aplicação na linha de comando, define: o ficheiro contendo os parâmetros necessários
ao modelo SIR, o método a usar e o passo de integração, o tamanho da população em
estudo, o número de dias a considerar para análise e o nome do ficheiro de saída CSV onde
é guardado o resultado obtido. O comando a ser utilizado será disponibilizado no Moodle.

• O grupo deve guardar todo o material desenvolvido para a realização do projeto na pasta
Ficheiros do seu canal privado no Teams. Não é necessário incluir nesta pasta o código que está
disponível no repositório do BitBucket.

---



