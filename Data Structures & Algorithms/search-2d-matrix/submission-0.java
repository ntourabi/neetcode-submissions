class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = matrix.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (TargetInArrayRange(matrix[mid], target) && ArrayHasTarget(matrix[mid], target)) return true;
            else if (matrix[mid][0] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }


    public boolean ArrayHasTarget(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public boolean TargetInArrayRange(int[] arr, int target) {
        return (arr[0] <= target && target <= arr[arr.length-1]);
    }

    //two stage binary search
    // - perform binary search on outer array.
    // - inner array chosen as mid. 
    // - we know mid contains target if inner[0] <= target <= inner[inner.length-1]
    // - binary search inner array.
}
