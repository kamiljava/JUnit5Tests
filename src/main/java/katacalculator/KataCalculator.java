package katacalculator;

public class KataCalculator {

    //https://osherove.com/tdd-kata-1

    public static int sum(String numbers) {

        if (numbers.equals("")) {
            return 0;
        }
        String[] sumTable = numbers.split("[\n|,|]");
        int sum = 0;
        for (int i = 0; i < sumTable.length; i++) {
            sum +=  Integer.parseInt(sumTable[i]);
        }
        return sum;
    }
}
