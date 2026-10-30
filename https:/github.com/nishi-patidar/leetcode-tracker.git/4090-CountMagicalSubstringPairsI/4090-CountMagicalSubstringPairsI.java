// Last updated: 10/30/2026, 8:35:55 PM
class Solution {
    public int countMagicalPairs(String s) {
        int n=s.length();
        int[][] left= new int[n][27];
        int [][] right = new int[n][27];

        for(int i=0; i<n; i++){
            int mask=0;
            int dist=0;
            for(int j=i; j>=0; j--){
                int bit =1<<(s.charAt(j)-'a');
                if((mask & bit)==0){
                    mask |= bit;
                    dist++;
                }
                left[i][dist]++;
            }
            mask=0;
            dist=0;
            for(int j=i; j<n; j++){
                int bit =1 << (s.charAt(j)-'a');
                if((mask & bit)==0){
                    mask|=bit;
                    dist++;
                }
                right[i][dist]++;
            }
        }
        int ans=0;
        for(int j=0; j<n-1; j++){
            for(int c=1; c<=26; c++){
                ans+=left[j][c] * right[j+1][c];
            }
        }
        return ans;
    }
    
}