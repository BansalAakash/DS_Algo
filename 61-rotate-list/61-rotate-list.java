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
    int length(ListNode head){
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = length(head);
        if(head == null || n == 1) return head;
        k = k % n;
        if(k == n || k == 0) return head;
        ListNode temp = head;
        int num = n - k;
        while(--num > 0)
            temp = temp.next;
        ListNode newHead = temp.next, newTemp = newHead;
        temp.next = null;
        while(newTemp.next != null) newTemp = newTemp.next;
        newTemp.next = head;
        return newHead;
    }
}