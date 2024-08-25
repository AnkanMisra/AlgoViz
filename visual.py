import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import os
import logging


logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')


if not os.path.exists('graph'):
    os.makedirs('graph')
    logging.info("Created 'graph' directory for saving plots.")

# Function to generate line plot
def plot_line(df, algorithms):
    plt.figure(figsize=(14, 10))
    colors = plt.get_cmap('tab10')
    line_styles = ['-', '--', '-.', ':', '-', '--', '-.', ':', '-', '--']

    for i, algorithm in enumerate(algorithms):
        data = df[df['Algorithm'] == algorithm]
        plt.plot(data['InputSize'], data['Time(ms)'], 
                 marker='o', markersize=8, linewidth=2, 
                 label=algorithm, color=colors(i / len(algorithms)), linestyle=line_styles[i])

    plt.title('Sorting Algorithm Performance', fontsize=22, weight='bold')
    plt.xlabel('Input Size', fontsize=18)
    plt.ylabel('Time (ms)', fontsize=18)
    plt.yscale('log')
    plt.grid(True, which="both", ls="--", linewidth=0.5)
    plt.legend(loc='upper left', fontsize=14)
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_performance.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Line plot saved as 'sorting_algorithm_performance.png'.")


def plot_heatmap(df):
    heatmap_data = df.pivot(index="Algorithm", columns="InputSize", values="Time(ms)")
    plt.figure(figsize=(14, 8))
    sns.heatmap(heatmap_data, annot=True, fmt=".2f", cmap="viridis", linewidths=0.5)
    plt.title('Sorting Algorithm Performance Heatmap', fontsize=20)
    plt.xlabel('Input Size', fontsize=16)
    plt.ylabel('Algorithm', fontsize=16)
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_heatmap.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Heatmap saved as 'sorting_algorithm_heatmap.png'.")


def plot_boxplot(df):
    plt.figure(figsize=(14, 8))
    sns.boxplot(x='Algorithm', y='Time(ms)', data=df)
    plt.title('Distribution of Execution Times by Algorithm', fontsize=20)
    plt.xlabel('Algorithm', fontsize=16)
    plt.ylabel('Time (ms)', fontsize=16)
    plt.yscale('log')
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_boxplot.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Box plot saved as 'sorting_algorithm_boxplot.png'.")


def plot_pairplot(df):
    sns.pairplot(df, hue='Algorithm', height=2.5)
    plt.suptitle('Pairwise Comparison of Sorting Algorithms', y=1.02, fontsize=20)
    plt.savefig('graph/sorting_algorithm_pairplot.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Pairplot saved as 'sorting_algorithm_pairplot.png'.")


def plot_violinplot(df):
    plt.figure(figsize=(14, 8))
    sns.violinplot(x='Algorithm', y='Time(ms)', data=df)
    plt.title('Density of Execution Times by Algorithm', fontsize=20)
    plt.xlabel('Algorithm', fontsize=16)
    plt.ylabel('Time (ms)', fontsize=16)
    plt.yscale('log')
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_violinplot.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Violin plot saved as 'sorting_algorithm_violinplot.png'.")


def plot_barplot(df):
    avg_times = df.groupby('Algorithm')['Time(ms)'].mean().reset_index()
    plt.figure(figsize=(14, 8))
    sns.barplot(x='Algorithm', y='Time(ms)', data=avg_times)
    plt.title('Average Execution Time by Algorithm', fontsize=20)
    plt.xlabel('Algorithm', fontsize=16)
    plt.ylabel('Average Time (ms)', fontsize=16)
    plt.yscale('log')
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_barplot.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Bar plot saved as 'sorting_algorithm_barplot.png'.")


def plot_swarmplot(df):
    plt.figure(figsize=(14, 8))
    sns.swarmplot(x='Algorithm', y='Time(ms)', data=df)
    plt.title('Execution Times by Algorithm', fontsize=20)
    plt.xlabel('Algorithm', fontsize=16)
    plt.ylabel('Time (ms)', fontsize=16)
    plt.yscale('log')
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_swarmplot.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Swarm plot saved as 'sorting_algorithm_swarmplot.png'.")


def plot_regression(df):
    sns.lmplot(x='InputSize', y='Time(ms)', hue='Algorithm', data=df, logx=True, height=8, aspect=1.5)
    plt.title('Execution Time vs Input Size with Regression Line', fontsize=20)
    plt.xlabel('Input Size', fontsize=16)
    plt.ylabel('Time (ms)', fontsize=16)
    plt.yscale('log')
    plt.tight_layout()
    plt.savefig('graph/sorting_algorithm_regression.png', dpi=300, bbox_inches='tight')
    plt.show()
    logging.info("Scatter plot with regression saved as 'sorting_algorithm_regression.png'.")


def main():
    df = pd.read_csv('sorting_times.csv')
    algorithms = df['Algorithm'].unique()

    plot_line(df, algorithms)
    plot_heatmap(df)
    plot_boxplot(df)
    plot_pairplot(df)
    plot_violinplot(df)
    plot_barplot(df)
    plot_swarmplot(df)
    plot_regression(df)

    logging.info("All plots generated and saved successfully.")

if __name__ == "__main__":
    main()