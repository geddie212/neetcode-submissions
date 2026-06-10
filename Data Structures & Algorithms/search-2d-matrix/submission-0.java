class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int l = 0;
        int r = matrix[0].length - 1;
        while (row < matrix.length){
            while (l <= r){
                int mid = (l + r)/2;
                if (matrix[row][mid] == target){
                    return true;
                }
                else if (matrix[row][mid] < target){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            row++;
            l = 0;
            r = matrix[0].length - 1;
        }
        return false;
    }
}
