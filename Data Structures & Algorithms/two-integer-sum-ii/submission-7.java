class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            int result = numbers[l] + numbers[r];
            if (result > target) r--;
            else l++;
        }
        l++;
        r++;
        return new int[]{l, r};
    }
}
