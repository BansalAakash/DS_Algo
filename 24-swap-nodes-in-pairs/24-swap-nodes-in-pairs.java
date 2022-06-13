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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        while(temp.next != null && temp.next.next != null){
            ListNode curTemp = temp.next.next;
            temp.next.next = curTemp.next;
            curTemp.next = temp.next;
            temp.next = curTemp;
            temp = temp.next.next;
        }
        return dummy.next;
    }
}