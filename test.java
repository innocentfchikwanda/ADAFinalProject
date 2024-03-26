int knapsack_Capacity = 25;
int[] item_values = { 40, 30, 20, 10 };
int[] item_weights = { 15, 10, 5, 2 };

int max_value = knapsack.choice(knapsack_Capacity, item_values, item_weights);
System.out.println("Maximum value is " + max_value);

int knapsack_Capacity2 = 15;
int[] item_values2 = { 5, 21, 10, 40 };
int[] item_weights2 = { 2, 3, 10, 8 };

int max_value2 = knapsack.choice(knapsack_Capacity2, item_values2, item_weights2);
System.out.println("Maximum value is " + max_value2);
