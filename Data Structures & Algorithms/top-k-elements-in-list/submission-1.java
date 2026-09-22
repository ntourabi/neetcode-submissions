class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] visited = createVisitedArray(k);
        int v_ptr = 0; //next available space. if v_ptr == visited.length then it is full.
        HashMap<Integer, Integer> hm = generateHM(nums);
        
        for (int i = 0; i < k; i++) { //check the next most frequent k times.
            int biggestNum = -9999; //what we currently believe to be the biggest number for loop i.
            int frequency = -1; //the frequency of that biggest number for loop i.
            for (Integer key : hm.keySet()) {
                if (arrayContains(visited, key)) {
                    continue;
                }
                if (hm.get(key) > frequency) {
                    biggestNum = key;
                    frequency = hm.get(key);
                }
            }
            visited[v_ptr] = biggestNum;
            v_ptr++;
        }

        return visited;
    }

    public int[] createVisitedArray(int k) {
        int[] visited = new int[k];
        for (int i = 0; i < k; i++) {
            visited[i] = -9999;
        }
        return visited;
    }

    public boolean arrayContains(int[] arr, int query) {
        for (int item : arr) {
            if (item == query) return true;
        }
        return false;
    }

    public HashMap<Integer, Integer> generateHM(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        System.out.println(hm);
        return hm;
    }
}
