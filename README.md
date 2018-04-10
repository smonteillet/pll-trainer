# pll-trainer

PLL stands for Position Last Layer, the last step of Fridrich method for solving Rubik's cube.
This Groovy script will help you to train how to solve PLLs. It will allows you to generate a scramble which will lead you to a random PLL case.

## How to run

    $ groovy pll_trainer.groovy

    Next PLL scramble:
    F R' F' R U R U' R' F R U' R' U R U R' F' U2
    Press [ENTER] to STOP timer!
    0.703 sec
    The PLL was : T
    -------------------------------------------------

    Next PLL scramble:
    R' D' R U' R' D R U R' D' R U2 R' D R U' R' D' R U R' D R U2
    Press [ENTER] to Start timer!

If you want to specify a defined set of PLLs, you can add the following argument:

    $ groovy pll_trainer.groovy Ga,Gb,Gc,Gd

    Next PLL scramble:
    R' U2 R U' F R U R' U' R' F' U' R U R U' R'
    Press [ENTER] to STOP timer!
    0.5 sec
    The PLL was : Ga
    -------------------------------------------------

    Next PLL scramble:
    U' R2 U' R U' R U R' U R2 D' U R U' R' D U2
    Press [ENTER] to Start timer!
