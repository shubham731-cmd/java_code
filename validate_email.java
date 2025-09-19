import java.util.*;

public class validate_email {
    public static boolean isValidEmail(String email) {
        // Your code here
        int n = email.length();

        // Rule 1: must contain exactly one '@'
        int atCount = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') atCount++;
        }
        if (atCount != 1) return false;

        int atPos = email.indexOf('@');

        // Rule 2: '@' cannot be first or last
        if (atPos == 0 || atPos == n - 1) return false;

        // Rule 3: must contain '.' after '@'
        int dotPos = email.indexOf('.', atPos);
        if (dotPos == -1) return false;

        // '.' cannot be at the end
        if (dotPos == n - 1) return false;

        // Rule 4: domain must have at least 2 chars after last '.'
        int lastDot = email.lastIndexOf('.');
        if (n - lastDot <= 2) return false;

        // Rule 5: check consecutive invalid characters
        for (int i = 1; i < n; i++) {
            char prev = email.charAt(i - 1);
            char curr = email.charAt(i);
            if ((curr == '.' && prev == '.') ||
                (curr == '@' && prev == '@') ||
                (curr == '.' && prev == '@') ||
                (curr == '@' && prev == '.')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // List<String> tests = Arrays.asList(
        //     "test@example.com",
        //     "abc@xyz.in",
        //     "abc.xyz@domain.co",
        //     "abc@domain",          // invalid
        //     "@gmail.com",          // invalid
        //     "user..name@mail.com", // invalid
        //     "abc@.com"             // invalid
        // );
        Scanner sc=new Scanner(System.in);   
        String email = sc.nextLine();
        System.out.println(email + " --> " + (isValidEmail(email) ? "Valid" : "Invalid"));
        sc.close();
    }    
}
