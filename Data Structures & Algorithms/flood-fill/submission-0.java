class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        return filler(image, visited, sr, sc, oc, color);
    }

    public int[][] filler(int[][] image, int[][] visited, int r, int c, int oc, int color){
        System.out.println("Row"+r);
        System.out.println("Image row count:"+image.length);
        System.out.println("Col"+c);
        System.out.println("Image col count:"+image[0].length+"\n");


        if(r>=0 && c>=0 && r<image.length && c<image[0].length && visited[r][c]==0 && image[r][c]==oc){
            image[r][c] = oc;
            visited[r][c] = 1;
            image[r][c] = color;
            image = filler(image, visited, r, c+1, oc, color);
            image = filler(image, visited, r+1,c,oc, color);
            image = filler(image, visited, r, c-1, oc, color);
            image = filler(image, visited, r-1,c,oc, color);
            return image;
        }
        else{
            return image;
        }
    }
}