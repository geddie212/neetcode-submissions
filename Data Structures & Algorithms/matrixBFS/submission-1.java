class Solution {
    class Coordinate{
        int r;
        int c;
        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int shortestPath(int[][] grid) {
        int[][] visited = new int [grid.length][grid[0].length];
        Queue<Coordinate> queue = new LinkedList<>();
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int length = 0;
        queue.offer(new Coordinate(0,0));
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Coordinate c = queue.poll();
                if (c.r == grid.length - 1 && c.c == grid[0].length - 1){
                    return length;
                }
                for (int[] d : direction){
                    if (c.r + d[0] < 0 || c.c + d[1] < 0 || c.r + d[0] >= grid.length || c.c + d[1] >= grid[0].length || visited[c.r+d[0]][c.c+d[1]] == 1
                    || grid[c.r+d[0]][c.c+d[1]] == 1){
                        continue;
                    }
                    queue.offer(new Coordinate(c.r + d[0],c.c + d[1]));
                    visited[c.r + d[0]][c.c + d[1]] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}
