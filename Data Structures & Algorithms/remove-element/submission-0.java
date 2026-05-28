class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int l = 0;
        int r = 1;
        while (l < nums.length - 1){
            if (nums[l] == val && r < nums.length){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r++;
            }
            else {
                l++;
                r = l + 1;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                k++;
            }
        }
        return k;
    }
}