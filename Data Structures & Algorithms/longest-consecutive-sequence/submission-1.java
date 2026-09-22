class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        //Set.of(int[]) doesn't work because generics don't work with primitives
        // and Set.of() expects some number of generic type E params.

        //N is the start if nums does not contain N-1. 

        Set<Integer> starters = new HashSet<>();
        for (int n: nums) {
            if (!numSet.contains(n-1)) starters.add(n);
        }

        int biggest = 0;
        for (int s : starters) {
            int sx = s;
            int i = 0;
            while (numSet.contains(sx)) {
                sx++;
                i++;
            }
            if (i > biggest) biggest = i;
        }
        return biggest;
    }
}
