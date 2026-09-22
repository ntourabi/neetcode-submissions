class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //return solution1_bruteForce(temperatures);
        return solution2_MonotonicDecreasingStack(temperatures);
    }

    record Pair(int temperature, int index) {};

    public int[] solution2_MonotonicDecreasingStack(int[] temperatures) {
        Stack<Pair> stack = new Stack();
        int[] results = new int[temperatures.length];
        Arrays.fill(results, 0);
        for (int i = 0; i < temperatures.length; i++) {
            
            while (!stack.isEmpty() && temperatures[i] > stack.peek().temperature()) {
                Pair t_i = stack.pop();
                results[t_i.index()] = i - t_i.index();
            }
            stack.push(new Pair(temperatures[i], i));
        }
        return results;
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
