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
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            ListNode temp = current.next;
            current.next = null;
            current = temp;
        }

        current = head;
        int n = nodes.size() - 1;
        int i = 0;
        boolean f = true;
        while (i <= n) {
            if (f) {
                current.next = nodes.get(i);
                i++;
                f = !f;
            } else {
                current.next = nodes.get(n);
                n--;
                f = !f;
            }
            current = current.next;
        }
    }
}
