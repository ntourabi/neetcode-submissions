class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return solution1_bruteForce(temperatures);
    }

    public int[] solution1_bruteForce(int[] temperatures) {
        int[] results = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int jOfBiggest = -1;
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    jOfBiggest = j;
                    break;
                }
            }
            if (jOfBiggest == -1) {
                results[i] = 0;
            } else {
                results[i] = jOfBiggest - i;
            }
            
        }
        return results;
    }
}
