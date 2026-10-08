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
        solution1(head);
    }

    //O(n) time, O(n) space.
    private void solution1(ListNode head) {
        if (head.next == null) return;
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;;
        }

        current = head;
        int n = nodes.size();
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                current.next = nodes.get(n - (i+1) / 2);
            } else {
                current.next = nodes.get(i / 2);
            }
            current = current.next;
        }
        current.next = null;
    }
}
