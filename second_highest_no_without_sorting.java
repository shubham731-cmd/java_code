import java.util.*;  // for Collections, List, Map, etc.
//import java.io.*;    // for Input/Output classes

public class second_highest_no_without_sorting
{
	public static void main(String[] args) {
		//int[] ar={10,20,4,45,99,99,98};
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] ar=new int[n];
		for(int i=0;i<n;i++){
		    ar[i]=sc.nextInt();
		}
		
		int maxi=Integer.MIN_VALUE;
		int secondMaxi=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
		    if(ar[i]>maxi){
		        secondMaxi=maxi;
		        maxi=ar[i];
		    }else if(ar[i]<maxi && ar[i]>secondMaxi){
		        secondMaxi=ar[i];
		    }
		}
		System.out.println(secondMaxi);
		sc.close();
	}
}