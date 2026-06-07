class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] arr = new int[k][2];
        mergeSort(points, 0 , points.length - 1);
        for (int i = 0; i < k; i++){
            arr[i] = points[i];
        }
        return arr;
    }

    public int[][] mergeSort(int[][] points, int l, int r){
        if (l < r){
            int slow = l;
            int fast = l;
            double pivotVal = Math.sqrt(Math.pow(points[r][0], 2) + Math.pow(points[r][1],2));
            while (fast < r){
                double curr = Math.sqrt(Math.pow(points[fast][0], 2) + Math.pow(points[fast][1], 2));
                if(curr < pivotVal){
                    int[] temp = points[slow];
                    points[slow] = points[fast];
                    points[fast] = temp;
                    slow++;
                }
                fast++;
            }

            int[] temp = points[slow];
            points[slow] = points[r];
            points[r] = temp;

            mergeSort(points, l, slow - 1);
            mergeSort(points, slow + 1, r);

            return points;
        }

        return points;
    }
}
