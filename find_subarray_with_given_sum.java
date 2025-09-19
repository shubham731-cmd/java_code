import java.util.*;
public class find_subarray_with_given_sum
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int target=sc.nextInt();
		
		int [] a = new int[n];
		for(int i=0;i<n;i++){
		    a[i]=sc.nextInt();
		}
		int sum;
		List<List<Integer>>v=new ArrayList<>();
		for(int i=0;i<n;i++){
		    List<Integer>vec=new ArrayList<>();
		    sum=0;
		    for(int j=i;j<n;j++){
		        sum+=a[j];
		        vec.add(a[j]);
		        if(sum==target){
		            v.add(vec);
		            break;
		        }
		    }
		}
	    for(var e:v){
	        for(var e1:e){
	            System.out.print(e1+" ");
	        }
	        System.out.println();
	    }
		sc.close();
	}
}
