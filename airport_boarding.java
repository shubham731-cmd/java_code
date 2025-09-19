import java.util.*;
public class airport_boarding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] v = new int[n];

        // Read input and copy
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            v[i] = a[i];
        }

        // Sort the copy
        Arrays.sort(v);

        // Count mismatches
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != v[i]) {
                c++;
            }
        }

        System.out.println(c / 2); // each swap causes 2 mismatches
        sc.close();
    }
}
