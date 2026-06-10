class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Integer min = 1;
        Integer max = null;
        for (int i = 0; i < piles.length; i++){
            if (max == null){
                max = piles[i];
            }
            if (piles[i] > max){
                max = piles[i];
            }
        }
        int curr = max;
        while (min <= max){
            int mid = (min + max) / 2;
            int total = 0;
            for (int i = 0; i < piles.length; i++){
                total += piles[i] / mid;
                if (piles[i] % mid != 0){
                    total++;
                }
            }
            if (total <= h){
                curr = mid;
                max = mid - 1;
            }
            else if (total > h){
                min = mid + 1;
            }
        }

        return curr;
    }
}
