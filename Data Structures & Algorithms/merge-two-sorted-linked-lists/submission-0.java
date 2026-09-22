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
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        // Step 1: Decide the head node of list3
        ListNode list3_head = null;
        if (list1.val < list2.val) {
            list3_head = list1;
            list1 = list1.next;
        } else {
            list3_head = list2;
            list2 = list2.next;
        }
        ListNode list3 = list3_head;
        // Step 2: Each list has a ptr. Compare vals + increment ptr of greater node
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }
        // Step 3: One ptr ultimately becomes null. Append the rest.
        while (list1 != null) {
            list3.next = list1;
            list1 = list1.next;
            list3 = list3.next;
        }

        while (list2 != null) {
            list3.next = list2;
            list2 = list2.next;
            list3 = list3.next;
        }

        return list3_head;
    }
}