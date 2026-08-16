class Solution {

    class TrieNode{
        HashMap<Character, TrieNode> h = new HashMap<>();
        boolean last = false;

        public TrieNode next(Character letter, TrieNode curr){
            if (!curr.h.containsKey(letter)){
                return null;
            }
            return curr.h.get(letter);
        }
    }

    class Trie{
        TrieNode o;

        public Trie(){
            this.o = new TrieNode();
        }

        public TrieNode getHead(){
            return this.o;
        }

        public void insert(String word){
            TrieNode curr = this.o;
            for (int i = 0; i < word.length(); i++){
                if (!curr.h.containsKey(word.charAt(i))){
                    curr.h.put(word.charAt(i), new TrieNode());
                }
                curr = curr.h.get(word.charAt(i));
            }
            curr.last = true;
        }



        // public boolean search(Character letter){
        //     TrieNode curr = this.o;
        //     for (int i = 0; i < word.length(); i++){
        //         if (!curr.h.containsKey(word.charAt(i))){
        //             return false;
        //         }
        //         curr = curr.h.get(word.charAt(i));
        //     }
        //     return curr.last;
        // }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for (String w: words){
            t.insert(w);
        }
        StringBuilder s = new StringBuilder();
        HashSet<String> wordList = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                TrieNode n = t.getHead();
                wordFind(s, board, i, j, n, wordList, visited);
            }
        }
        return new ArrayList<>(wordList);
    }

    public void wordFind(StringBuilder s, char[][] board, int r, int c, TrieNode t, HashSet<String> words, boolean[][] visited){
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && visited[r][c] == false){
            if (t != null){
            
                if (!t.h.containsKey(board[r][c])){
                    return;
                }

                visited[r][c] = true;
                t = t.h.get(board[r][c]);
                s.append(board[r][c]);
                
                if (t.last){
                    words.add(s.toString());
                }
                wordFind(s, board, r - 1, c, t, words, visited);
                wordFind(s, board, r, c + 1, t, words, visited);
                wordFind(s, board, r, c - 1, t, words, visited);
                wordFind(s, board, r + 1, c, t, words, visited);
                s.deleteCharAt(s.length() - 1);
                visited[r][c] = false;
            }
        }
    }

}
