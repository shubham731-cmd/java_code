import java.util.*;

public class reverse_only_digits {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		String s=sc.next();
		List<Character>v1 = new ArrayList<>();
		List<Character>v2 = new ArrayList<>();
		Map<Character,Character> m= new HashMap<>();
		
		for(int i=0;i<s.length();i++){
		    if(Character.isDigit(s.charAt(i))){
		        v1.add(s.charAt(i));
		    }
		    
		}
		for(int i=s.length()-1;i>=0;i--){
		    if(Character.isDigit(s.charAt(i))){
		        v2.add(s.charAt(i));
		    }
		}
		for(int i=0;i<v1.size();i++){
		    m.put(v1.get(i),v2.get(i));
		}
		StringBuilder str = new StringBuilder();
		for(int i=0;i<s.length();i++){
		    if(m.containsKey(s.charAt(i))){
		        str.append(m.get(s.charAt(i)));
		    }else{
		        str.append(s.charAt(i));
		    }
		}
		System.out.println(str);
	
		sc.close();
    }
}
