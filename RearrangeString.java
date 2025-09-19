import java.util.*;

public class RearrangeString {
    public static String rearrangeString(String s) {
        // Count frequency of characters
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Max Heap: higher frequency first
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            result.append(curr.getKey());

            // Decrease frequency
            curr.setValue(curr.getValue() - 1);

            // Push the previous entry back if it still has remaining count
            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }

            // Update prev to current
            prev = curr;
        }

        // If result length != input → not possible
        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);   
        String s = sc.nextLine();
        String ans = rearrangeString(s);
        if (ans.isEmpty())
            System.out.println("Not possible");
        else
            System.out.println(ans);
        sc.close();
    }
}
