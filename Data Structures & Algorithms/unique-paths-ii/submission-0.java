class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        for (int r = rows - 1; r >= 0;r--){
            for (int c = cols - 1; c >= 0; c--){
                if (c == cols - 1 && r == rows - 1 && obstacleGrid[r][c] == 0){
                    paths[r][c] = 1;
                }
                else if (obstacleGrid[r][c] == 1){
                    paths[r][c] = 0;
                }
                else if (r+1>=rows){
                    paths[r][c] += paths[r][c+1];
                }
                else if (c+1>=cols){
                    paths[r][c] += paths[r+1][c];
                }
                else{
                    paths[r][c] += paths[r+1][c];
                    paths[r][c] += paths[r][c+1];
                }
            }
        }
        return paths[0][0];
    }
}