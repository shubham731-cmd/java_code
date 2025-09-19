import java.util.*;

public class vowel_puzzle_checker {
    
        static boolean isVowel(char c) {
            return "aeiou".indexOf(c) != -1;
        }
        
        static boolean isValidPuzzleWord(String word) {
            if (word.length() < 3) return false; // must have room for inner letters
    
            // Check first and last character
            if (!isVowel(word.charAt(0)) || !isVowel(word.charAt(word.length() - 1))) {
                return false;
            }
    
            // Count vowels inside (excluding first and last)
            int count = 0;
            for (int i = 1; i < word.length() - 1; i++) {
                if (isVowel(word.charAt(i))) {
                    count++;
                }
            }
    
            return count == 2;
        }
        
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a word: ");
            String word = sc.nextLine().toLowerCase();
    
            if (isValidPuzzleWord(word)) {
                System.out.println("Valid Puzzle Word");
            } else {
                System.out.println("Invalid Puzzle Word");
            }
            sc.close();
    }
}
