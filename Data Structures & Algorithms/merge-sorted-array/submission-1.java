class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        int o = m + n - 1;
        while (l >= 0 && r >= 0){
            if (nums1[l] >= nums2[r]){
                nums1[o--] = nums1[l--];
            }
            else{
                nums1[o--] = nums2[r--];
            }
        }
        while (l >= 0){
            nums1[o--] = nums1[l--];
        }
        while(r >= 0){
            nums1[o--] = nums2[r--];
        }
    }
}


        // int[] temp = new int[m+n];
        // int ms = 0;
        // int ns = 0;
        // int o = 0;
        // while (ms < m && ns < n){
        //     if (nums2[ns] < nums1[ms]){
        //         temp[o] = nums2[ns];
        //         ns++;
        //     }
        //     else{
        //         temp[o] = nums1[ms];
        //         ms++;
        //     }
        //     o++;
        // }

        // while (ms < m){
        //     temp[o++] = nums1[ms++];
        // }

        // while (ns < n){
        //     temp[o++] = nums2[ns++];
        // }

        // for (int i = 0;i < temp.length;i++){
        //     nums1[i] = temp[i];
        // }