class KthLargest {

    int kth;
    List<Integer> maxHeap;

    public KthLargest(int k, int[] nums) {
        this.maxHeap = new ArrayList<>();
        this.maxHeap.add(null);
        this.addArr(nums);
        this.kth = k;
    }

    public int add(int val) {
        this.maxHeap.add(val);
        this.percolateUp();
        int out = 0;
        List<Integer> popped = new ArrayList<>();
        for (int i = 0;i<this.kth;i++){
            out = this.pop();
            popped.add(out);
        }
        for(int i = 0;i<popped.size();i++){
            this.maxHeap.add(popped.get(i));
            this.percolateUp();
        }
        return out;
    }

    private void addArr(int[] nums){
        for (int i = 0; i < nums.length; i++){
            this.maxHeap.add(nums[i]);
            this.percolateUp();
        }
    }

    private void percolateUp(){
        int i = this.maxHeap.size()-1;

        while (i > 1){
            if (this.maxHeap.get(i)>this.maxHeap.get(i/2)){
                int temp = this.maxHeap.get(i/2);
                this.maxHeap.set(i/2, this.maxHeap.get(i));
                this.maxHeap.set(i, temp);
                i/=2;
            }
            else{
                break;
            }
        }
    }

    private int pop(){
        if (this.maxHeap.size()>=2){
            int out = this.maxHeap.get(1);
            if (this.maxHeap.size()==2){
                this.maxHeap.remove(1);
                return out;
            }
            this.maxHeap.set(1,this.maxHeap.get(this.maxHeap.size()-1));
            this.maxHeap.remove(this.maxHeap.size()-1);

            int i = 1;

            while (i < this.maxHeap.size()){
                Integer left = null, right = null;
                if (i * 2<this.maxHeap.size()){
                    left = this.maxHeap.get(i*2);
                }
                if (left == null){
                    break;
                }
                if (i*2+1<this.maxHeap.size()){
                    right = this.maxHeap.get(i*2+1);
                }
                if(right != null && right > left && right > this.maxHeap.get(i)){
                    int temp = this.maxHeap.get(i);
                    this.maxHeap.set(i, this.maxHeap.get(i*2+1));
                    this.maxHeap.set(i*2+1, temp);
                    i=i*2+1;
                }
                else if (left>this.maxHeap.get(i)){
                    int temp = this.maxHeap.get(i);
                    this.maxHeap.set(i,this.maxHeap.get(i*2));
                    this.maxHeap.set(i*2,temp);
                    i*=2;
                }
                else{
                    break;
                }
            }
            return out;
        }
        return -1;
    }
    
}
