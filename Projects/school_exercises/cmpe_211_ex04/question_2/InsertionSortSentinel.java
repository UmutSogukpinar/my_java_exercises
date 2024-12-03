package cmpe_211_ex04.question_2;

public class InsertionSortSentinel
{

    public static void insertionSort(int[] array)
    {

        int minIndex = 0;
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] < array[minIndex])
                minIndex = i;
        }

        int temp = array[0];
        array[0] = array[minIndex];
        array[minIndex] = temp;

        for (int i = 2; i < array.length; i++)
        {
            int current = array[i];
            int j = i;

            while (array[j - 1] > current)
            {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = current;
        }
    }

    public static void main(String[] args)
    {
        int[] array = {5, 2, 91, 14, 35};

        System.out.println("Array before the sorting:");
        printArray(array);

        insertionSort(array);

        System.out.println("Array after the sorting:");
        printArray(array);
    }

    public static void printArray(int[] array)
    {
        for (int value : array)
            System.out.print(value + " ");

        System.out.println();
    }
}

