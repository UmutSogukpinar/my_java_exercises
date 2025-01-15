package Sorting;

class QuickSort
{
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Sıralama öncesi:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSıralama sonrası:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high)
    {
        int i = low - 1;
        int pivot = arr[high];

        for (int j = low; j < high; j++){
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;

        return  (i + 1);
    }
}
