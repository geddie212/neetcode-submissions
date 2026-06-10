class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rt = 0;
        int rb = matrix.length - 1;
        int rc = 0;

        while (rt <= rb){
            int mid = (rt+rb)/2;
            System.out.println("rt: "+rt);
            System.out.println("rb: "+ rb);
            System.out.println("[mid][0]: "+matrix[mid][0]);
            System.out.println("matrix[mid][matrix[0].length - 1]: "+matrix[mid][matrix[0].length - 1]);
            System.out.println("Target: "+target);
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]){
                System.out.println("Mid: "+mid);
                rc = mid;
                break;
            }
            else if (matrix[mid][0] > target){
                rb = mid - 1;
            }
            else {
                rt = mid + 1;
                
            }
        }

        if (rt > rb){
            System.out.println("False for some reason");
            return false;
        }

        int l = 0;
        int r = matrix[0].length - 1;
        while (l <= r){
            int mid = (l + r)/2;
            System.out.println("after loop matrix[rc][mid]:"+matrix[rc][mid]);
            System.out.println("target:"+target);
            if (matrix[rc][mid] == target){
                return true;
            }
            else if (matrix[rc][mid] < target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return false;
    }
}
