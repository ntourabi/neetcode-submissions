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

//t=1, h=1
//t=2, h=3
//t=3, h=1
//t=4, h=3
//t=2, h=1
//t=3, h=3
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode tortoise = head.next;
        ListNode hare = head.next.next;

        while (tortoise != hare) {
            if (hare.next == null || hare.next.next == null) return false;
            else hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
}
