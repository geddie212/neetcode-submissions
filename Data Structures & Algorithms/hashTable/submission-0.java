class HashTable {

    class Node{
        int key;
        int val;
        Node next;
    }

    int capacity;
    int size;
    List<Node> hm;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hm = new ArrayList<>();
        for (int i = 0; i < this.capacity; i++){
            this.hm.add(null);
        }
    }

    public void insert(int key, int value) {
        if (this.hm.get(key%this.capacity) == null){
            Node h = new Node();
            h.key = key;
            h.val = value;
            this.hm.set(key%this.capacity,h);
            this.size++;
            if (this.size >= this.capacity/2){
                this.resize();
            }
        }
        else{
            Node c = this.hm.get(key%this.capacity);
            boolean hasKey = false;
            while (c.next != null){
                if (c.key==key){
                    c.val = value;
                    hasKey = true;
                    break;
                }
                c = c.next;
            }
            if (c.key == key){
                c.val = value;
                hasKey = true;
            }
            if (hasKey == false){
                Node t = new Node();
                t.key = key;
                t.val = value;
                c.next = t;
                this.size++;
                if (this.size >= this.capacity/2){
                    this.resize();
                }
            }
        }
    }

    public int get(int key) {
        Node n = this.hm.get(key % this.capacity);
        while (n != null){
            if (n.key == key){
                return n.val;
            }
            n = n.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        if(this.hm.get(key%this.capacity)==null){
            return false;
        }
        else{
            Node n = this.hm.get(key%this.capacity);
            if (n.key == key){
                n = n.next;
                this.hm.set(key%this.capacity,n);
                this.size--;
                return true;
            }
            else{
                while(n.next != null){
                    if(n.next.key == key){
                        n.next = n.next.next;
                        this.size--;
                        return true;
                    }
                    n = n.next;
                }
                return false;
            }
        }

    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        List<Node> nh = new ArrayList<>();
        for (int i = 0; i < this.capacity * 2; i++){
            nh.add(null);
        }
        for (int i = 0; i < this.capacity; i++){
            Node c = this.hm.get(i);
            while (c != null){
                Node n = nh.get(c.key%(this.capacity*2));
                Node nn = new Node();
                nn.key = c.key;
                nn.val = c.val;
                if (n == null){
                    nh.set(c.key % (this.capacity * 2),nn);
                }
                else{
                    while (n.next != null){
                        n = n.next;
                    }
                    n.next = nn;

                }
                c = c.next;
            }
        }
        this.capacity *= 2;
        this.hm = nh;
    }
}