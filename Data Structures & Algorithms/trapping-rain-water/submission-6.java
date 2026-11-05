// Three types: empty, water, bar.
// The elevation map technically is a 2D grid.
// Whether a cell is empty/water tells us if it can be occupied.
// What defines a cell that can be occupied by water?
// Cells are water if a bar cell can eventually be reached moving to the left and to the right.
class Solution {
    public int trap(int[] height) {
        //Find maximum column to the LEFT of every column
        int[] maxToLeft = new int[height.length];
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            maxToLeft[i] = maxHeight;
            maxHeight = Math.max(height[i], maxHeight);
        }

        //Find maximum column to the RIGHT of every column
        int[] maxToRight = new int[height.length];
        maxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxToRight[i] = maxHeight;
            maxHeight = Math.max(height[i], maxHeight);
        }

        //Select minimum height for each one. 
        int[] heightDiffs = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            heightDiffs[i] = Math.min(maxToLeft[i], maxToRight[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            totalWater += Math.max(heightDiffs[i] - height[i], 0);
        }
        
        return totalWater;
    }

    public int solution1(int[] height) {
        int totalWater = 0;
        //Which row of blocks we are examining (0-indexed)
        int elevation = 0;
        int maxElevation = 0;
        for (int h : height) {
            maxElevation = Math.max(maxElevation, h);
        }

        for (int h = 0; h < maxElevation; h++) {
            int water = totalWaterAtElevation(height, h);
            //System.out.println("Water at h=" + h + ": " + water);
            totalWater += water;
        }

        return totalWater;
    }

    private int totalWaterAtElevation(int[] height, int elevation) {
        int totalWater = 0;
        //The difference between these two will tell us the amount of water that can be used. 
        int x_left = 0; 
        int x_right = 0;
        boolean measuring = false;
        //Two states: Finding a body of water to measure, OR measuring a body of water.
        //The first cells on the left are always either empty or cell, because of the edge of the array.
        while (x_left < height.length) {
            if (!measuring) { //We're trying to find our first bar cell. 
                if (height[x_left] > elevation) { //If our current xy is a bar cell.
                    measuring = true;
                    x_right = x_left + 1;
                    //System.out.println("Found bar cell at x=" + x_left);
                }
                x_left++;
            } else {
                while (x_right < height.length && height[x_right] <= elevation) {
                    x_right++;
                }
                if (x_right < height.length) {
                    measuring = false;
                    int body = Math.max((x_right - x_left), 0);
                    totalWater += body;
                    //System.out.println("Found body of water, length=" + body);
                }
                x_left = x_right;
            }
        }

        return totalWater;
    }
}
