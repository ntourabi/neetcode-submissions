/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return solution1(head, n);
    }

    public ListNode solution2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        
        ListNode slow = dummy;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public ListNode solution1(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        int i = nodes.size() - n;
        if (i == 0) {
            if (nodes.size() == 1) return null;
            else return nodes.get(1);
        } else if (i == nodes.size() - 1) {
            nodes.get(nodes.size() - 2).next = null;
        } else {
            nodes.get(i - 1).next = nodes.get(i + 1);
        }

        return head;
    }
}
