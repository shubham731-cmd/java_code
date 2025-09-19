import java.util.*;

public class repeating_pattern_in_string {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		String s=sc.next();
		List<Character>v = new ArrayList<>();
		Map<Character,Integer> m= new HashMap<>();
		
		for(int i=0;i<s.length();i++){
		    //m[s[i]]=m[s[i]]+1;
		    m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
		    
		}
		for(var p:m.entrySet()){
		    if(p.getValue()>1){
		        v.add(p.getKey());
		    }
		}
		for(var e:v){
		    System.out.print(e+" ");
		}
		sc.close();
    }

}
