# Chaos and Order [![Build Status](https://travis-ci.com/RacmanT/ChaosAndOrder.svg?branch=main)](https://travis-ci.com/RacmanT/ChaosAndOrder)

This repository contains the final project for the Software Development Methods 2020/21 [course](https://corsi.units.it/en/sm34/teaching-unit/software-development-methods-567sm-2020-pds0-2018-ord-2018-common) at [University of Trieste](https://www.units.it/en).

<p align="center">
<img src="https://github.com/RacmanT/ChaosAndOrder/blob/main/screenshots/Logo.png" height="328" width="487">
</p>

## Table of Contents

- [Introduction](#introduction)
- [How to play](#how-to-play)
- [The Game](#the-game)
  - [Command Line Interface](#command-line-interface)
  - [Graphical User Interface](#graphical-user-interface)
- [What is next?](#what-is-next)
- [Contributors](#contributors)

### Introduction

The goal of the project is to implement a board game called Chaos and Order, which was invented by Stephen Sniderman and introduced by him in Games magazine in 1981.

_Source: [Wikipedia](https://en.wikipedia.org/wiki/Order_and_Chaos)_

---

### How to play

The game is a variation of the more known Tic Tac Toe game and it is played on a 6x6 board. The two rivals are named _Chaos_ and _Order_ and they play turns alternatively. On each turn, a player has to pick a Cross or a Circle and is free to put it on an empty cell. Order's purpose is to make a quintuple of equal signs, regardless the direction (namely vertically, horizontally and diagonally), while Chaos has to prevent it, until the board is filled and no further moves are available.
Order moves first.

---

### The Game

The game can be played both from a Command Line Interface (CLI) or a Graphical User Interface (GUI).  
To Start it, move to the directory where you have cloned the repository and run:

`./gradlew jar`  
`java jar ./build/libs/ChaosAndOrder-1.0.jar [OPTION]`

where `[OPTION]` can be:

- `-cli` for the Command Line Interface
- `-gui` for the Graphical User Interface

If you want a portable version of the game you can run `./gradlew distZip`, which will produce your zip archive in `./build/distributions`.

- #### Command Line Interface

<!-- To start the Command Line Interface move to the directory where you have cloned the repository and run:

`./gradlew jar`
`java jar ./build/libs/ChaosAndOrder-1.0.jar -cli`   -->

<p align="center">
<img src="https://github.com/RacmanT/ChaosAndOrder/blob/main/screenshots/CLI_1.png">
</p>

Moves are given in the format `ColumnRow Symbol`, where the Column can be chosen among **[A,F]**, the Row among **[1,6]** and the Symbol between **[X,O]** (e.g. _A5 X_, _E2 O_). The game is not case sensitive and extra empty spaces are handled too.

- #### Graphical User Interface

<!-- To start the Graphical User Interface move to the directory where you have clone the repository and run:  -->

<p align="center">
<img src="https://github.com/RacmanT/ChaosAndOrder/blob/main/screenshots/GUI_1.png">
</p>

To play your turn pick a symbol by clicking on a Circle or a Cross on top right corner and put it on the board by clicking on an empty cell. Player's turn is displayed on left corner so you can not mess up.

The application panel might be useful if:

- you want to start a new game go to _File > New Game_
- you want to exit _File > Exit_
- you forgot about the rules go to _Help > Read Instructions_
- you are wondering who made this beautiful game _Help > About _ :wink:

##### Light / Dark Theme

<p align="center">
<img src="https://github.com/RacmanT/ChaosAndOrder/blob/main/screenshots/LightAndDarkMode.png">
</p>

To activate the Dark Mode go to _File > Themes > Dark Mode_.

---

### What is next?

Some new features might be added in a next release. Some of them are:

- [x] Portability :briefcase:
- [x] Light mode :sunny: / Dark mode :crescent_moon:
- [ ] Support for more langauges :earth_africa:
- [ ] Multiplayer (Client/Server) :family_man_man_girl_boy:

If you want to contribute in the implementation or you have any other idea for a next release feel free to fork and / or contact us.

---

### Contributors

- [Tibor Racman](https://github.com/RacmanT)
- [Massimo Palmisano](https://github.com/PalMassimo)
- [Luca Raveri](https://github.com/LucaRaveri)

---
