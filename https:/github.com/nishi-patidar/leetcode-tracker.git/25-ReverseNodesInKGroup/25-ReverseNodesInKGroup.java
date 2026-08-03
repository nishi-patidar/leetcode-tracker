// Last updated: 8/3/2026, 12:51:04 PM
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        ListNode prevGroupTail = dummy;
        curr = head;

        while (count >= k) {
            ListNode groupHead = curr;
            ListNode prev = null;
            
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            prevGroupTail.next = prev;
            groupHead.next = curr;
            prevGroupTail = groupHead;
            
            count -= k;
        }

        return dummy.next;
    }
}
