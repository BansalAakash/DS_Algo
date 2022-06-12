/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int length(ListNode l){
        int len = 0;
        while(l != null){
            len++;
            l = l.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);
        if(l1 < l2) return getIntersectionNode(headB, headA);
        int dif = l1 - l2;
        while(dif-- != 0)
            headA = headA.next;
        while(headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        if(headA == headB) return headA;
        return null;
    }
}