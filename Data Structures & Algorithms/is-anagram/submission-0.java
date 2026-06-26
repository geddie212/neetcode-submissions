class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length();i++){
            if (h.containsKey(s.charAt(i))){
                int ch = h.get(s.charAt(i)) + 1;
                h.put(s.charAt(i), ch);
            }
            else {
                h.put(s.charAt(i),1);
                System.out.println("putted value: "+h.get(s.charAt(i)));
            }
        }
        
        for(int i = 0;i < t.length();i++){
            //System.out.println(t.charAt(i));
            //System.out.println(h.containsKey(t.charAt(i)));
            //System.out.println(h.get(t.charAt(i)));

            if(!h.containsKey(t.charAt(i))){
                return false;
            }
            else{
                int num = h.get(t.charAt(i)) - 1;
                h.put(t.charAt(i),num);
                if (h.get(t.charAt(i)) < 0){
                    return false;
                }
            }
        }

        for (Character c : h.keySet()){
            if (h.get(c)!=0){
                return false;
            }
        }

        return true;
    }
}
