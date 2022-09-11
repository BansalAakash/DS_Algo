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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        while(fast != null && fast.next != null){
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)                    //odd nodes
            slow = slow.next;
        while(!stack.isEmpty()){
            if(stack.pop().val != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }
}