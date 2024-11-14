public class BinarySearch
{
    public static int defaultBinarySearch(int key, int[] a)
    {
        int max = a.length -1;
        int min = 0;
        int mid;

        while (min <= max)
        {
            mid = ((max - min) / 2) + min;
            if (a[mid] == key)
                return (mid);
            else if (a[mid] < key)
                min = mid + 1;
            else if (a[mid] > key)
                max = mid - 1;
        }
        return (-1);
    }

    public static int recursiveBinarySearch(int[] a, int key, int low, int high)
    {
        if (low > high)
            return (-1);

        int mid = low + ((high - low) / 2);

        if (a[mid] == key)
            return (mid);
        else if (a[mid] > key)
            return (recursiveBinarySearch(a, key, low, mid - 1));
        else
            return (recursiveBinarySearch(a, key, low + 1, high));
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int key = 7;

        int result = BinarySearch.defaultBinarySearch(key, arr);

        if (result != -1)
            System.out.println("Key found! İndex: " + result);
        else
            System.out.println("Key not found");

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Key to search for
        int key2 = 7;

        // Perform the binary search
        int result2 = recursiveBinarySearch(a, key2, 0, a.length - 1);

        // Output the result
        if (result2 != -1) {
            System.out.println("Element " + key2 + " found at index: " + result2);
        } else {
            System.out.println("Element " + key2 + " not found in the array.");
        }
    }
}
