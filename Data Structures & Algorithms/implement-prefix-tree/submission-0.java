class PrefixTree {
    class TrieNode{
        HashMap<Character, TrieNode> c = new HashMap<>();
        boolean last = false;
    }

    TrieNode o;

    public PrefixTree() {
         this.o = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.o;
        for (int i = 0; i < word.length(); i++){
            if (!curr.c.containsKey(word.charAt(i))){
                curr.c.put(word.charAt(i), new TrieNode()); 
            }
            curr = curr.c.get(word.charAt(i));
        }
        curr.last = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.o;
        for (int i = 0; i < word.length(); i++){
            if (!curr.c.containsKey(word.charAt(i))){
                return false;
            }
            curr = curr.c.get(word.charAt(i));
        }
        return curr.last;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.o;
        for (int i = 0; i < prefix.length(); i++){
            if (!curr.c.containsKey(prefix.charAt(i))){
                return false;
            }
            curr = curr.c.get(prefix.charAt(i));
        }
        return true;
    }
}
