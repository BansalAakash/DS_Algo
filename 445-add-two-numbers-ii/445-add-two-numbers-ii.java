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
    int length(ListNode l){
        int len = 0;
        while(l != null){
            len++;
            l = l.next;
        }
        return len;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1), len2 = length(l2);
        if(len2 > len1) return addTwoNumbers(l2, l1);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        int count = 0;
        while(count++ < len1 - len2){
            stack1.push(l1.val);
            l1 = l1.next;
            stack2.push(0);
        }
        
        while(l1 != null || l2 != null) {
            stack1.push(l1 == null ? 0 : l1.val);
            stack2.push(l2 == null ? 0 : l2.val);
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
        }
        int sum = 0, carry = 0;
        Stack<Integer> stack3 = new Stack<>();
        while(!stack1.isEmpty()){
            sum = stack1.pop() + stack2.pop() + carry;
            stack3.push(sum % 10);
            carry = sum / 10;
        }
        if(carry > 0) stack3.push(carry);
        
        ListNode dummyHead = new ListNode(-1), temp = dummyHead;
        while(!stack3.isEmpty()){
            temp.next = new ListNode(stack3.pop());
            temp = temp.next;
        }
        return dummyHead.next;
    }
}