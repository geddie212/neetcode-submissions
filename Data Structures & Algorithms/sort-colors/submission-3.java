class Solution {
    public void sortColors(int[] nums) {
        int[] buc = new int[3];
        for (int i = 0; i < nums.length; i++){
            buc[nums[i]]++;
        }
        int currIdx = 0;
        for (int i = 0; i < buc.length; i++){
            while(buc[i] > 0){
                nums[currIdx] = i;
                currIdx++;
                buc[i]--;
            }
        }
    }
}