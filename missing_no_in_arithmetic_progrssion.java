//import java.util.*;

import java.util.Scanner;

public class missing_no_in_arithmetic_progrssion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int  i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int d=(arr[arr.length-1]-arr[0])/arr.length;
        int d1=(arr[arr.length-1]-arr[0])/(arr.length-1);
        int c=0;
        for(int i=0;i<arr.length-1;i++){
            if((arr[i+1]-arr[i])==d1){
                c++;
            }
        }
        if(c==arr.length-1) {
            System.out.println(arr[arr.length-1]+d1);
            sc.close();
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            if((arr[i+1]-arr[i])!=d){
               System.out.println(arr[i]+d);
               sc.close();
               return;
            }
        }
        sc.close();
    }
}
