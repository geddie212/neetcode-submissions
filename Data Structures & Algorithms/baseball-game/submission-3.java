class Solution {
    public int calPoints(String[] operations) {
        List<Integer> stack  = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < operations.length; i++){
            if (operations[i].charAt(0) >= 48 && operations[i].charAt(0) <= 57 || operations[i].charAt(0) == 45){
                stack.add(Integer.parseInt(operations[i]));
                sum += stack.get(stack.size() - 1);
            }
            else if  (operations[i].charAt(0) == 43){
                int l1 = stack.remove(stack.size() - 1);
                int l2 = stack.remove(stack.size() - 1);
                stack.add(l2);
                stack.add(l1);
                stack.add(l1+l2);
                sum += stack.get(stack.size() - 1);
            }
            else if (operations[i].charAt(0) == 68){
                stack.add(stack.get(stack.size() - 1)*2);
                sum += stack.get(stack.size() - 1);
            }
            else if (operations[i].charAt(0) == 67){
                sum -= stack.remove(stack.size() - 1);
            }
        }
        return sum;
    }
}