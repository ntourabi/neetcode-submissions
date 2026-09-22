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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode previous = head;
        ListNode current = head.next;
        ListNode next = current.next;
        return reverseDatList(previous, current, next);
    }

    public ListNode reverseDatList(ListNode previous, ListNode current, ListNode next) {
        previous.next = null;
        while (current != null) {
            current.next = previous;
            previous = current;
            current = next;
            if (next != null) next = next.next;
        }
        return previous;
    }
}
