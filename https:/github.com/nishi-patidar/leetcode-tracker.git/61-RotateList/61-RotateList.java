// Last updated: 8/3/2026, 12:49:04 PM
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        tail.next = head;
        
        k = k % length;
        int stepsToNewTail = length - k;
        
        ListNode newTail = tail;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
