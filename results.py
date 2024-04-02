import pandas as pd
import matplotlib.pyplot as plt

# Load the data from the CSV file
data = pd.read_csv('output.csv')

# Plot the data
plt.figure(figsize=(10, 6))
plt.plot(data['InputSize'], data['DPKnapSackTime'], label='DPKnapSack')
plt.plot(data['InputSize'], data['GreedyKnapSackTime'], label='GreedyKnapSack')
plt.xlabel('Input Size')
plt.ylabel('Time (milliseconds)')
plt.title('DPKnapSack vs GreedyKnapSack')
plt.legend()
plt.grid(True)
plt.show()