import java.io.PrintWriter;
import java.util.Random;

public class Tester {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("output.csv", "UTF-8");
        writer.println("InputSize,DPKnapSackTime,GreedyKnapSackTime");

        for (int n = 100; n <= 1000; n += 100) {
            // Generate inputs
            int[] values = new int[n];
            int[] weights = new int[n];
            double[][] options = new double[n][4];
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                values[i] = rand.nextInt(1000); // random value between 0 and 999
                weights[i] = rand.nextInt(1000); // random weight between 0 and 999
                options[i][0] = i;
                options[i][1] = values[i];
                options[i][2] = weights[i];
            }

            int capacity = n * 500; // knapsack capacity

            // Run DPKnapSack
            DPKnapSack dpKnapSack = new DPKnapSack();
            long dpTime = 0;
            for (int i = 0; i < 10; i++) {
                long start = System.nanoTime();
                dpKnapSack.choice(capacity, values, weights);
                long end = System.nanoTime();
                dpTime += (end - start) / 1000000; // convert to milliseconds
            }
            dpTime /= 10; // take average

            // Run GreedyKnapSack
            GreedyKnapSack greedyKnapSack = new GreedyKnapSack(options, capacity);
            long greedyTime = 0;
            for (int i = 0; i < 10; i++) {
                long start = System.nanoTime();
                greedyKnapSack.choose();
                long end = System.nanoTime();
                greedyTime += (end - start) / 1000000; // convert to milliseconds
            }
            greedyTime /= 10; // take average

            writer.println(n + "," + dpTime + "," + greedyTime);
        }

        writer.close();
    }
}