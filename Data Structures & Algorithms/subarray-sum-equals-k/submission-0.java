class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] pre = new int[nums.length];
        int preT = 0;
        for (int i = 0; i < nums.length; i++){
            preT += nums[i];
            pre[i] = preT;
        }
        hm.put(0,1);
        int out = 0;
        for (int i = 0; i < pre.length; i++){
            if (hm.containsKey(pre[i]-k)){
                out += hm.get(pre[i] - k);
            }
            if (!hm.containsKey(pre[i])){
                hm.put(pre[i], 1);
            }
            else{
                int curr = hm.get(pre[i]) + 1;
                hm.put(pre[i], curr);
            }
        }
        return out;
    }
}