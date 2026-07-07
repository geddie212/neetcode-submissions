class Solution {
    class Coordinate{
        int r;
        int c;
        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1){
            return -1;
        }
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Coordinate> queue = new LinkedList<>();
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        queue.offer(new Coordinate(0,0));
        visited[0][0] = 1;
        int length = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size ; i++){
                Coordinate c = queue.poll();
                if (c.r == grid.length - 1 && c.c == grid[0].length - 1){
                    return length;
                }
                for (int[] d: directions){
                    int nr = c.r + d[0];
                    int nc = c.c + d[1];
                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc] == 1 || grid[nr][nc] == 1){
                        continue;
                    }
                    queue.offer(new Coordinate(nr,nc));
                    visited[nr][nc] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}