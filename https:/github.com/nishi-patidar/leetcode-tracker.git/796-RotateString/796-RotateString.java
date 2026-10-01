// Last updated: 10/1/2026, 3:03:23 PM
class Solution {
    public boolean rotateString(String s, String goal) {
        // If the lengths are different, they cannot be rotations of each other
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself and check if goal is a substring
        String doubledString = s + s;
        return doubledString.contains(goal);
    }
}
