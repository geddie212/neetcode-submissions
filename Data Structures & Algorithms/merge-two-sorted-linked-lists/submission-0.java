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
        if (list1 == null){
            return list2;
        }
        else if (list2 == null){
            return list1;
        }
        
        ListNode newHead;

        if (list1.val < list2.val){
            newHead = list1;
            list1 = list1.next;
        }
        else{
            newHead = list2;
            list2 = list2.next;
        }

        ListNode workHead = newHead;


        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                workHead.next = list1;
                list1 = list1.next;
            }
            else {
                workHead.next = list2;
                list2 = list2.next;
            }
            workHead = workHead.next;
        }

        if (list1 != null){
            workHead.next = list1;
        }
        if (list2 != null){
            workHead.next = list2;
        }

        return newHead;
    }
}