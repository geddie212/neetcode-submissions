class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()){
            if (hm.containsKey(s.charAt(r))){
                for (int i = l; i < hm.get(s.charAt(r)); i++){
                    hm.remove(s.charAt(i));
                }
                l = hm.get(s.charAt(r)) + 1;
            }
            max = Math.max(max, r-l + 1);
            hm.put(s.charAt(r),r);
            r++;
        }
        return max;
    }
}
