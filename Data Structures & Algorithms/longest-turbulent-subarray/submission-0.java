class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 0;
        int max = 0;
        while (r<arr.length){
            if (r - 2 >= 0 && r - 2 >= l){
                if (arr[r - 2] > arr[r - 1] && arr[r-1] > arr[r]){
                    l = r - 1;
                    continue;
                }
                if (arr[r-2] < arr[r - 1] && arr[r-1] < arr[r]){
                    l = r - 1;
                    continue;
                }
            }
            if (r != l && arr[r] == arr[r-1]){
                l = r;
                continue;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}