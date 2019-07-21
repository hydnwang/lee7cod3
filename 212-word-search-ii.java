// Refer to solution (Use Trie):
// https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        if (words == null || words.length == 0)
            return res;
        // convert words to a string trie.
        TrieNode root = buildTrie(words);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int x, int y, TrieNode t, List<String> res) {
        char c = board[x][y];
        if (c == '@')
            return;
        if (t.next[c - 'a'] == null)
            return;

        t = t.next[c - 'a'];
        if (t.word != null) {
            res.add(t.word);
            t.word = null; // avoid finding duplicate words
            // return; // keep finding, don't stop
        }

        board[x][y] = '@';
        if (x > 0)
            dfs(board, x - 1, y, t, res);
        if (y > 0)
            dfs(board, x, y - 1, t, res);
        if (x < board.length - 1)
            dfs(board, x + 1, y, t, res);
        if (y < board[0].length - 1)
            dfs(board, x, y + 1, t, res);
        // backtracking
        board[x][y] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                int nxtChar = c - 'a';
                if (cur.next[nxtChar] == null) {
                    cur.next[nxtChar] = new TrieNode();
                }
                cur = cur.next[nxtChar];
            }
            cur.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}