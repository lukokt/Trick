/**
 * Created by lukasz on 1/17/14.
 */
public class Trick {

    public Trick(int x, int y, int z) {

        printCombinations(8, 3);
    }

    private void printCombinations(int n, int k) {

        int[][] combinations = getCombinations(n, k);

        System.out.println("the number of " + k +"-combinations sets of set " + n + " is equal: " + combinations.length);

        int[] combination;
        for(int i = 0; i < combinations.length; i++) {

            combination = combinations[i];
            if (combination[0] == 0) {
                break;
            }
            System.out.println(combination[0] + ", " + combination[1] + ", " + combination[2]);
        }
    }

    private int[][] getCombinations(int n, int k) {

        int combinationsCount = binomialCoefficient(n, k);

        int[][] combinations = new int[combinationsCount][k];

        int c = 0;
        for(int i = 1; i <= n-k+2; i++) {
            for(int j = i+1; j <= n-k+2; j++) {
                for(int l = j+1; l <= n; l++) {
                    combinations[c++] = new int[]{i, j, l};
                    System.out.println("trick: " + i + ", " + j + ", " + l);
                }
            }
        }

        return combinations;
    }

    private int binomialCoefficient(int n, int k) {
        // TODO nie liczyc za duzo
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static void main(String[] args) {

        if (args.length != 3) {
            usage();
        }

        new Trick(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));

    }

    private static void usage() {
        System.out.println("trick: wrong number of arguments");
        System.out.println("Usage: jar trick.jar number1 number2 number3");
        System.out.println("number[123] is int from 1 to 8");
    }
}
