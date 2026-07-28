class Solution {
    public int trap(int[] height) {
        if (height.length < 3){
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        int total = 0;
        int curr = l;
        while (l <= r){
            lMax = Math.max(lMax,height[l]);
            rMax = Math.max(rMax, height[r]);
            if (Math.min(lMax,rMax)-height[curr] < 0){
                total += 0;
            }
            else{
                total += Math.min(lMax,rMax)-height[curr];
            }
            if (rMax < lMax){
                r--;
                curr = r;
            }
            else{
                l++;
                curr=l;
            }
        }
        return total;
    }
}
