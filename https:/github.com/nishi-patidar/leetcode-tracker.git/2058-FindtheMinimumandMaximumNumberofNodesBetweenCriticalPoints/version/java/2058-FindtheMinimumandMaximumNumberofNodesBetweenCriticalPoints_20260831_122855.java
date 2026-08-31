// Last updated: 8/31/2026, 12:28:55 PM
1class Solution {
2    public int[] nodesBetweenCriticalPoints(ListNode head) {
3        if (head == null || head.next == null || head.next.next == null) {
4            return new int[]{-1, -1};
5        }
6
7        int minDistance = Integer.MAX_VALUE;
8        int firstCriticalIdx = -1;
9        int lastCriticalIdx = -1;
10        
11        int idx = 1;
12        ListNode prev = head;
13        ListNode curr = head.next;
14        
15        while (curr.next != null) {
16            ListNode next = curr.next;
17            
18            if ((curr.val > prev.val && curr.val > next.val) || 
19                (curr.val < prev.val && curr.val < next.val)) {
20                
21                if (firstCriticalIdx == -1) {
22                    firstCriticalIdx = idx;
23                } else {
24                    int dist = idx - lastCriticalIdx;
25                    if (dist < minDistance) {
26                        minDistance = dist;
27                    }
28                }
29                lastCriticalIdx = idx;
30            }
31            
32            prev = curr;
33            curr = next;
34            idx++;
35        }
36        
37        if (firstCriticalIdx != -1 && firstCriticalIdx != lastCriticalIdx) {
38            return new int[]{minDistance, lastCriticalIdx - firstCriticalIdx};
39        }
40        
41        return new int[]{-1, -1};
42    }
43}