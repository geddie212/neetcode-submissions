class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        combSum(nums, 0, 0, target, new ArrayList<Integer>(), out);
        return out;
        
    }
    public void combSum(int[] nums, int idx, int curr, int target, List<Integer> sub, List<List<Integer>> out){
        if (curr < target && idx < nums.length){
            curr+= nums[idx];
            sub.add(nums[idx]);
            List<Integer> sub2 = new ArrayList<>();
            for (int i = 0; i < sub.size() - 1; i++){
                sub2.add(sub.get(i));
            }
            if (curr == target){
                out.add(sub);
            }
            else if (curr < target){
                combSum(nums, idx, curr, target, sub, out);
            }
            combSum(nums, idx + 1, curr - nums[idx], target, sub2, out);
        }
    }
}


// class Solution {
//     public List<List<Integer>> combinationSum(int[] nums, int target) {
//         List<List<Integer>> out = new ArrayList<>();
//         combSum(nums, 0, target, 0, new ArrayList<Integer>(), out);
//         return out;
        
//     }
//     public void combSum(int[] nums, int curT, int target, int idx, List<Integer> sub, List<List<Integer>> out){
//         if (idx<nums.length){
//             int newT = curT;

//             while (newT < target){
//                 newT += nums[idx];
//                 sub.add(nums[idx]);

//                 int subE = 0;
//                 int rT = 0;

//                 if (newT == target){
//                     out.add(sub);
//                     subE = sub.size() - 1;
//                     rT = newT - nums[idx];
//                 }

//                 else if (newT < target){
//                     subE = sub.size();
//                     rT = newT;
//                 }

//                 if (subE - 1 >= 0 && sub.get(subE - 1) == nums[idx]){
//                     for (int i = idx + 1; i < nums.length; i++){
//                         List<Integer> newSub = new ArrayList<>();
//                         for (int j = 0; j < subE; j++){
//                             newSub.add(sub.get(j));
//                         }
//                         combSum(nums, rT, target, i, newSub, out);
//                     }
//                 }
//             }
//             combSum(nums, 0, target, idx + 1, new ArrayList<Integer>(), out);
//         }
//     }
// }



