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
    private int len(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        k = k % len(head);
        if(k == 0)
            return head;
        ListNode slow = head, fast = head;
        while(k-- > 0)
            fast = fast.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}