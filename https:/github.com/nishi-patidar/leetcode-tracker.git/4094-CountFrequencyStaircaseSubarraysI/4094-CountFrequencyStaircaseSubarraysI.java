// Last updated: 10/30/2026, 8:35:27 PM
class Solution {
    public int countStaircase(int[] nums) {
        int ans=0, n=nums.length, id=0;
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        int[] c = new int[n];

        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], id++);
            c[i] = map.get(nums[i]);
        }

        int[] f=new int[id], order =new int[id], epoch=new int[id];

        for(int i=0; i<n; i++){
            int distinct =0, correct=0;
            for(int j=i; j<n; j++){
                int v=c[j];

                if(epoch[v] !=i+1){
                    epoch[v] =i+1;
                    f[v]=0;
                    order[v] = ++distinct;
                }
                if(f[v] == order[v]) correct--;
                if(++f[v] ==order[v]) correct++;
                if (correct == distinct) ans++;
            }
                
        }
        return ans;
    }
}