class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalSum = 0;
        int minCurr = 0;
        int minSum = nums[0];
        int maxCurr = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++){
            globalSum += nums[i];
            minCurr = Math.min(0,minCurr);
            maxCurr = Math.max(0,maxCurr);
            minCurr += nums[i];
            maxCurr += nums[i];
            minSum = Math.min(minSum,minCurr);
            maxSum = Math.max(maxSum, maxCurr);
        }
        if (maxSum < 0){
            return maxSum;
        }
        if (maxSum > globalSum - minSum){
            return maxSum;
        }
        return globalSum - minSum;
    }
}