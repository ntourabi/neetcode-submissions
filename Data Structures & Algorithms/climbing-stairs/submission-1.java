class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        return climbAux(n, hm);
    }

    public int climbAux(int n, HashMap<Integer, Integer> hm) {
        if (n <= 2) return n;
        if (hm.containsKey(n)) return hm.get(n);
        int rec = climbAux(n-1, hm) + climbAux(n-2, hm);
        hm.put(n, rec);
        return rec;
    }
}
