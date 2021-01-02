# Chaos and Order


This repository contains the final project for the Software Development Methods 2020/21 [course](https://corsi.units.it/sm34/modulo/software-development-methods-567sm-2020-pds0-2018-ord-2018-comune).

## Table of Contents

- [Introduction](#introduction)
- [How to play](#how-to-play)
- [Versions](#versions)
    - [Command line interface](#command-line-interface)
    - [Graphical user interface](#graphical-user-interface)
- [What is next?](#what-is-next)
- [Contributors](#contributors)



### Introduction


The goal of the project is to implement a board game called Chaos and Order, which was invented by Stephen Sniderman and introduced by him in Games magazine in 1981.

_Source: [Wikipedia](https://en.wikipedia.org/wiki/Order_and_Chaos)_

---

### How to play


The game is a variation of the more known Tic Tac Toe game. It is still played on a 6x6 board as the original game, however the two players have different porpouses. Every player can, at every turn, pick a Cross or Circle and is free to put the chosen sign wherever he wants. Order's purpose is to make a quintuple of equal signs, regardless the direction (namely vertically, horizontally and diagonally), while Chaos has to prevent that, until the board is filled and no further moves are available.  
Order moves first.

---


### Versions


The game can be played both from a Command line interface (CLI) or from a Graphical user interface (GUI):

- #### Command line interface

To start the Command line interface move to the directory where you have extracted the deployed and run `./ChaosAndOrder --cli`.

<!-- <p align="center">
<img src="https://github.com/RacmanT/ChaosAndOrder/screenshots/CLI_1.png">
</p> -->

Moves are given in the format _RowColumn Sign_, where the Row can be chosen among [A,F], the Column among [1,6] and the Sign between [X,O] (e.g. _A5 X, E2 O_,...) The game is not case sensitive and extra empty spaces will be handled too.

- #### Graphical User Interface

To start the Command line interface move to the directory where you have extracted the deployed archive and run `./ChaosAndOrder --gui`.



---

### What is next?

Some new features might be added in a next release. Some of them are:

- [x] Light mode :sunny: / Dark mode :crescent_moon:
- [ ] Support for more langauges :earth_africa:
- [ ] Multiplayer (Client/Server) :family_man_man_girl_boy:

If you want to contribute in the implementation or you any other idea for a next release feel free to fork and / or contact us using Github.


---

### Contributors

- [Tibor Racman](https://github.com/RacmanT)
- [Massimo Palmisano](https://github.com/PalMassimo)
- [Luca Raveri](https://github.com/LucaRaveri)

---