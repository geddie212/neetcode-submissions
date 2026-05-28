class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mini;
    int min;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.mini = new Stack<Integer>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        if (this.mini.size() != 0){
            if (this.mini.get(this.mini.size() - 1) > val){
                this.mini.add(val);
            }
            else {
                this.mini.add(this.mini.get(this.mini.size() - 1));
            }
        }
        else{
            this.mini.add(val);
        }
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
        this.mini.remove(this.mini.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
        
    }
    
    public int getMin() {
        return this.mini.get(this.mini.size() - 1);
    }
}
