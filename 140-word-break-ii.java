// Refer to solution: 
// https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS/43403
class Solution {
    
    HashMap<String,List<String>> mem = new HashMap<String,List<String>>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }
    
    private List<String> dfs(String s, List<String> wordDict) {
        // alredy seen before, return result immediately
        if (mem.containsKey(s)) return mem.get(s);
        
        List<String> res = new ArrayList();
        
        // if (s.length == 0 || s == null) {
        //     res.add("");
        //     return res;
        // }
        
        for (String word : wordDict) {
            // if current string contains words in wordDict
            // use the rest characters to keep matching words
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) { // reach the end of string s
                    res.add(word);
                } else { // 
                    List<String> sublist = dfs(next, wordDict);
                    for (String sub : sublist) {
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        mem.put(s, res);
        return res;
    }
}