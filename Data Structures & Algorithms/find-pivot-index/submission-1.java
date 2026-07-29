class Solution {
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            total += nums[i];
            pre[i] = total;
        }
        if (pre[pre.length - 1] - pre[0] == 0){
            return 0;
        }
        for (int i = 1; i < pre.length; i++){
            if (pre[i - 1] == pre[pre.length - 1] - pre[i]){
                return i;
            }
        }
        return -1;
    }
}