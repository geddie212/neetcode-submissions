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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
            if (fast.next == null){
                break;
            }
            fast = fast.next;
        }
        //System.out.println(slow.val);
        //System.out.println(fast.val);
        ListNode prev = null;
        ListNode curr = head;
        ListNode after = head.next;
        while (true){
            curr.next = prev;
            prev = curr;
            curr = after;
            after = after.next;
            if (curr == slow){
                break;
            }
        }
        //System.out.println(prev.next.val);
        int max = Integer.MIN_VALUE;
        while (prev != null && slow != null){
            max = Math.max(max, prev.val + slow.val);
            //System.out.println(max);
            prev = prev.next;
            slow = slow.next;
        }
        return max;
    }
}