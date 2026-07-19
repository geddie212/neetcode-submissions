class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length){
            sum += nums[r];
            while (sum >= target && l <= r){
                count = Math.min(r-l+1, count);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        if (count == Integer.MAX_VALUE){
            return 0;
        }
        return count;
    }
}