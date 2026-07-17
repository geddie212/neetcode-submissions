class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++){
            currSum = Math.max(0,currSum);
            currSum += nums[i];
            max = Math.max(max, currSum);
        }
        return max;
    }
}
