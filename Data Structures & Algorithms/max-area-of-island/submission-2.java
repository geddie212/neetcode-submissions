class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        HashSet<Integer> nums = new HashSet<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                nums.add(maxArea(i,j,grid,visited));
            }
        }
        Integer max = null;
        for (int i : nums){
            if(max == null){
                max = i;
            }
            else if (i>max){
                max = i;
            }
        }
        if (max==null){
            return 0;
        }
        return max;
    }
    public int maxArea(int r, int c, int[][]grid, int[][]visited){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||visited[r][c]==1||grid[r][c]==0){
            return 0;
        }
        visited[r][c] = 1;
        return 1 + maxArea(r,c+1,grid,visited) + maxArea(r+1,c,grid,visited) + maxArea(r,c-1,grid,visited) + maxArea(r-1, c, grid, visited);
    }
}
