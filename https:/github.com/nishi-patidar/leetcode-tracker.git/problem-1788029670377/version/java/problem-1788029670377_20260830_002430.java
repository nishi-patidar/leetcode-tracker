// Last updated: 8/30/2026, 12:24:30 AM
1class Solution {
2    public int maxValidSplits(int[] nums) {
3       int n=nums.length;
4        if(n<=2){
5            return(n==2 && nums[0] == nums[1]) ? 1:0;
6        }
7        int[] pref =  new int[n], suff=new int[n];
8        pref[0] = nums[0];
9        for(int i=1; i<n; i++) pref[i]= gcd(pref[i-1], nums[i]);
10        suff[n-1] = nums[n-1];
11        for(int i =n-2; i>=0; i--) suff[i]=gcd(suff[i+1], nums[i]);
12
13        int ans=0;
14        for(int i=0; i<n-1; i++){
15            if(pref[i] == suff[i+1]) ans++;
16        }
17    
18
19        Set<Integer> cands = new HashSet<>();
20        cands.add(0);
21        cands.add(n-1);
22        
23        for(int i=1; i<n; i++){
24            if(pref[i] !=pref[i-1]){
25                cands.add(i);
26                cands.add(i-1);
27            }
28        }
29        for(int i=1; i<n; i++){
30            if(pref[i] !=pref[i-1]){
31                cands.add(i);
32                cands.add(n-1);
33            }
34        }
35        for(int rem : cands){
36            if(rem<0 || rem>=n) continue;
37            ans = Math.max(ans, count(nums, rem));
38        }
39        return ans;
40        
41        }
42        private int count(int[] nums, int rem){
43            int n =nums.length;
44            int m=n-1;
45            int[] arr=new int[m];
46            for(int i=0,k=0; i<n; i++){
47                if(i!=rem) arr[k++] = nums[i];
48            }
49            int[] suf= new int[m];
50            suf[m-1]= arr[m-1];
51            for(int i=m-2; i>=0; i--){
52                suf[i]=gcd(suf[i+1], arr[i]);
53            }
54            int cnt =0,p=0;
55            for(int i=0; i<m-1; i++){
56                p=gcd(p, arr[i]);
57                if(p==suf[i+1]){
58                    cnt++;
59                }
60        }
61        return cnt;
62    }
63    private int gcd(int a, int b){
64        return b==0 ? a:gcd(b, a%b);
65    }
66}