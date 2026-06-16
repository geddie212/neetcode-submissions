class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        subSetter(nums, 0, sub, out);
        return out;
    }

    public void subSetter(int[] nums, int idx, List<Integer> sub, List<List<Integer>> out){
        List<Integer> yes = new ArrayList<>();
        for (int i = 0; i < sub.size(); i++){
            yes.add(sub.get(i));
        }
        yes.add(nums[idx]);
        if (idx == nums.length - 1){
            out.add(sub);
            out.add(yes);
        }
        else {
            subSetter(nums, idx + 1, sub, out);
            subSetter(nums, idx + 1, yes, out);
        }
    }
}
