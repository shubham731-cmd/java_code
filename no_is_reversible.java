import java.util.Scanner;

public class no_is_reversible {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int o=n;
		int rev=0;
		while(o!=0){
		    int rem=o%10;
		    rev=rev*10+rem;
		    o=o/10;
		}
		int new1=rev+n;
		String str=Integer.toString(new1);
		for(int i=0;i<str.length();i++){
		    if((str.charAt(i)-'0')%2==0){
		        System.out.println("False");
                sc.close();
		        return;
		    }
		}
		System.out.println("True");
		sc.close();
    }
}
