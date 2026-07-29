class NumMatrix {

    int[][] pre;

    public NumMatrix(int[][] matrix) {
        this.pre = new int[matrix.length][matrix[0].length];
        int total = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i-1 >= 0 && j - 1 >= 0){
                    this.pre[i][j] = matrix[i][j] + this.pre[i-1][j] + this.pre[i][j-1] - this.pre[i-1][j-1];
                }
                else if(i-1 < 0 && j-1 >= 0){
                    this.pre[i][j] = matrix[i][j] + this.pre[i][j-1];
                }
                else if(j-1 < 0 && i -1 >= 0){
                    this.pre[i][j] = matrix[i][j] + this.pre[i-1][j]; 
                }
                else{
                    this.pre[i][j] = matrix[i][j];
                }  
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int out = this.pre[row2][col2];
        if (row1 - 1 >= 0 && col1 - 1 >= 0){
            return out - this.pre[row1 - 1][col2] - this.pre[row2][col1 - 1] + this.pre[row1 - 1][col1 - 1];
        }
        else if (row1 - 1 < 0 && col1 - 1 >= 0){
            return out - this.pre[row2][col1-1];
        }
        else if (col1 - 1 < 0 && row1 - 1 >= 0){
            return out - this.pre[row1-1][col2];
        }
        else{
            return out;
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */