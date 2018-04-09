// The following map is representing plls with list of moves for solving the specific PLL.
def plls = [
    Aa : ["R' F R' B2 R F' R' B2 R2", "R' U2 R2 U' L' U R' U' L U R' U2 R", "R U' L' U' L2 U' R2 U L2 U' R2 U2 L U R'"],
    Ab : ["R B' R F2 R' B R F2 R2"],
    E  : ["R' U L' D2 L U' R L' U R' D2 R U' L", "R' D' R U' R' D R U R' D' R U2 R' D R U' R' D' R U R' D R"],
    F  : ["R' U' F' R U R' U' R' F R2 U' R' U' R U R' U R", "R' U R U' R2 F' U' F U R F R' F' R2 U'", "L U' L' U L2 F U F' U' L' F' L F L2 U", "R' U2 R' U2 L U' R' U' R' U R U2 L' U2 R U R"],
    Ga : ["R2 U R' U R' U' R U' R2 D U' R' U R D' U", "R U R' U' R' U F R U R U' R' F' U R' U2 R"],
    Gb : ["R' U' R B2 D L' U L U' L D' B2", "R' U' R U D' R2 U R' U R U' R U' R2 D"],
    Gc : ["R2 U' R U' R U R' U R2 D' U R U' R' D U'", "L' U' L U L U' F' L' U' L' U L F U' L U2 L'"],
    Gd : ["D' R U R' U' D R2 U' R U' R' U R' U R2 U"],
    H  : ["R2' U2 R' U2 R2' U2' R2' U2 R' U2 R2'", "R2 U2 R2 U2 R2 U R2 U2 R2 U2 R2", "R U2' R' U' R' U' R2 U' R2' U2' R2 U2' R'", "L2 U2 L' U2 L2 U2 L2 U2 L' U2 L2", "L R U2 L' R' F' B' U2 F B"],
    Ja : ["R' U L' U2 R U' R' U2 R L U'", "B' U F' U2 B U' B' U2 F B U'", "B2 R' U' R B2 L' D L' D' L2", "L' U' L F L' U' L U L F' L2 U L U"],
    Jb : ["R U R' F' R U R' U' R' F R2 U' R' U'", "B U' F U2 B' U B U2 F' B' U", "R U' L U2 R' U L' U' R U' L U2 R' U L'"],
    Na : ["L U' R U2 L' U R' L U' R U2 L' U R' U'", "L U' L' U L F U F' L' U' L F' L F L' U L'", "R' U R2 B2 U R' B2' R U' B2 R2' U' R U'"],
    Nb : ["R' U L' U2 R U' L R' U L' U2 R U' L U", "R' U R U' R' F' U' F R U R' F R' F' R U' R", "	F L' U' L U L F' L2 F' U L U L' U' F L"],
    Rb : ["R' U2 R U2' R' F R U R' U' R' F' R2 U'", "B2 L2 U' B' U' B U B U L2 B U' B U", "R' U2 R U R B R' U2 R' U2 R B' R' U R U'"],
    Ra : ["R U' R' U' R U R D R' U' R D' R' U2 R' U'", "R U2 R' U2 R B' R' U' R U R B R2 U", "F2 L2 U F U F' U' F' U' L2 F' U F' U'"],
    T  : ["F R U' R' U' R U R' F' R U R' U' R' F R F'", "R2 U R2 U' R2' U' D R2 U' R2' U R2 D'", "R2 U' R2 D B2 L2 U L2 D' B2 U"],
    Ua : ["R2 U R U R' U' R' U' R' U R'", "R U R' U R' U' R2 U' R' U R' U R" , "R U R' U' L' U' L U2 R U' R' U' L' U L", "R U R' U' L' U' L U2 R U' R' U' L' U L"],
    Ub : ["R U' R U R U R U' R' U' R2", "L' U' L U R U R' U2 L' U L U R U' R'", "L' U' L U R U R' U2 L' U L U R U' R'"],
    V  : ["R' U R' U' B' R' B2 U' B' U B' R B R", "R' U R' U' B' D B' D' B2 R' B' R B R", "F' U B U' F U F' U B' U' F U2 B U2 B'"],
    Y  : ["F R U' R' U' R U R' F' R U R' U' R' F R F'", "R2 U' R2 U' R2 U F U F' R2 F U' F'", "F2 D R2 U R2 D' R' U' R F2 R' U R"],
    Z  : ["R' U' R2 U R U R' U' R U R U' R U' R'", "U R' U' R U' R U R U' R' U R U R2 U' R' U", "R U R' U R' U' R' U R U' R' U' R2 U R"]
]

int getRandomNumber(int upperRange) {
    return Math.abs(new Random().nextInt() % upperRange);
}

while (true) {
    // Chose which PLL
    int chosenPllIndex = getRandomNumber(plls.size());
    def chosenPLL = (plls.keySet() as String[])[chosenPllIndex];
    // Chose which solve of the chosen PLL
    int chosenPllSolveIndex =  getRandomNumber(plls[chosenPLL].size());
    String pllSolveAlgorithm = plls[chosenPLL].get(chosenPllSolveIndex);
    // Generate Scramble from pll solve algo
    String scramble = "";
    pllSolveAlgorithm.split(" ").reverse().each{ move ->
        if (move.contains("2")) {
            scramble = scramble + move + " ";
        }
        else if (move.endsWith("'")) {
            scramble = scramble + move.subSequence(0, move.length() - 1) + " "
        }
        else if (!move.endsWith("'")) {
            scramble = scramble + move + "' ";
        }
    }

    println "\nNext PLL scramble: ";
    println scramble
    System.console().readLine 'Press enter to reveal PLL ';
    println "The PLL was : $chosenPLL";
}