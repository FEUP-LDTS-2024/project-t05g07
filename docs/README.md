## LDTS_T05_G07 - ECLIPTICA

In Eclipitica, the player plays as an astronaut navigating an arena. The goal is to collect coins, stars, and power-ups such as a Magnet to attract nearby coins, a Coin Multiplier for extra coins and a Shield to protect the player from dangerous obstacles. The astronaut moves in one direction until he finds a wall, this allows the player to jump quickly across the map in straight lines.

The game introduces two enemy types: Spike Walls that act as instant death zones, ending the game upon contact and Infected Walls that spawn spikes around them when the player passes by. As the player progresses, the arenas grow more difficult, with more obstacles to navigate.

This project was developed by *Ana Pacheco* (*up202307150*@fe.up.pt) , *Carolina Mosqueiro* (*up202303637@up.pt*) and *Vasco Vieira* (*up202307797*@fe.up.pt) for LDTS 2024⁄25.

### IMPLEMENTED FEATURES

- **Movimento linear** - ...
- **Coleta de pontos, moedas e estrelas** - ...
- **Acúmulo de moedas** - ...
- **Monstros** - ...
  - **Espinhos** - ...
  - **Armadilha** - ... 
- **Power-ups** - ...
  - **Íman** - ...
  - **Escudo** - ...
  - **Bónus de Moedas** - ...
- **Aumento da duração dos powerups** - ...
- **Níveis** - ...
- **Diferentes menus** - ...
- **Botões** - ...
- **Som** - ...
- **Arte e animações** - ...
- ...
- **Jumping** - The game character will jump when the space bar key is pressed.
- **Getting hidden coins** - When the game character hits a platform from below (by jumping beneath it) it will smash that segment of the platform and will get any coins that may exist hidden there.

### PLANNED FEATURES

- **Pontuação** - ...
- **Estrelas afetarem a progressão do jogo** - ...
- **Nível do jogador** - ...
- ...

### DESIGN

- MVC
- State
- Game loop
- Builder (?)
- Decorator
- Strategy

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

### KNOWN CODE SMELLS

- A classe AstronautController está muito complexa e (provavelmente) vai contra o Single Responsibility ...
- A armadilha não volta a spawnar um espinho se o Astronauta ainda estiver a tocar nela e não tiver sido morto ...
- O astronauta consegue parar em posições do mapa que não devia por causa do escudo ...
- ...

### TESTING

...

### SELF-EVALUATION

- Eu: 33.3%
- Tu: 33.3%
- Ele: 33.3%
- Nós, vós, eles, deus: 0.1%
