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
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = length(head);
        if(size < k) return head;
        ListNode cur = head, prev = null, mainHead = null, prevTail = null, newHead = null;
        while(size >= k){
            int count = k, tempC = k;
            ListNode temp1 = cur;
            newHead = cur;
            while(tempC-- > 0)
                temp1 = temp1.next;
            prev = temp1;
            while(count-- > 0){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            if(mainHead == null) mainHead = prev;
            if(prevTail != null) prevTail.next = prev;
            prevTail = newHead;
            size -= k;
        }
        return mainHead;
    }
}