class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] grid = new int[text1.length()][text2.length()];
        for (int r = 0; r < text1.length(); r++){
            for (int c = 0; c < text2.length(); c++){
                if(text1.charAt(r)==text2.charAt(c)){
                    if (r - 1 < 0 && c - 1 < 0){
                        grid[r][c] = 1;
                    }
                    else if(r - 1<0){
                        grid[r][c] = 1;
                    }
                    else if(c - 1<0){
                        grid[r][c] = 1;
                    }
                    else{
                        grid[r][c] = 1 + grid[r-1][c-1];
                    }
                }else{
                    if (r -1 < 0 && c-1 <0){
                        grid[r][c] = 0;
                    }
                    else if (r - 1< 0 ){
                        grid[r][c] = grid[r][c-1];
                    }
                    else if (c - 1 < 0){
                        grid[r][c] = grid[r-1][c];
                    }
                    else{
                        grid[r][c] = Math.max(grid[r-1][c],grid[r][c-1]);
                    }
                }
            }
        }
        return grid[grid.length-1][grid[0].length - 1];
    }
}
