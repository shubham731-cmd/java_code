class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class DetectCycle {

    public static void main(String[] args) {
        // Create linked list: 1 → 2 → 3 → 4 → 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a cycle (5 → 3)
        head.next.next.next.next.next = head.next.next;

        Node start = detectCycle(head);

        if (start != null)
            System.out.println("Cycle starts at node: " + start.val);
        else
            System.out.println("No cycle detected.");
    }

    static Node detectCycle(Node head) {
        Node slow = head, fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle found
                // Step 2: Find start node of cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // start of cycle
            }
        }
        return null; // no cycle
    }
}
