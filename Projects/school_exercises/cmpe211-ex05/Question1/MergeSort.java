package Question1;

import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    private static int[] generateRandomArray(int size)
    {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int size = 1000;
        for (int i = 0; i < 5; i++) {
            int[] arr = generateRandomArray(size);

            long startTime = System.nanoTime();
            mergeSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();

            System.out.println("Array size: " + size + ", Time taken: " + (endTime - startTime) / 1e6 + " ms");
            size *= 2;
        }
    }
}
