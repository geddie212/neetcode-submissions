class Solution {
    public int[] countBits(int n) {
        int[] out = new int[n+1];
        int count = 0;
        int curr = 0;
        for (int i = 0; i <= n; i++){
            count = 0;
            curr = i;
            while (curr != 0){
                if ((curr & 1)==1){
                    count++;
                }
                curr >>= 1;
            }
            out[i] = count;
        }
        return out;
    }
}
