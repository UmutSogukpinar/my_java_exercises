package cmpe_211_ex04.question_3;

public class BinaryInsertion
{
    public static int getCorrectPosition(int[] array, int item, int low, int high)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (item == array[mid])
                return mid + 1;
            else if (item < array[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void binaryInsertionSort(int[] array)
    {
        int n = array.length;

        for (int i = 1; i < n; i++)
        {
            int current = array[i];
            int position = getCorrectPosition(array, current, 0, i - 1);

            for (int j = i; j > position; j--)
                array[j] = array[j - 1];

            array[position] = current;
        }
    }

    public static void printArray(int[] array)
    {
        for (int value : array)
            System.out.print(value + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] array = {43, 8, 9, 1, 3};

        System.out.println("The array before sorting:");
        printArray(array);

        binaryInsertionSort(array);

        System.out.println("The array after sorting:");
        printArray(array);
    }
}