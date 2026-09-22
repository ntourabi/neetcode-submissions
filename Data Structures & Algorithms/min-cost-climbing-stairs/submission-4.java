class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = recursive(0, cost, new HashMap<>());
        int b = recursive(1, cost, new HashMap<>());
        if (a > b) return b;
        else return a;
    }

    public int recursive(int i, int[] cost, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        if (i >= cost.length) return 0;
        int a = recursive(i+1, cost, memo);
        int b = recursive(i+2, cost, memo);
        if (a > b) memo.put(i, cost[i] + b);
        else memo.put(i, cost[i] + a);
        return memo.get(i);
    }
}
