class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. Use queue to control levels (travel length) when traversing.
        // 2. replace each character of each word and check if it exists in the wordlist (use Set)
        // 3. if word is found in wordList set, add it to queue and remove it from worldList.
        // 4. iteratively repeat step 1-3, once found word is equal to endWord, return length
        int length = 1;
        if (beginWord.equals(endWord)) return length;
        
        HashSet<String> set = new HashSet(wordList); // prevent TLE
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < beginWord.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        StringBuilder str = new StringBuilder(word);
                        str.setCharAt(j, ch);
                        String s = str.toString();
                        if (set.contains(s)) {
                            if (s.equals(endWord)) return length;
                            queue.offer(s);
                            set.remove(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}