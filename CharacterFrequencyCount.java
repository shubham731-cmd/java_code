import java.util.*;
public class CharacterFrequencyCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        //String str = "hello world";
        int[] freq = new int[256]; // Assuming ASCII character set

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        // Print characters and their frequencies
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char)i + ": " + freq[i]);
            }
        }
        sc.close();
    }
}
