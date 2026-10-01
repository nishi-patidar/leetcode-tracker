// Last updated: 10/1/2026, 2:57:25 PM
class Solution {
    public int reverseDegree(String s) {
        int result = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            result += ('z' - arr[i] + 1) * (i + 1);
        }
        return result;
    }
}