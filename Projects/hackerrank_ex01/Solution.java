import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b)
    {
        if (a == null || b == null)
            return (false);
        a = a.replaceAll("\\s+", "").toLowerCase();
        b = b.replaceAll("\\s+", "").toLowerCase();
        if (a.length() > 50 || b.length() > 50 || a.isEmpty() || b.isEmpty())
            return (false);
        if (a.length() != b.length())
            return (false);
        String sorted_a = sortArray(a);
        String sorted_b = sortArray(b);
        for (int i = 0; i < sorted_a.length(); i++) {
            char one = sorted_a.charAt(i);
            char sec = sorted_b.charAt(i);
            if (one != sec)
                return (false);
        }
        return (true);
    }

    public static String sortArray(String str)
    {
        char temp;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++)
        {
            for (int j = i + 1; j < charArray.length; j++)
            {
                if (charArray[i] > charArray[j])
                {
                    temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        return (new String(charArray));
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

    }
}