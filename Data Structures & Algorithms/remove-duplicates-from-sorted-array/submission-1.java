class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int l = 0;
        int r = 1;
        int count = 1;
        while (r < nums.length){
            while(r < nums.length && nums[l] == nums[r]){
                r++;

            }
            if (r >= nums.length){
                    continue;
            }
            nums[l + 1] = nums[r];
            l++;
            r++;
            count++;
        }
        return count;
    }
}