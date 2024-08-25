import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Sort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, l, L, 0, n1);
        System.arraycopy(array, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) {
            array[k++] = L[i++];
        }

        while (j < n2) {
            array[k++] = R[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void radixSort(int[] arr) {
        int m = getMax(arr);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
    
        Arrays.fill(count, 0);
    
        for (int value : arr) {
            count[(value / exp) % 10]++;
        }
    
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
    
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
    
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void bucketSort(int[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        int maxValue = getMax(arr);
        List<List<Integer>> buckets = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : arr) {
            int bucketIndex = (value * n) / (maxValue + 1);
            buckets.get(bucketIndex).add(value);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    private static int getMax(int[] arr) {
        return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
    }

    
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int[] count = new int[max + 1];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void copyAndSort(int[] originalArray, int[] array, Consumer<int[]> sortMethod, String sortName, BufferedWriter writer) throws IOException {
        System.arraycopy(originalArray, 0, array, 0, originalArray.length);
        double startTime = System.nanoTime();
        sortMethod.accept(array);
        double stopTime = System.nanoTime();
        double timeElapsed = (stopTime - startTime) / 1_000_000.0;

        writer.write(sortName + "," + originalArray.length + "," + timeElapsed + "\n");
    }
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorting_times.csv"))) {
            writer.write("Algorithm,InputSize,Time(ms)\n");
    
            
            int[] sizes = {100, 1000, 5000, 10000, 20000, 40000, 80000, 100000, 200000};
    
            for (int n : sizes) {
                int[] array = new int[n];
                int[] originalArray = new int[n];
                Random random = new Random();
    
               
                for (int i = 0; i < n; i++) {
                    originalArray[i] = random.nextInt(10000) + 1;
                }
    
               
                copyAndSort(originalArray, array, Sort::bubbleSort, "Bubble Sort", writer);
                copyAndSort(originalArray, array, Sort::selectionSort, "Selection Sort", writer);
                copyAndSort(originalArray, array, Sort::insertionSort, "Insertion Sort", writer);
                copyAndSort(originalArray, array, arr -> mergeSort(arr, 0, arr.length - 1), "Merge Sort", writer);
                copyAndSort(originalArray, array, arr -> quickSort(arr, 0, arr.length - 1), "Quick Sort", writer);
                copyAndSort(originalArray, array, Sort::radixSort, "Radix Sort", writer);
                copyAndSort(originalArray, array, Sort::bucketSort, "Bucket Sort", writer);
                copyAndSort(originalArray, array, Sort::heapSort, "Heap Sort", writer);
                copyAndSort(originalArray, array, Sort::shellSort, "Shell Sort", writer);
                copyAndSort(originalArray, array, Sort::countingSort, "Counting Sort", writer);
            }
    
            System.out.println("Execution times have been written to sorting_times.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}