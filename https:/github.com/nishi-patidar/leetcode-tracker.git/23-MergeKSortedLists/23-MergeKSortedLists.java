// Last updated: 8/3/2026, 12:51:09 PM
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            tail.next = current;
            tail = current;
            
            if (current.next != null) {
                minHeap.add(current.next);
            }
        }
        
        return dummy.next;
    }
}
