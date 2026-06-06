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
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] n, int l, int r){
        if (l < r){
            int m = (l+r)/2;
            ListNode ls = mergeSort(n, l, m);
            ListNode rs = mergeSort(n, m+1, r);
            return merge(ls, rs);
        }
        return n[l];
    }

    public ListNode merge(ListNode ls, ListNode rs){
        if (ls == null || rs == null){
            if (ls != null){
                return ls;
            }
            return rs;
        }

        ListNode curr = new ListNode();
        ListNode head = new ListNode();

        if (ls.val <= rs.val){
            curr = ls;
            ls = ls.next;
        }
        else{
            curr = rs;
            rs = rs.next;
        }
        head = curr;

        while (ls != null && rs != null){
            if (ls.val <= rs.val){
                curr.next = ls;
                ls = ls.next;
            }
            else {
                curr.next = rs;
                rs = rs.next;
            }
            curr = curr.next;
        }

        if (ls != null){
            curr.next = ls;
        }
        if (rs != null){
            curr.next = rs;
        }

        return head;
    }
}


    //  if (lists.length == 0){
    //         return null;
    //     }

    //     ListNode out = null;
    //     ListNode head = null;

    //     boolean isEmpty = true;

    //     for (ListNode n : lists){
    //         if (n != null){
    //             isEmpty = false;
    //         }
    //     }

    //     while (!isEmpty){
    //         Integer min = null;
    //         int sIdx = 0;
    //         for (int i = 0; i < lists.length; i++){
    //             if (lists[i] != null){
    //                 if (min == null || min > lists[i].val){
    //                     min = lists[i].val;
    //                     sIdx = i;
    //                 }
    //             }
    //         }
    //         if (min != null){
    //             ListNode n = new ListNode(lists[sIdx].val);
    //             if (out == null){
    //                 out = n;
    //                 head = out;
    //             }
    //             else {
    //                 out.next = n;
    //                 out = out.next;
    //                 lists[sIdx] = lists[sIdx].next;
    //             }
    //         }

    //         isEmpty = true;
            
    //         for (ListNode n : lists){
    //             if (n != null){
    //                 isEmpty = false;
    //             }
    //         }
    //     }
    //     return head.next;
