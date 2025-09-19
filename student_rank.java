import java.util.*;

public class student_rank {
    public static void main(String[] args){
        // int[] skills = {10, 20, 30, 40};
        Scanner sc= new Scanner(System.in);
        
        //int n = skills.length;
        int n= sc.nextInt();
        Integer [] a=new Integer[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a,Collections.reverseOrder());
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        sc.close();
    }
}
