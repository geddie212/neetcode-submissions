class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int ms = 0;
        int ns = 0;
        int o = 0;
        while (ms < m && ns < n){
            if (nums2[ns] < nums1[ms]){
                temp[o] = nums2[ns];
                ns++;
            }
            else{
                temp[o] = nums1[ms];
                ms++;
            }
            o++;
        }

        while (ms < m){
            temp[o++] = nums1[ms++];
        }

        while (ns < n){
            temp[o++] = nums2[ns++];
        }

        for (int i = 0;i < temp.length;i++){
            nums1[i] = temp[i];
        }
    }
}