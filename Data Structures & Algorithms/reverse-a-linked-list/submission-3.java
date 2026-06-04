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

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null){
//             return head;
//         }
//         ListNode prev = null;
//         ListNode curr = head;
//         ListNode nex = head.next;

//         while (curr != null){
//             curr.next = prev;
//             prev = curr;
//             curr = nex;
//             if (nex != null){
//                  nex = nex.next;
//             }  
//         }
//         return prev;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        else {
            ListNode last = head;
            while (last.next != null){
                last = last.next;
            }
            this.rec(head, true);
            return last;
        }
    }

    public ListNode rec(ListNode curr, boolean head){
        if (curr == null){
            return null;
        }
        else{
            ListNode after = this.rec(curr.next, false);
            if (after != null){
                after.next = curr;
            }
            if (head == true){
                curr.next = null;
            }
            return curr;
        }
    }
}
