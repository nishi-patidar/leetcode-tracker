// Last updated: 8/3/2026, 12:44:27 PM
#include <cmath>

class Solution {
public:
    int mirrorDistance(int n) {
        int original = n;
        int rev = 0;
        
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        
        return std::abs(original - rev);
    }
};
