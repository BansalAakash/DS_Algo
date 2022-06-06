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
        if(l1 == null && l2 == null) return null;
        int val1 = 0, val2 = 0, sum = 0, carry = 0;
        ListNode l3 = null, temp = null;
        while(l1 != null || l2 != null){
            val1 = l1 == null ? 0 : l1.val;
            val2 = l2 == null ? 0 : l2.val;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            if(l3 == null){
                l3 = new ListNode(sum % 10);
                temp = l3;
            } else{
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if(carry > 0)
            temp.next = new ListNode(carry);
        return l3;
    }
}