// Last updated: 10/1/2026, 2:54:22 PM
class Solution {
public:
    long long shadowPairs(vector<int>& a) {
        long long ans =0;
        vector<int> st;

        for (int x:a){

            while (!st.empty() && st.back() >x){
                st.pop_back();
            }

            ans+=lower_bound(st.begin(), st.end(), x) -st.begin();

            st.push_back(x);
        }
    
        return ans;
    }
};