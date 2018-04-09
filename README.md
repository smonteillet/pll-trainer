# pll-trainer

PLL stands for Position Last Layer, the last step of Fridrich method for solving Rubik's cube.
This Groovy script will help you to train how to solve PLLs. It will allows you to generate a scramble which will lead you to a random PLL case.

## How to run

    $ groovy pll-trainer.groovy
    U R U2 R D R' U R D' R' U' R' U R U R'
    Press enter to reveal PLL

If you want to specify a defined set of PLLs, you can add the following argument:

    $ groovy pll-trainer.groovy Ga,Gb,Gc,Gd
    U' R2 U' R U' R U R' U R2 D' U R U' R' D U'
    Press enter to reveal PLL