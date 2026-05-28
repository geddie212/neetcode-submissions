class MinStack {
    Stack<Integer> stack;

    public MinStack() {
        this.stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        this.stack.add(val);
    }
    
    public void pop() {
        if (this.stack.size() != 0){
            this.stack.remove(this.stack.size() - 1);
        }
    }
    
    public int top() {
        if (this.stack.size() != 0){
            return this.stack.get(this.stack.size() - 1);
        }
        return -1;
    }
    
    public int getMin() {
        if (this.stack.size() != 0){
            int min = this.stack.get(0);
            for (int i = 1; i < this.stack.size(); i++){
                if (this.stack.get(i) < min){
                    min = this.stack.get(i);
                }
            }
            return min;
        }
        else {
            return -1;
        }

    }
}
