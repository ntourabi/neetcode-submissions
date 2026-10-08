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
        if (head == null) return false;
        ListNode tortoise = head;
        ListNode hare = head;
        tortoise = advance(tortoise);
        hare = advance(hare);
        hare = advance(hare);

        while (tortoise != null && hare != null) {
            tortoise = advance(tortoise);
            hare = advance(hare);
            hare = advance(hare);
            if (hare == tortoise) return true;
        }
        return false;
    }

    public ListNode advance(ListNode n) {
        if (n == null) return null;
        else return n.next;
    }
}
