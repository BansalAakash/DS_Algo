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
    ListNode middle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode mid = middle(head);
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = mid.next;
        mid.next = null;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while(!stack.isEmpty()){
            ListNode next = temp.next;
            temp.next = stack.pop();
            temp.next.next = next;
            temp = temp.next.next;
        }
    }
}