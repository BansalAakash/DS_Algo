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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;
        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        temp = head;
        while(!stack.isEmpty()){
            ListNode cur = stack.pop();
            cur.next = temp.next;
            temp.next = cur;
            temp = temp.next.next;
        }
    }
}