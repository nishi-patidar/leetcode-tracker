// Last updated: 10/30/2026, 8:35:53 PM
class Solution {
    public long countMagicalPairs(String s) {
        int n=s.length();
        int[][] L = new int[n][27], R = new int[n][27];
        int[] posL=new int[26], posR=new int[26];
        Arrays.fill(posL, -1);
        Arrays.fill(posR, n);

        for(int i=0; i<n; i++){
            posL[s.charAt(i)-'a']=i;
            int[] p=posL.clone();
            Arrays.sort(p);
            for(int k=25; k>=0 && p[k]!=-1; k--){
              L[i][26-k]=p[k]-(k==0 ? -1 : p[k-1]);}
        }

        for(int i=n-1; i>=0; i--){
            posR[s.charAt(i) -'a']=i;
            int[] p= posR.clone();
            Arrays.sort(p);
            for(int k=0; k<26 && p[k]!= n; k++){
                R[i][k+1]= (k==25 ? n: p[k+1]) - p[k];
                    }
        }
        long ans=0;
        for(int j=0; j<n-1;j++){
            for(int c=1; c<=26; c++){
                ans+= (long) L[j][c] * R[j+1][c];
            }
        }
        return ans;
    }
}