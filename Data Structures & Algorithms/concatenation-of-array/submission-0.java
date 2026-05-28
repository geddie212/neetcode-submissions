class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] out = new int [nums.length * 2];
        for (int i = 0; i < nums.length; i++){
            out[i] = nums[i];
        }
        for (int i = nums.length; i < nums.length*2; i++){
            out[i] = nums[i-nums.length];
        }
        return out;
    }
}