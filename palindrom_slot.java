import java.util.*;
public class palindrom_slot {
    
    public static void main(String[] args) {
        // int[] skills = {10, 20, 30, 40};
        Scanner sc= new Scanner(System.in);
        
        //int n = skills.length;
        String s= sc.next();
        int n=s.length();
        int left=0,right=n-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                System.out.print("Invalid");
                sc.close();
                return;
            }
            left++;right--;
        }
        if((Integer.parseInt(s))%3==0){
            System.out.println("Jackpot");
        }else{
            System.out.println("Invalid");
        }
        sc.close();
    }
}
