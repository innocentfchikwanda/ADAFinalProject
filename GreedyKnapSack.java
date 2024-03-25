import java.util.Arrays;
import java.util.Comparator;

public class GreedyKnapSack {
    double[][] Options;
    double MaxWeight;

    public GreedyKnapSack(double[][] Options, double MaxWeight) {
        this.Options = Options; // options 3D-array with 0th row as value, 1st row as weight, 2nd row as value
                                // to weight ratio
        this.MaxWeight = MaxWeight; // the maximum weight the knapsack can carry
    }

    public double[] choose() {
        for (int i = 0; i <= this.Options.length; i++) {
            System.out.print(this.Options[0][i]);
            System.out.print("/");
            System.out.print(Options[1][i]);
            System.out.print("/");
            this.Options[2][i] = this.Options[0][i] / Options[1][i]; // populate the ratio row of the options table with
                                                                     // value to weight ratio
        }

        // sort options table using the ratio column in non-increasing order
        Arrays.sort(Options, Comparator.comparingDouble(row -> row[2]));
        double[] choices = new double[Options[0].length];// set the size of the choices to the size of the rows of the
                                                         // options table

        for (double[] item : Options) {
            for (double i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        double weight = 0;
        int j = 0;
        int k = 0;

        while ((j < this.Options[0].length) && (weight < MaxWeight)) {
            if (weight + this.Options[1][j] < MaxWeight) {
                weight += this.Options[1][j];
                choices[k] = this.Options[0][j]; // Add the value instead of the weight to choices
                k++;
            }
            j++;
        }
        return choices;
    }

    public static void main(String[] args) {

        double[][] Options = { { 3, 4, 6, 5 }, { 2, 3, 1, 4 }, { 0, 0, 0, 0 } };
        double MaxWeight = 30;

        GreedyKnapSack greedyKnapSack = new GreedyKnapSack(Options, MaxWeight);
        double[] choices = greedyKnapSack.choose();

        for (double choice : choices) {
            System.out.println("Element with weight " + choice + " is chosen");
        }
    }
}
