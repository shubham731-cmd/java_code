import java.util.Scanner;

public class custom_password {
    public static void main(String[] args) {
        //String input = "Java1234";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder encoded = new StringBuilder();

        for (char ch : input.toCharArray()) {
            char upper = Character.toUpperCase(ch);

            // Rule 1: Replace vowels with '@'
            if ("AEIOU".indexOf(upper) != -1) {
                encoded.append('@');
            }
            // Rule 2: Replace even digits with '*'
            else if (Character.isDigit(upper)) {
                int digit = upper - '0';
                if (digit % 2 == 0) {
                    encoded.append('*');
                } else {
                    encoded.append(upper);
                }
            }
            // Rule 3: Other characters remain uppercase
            else {
                encoded.append(upper);
            }
        }

        System.out.println(encoded.toString());
        sc.close();
    }
}

