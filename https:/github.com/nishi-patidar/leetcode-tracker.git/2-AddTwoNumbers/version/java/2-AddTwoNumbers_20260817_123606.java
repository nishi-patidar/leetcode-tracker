// Last updated: 8/17/2026, 12:36:06 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        ListNode dummyHead = new ListNode(0);
14        ListNode curr = dummyHead;
15        int carry = 0;
16        
17        while (l1 != null || l2 != null || carry != 0) {
18            int x = (l1 != null) ? l1.val : 0;
19            int y = (l2 != null) ? l2.val : 0;
20            
21            int sum = carry + x + y;
22            carry = sum / 10;
23            
24            curr.next = new ListNode(sum % 10);
25            curr = curr.next;
26            
27            if (l1 != null) l1 = l1.next;
28            if (l2 != null) l2 = l2.next;
29        }
30        
31        return dummyHead.next;
32    }
33}