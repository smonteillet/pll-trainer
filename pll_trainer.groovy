import groovy.transform.Field;
import java.text.DecimalFormat;
import groovy.io.FileType

def cli = new CliBuilder(usage:'pll_trainer [options]')
cli.i(longOpt:'include', args:1, argName:'include_pll', 'train including a specific set of plls seperated by comma')
cli.e(longOpt:'exclude', args:1, argName:'exclude_pll', 'train excluding a specific set of plls seperated by comma')
cli.l(longOpt:'list', args:0, 'list of all plls')
options = cli.parse(args)

def plls = [];
new File("algos").eachFileRecurse(FileType.FILES) { file ->  plls.add(file.name) }

if (options.list) {
    pllList.each{ println it }
    System.exit(0);
}
else if (options.include) {
    checkUserPllListValidity(options.include, plls);
    plls = options.include.split(",");
}
else if (options.exclude) {
    checkUserPllListValidity(options.exclude, plls);
    plls.removeAll(options.exclude.split(","));
}

DecimalFormat df = new DecimalFormat("0.000");

while (true) {
    def pllName = getRandomElementInList(plls);
    String pllAlgo = chooseRandomPllAlgo(pllName);
    def scramble = generateScramble(pllAlgo);
    println "\nNext PLL scramble: ";
    println scramble
    println 'Use [ENTER] to START / STOP timer!';
    System.in.newReader().readLine();
    long start = System.currentTimeMillis();
    def t = Thread.start {
        while (true) {
            long now = System.currentTimeMillis();
            String timeFormated = df.format(((now - start) / 1000d));
            print "\r $timeFormated s"
            Thread.sleep(5);
        }
    }
    System.in.newReader().readLine();
    t.stop(); 
    println "\nThe PLL was : $pllName";
    println "-------------------------------------------------"
}

def getRandomElementInList(def list) {
    int index = Math.abs(new Random().nextInt() % list.size());
    return list[index];
}

int getRandomNumber(int upperRange) {
    return Math.abs(new Random().nextInt() % upperRange);
}

def chooseRandomPllAlgo(def pllName) {
    def lines = new File("algos/$pllName").readLines();
    return getRandomElementInList(lines);
}

def generateScramble(String pllAlgo) {
    String scramble = "";
    pllAlgo.split(" ").reverse().each{ move ->
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
    return scramble + getRandomElementInList(["U", "U'", "U2", ""]);
}

def checkUserPllListValidity(def userPllList, def plls) {
    userPllList.split(",").each { pll ->
        if (!plls.contains(pll)) {
            println "PLL $pll is not handle by this script";
            System.exit(0);
        }
    }
}