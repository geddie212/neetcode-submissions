class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length;i++){
            for (int j=0; j< grid[0].length;j++){
                count += islandCount(grid,visited,i,j);
            }
        }
        return count;
    }
    public int islandCount(char[][] grid, int[][] visited, int r, int c){
        if(r<0||c<0||r>= grid.length||c>=grid[0].length||visited[r][c]==1||grid[r][c] == '0'){
            return 0;
        }
        visited[r][c]=1;
        islandCount(grid,visited,r,c+1);
        islandCount(grid,visited,r+1,c);
        islandCount(grid,visited, r, c-1);
        islandCount(grid,visited,r-1,c);
        return 1;
    }
}
