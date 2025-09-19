import java.util.*;
public class bus_seat {
    
	public static void main(String[] args) {
		// int[] skills = {10, 20, 30, 40};
		Scanner sc= new Scanner(System.in);

		//int n = skills.length;
		int n= sc.nextInt();
		int []arr=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		Map<Integer,Integer>m=new HashMap<>();
		for(int i=0; i<n; i++) {
			if(arr[i]<1 || arr[i]>40) {
				System.out.println("Seat "+arr[i]+" Invalid Seat");
			} else {
				m.put(arr[i],m.getOrDefault(arr[i],0)+1);
				if(m.get(arr[i])!=1) {
					System.out.println("Seat " + arr[i] + " Already Booked");
				} else {
                    System.out.println("Seat " + arr[i] + " Booked");
				}
			}
		}
		sc.close();
	}
}

