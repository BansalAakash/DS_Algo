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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode cur = head, next = null, prev = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private void display(ListNode head){
        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        ListNode temp1 = head, temp2 = slow.next;
        while(temp2 != null && temp1.val == temp2.val){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        slow.next = reverse(slow.next);
        // display(head);
        return temp2 == null;
    }
}