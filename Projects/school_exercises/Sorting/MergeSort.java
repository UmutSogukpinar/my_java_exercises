package Sorting;

class MergeSort
{

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Sıralama öncesi:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSıralama sonrası:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right)
    {
        int leftArrayNum = mid - left + 1;
        int rightArrayNum = right - mid;

        int[] leftArray = new int[leftArrayNum];
        int[] rightArray = new int[rightArrayNum];

        for (int i = 0; i < leftArrayNum; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArrayNum; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int j = 0;
        int i = 0;
        int k = left;

        while (i < leftArrayNum && j < rightArrayNum)
        {
            if (leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArrayNum)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArrayNum)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
