package Question1;

import java.util.Random;

public class QuickSort
{

    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] generateRandomArray(int size)
    {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(100000);
        return arr;
    }

    public static void main(String[] args)
    {
        int size = 1000;
        for (int i = 0; i < 5; i++)
        {
            int[] arr = generateRandomArray(size);

            long startTime = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();

            System.out.println("Array size: " + size + ", Time taken: " + (endTime - startTime) / 1e6 + " ms");
            size *= 2;
        }
    }
}
