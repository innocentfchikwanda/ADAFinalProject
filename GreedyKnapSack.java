import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class GreedyKnapSack {
    double[][] Options;
    double MaxWeight;

    public GreedyKnapSack(double[][] Options, double MaxWeight) {
        this.Options = Options; // options 3D-array with 0th row as value, 1st row as weight, 2nd row as value
                                // to weight ratio
        this.MaxWeight = MaxWeight; // the maximum weight the knapsack can carry
    }

    public ArrayList<Double> choose() {
        for (int i = 0; i < this.Options.length; i++) {
            this.Options[i][3] = this.Options[i][1] / Options[i][2]; // populate the ratio row of the options table with
                                                                     // value to weight ratio
        }

        // sort options table using the ratio column in non-increasing order
        Arrays.sort(Options, Comparator.comparingDouble(col -> col[3]));
        ArrayList<Double> choices = new ArrayList<Double>();// set the size of the choices to the size of the rows of
                                                            // the
        // options table

        double weight = 0;
        int j = this.Options.length - 1;

        while ((j >= 0) && (weight <= MaxWeight)) {
            if (weight + this.Options[j][2] <= MaxWeight) {
                weight += this.Options[j][2];
                choices.add(this.Options[j][0]); // Add the value instead of the weight to choices
            }
            j--;
        }
        return choices;
    }

    public static void main(String[] args) {

        // {{element, weight, value, w/v}}
        double[][] Options = { { 1, 10, 2, 0 },
                { 2, 20, 5, 0 },
                { 3, 30, 10, 0 },
                { 4, 40, 15, 0 } };

        double MaxWeight = 25;

        GreedyKnapSack greedyKnapSack = new GreedyKnapSack(Options, MaxWeight);
        ArrayList<Double> choices = greedyKnapSack.choose();

        for (double choice : choices) {
            System.out.println("Element " + (int) choice + " was chosen");
        }
    }
}
