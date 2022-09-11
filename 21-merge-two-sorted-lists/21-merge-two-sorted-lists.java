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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null, cur = null, temp = null;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if(val1 < val2){
                temp = l1;
                l1 = l1 == null ? l1 : l1.next;
            } else{
                temp = l2;
                l2 = l2 == null ? l2 : l2.next;
            }
            if(cur == null){
                cur = temp;
                newHead = cur;
            } else{
                cur.next = temp;
                cur = cur.next;
            }
        }
        return newHead;
    }
}