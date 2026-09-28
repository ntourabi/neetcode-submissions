class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int totalWater = 0;

        for (int left = 0; left < height.length; left++) {
            int level = height[left];
            //Count number of water blocks.
            while (level > 0) {
                int right = left + 1;
                int waterRow = 0;
                while (right < height.length && height[right] < level) {
                    waterRow++;
                    right++;
                }
                if (right == height.length) waterRow = 0;
                totalWater += waterRow;
                level--;
            }
        }

        return totalWater;
    }
}
