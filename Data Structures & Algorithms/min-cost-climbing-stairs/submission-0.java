class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = recursive(cost, 0);
        int b = recursive(cost, 1);
        if (a > b) return b;
        else return a;
    }

    public int recursive(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        } else if (i == cost.length - 1) {
            return cost[i];
        } else {
            int a = recursive(cost, i+1);
            int b = recursive(cost, i+2);
            if (a > b) return (b + cost[i]);
            else return (a + cost[i]);
        }
    }
}
