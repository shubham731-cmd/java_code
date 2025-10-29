class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class DetectCycle {

    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

    
        head.next.next.next.next.next = head.next.next;

        Node start = detectCycle(head);

        if (start != null)
            System.out.println("Cycle starts at node: " + start.val);
        else
            System.out.println("No cycle detected.");
    }

    static Node detectCycle(Node head) {
        Node slow = head, fast = head;

       
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; 
            }
        }
        return null; 
    }
}
