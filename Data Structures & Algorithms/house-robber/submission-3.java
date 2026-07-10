class Solution {

    int[] arr;

    public int rob(int[] nums) {
        this.arr = new int[nums.length];
        for (int i = 0; i < nums.length;i++){
            this.arr[i] = -1;
        }
        return robb(0,nums);
    }

    public int robb(int i, int[] nums){
        if (i >= nums.length){
            return 0;
        }
        if (this.arr[i] != -1){
            return this.arr[i];
        }
        int take = nums[i] + robb(i+2,nums);
        int skip = robb(i+1, nums);

        if (take>skip){
            this.arr[i]= take;
        }
        else{
            this.arr[i] = skip;
        }
        return this.arr[i];
    }
    
}
