class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, List<Integer>> ni = new HashMap<>();
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (ni.containsKey(target-nums[i])){
                List<Integer> n = ni.get(target-nums[i]);
                n.add(i);
                if (n.size()==2){
                    return new int[]{n.get(0),n.get(1)};
                }
            }
            else if(ni.containsKey(nums[i])){
                List<Integer> m = ni.get(nums[i]);
                m.add(i);
            }
            else{
                List<Integer> o = new ArrayList<>();
                o.add(i);
                ni.put(nums[i],o);
            }
        }
        return new int[]{-1,-1};
    }
}
