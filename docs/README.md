## LDTS_T05_G07 - ECLIPTICA

In Ecliptica, the player plays as an astronaut navigating an arena. The goal is to collect coins, stars, and power-ups such as a Magnet to attract nearby coins, a Coin Multiplier for extra coins and a Shield to protect the player from dangerous obstacles. The astronaut moves in one direction until he finds a wall, this allows the player to jump quickly across the map in straight lines.

The game introduces two enemy types: Spike Walls that act as instant death zones, ending the game upon contact and Infected Walls that spawn spikes around them when the player passes by. As the player progresses, the arenas grow more difficult, with more obstacles to navigate.
***
This project was developed by *Ana Pacheco* (*up202307150*@fe.up.pt) , *Carolina Mosqueiro* (*up202303637@up.pt*) and *Vasco Vieira* (*up202307797*@fe.up.pt) for LDTS 2024⁄25.
***
### IMPLEMENTED FEATURES

- **Linear Movement** - The player moves swiftly in straight lines across the map, only stopping when he encounters a wall.
- **Collectibles** - The player can collect coins, points and stars scattered across the levels.
- **Wallet** - Throughout the levels, as the player collects coins and points, these contribute to the player's wallet.
- **Enemies** - All enemies instantly kill the player upon contact. There is no concept of health. 
  - **Spike Walls** - Players can come into contact with Spike Walls but cannot land directly on them, since they only cause damage if the player directly jumps into them. This allows the player to brush against Spike Walls without immediately dying, as long as the contact doesn't involve a direct collision.
  - **Infected Walls** - Contrary to Spike Walls, the player can safely come into contact with Infected Walls, as they do not oppose direct danger. Instead, if the player moves near an Infected Wall, it will spawn a Spike Wall in the direction of the player's movement. To overcome Infected Walls, the player must anticipate their behavior and avoid triggering the spikes while navigating through the map.
- **Power-ups** - Throughout the levels, the player can find different temporary Power-Ups to help him in his journey.
  - **Magnet** - Automatically attracts nearby coins.
  - **Shield** - Provides protection against enemies.
  - **Coin Multiplier** - Increases the value of coins and points. 
- **Power-Ups' Upgrades** - Initially, each Power-Up has the duration of 3.0 seconds, but the player can increase this time in the Game Shop in the Main Menu, using his Wallet. Each upgrade increases the time by 0.5 seconds. 
- **Levels** - The game features a total of 8 levels. To advance to the next level, the player must successfully complete the current one 
- **Menus** - There are 5 Menus that allow the player to navigate through the game.
  - **Main Menu** - It is possible to play or exit the game and to access the PowerUps' Menu. 
  - **PowerUp's Menu** - The player can either buy upgrades or return to the Main Menu. 
  - **Completed Level Menu** - After completing a level, the player can proceed to the next one, retry the current one or return to the Main Menu. 
  - **Failed Level Menu** - After failing a level, the player can either retry the current level or return to the Main Menu, not allowing the player to progress in the game.
  - **Completed Game Menu** - After completing all 8 levels, the player reaches a menu with a 'You Won!!' message, where the player's only option is to return to the Main Menu.
- **Sound** - The game includes background music and sound effects. Background music plays continuously during levels and in the menus, while specific sound effects are triggered for actions like collecting coins and points and activating power-ups.
***
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
