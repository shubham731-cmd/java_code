import java.util.Scanner;

public class odd_digit {
    public static void main(String[] args) {
        //int num = 123456789;
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        String s = String.valueOf(num);
        StringBuilder result = new StringBuilder();

        // Traverse digits in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int digit = ch - '0';
            if (digit % 2 == 1) {  // odd check
                result.append(digit);
            }
        }

        System.out.println(result.toString());
        sc.close();
    }
}