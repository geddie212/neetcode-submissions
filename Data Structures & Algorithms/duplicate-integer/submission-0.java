class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap <Integer, Integer> n = new HashMap<>();
        for (int i = 0; i< nums.length;i++){
            if (n.containsKey(nums[i])){
                return true;
            }
            n.put(nums[i],nums[i]);
        }
        return false;
    }
}