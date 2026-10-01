// Last updated: 10/1/2026, 2:53:55 PM
class Solution {
    public int maxValidSplits(int[] nums) {
       int n=nums.length;
        if(n<=2){
            return(n==2 && nums[0] == nums[1]) ? 1:0;
        }
        int[] pref =  new int[n], suff=new int[n];
        pref[0] = nums[0];
        for(int i=1; i<n; i++) pref[i]= gcd(pref[i-1], nums[i]);
        suff[n-1] = nums[n-1];
        for(int i =n-2; i>=0; i--) suff[i]=gcd(suff[i+1], nums[i]);

        int ans=0;
        for(int i=0; i<n-1; i++){
            if(pref[i] == suff[i+1]) ans++;
        }
    

        Set<Integer> cands = new HashSet<>();
        cands.add(0);
        cands.add(n-1);
        
        for(int i=1; i<n; i++){
            if(pref[i] !=pref[i-1]){
                cands.add(i);
                cands.add(i-1);
            }
        }
        for(int i=1; i<n; i++){
            if(pref[i] !=pref[i-1]){
                cands.add(i);
                cands.add(n-1);
            }
        }
        for(int rem : cands){
            if(rem<0 || rem>=n) continue;
            ans = Math.max(ans, count(nums, rem));
        }
        return ans;
        
        }
        private int count(int[] nums, int rem){
            int n =nums.length;
            int m=n-1;
            int[] arr=new int[m];
            for(int i=0,k=0; i<n; i++){
                if(i!=rem) arr[k++] = nums[i];
            }
            int[] suf= new int[m];
            suf[m-1]= arr[m-1];
            for(int i=m-2; i>=0; i--){
                suf[i]=gcd(suf[i+1], arr[i]);
            }
            int cnt =0,p=0;
            for(int i=0; i<m-1; i++){
                p=gcd(p, arr[i]);
                if(p==suf[i+1]){
                    cnt++;
                }
        }
        return cnt;
    }
    private int gcd(int a, int b){
        return b==0 ? a:gcd(b, a%b);
    }
}