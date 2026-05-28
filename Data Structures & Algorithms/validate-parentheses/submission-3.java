class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> lifo = new ArrayList<Character>();
        if (s.length() % 2 != 0){
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '['){
                lifo.add(s.charAt(i));
            }
            else {
                if (lifo.size() == 0){
                    return false;
                }
                char popped = lifo.remove(lifo.size() - 1);
                if (popped == '(' && s.charAt(i) != ')'){
                    return false;
                }
                if (popped == '{' && s.charAt(i) != '}'){
                    return false;
                }
                if (popped == '[' && s.charAt(i) != ']'){
                    return false;
                }
            }
        }
        if (lifo.size() != 0){
            return false;
        }
        return true;
    }
}
