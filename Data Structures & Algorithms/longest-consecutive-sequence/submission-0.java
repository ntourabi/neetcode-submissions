class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        // Find out what our smallest number is, and create a HashSet for constant lookup time.

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        //Set.of(int[]) doesn't work because generics don't work with primitives
        // and Set.of() expects some number of generic type E params.

        // Start with the smallest as N, and ask if our hashset contains N+1.
        // If it does, we set N = N+1 and reask and increment a consecutive counter.
        // If it doesn't, we check for a new highest consecutive, reset the counter, and find the next smallest number. 


        //N is the start of a sequence if the set contains N+1 and does not contain N-1.

        Set<Integer> starters = new HashSet<>();
        for (int n: nums) {
            if (numSet.contains(n+1) && !numSet.contains(n-1)) starters.add(n);
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
