class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int pT = 1;
        int[] suf = new int[nums.length];
        int sT = 1;
        for (int i = 0; i < nums.length; i++){
            pT *= nums[i];
            pre[i] = pT;
            sT *= nums[nums.length - 1 - i];
            suf[nums.length - 1 - i] = sT;
        }
        // for (int i = nums.length - 1; i >= 0; i --){
        //     sT*=nums[i];
        //     suf[i] = sT;
        // }
        int out[] = new int[nums.length];
        out[0] = suf[1];
        for (int i = 1;i < nums.length - 1; i++){
            out[i] = pre[i-1] * suf[i+1];
        }
        out[out.length - 1] = pre[pre.length - 2];
        return out;
    }
}  
