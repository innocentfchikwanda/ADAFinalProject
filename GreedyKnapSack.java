
//IMPORTING USEFUL JAVA LIBRARIES
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

//A CLASS TO IMPLEMENT THE GRREDY ALGORITHM FOR SOLVING THE KNAPSACK PROBLEM
public class GreedyKnapSack {
    double[][] Options; // A 2-D array of options
    double MaxWeight; // The Maximum permissible weight within the knapsack

    public GreedyKnapSack(double[][] o, double w) {
        Options = o; // instantiating Options with passed argument
        MaxWeight = w; // instantiating Options with passed argument
    }

    // A method to perform repeated choosing of the best local optimum
    public ArrayList<Double> choose() {
        for (int i = 0; i < this.Options.length; i++) {
            // O(n)
            this.Options[i][3] = this.Options[i][1] / Options[i][2]; // populate the ratio row of the options table with
                                                                     // value to weight ratio
        }

        // sort options table using the ratio column in non-increasing order
        Arrays.sort(Options, Comparator.comparingDouble(col -> col[3])); // O(nlogn)

        ArrayList<Double> choices = new ArrayList<Double>(1);// set the size of the choices to the size of the rows of
                                                             // the options table O(1)

        // Inserting chosen options into the knapsack
        double weight = 0;
        int j = this.Options.length - 1;
        while ((j >= 0) && (weight <= MaxWeight)) {
            // O(n)
            if (weight + this.Options[j][2] <= MaxWeight) {
                weight += this.Options[j][2];
                choices.add(this.Options[j][0]); // Add the value instead of the weight to choices
            }
            j--;
        }
        return choices;
    }

    // Main method to run the program
    public static void main(String[] args) {

        // Example 1
        // {{element, weight, value, w/v}}
        double[][] Options1 = { { 1, 10, 2, 0 },
                { 2, 20, 5, 0 },
                { 3, 30, 10, 0 },
                { 4, 40, 15, 0 } };

        double MaxWeight1 = 25;

        GreedyKnapSack greedyKnapSack = new GreedyKnapSack(Options1, MaxWeight1);
        ArrayList<Double> knapSack1 = greedyKnapSack.choose();

        System.out.println("This is the choice of elements in the for the first example");
        for (double choice : knapSack1) {
            System.out.println("Element " + (int) choice + " was chosen");
        }

        // Example 2
        // {{element, weight, value, w/v}}
        double[][] Options2 = { { 1, 5, 2, 0 },
                { 2, 21, 3, 0 },
                { 3, 10, 10, 0 },
                { 4, 40, 8, 0 } };

        double MaxWeight2 = 15;

        GreedyKnapSack greedyKnapSack2 = new GreedyKnapSack(Options2, MaxWeight2);
        ArrayList<Double> knapSack2 = greedyKnapSack2.choose();

        System.out.println("This is the choice of elements in the for the second example");
        for (double choice : knapSack2) {
            System.out.println("Element " + (int) choice + " was chosen");
        }
    }
}
