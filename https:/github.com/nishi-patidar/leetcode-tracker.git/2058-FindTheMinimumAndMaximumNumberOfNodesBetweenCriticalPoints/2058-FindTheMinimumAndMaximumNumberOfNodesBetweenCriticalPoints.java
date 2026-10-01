// Last updated: 10/1/2026, 3:00:37 PM
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;
        int firstCriticalIdx = -1;
        int lastCriticalIdx = -1;
        
        int idx = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        
        while (curr.next != null) {
            ListNode next = curr.next;
            
            if ((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)) {
                
                if (firstCriticalIdx == -1) {
                    firstCriticalIdx = idx;
                } else {
                    int dist = idx - lastCriticalIdx;
                    if (dist < minDistance) {
                        minDistance = dist;
                    }
                }
                lastCriticalIdx = idx;
            }
            
            prev = curr;
            curr = next;
            idx++;
        }
        
        if (firstCriticalIdx != -1 && firstCriticalIdx != lastCriticalIdx) {
            return new int[]{minDistance, lastCriticalIdx - firstCriticalIdx};
        }
        
        return new int[]{-1, -1};
    }
}