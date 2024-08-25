
# SortViz

**SortViz** is a tool designed to visually demonstrate the time complexity of various sorting algorithms. This project provides an educational resource for understanding and comparing the efficiency of different sorting methods through clear and intuitive visualizations.

## Features

- **Visualize Time Complexity**: Shows how different sorting algorithms perform on various input sizes.
- **Support for Multiple Algorithms**:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Radix Sort
  - Bucket Sort
  - Heap Sort
  - Shell Sort
  - Counting Sort
- **Logarithmic Scale Representation**: Accurately depicts the time complexity of sorting algorithms using a logarithmic scale.
- **Graphs and Heatmaps**: Includes a variety of visualizations such as line charts and heatmaps to offer different perspectives on algorithm performance.

## Installation

To run the visualizations locally, you'll need to have Java and Python installed on your machine.

### Java

1. Clone the repository:
   ```bash
   git clone https://github.com/AnkanMisra/AlgoViz.git
   cd AlgoViz
  
2. Compile and run
   ```bash
    java sort.java

3. The data will be stored to the sorting_times.csv file

4. Install these packages
    ```bash
   pip install pandas seaborn matplotlib
5. Run the Command
   ```bash
    python3 visual.py

## Visualization
The following visualizations will be generated and saved in the graph/ directory:
	-	Line Plot: Compares the time complexity of all sorting algorithms on different input sizes.
	-	Heatmap: Displays a matrix of execution times for each algorithm at various input sizes.
	-	Box Plot: Shows the distribution of execution times for each algorithm.
	-	Pairplot: Provides a pairwise comparison of the algorithms’ performance.
	-	Violin Plot: Illustrates the density of execution times across different algorithms.
	-	Bar Plot: Highlights the average execution time for each sorting algorithm.
	-	Swarm Plot: Visualizes individual execution time data points without overlap.
	-	Scatter Plot with Regression Line: Shows the trend of execution time as input size increases, with a regression line for each algorithm.
 
## Tech Used

-	Java:
-	Used to implement the sorting algorithms and measure their performance on various input sizes.
-	Compiles the Java source code (sort.java) into bytecode (Sort.class) that can be executed to generate sorting time data.
-	Python: Utilizes the Pandas, Seaborn, and Matplotlib libraries to read the sorting time data from sorting_times.csv and generate visualizations.	
-	visual.py script processes the data and creates various types of graphs to illustrate the time complexity of the sorting algorithms.
-	Pandas: A powerful data manipulation library in Python used to read and pivot the sorting time data for visualization.
-	Seaborn: A statistical data visualization library in Python built on top of Matplotlib, used for creating the heatmaps and other advanced plots.
-	Matplotlib: A comprehensive library for creating static, animated, and interactive visualizations in Python. Used to generate line plots, bar plots, and other basic visualizations.


## Project Structure
```bash
├── graph/                      # Directory where generated graphs are saved
│   └── test.text               # Example file in the graph directory (this can be removed or replaced with your generated images)
├── Sort.class                  # Compiled Java class file for sorting algorithms
├── sort.java                   # Java source file containing sorting algorithms
├── sorting_times.csv           # CSV file where sorting times are stored
└── visual.py                   # Python script for generating visualizations
