class Solution {
    public int countPaths(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        return this.visitor(visited, grid, 0, 0);
    }
    
    public int visitor(int[][] visited, int[][] matrix, int r, int c){
        if(r<0 || c < 0 || r>= matrix.length || c>= matrix[0].length || visited[r][c] == 1 || matrix[r][c] == 1){
            return 0;
        }
        if (r == matrix.length - 1 && c == matrix[0].length - 1){
            return 1;
        }
        visited[r][c] = 1;
        int count = 0;
        count += visitor(visited, matrix, r, c+1);
        count += visitor(visited, matrix, r+1,c);
        count += visitor(visited, matrix, r, c-1);
        count += visitor(visited, matrix, r-1, c);
        visited[r][c] = 0;
        return count;
    }

}
