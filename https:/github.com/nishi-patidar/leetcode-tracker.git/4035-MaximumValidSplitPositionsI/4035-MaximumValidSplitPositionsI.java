// Last updated: 10/1/2026, 2:54:01 PM
class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length, ans=count(nums);
        if(n>2){
            for(int i=0; i<n; i++){
                int[] arr = new int[n-1];
                for(int j=0,k=0; j < n; j++){
                    if(j!=i) arr[k++] = nums[j];
                }
                ans = Math.max(ans, count(arr));
            }
        }
        return ans;
    }
    private int count(int[] a){
        int m = a.length, c=0;
        int[] suf = new int[m];
        suf[m-1]= a[m-1];
        for(int i = m-2; i>=0; i--) suf[i] = gcd(suf[i+1], a[i]);
        for(int i = 0, p = 0; i<m-1; i++){
            p = gcd(p,a[i]);
            if(p==suf[i+1]) c++;
        }
        return c;
    }
    private int gcd(int a, int b ){
        return b == 0 ? a:gcd(b, a%b);
    }
}