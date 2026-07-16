class Solution {
    public int reverseBits(int n) {
        int out = 0;
        int bit = 32;
        while (bit > 0){
            out <<= 1;
            if ((n&1)==1){
                out += 1;
            }
            n >>= 1;
            bit--;
        }
        return out;
    }
}
