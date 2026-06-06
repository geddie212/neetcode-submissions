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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        ListNode out = null;
        ListNode head = null;

        boolean isEmpty = true;

        for (ListNode n : lists){
            if (n != null){
                isEmpty = false;
            }
        }

        while (!isEmpty){
            Integer min = null;
            int sIdx = 0;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null){
                    if (min == null || min > lists[i].val){
                        min = lists[i].val;
                        sIdx = i;
                    }
                }
            }
            if (min != null){
                ListNode n = new ListNode(lists[sIdx].val);
                if (out == null){
                    out = n;
                    head = out;
                }
                else {
                    out.next = n;
                    out = out.next;
                    lists[sIdx] = lists[sIdx].next;
                }
            }

            isEmpty = true;
            
            for (ListNode n : lists){
                if (n != null){
                    isEmpty = false;
                }
            }
        }
        return head.next;
    }
}
