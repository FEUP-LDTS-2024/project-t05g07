# Descrição do Jogo
O jogo ocorre num labirinto, onde o jogador controla um astronauta que se movimenta
rapidamente em linha reta, parando apenas ao encontrar um obstáculo. Esta mecânica
simples desafia o jogador a planear os seus movimentos com precisão para evitar perigos,
tais como armadilhas, aliens e outras ameaças. O objetivo principal é encontrar a saída do
labirinto enquanto coleta itens como estrelas e pontos, que podem ser usados para
desbloquear novas habilidades.
Conforme o jogador acumula pontos, ele sobe de nível e desbloqueia novas arenas em
diferentes planetas que serão mais complexos e darão recompensas maiores.


# Funcionalidades do Jogador

## Movimentação
- O jogador pode se mover em quatro direções (cima, baixo, esquerda e direita);
- O movimento é uniforme até encontrar um obstáculo.

## Coleta de Itens
- O jogador coleta automaticamente itens ao tocá-los, como moedas, pontos,
estrelas e power-ups.


# Principais Elementos do Jogo

## Arena (Labirinto)
- Cada nível ocorre numa arena única, representando um planeta diferente;
- Existem armadilhas e obstáculos móveis ou estáticos que o jogador deve evitar.

## Jogador
- Movimenta-se rapidamente em linha reta até atingir um obstáculo;
- Morre instantaneamente ao encontrar um inimigo/armadilha.

## Itens Colecionáveis
### Pontos
- São coletados ao longo das arenas;
- Num planeta, se o jogador coletar todos os pontos, recebe 200 moedas;
- Permitem subir de nível.

### Moedas
- São coletadas ao longo das arenas;
- Aumentam a pontuação e podem ser usadas para comprar upgrades no
menu.

### Estrelas
- Elementos que permitem desbloquear novos planetas;
- Usadas como método de classificação da performance do jogador num nível
específico;
- Para desbloquear a próxima arena, o jogador deve coletar pelo menos uma
estrela.

### Power-ups
- Garantem habilidades temporárias;
- Podem ser melhorados no menu, aumentando eficácia ou duração;
- Podem ser:
  - **Escudo:** Torna o jogador imune a armadilhas;
  - **Imobilizador:** Imobiliza os inimigos e armadilhas;
  - **Viciado em moedas:** Duplica o valor de cada moeda coletada;
  - **Potenciador de Pontuação:** Multiplica a pontuação obtida;
  - **Íman:** Atrai pontos próximos.
 
### Obstáculos
- Podem ser fixos ou móveis;
- Variam entre espinhos, projéteis ou inimigos móveis que matam o jogador
ao contato;
- Alguns inimigos perseguem o jogador, exigindo estratégia para escapar.

# Diagrama UML

![UML class diagram](docs/uml_ldts.drawio.png)

