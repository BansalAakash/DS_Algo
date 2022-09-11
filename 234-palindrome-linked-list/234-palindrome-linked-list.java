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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null, cur = head, fast = head, next = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        boolean isPal = true;
        next = cur;
        if(fast != null) //odd
            cur = cur.next;
        while(prev != null){
            if(cur.val != prev.val)
                isPal = false;
            ListNode temp = prev.next;
            prev.next = next;
            next = prev;
            prev = temp;
            cur = cur.next;
        }
        return isPal;
    }
}