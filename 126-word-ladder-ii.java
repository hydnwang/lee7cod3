// Refer to solution:
// https://leetcode.com/problems/word-ladder-ii/discuss/340257/Java-BFS-%2B-DFS-solution
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Solution1: BFS from end to start, then DFS from start to end
        List<List<String>> res = new ArrayList();
        
        // if end word is absent, return
        if (!wordList.contains(endWord)) return res;
        
        
        // Step1: BFS: create graph and record shortest distances of words
        // convert word list to set, accelerate program
        Set<String> dict = new HashSet(wordList);
        
        // add beginWord cuz we first do BFS from end to begin,
        // begin word must present
        dict.add(beginWord);
        
        // create graph, so we can find next word in O(1)
        Map<String, Set<String>> graph = new HashMap();
        // record the shortest distance of each word
        Map<String, Integer> distances = new HashMap();
        
        bfs(graph, distances, endWord, dict);
        
        
        // Step2: DFS
        // using set to record visited words can accelerate program
        Set<String> visited = new HashSet();
        visited.add(beginWord);
        // record current path, once reached end, add to res
        List<String> path = new ArrayList();
        path.add(beginWord);
        
        dfs(res, path, visited, distances, graph, beginWord, endWord);
        
        // step3: return result
        return res;
    }
    
    private void bfs(Map<String, Set<String>> graph, Map<String, Integer> distances, String start, Set<String> dict) {
        
        Queue<String> q = new LinkedList();
        
        // Create graph using BFS
        for (String d : dict) graph.put(d, new HashSet());
        
        q.offer(start);
        distances.put(start, 0);
        StringBuilder str;
        List<String> candidates;
        
        while (!q.isEmpty()) {
            
            String word = q.poll();
            candidates = new ArrayList<String>();
            
            for (int i = 0; i< word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != word.charAt(i)) {
                        str = new StringBuilder(word);
                        str.setCharAt(i, ch);
                        if (dict.contains(str.toString())) {
                            candidates.add(str.toString());
                        }
                    }
                }
            }
            
            for (String candidate : candidates) {
                // create graph in reversed order cuz we do BFS from end to begin
                graph.get(candidate).add(word);
                
                // update distances
                if (!distances.containsKey(candidate)) {
                    distances.put(candidate, distances.get(word)+1);
                    q.offer(candidate);
                }
            }
        }
    }
    
    private void dfs(List<List<String>> res, List<String> path, Set<String> visited, Map<String, Integer> distances, Map<String, Set<String>> graph, String start, String end) {
        if (start.equals(end)) {
            res.add(new ArrayList<String>(path));
            return;
        }
        
        for (String w : graph.get(start)) {
            if (distances.containsKey(w) && 
                distances.get(w)+1==distances.get(start) && !visited.contains(w)) 
            {
                path.add(w);
                visited.add(w);
                dfs(res, path, visited, distances, graph, w, end);
                
                visited.remove(w); // backtracking
                path.remove(path.size()-1); // backtracking
            }
        }
    }
}