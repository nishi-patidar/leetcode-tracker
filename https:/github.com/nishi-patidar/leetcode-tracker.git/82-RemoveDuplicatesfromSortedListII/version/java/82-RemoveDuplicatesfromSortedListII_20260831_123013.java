// Last updated: 8/31/2026, 12:30:13 PM
1class Solution {
2    public ListNode deleteDuplicates(ListNode head) {
3        ListNode dummy = new ListNode(0);
4        dummy.next = head;
5        ListNode prev = dummy;
6        ListNode curr = head;
7        
8        while (curr != null) {
9            if (curr.next != null && curr.val == curr.next.val) {
10                while (curr.next != null && curr.val == curr.next.val) {
11                    curr = curr.next;
12                }
13                prev.next = curr.next;
14            } else {
15                prev = curr;
16            }
17            curr = curr.next;
18        }
19        
20        return dummy.next;
21    }
22}