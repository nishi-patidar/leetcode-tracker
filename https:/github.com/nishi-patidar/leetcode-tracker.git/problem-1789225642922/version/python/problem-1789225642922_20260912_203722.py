# Last updated: 9/12/2026, 8:37:22 PM
1from bisect import bisect_left, bisect_right
2
3class Solution(object):
4    def distantSubarrays(self, nums, goal, k):
5        P=[0]
6        for x in nums:
7            P.append(P[-1] +x)
8        vals = sorted(set(P))
9        m = len(vals)
10        bit =[0]*(m+1)
11        ans=0
12
13        def update(i):
14            while i<=m:
15                bit[i]+=1
16                i+=i & -i
17
18        def query(i):
19            s=0
20            while i>0:
21                s+=bit[i]
22                i-= i& -i
23            return s
24
25        for j,p in enumerate(P):
26            if j:
27                ans+=j if k==0 else (query(bisect_right(vals, p - goal - k)))+ query(m) - query(bisect_left(vals, p - goal +k))
28            update(bisect_right(vals, p))
29        return ans