

class MyStack {
    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;

    public MyStack() {
        this.queueOne = new LinkedList<Integer>();
        this.queueTwo = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if (this.queueOne.size() == 0 && this.queueTwo.size() == 0 || this.queueOne.size() != 0){
            this.queueOne.offer(x);
        }
        else {
            this.queueTwo.offer(x);
        }
    }
    
    public int pop() {
        int result = -1;
       if(this.queueOne.size() != 0){
            while (this.queueOne.size() != 0){
                if (this.queueOne.size() == 1){
                    result = this.queueOne.poll();
                }
                else {
                    this.queueTwo.offer(this.queueOne.poll());
                }
            }
       }
       else {
            while(this.queueTwo.size() != 0){
                if (this.queueTwo.size() == 1){
                    result = this.queueTwo.poll();
                }
                else{
                    this.queueOne.offer(this.queueTwo.poll());
                }
            }
       } 
       return result;
    }
    
    public int top() {
        int result = -1;
       if(this.queueOne.size() != 0){
            while (this.queueOne.size() != 0){
                if (this.queueOne.size() == 1){
                    result = this.queueOne.poll();
                    this.queueTwo.offer(result);
                }
                else {
                    this.queueTwo.offer(this.queueOne.poll());
                }
            }
       }
       else {
            while(this.queueTwo.size() != 0){
                if (this.queueTwo.size() == 1){
                    result = this.queueTwo.poll();
                    this.queueOne.offer(result);
                }
                else{
                    this.queueOne.offer(this.queueTwo.poll());
                }
            }
       } 
       return result;
    }
    
    public boolean empty() {
        if (this.queueOne.size() == 0 && this.queueTwo.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */