package Sorting;

class SelectionSort
{
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 14, 7, 6};

        System.out.println("Sıralama öncesi:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\nSıralama sonrası:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
            {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
