// Last updated: 8/29/2026, 11:48:40 PM
1class Solution {
2    public int maxValidSplits(int[] nums) {
3        int n = nums.length, ans=count(nums);
4        if(n>2){
5            for(int i=0; i<n; i++){
6                int[] arr = new int[n-1];
7                for(int j=0,k=0; j < n; j++){
8                    if(j!=i) arr[k++] = nums[j];
9                }
10                ans = Math.max(ans, count(arr));
11            }
12        }
13        return ans;
14    }
15    private int count(int[] a){
16        int m = a.length, c=0;
17        int[] suf = new int[m];
18        suf[m-1]= a[m-1];
19        for(int i = m-2; i>=0; i--) suf[i] = gcd(suf[i+1], a[i]);
20        for(int i = 0, p = 0; i<m-1; i++){
21            p = gcd(p,a[i]);
22            if(p==suf[i+1]) c++;
23        }
24        return c;
25    }
26    private int gcd(int a, int b ){
27        return b == 0 ? a:gcd(b, a%b);
28    }
29}