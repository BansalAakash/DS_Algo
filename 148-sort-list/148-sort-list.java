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
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode l3 = null, temp = null, cur = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp = l1;
                l1 = l1.next;
            }
            else {
                temp = l2;
                l2 = l2.next;
            }
            if(l3 == null){
                l3 = temp;
                cur = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        if(l2 != null)
            l1 = l2;
        while(l1 != null){
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        return l3;
    }
    public ListNode sortList(ListNode l1) {
        if(l1 == null || l1.next == null)
            return l1;
        ListNode slow = l1, fast = l1, prev = slow;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1_ = sortList(l1);
        ListNode l2_ = sortList(slow);
        l1 = merge(l1_, l2_);
        return l1;
    }
}