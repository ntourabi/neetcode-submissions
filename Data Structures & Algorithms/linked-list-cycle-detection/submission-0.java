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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode tortoise = head;
        ListNode hare = head;
        tortoise = tortoise.next;
        hare = hare.next;
        if (hare != null) hare = hare.next;
        else return false;

        while (tortoise != null && hare != null) {
            if (tortoise.val == hare.val) return true;
            tortoise = tortoise.next;
            hare = hare.next;
            if (hare != null) hare = hare.next;
            else return false;
        }
        return false;
    }
}
