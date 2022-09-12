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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean flagA = false, flagB = false;
        ListNode nodeA = headA, nodeB = headB;
        while(true){
            if(nodeA == nodeB)
                return nodeA;
            if(nodeA.next == null){
                if(flagA == true) return null;
                flagA = true;
                nodeA = headB;
            } else nodeA = nodeA.next;
            if(nodeB.next == null){
                if(flagB == true) return null;
                flagB = true;
                nodeB = headA;
            } else nodeB = nodeB.next;
        }
    }
}