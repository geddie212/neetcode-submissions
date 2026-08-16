class WordDictionary {
    class TrieNode{
        HashMap<Character, TrieNode> h = new HashMap<>();
        boolean end = false;
    }

    TrieNode o;

    public WordDictionary() {
        this.o = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.o;
        for (int i = 0; i < word.length(); i++){
            if (!curr.h.containsKey(word.charAt(i))){
                curr.h.put(word.charAt(i),new TrieNode());
            }
            curr = curr.h.get(word.charAt(i));
        }
        curr.end = true;
    }

    public boolean search(String word) {
        if (word.length() == 0){
            return true;
        }
        return wordFind(0, this.o, word);
    }
    
    private boolean wordFind(int idx, TrieNode n, String word){
        if (idx == word.length()){
            return n.end;
        }
        if (word.charAt(idx)=='.'){
            boolean t = false;
            for (Character c : n.h.keySet()){
                if (wordFind(idx + 1, n.h.get(c), word)){
                    t = true;
                }
            }
            return t;
        }
        else {
            if (!n.h.containsKey(word.charAt(idx))){
                return false;
            }
            return wordFind(idx + 1, n.h.get(word.charAt(idx)), word);
        }
    }
}
