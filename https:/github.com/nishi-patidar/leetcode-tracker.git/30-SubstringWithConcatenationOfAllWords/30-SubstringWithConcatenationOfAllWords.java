// Last updated: 8/3/2026, 12:50:47 PM
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLen = words[0].length();
        int numWords = words.length;
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();
            
            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String sub = s.substring(right, right + wordLen);
                
                if (wordCount.containsKey(sub)) {
                    currentMap.put(sub, currentMap.getOrDefault(sub, 0) + 1);
                    count++;
                    
                    while (currentMap.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        
        return result;
    }
}
