class BrowserHistory {
    class Node{
        String val;
        Node prev;
        Node next;
    }
    Node head;
    Node curr;

    public BrowserHistory(String homepage) {
        this.head = new Node();
        this.head.val = homepage;
        this.curr = this.head;
    }
    
    public void visit(String url) {
        Node page = new Node();
        page.val = url;
        this.curr.next = page;
        page.prev = this.curr;
        this.curr = page;
    }
    
    public String back(int steps) {
        int currIdx = 0;
        while (this.curr.prev != null){
            if (currIdx == steps){
                return this.curr.val;
            }
            this.curr = this.curr.prev;
            currIdx++;
        }
        return this.curr.val;
    }
    
    public String forward(int steps) {
        int currIdx = 0;
        while (this.curr.next != null){
            if (currIdx == steps){
                return this.curr.val;
            }
            this.curr = this.curr.next;
            currIdx++;
        }
        return this.curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */