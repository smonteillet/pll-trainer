# pll-trainer

PLL stands for Position Last Layer, the last step of Fridrich (CFOP) method for solving Rubik's cube.
This Groovy script will help you to train how to solve PLLs. It will allows you to generate a scramble which will lead you to a random PLL case.

## How to run

    $ groovy pll_trainer.groovy

    Next PLL scramble:
    F R' F' R U R U' R' F R U' R' U R U R' F' U2
    Use [ENTER] to reveal PLL

    The PLL was : T
    -------------------------------------------------

    Next PLL scramble:
    R' D' R U' R' D R U R' D' R U2 R' D R U' R' D' R U R' D R U2
    Use [ENTER] to reveal PLL

## Option -i

If you want to train only with a specific set of PLLs, you can add the following argument:

    $ groovy pll_trainer.groovy -i Ga,Gb,Gc,Gd

    Next PLL scramble:
    R' U2 R U' F R U R' U' R' F' U' R U R U' R'
    Use [ENTER] to reveal PLL

    The PLL was : Ga

## Option -e

If you want to remove a specific set of PLLs, you can add the following argument:

    $ groovy pll_trainer.groovy -e Na,Nb

    Next PLL scramble:
    R' U2 R U' F R U R' U' R' F' U' R U R U' R'
    Use [ENTER] to reveal PLL

    The PLL was : Ga

### Option -t

If you want to add a timer to track your PLLs solve time, you can add the `-t` option like this:

    $ groovy pll_trainer.groovy -t

    Next PLL scramble:
    B2 U2 B' U2 B2 U2 F2 D2 B' D2 F2 U'
    Use [ENTER] to START / STOP timer!

    2,571 s

    The PLL was : H
    -------------------------------------------------
