package Sorting;

class HeapSort
{
    public static void heapSort(int[] arr)
    {
        int len = arr.length;

        for(int i = (len/2) - 1; i >= 0; i--){
            heapify(arr, len, i);
        }

        for(int i = len - 1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i,0);
        }
    }

    public static void heapify(int[] arr, int len, int i)
    {
        int largest = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

        if (left < len && arr[largest] < arr[left])
        {
            largest = left;
        }
        if (right < len && arr[largest] < arr[right])
        {
            largest = right;
        }

        if (largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, len, largest);
        }

    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Sıralama öncesi:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        heapSort(arr);

        System.out.println("\nSıralama sonrası:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
