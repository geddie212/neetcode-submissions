class Deque {

    class Node{
        int val;
        Node left;
        Node right;
    }
    Node l;
    Node r;

    public Deque() {
        this.l = null;
        this.r = null;
    }

    public boolean isEmpty() {
        if (this.l == null && this.r == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void append(int value) {
       Node n = new Node();
       n.val = value;
       if (this.r == null){
            this.l = this.r = n;
       }
       else {
            this.r.right = n;
            n.left = this.r;
            this.r = n;
       }
    }

    public void appendleft(int value) {
        Node n = new Node();
        n.val = value;
        if (this.l == null){
            this.l = this.r = n;
        }
        else {
            this.l.left = n;
            n.right = this.l;
            this.l = n;
        }
    }

    public int pop() {
        if (this.r == null){
            return -1;
        }
        else {
            int result = this.r.val;
            if (this.r.left != null){
                this.r = this.r.left;
                this.r.right = null;
            }
            else {
                this.r = null;
                this.l = null;
            }
            return result;
        }
    }

    public int popleft() {
        if (this.l == null){
            return -1;
        }
        else {
            int result = this.l.val;
            if (this.l.right != null){
                this.l = this.l.right;
                this.l.left = null;
            }
            else{
                this.l = null;
                this.r = null;
            }
            return result;
        }
    }
}
