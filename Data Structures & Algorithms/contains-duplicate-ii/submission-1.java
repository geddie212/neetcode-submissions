class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> in = new HashSet<>();
        in.add(nums[0]);
        if (nums.length > 1){
      for (int i = 1; i <= k; i++){
            if (in.contains(nums[i])){
                return true;
            }
            in.add(nums[i]);
        }
        for (int i = k+1; i < nums.length; i++){
            in.remove(nums[i-k-1]);
            if (in.contains(nums[i])){
                return true;
            }
            in.add(nums[i]);
        }
        }
  
        return false;
    }
}