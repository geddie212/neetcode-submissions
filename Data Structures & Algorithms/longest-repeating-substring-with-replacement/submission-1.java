class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int l = 0;
        int r = 0;
        int max = 0;
        int charMax = 0;
        while (r < s.length()){
            arr[(int)s.charAt(r)-65]++;
            charMax = 0;
            for (int i = 0; i < arr.length; i++){
                if (arr[i] > charMax){
                    charMax = arr[i];
                }
            }
            if (r-l+1-charMax>k){
                arr[(int) s.charAt(l)-65]--;
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
