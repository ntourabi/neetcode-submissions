class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row = locateRow(matrix, target);
        if (row == null) return false;
        return binarySearch(row, target);
    }

    public boolean binarySearch(int[] row, int target) {
        int lo = 0;
        int hi = row.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (row[mid] == target) return true;
            else if (row[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

    public int[] locateRow(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int n1 = matrix[mid][0];
            int n2 = matrix[mid][matrix[mid].length - 1];
            if (n1 <= target && target <= n2) return matrix[mid];
            else if (target > n2) lo = mid + 1;
            else hi = mid - 1;
        }
        return null;
    }
}
