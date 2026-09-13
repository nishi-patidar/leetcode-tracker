// Last updated: 9/13/2026, 8:46:57 AM
1class Solution {
2public:
3    long long shadowPairs(vector<int>& a) {
4        long long ans =0;
5        vector<int> st;
6
7        for (int x:a){
8
9            while (!st.empty() && st.back() >x){
10                st.pop_back();
11            }
12
13            ans+=lower_bound(st.begin(), st.end(), x) -st.begin();
14
15            st.push_back(x);
16        }
17    
18        return ans;
19    }
20};