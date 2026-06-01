class MyLinkedList {

    class Node{
        int val;
        Node next;
        Node prev;
    }

    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = this.head;
    }
    
    public int get(int index) {
        if (index < 0 || this.size == 0 || index >= this.size){
            return -1;
        }
        Node curr = this.head;
        int currIdx = 0;
        while (currIdx < index){
            curr = curr.next;
            currIdx++;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node();
        newHead.val = val;
        newHead.next = this.head;
        if (this.head != null){
            this.head.prev = newHead;
        }
        this.head = newHead;
        if (this.size == 0){
            this.tail = this.head;
        }
        this.size++;
    }
    
    public void addAtTail(int val) {
        Node newTail = new Node();
        newTail.val = val;
        if (this.size == 0){
            this.head = newTail;
            this.tail = newTail;
        }
        else {
            newTail.prev = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= this.size){
            if (index == 0){
                this.addAtHead(val);
            }
            else if (index == this.size){
                this.addAtTail(val);
            }
            else {
                Node curr = this.head;
                int currIdx = 0;
                while (currIdx < index){
                    curr = curr.next;
                    currIdx++;
                }
                Node newNode = new Node();
                newNode.val = val;
                newNode.prev = curr.prev;
                newNode.next = curr;
                curr.prev.next = newNode;
                curr.prev = newNode;
                this.size++;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= 0 && this.size != 0 && index < this.size){
            if (index == 0) {
                this.head = this.head.next;
                this.size--;

                if (this.head != null) {
                    this.head.prev = null;
                }

                if (this.size == 0) {
                    this.tail = null;
                }
            }
            else if (index == this.size - 1){
                this.tail = this.tail.prev;
                this.tail.next = null;
                this.size--;
            }
            else {
                int currIdx = 0;
                Node curr = this.head;
                while (currIdx != index){
                    curr = curr.next;
                    currIdx++;
                }
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
                curr = null;
                this.size--;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */