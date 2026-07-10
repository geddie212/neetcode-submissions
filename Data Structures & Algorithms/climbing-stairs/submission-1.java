class Solution {
    HashMap<Integer, Integer> cache;
    public Solution(){
        this.cache = new HashMap<>();
    }
    public int climbStairs(int n) {
        if (n <= 1){
            return 1;
        }
        if (this.cache.containsKey(n)){
            return this.cache.get(n);
        }

        this.cache.put(n, climbStairs(n-1) + climbStairs(n-2));
        return this.cache.get(n);
    }
}
