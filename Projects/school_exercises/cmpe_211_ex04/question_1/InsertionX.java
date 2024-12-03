package cmpe_211_ex04.question_1;

public class InsertionX
{

    public static void insertionSort(int[] array)
    {
        int current;
        for (int i = 1; i < array.length; i++)
        {
            current = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > current)
            {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }

    public static void main(String[] args){

        int[] array = {5, 2, 9, 1, 3};

        System.out.println("First form of array:");
        printArray(array);

        insertionSort(array);

        System.out.println("The array after insertionX:");
        printArray(array);
    }

    public static void printArray(int[] array)
    {
        for (int value : array)
            System.out.print(value + " ");

        System.out.println();
    }
}
