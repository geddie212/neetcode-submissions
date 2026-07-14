class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int r = m - 1; r >=0 ; r--){
            for (int c = n - 1; c >= 0; c--){
                if (r == m-1 && c == n-1){
                    paths[r][c] = 1;
                }
                else if (r + 1 >= m){
                    paths[r][c] += paths[r][c+1];
                }
                else if (c + 1 >= n){
                    paths[r][c] += paths[r+1][c];
                }
                else {
                    paths[r][c] += paths[r+1][c];
                    paths[r][c] += paths[r][c+1];
                }
            }
        }
        return paths[0][0];
    }
}
