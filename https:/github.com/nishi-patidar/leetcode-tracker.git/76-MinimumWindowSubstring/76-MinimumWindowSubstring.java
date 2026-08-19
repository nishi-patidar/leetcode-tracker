// Last updated: 8/19/2026, 9:00:18 PM
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (map[c1] > 0) {
                count--;
            }
            map[c1]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char c2 = s.charAt(left);
                map[c2]++;
                if (map[c2] > 0) {
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}