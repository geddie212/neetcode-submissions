class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0;
        int r = 0;
        int count = 0;
        double sum = 0;
        while (r < arr.length){
            if (r - l + 1 > k){
                sum -= (double) arr[l];
                l++;
            }
            sum += (double) arr[r];
            if (r - l + 1 == k && sum/k >= threshold){
                count++;
            }
            r++;
        }
        return count;
    }
}