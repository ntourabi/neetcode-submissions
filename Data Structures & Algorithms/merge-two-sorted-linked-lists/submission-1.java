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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        
        ListNode head = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                //Pop list2 onto new list.
                if (current != null) {
                    current.next = list2;
                    current = current.next;
                } else {
                    current = list2;
                    head = current;
                }
                list2 = list2.next;
            } else {
                //Pop list1 onto new list.
                if (current != null) {
                    current.next = list1;
                    current = current.next;
                } else {
                    current = list1;
                    head = current;
                }
                list1 = list1.next;
            }
        }

        while (list1 != null) {
            current.next = list1;
            current = current.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }

        return head;
    }

}