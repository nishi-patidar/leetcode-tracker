# Last updated: 10/1/2026, 2:54:32 PM
from bisect import bisect_left, bisect_right

class Solution(object):
    def distantSubarrays(self, nums, goal, k):
        P=[0]
        for x in nums:
            P.append(P[-1] +x)
        vals = sorted(set(P))
        m = len(vals)
        bit =[0]*(m+1)
        ans=0

        def update(i):
            while i<=m:
                bit[i]+=1
                i+=i & -i

        def query(i):
            s=0
            while i>0:
                s+=bit[i]
                i-= i& -i
            return s

        for j,p in enumerate(P):
            if j:
                ans+=j if k==0 else (query(bisect_right(vals, p - goal - k)))+ query(m) - query(bisect_left(vals, p - goal +k))
            update(bisect_right(vals, p))
        return ans