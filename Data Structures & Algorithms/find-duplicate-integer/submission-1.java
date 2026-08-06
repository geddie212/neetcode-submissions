class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if (slow == fast){
                break;
            }
        }
        int point = 0;
        while (point != slow){
            point = nums[point];
            slow = nums[slow];
        }
        return point;
    }
}
