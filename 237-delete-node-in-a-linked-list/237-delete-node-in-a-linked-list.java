/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next != null){
            node.val = node.next.val;
            if(prev == null)
                prev = node;
            else prev = prev.next;
            node = node.next;
        }
        prev.next = null;
    }
}