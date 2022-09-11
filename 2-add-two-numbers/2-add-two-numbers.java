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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = null, cur = null;
        while(l1 != null && l2 != null){
            int newVal = l1.val + l2.val + carry;
            ListNode temp = new ListNode(newVal % 10);
            carry = newVal / 10;
            if(cur == null){
                l3 = temp;
                cur = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2 != null)      //Only one of them will be null
            l1 = l2;
        while(l1 != null){
            int newVal = l1.val + carry;
            ListNode temp = new ListNode(newVal % 10);
            carry = newVal / 10;
            cur.next = temp;
            cur = cur.next;
            l1 = l1.next;
        }
        if(carry == 1)
            cur.next = new ListNode(1);
        return l3;
    }
}