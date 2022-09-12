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
    private ListNode helper(int rem, int k, ListNode head){
        if(rem < k)
            return head;
        ListNode cur = head, prev = null, next = null;
        int temp = 0;
        while(temp++ < k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = helper(rem - k, k, cur);
        return prev;
    }
    private int length(ListNode head){
        int l = 0;
        while(head != null){
            l++;
            head = head.next;
        }
        return l;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head.next == null)
            return head;
        head = helper(length(head), k, head);
        return head;
    }
}