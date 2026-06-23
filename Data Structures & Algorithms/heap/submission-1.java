class MinHeap {
    List<Integer> h;

    public MinHeap() {
        this.h = new ArrayList<>();
        this.h.add(null);
    }

    public void push(int val) {
        this.h.add(val);
        int i = this.h.size() - 1;
        while(i/2>0){
            if(this.h.get(i)<this.h.get(i/2)){
                int temp = this.h.get(i);
                this.h.set(i, this.h.get(i/2));
                this.h.set(i/2, temp);
                i/=2;
            }
            else{
                break;
            }
        }
    }

    public Integer pop() {
        if(this.h.size() == 1){
            return -1;
        }
        int out = this.h.get(1);
        this.h.set(1, this.h.get(this.h.size()-1));
        this.h.remove(this.h.size()-1);

        int i = 1;
        while(i<this.h.size()){
            Integer left = null;
            Integer right = null;

            if (i*2 < this.h.size()){
                left = this.h.get(i*2);
            }

            if (left == null){
                break;
            }

            if (i*2+1 < this.h.size()){
                right = this.h.get(i*2+1);
            }

            if(right != null && right<left&&right<this.h.get(i)){
                int temp = this.h.get(i);
                this.h.set(i,this.h.get(i*2+1));
                this.h.set(i*2+1,temp);
                i = i*2+1;
            }
            else if(left < this.h.get(i)){
                int temp = this.h.get(i);
                this.h.set(i, this.h.get(i*2));
                this.h.set(i*2, temp);
                i *= 2;
            }
            else{
                break;
            }
        }
        return out;
    }

    public Integer top() {
        if (this.h.size() == 1){
            return -1;
        }
        return this.h.get(1);
    }

    public void heapify(List<Integer> nums) {

        if (nums.size() == 0){
            this.h = new ArrayList<>();
            this.h.add(null);
            return;
        }

        int temp = nums.get(0);
        nums.set(0, null);
        nums.add(temp);

        for (int i = (nums.size()-1)/2; i > 0;i--){
            int curr = i;
            while(curr < nums.size()){
                Integer left = null;
                Integer right = null;
                if (curr*2 < nums.size()){
                    left = nums.get(curr*2);
                }
                if (left == null){
                    break;
                }
                if (curr*2+1<nums.size()){
                    right = nums.get(curr*2+1);
                }
                if (right != null && right < left && right < nums.get(curr)){
                    int temp1 = nums.get(curr);
                    nums.set(curr, right);
                    nums.set(curr*2+1, temp1);
                    curr = curr*2+1;
                }
                else if (left<nums.get(curr)){
                    int temp2 = nums.get(curr);
                    nums.set(curr, left);
                    nums.set(curr*2,temp2);
                    i*=2;
                }
                else{
                    break;
                }
            }
        }

        this.h = nums;
    }
}
