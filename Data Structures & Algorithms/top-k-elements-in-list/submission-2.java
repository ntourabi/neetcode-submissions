class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int n : nums) {
            if (frequencies.containsKey(n)) frequencies.put(n, frequencies.get(n)+1);
            else frequencies.put(n, 1);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int numWithBiggestF = -1001;
            int biggestF = -1;
            for (Integer num : frequencies.keySet()) {
                int freq = frequencies.get(num);
                if (freq > biggestF) {
                    biggestF = freq;
                    numWithBiggestF = num;
                }
            }
            frequencies.remove(numWithBiggestF);
            result[i] = numWithBiggestF;
        }

        return result;
    }
}
