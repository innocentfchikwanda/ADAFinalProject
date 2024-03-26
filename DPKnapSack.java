// implementing a tabulation (bottom up) algorithm to solve the 0-1 knapsack problem
//author : princess asiru-Balogun

import java.util.*;

class DPKnapSack {
    public int choice(int knapsack_Capacity, int[] item_values, int[] item_weights) {
        /* number of items given is assigned to n */
        int n = item_values.length;
        /* table to store values of subporblems as calculated */
        int[][] table = new int[n + 1][knapsack_Capacity + 1];

        // Fill the table in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= knapsack_Capacity; w++) {
                // base case is when there are no items and no knapsack weight, so we fill the
                // first column and row with zero
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                    // checking first taht the item is not heavier than the knapsack weight. if so,
                    // populate the cell with the maximum or optimal value from either including the
                    // last item or excluding the last item.
                } else if (item_weights[i - 1] <= w) {
                    table[i][w] = Math.max(item_values[i - 1] + table[i - 1][w - item_weights[i - 1]], table[i - 1][w]);
                } else {
                    table[i][w] = table[i - 1][w];
                }
            }
        }
        // the maximum value will be in the cell intersectng the last row and last
        // column.
        return table[n][knapsack_Capacity];
    }

    public static void main(String[] args) {
        int knapsack_Capacity = 50; // Weight capacity of knapsack
        int[] item_values = { 60, 100, 120 }; // Values of each item
        int[] item_weights = { 10, 20, 30 }; // Weights of each item

        DPKnapSack knapsack = new DPKnapSack();
        int max_value = knapsack.choice(knapsack_Capacity, item_values, item_weights);
        System.out.println("Maximum value is " + max_value);
    }
}
