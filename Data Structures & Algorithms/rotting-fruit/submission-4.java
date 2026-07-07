class Solution {

    class Coordinate{
        int r;
        int c;
        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rotCount = 0;
        int freshCount = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int minutes = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    freshCount++;
                }
                else if (grid[i][j] == 2){
                    queue.offer(new Coordinate(i,j));
                    visited[i][j] = 1;
                    rotCount++;
                }
            }
        }
        if (rotCount == 0 && freshCount == 0){
            return 0;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            int rotC = 0;
            for (int i = 0; i < size; i++){
                Coordinate c = queue.poll();
                for (int[] d: directions){
                    int nr = c.r + d[0];
                    int nc = c.c + d[1];
                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc] == 1 || grid[nr][nc] == 0){
                        continue;
                    }
                    queue.offer(new Coordinate(nr,nc));
                    visited[nr][nc] = 1;
                    freshCount--;
                    rotCount++;
                    grid[nr][nc] = 2;
                    rotC++;
                }
            }
            if (rotC > 0){
                minutes++;
            }
            if (freshCount == 0){
                return minutes;
            }
        }
        return -1;
        
    }
}
