class LRUCache {
    class Node{
        int[] kv;
        Node next;
        Node prev;
    }

    HashMap<Integer, Node> hm;
    Node lRU;
    Node mRU;
    int currC;
    int totC;

    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.lRU = new Node();
        this.mRU = new Node();
        this.currC = 0;
        this.totC = capacity;
    }

    private void removal(){
        Node nr = this.lRU.next;
        if (this.lRU.next == this.mRU.next){
            if (this.lRU.next != null){
                this.currC--;
            }
            this.lRU.next = null;
            this.mRU.next = null;
        }
        else{
            this.lRU.next = nr.prev;
            this.lRU.next.next = null;
            nr.prev = null;
            this.currC--;
        }
        if (nr != null){
            this.hm.remove(nr.kv[0]);
        }
    }

    private void shifting(int key, int val){
        if (!this.hm.containsKey(key)){
            int[] lkv = {key,val};
            Node n = new Node();
            n.kv = lkv;
            if (this.mRU.next == null){
                this.mRU.next = n;
                this.lRU.next = n;
            }
            else{
                n.next = this.mRU.next;
                this.mRU.next.prev = n;
                this.mRU.next = n;
                
            }
            this.hm.put(key,n);
            this.currC++;
        }
        else{
            Node g = this.hm.get(key);
            g.kv[1] = val;
            if (g.next == null && g.prev != null){
                this.lRU.next = this.lRU.next.prev;
                this.lRU.next.next = null;
                g.next = this.mRU.next;
                this.mRU.next.prev = g;
                this.mRU.next = g;
                g.prev = null;
            }
            else if (g.next != null && g.prev != null){
                g.prev.next = g.next;
                g.next.prev = g.prev;
                g.next = this.mRU.next;
                this.mRU.next.prev = g;
                this.mRU.next = g;
                g.prev = null;
            }
        }

    }
    
    public int get(int key) {
        if(!this.hm.containsKey(key)){
            return -1;
        }
        else{
            int val = this.hm.get(key).kv[1];
            this.shifting(key,val);
            return val;
        }
    }
    
    public void put(int key, int value) {
        this.shifting(key,value);
        if (this.currC > this.totC){
            this.removal();
        }
    }
}
