class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return solution2_binarySearch(numbers, target);
    }

    public int[] solution2_binarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Current index: " + i);
            int low = i+1;
            int high = numbers.length - 1;
            int searchValue = target - numbers[i];
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.println("Low: " + low + ". High: " + high + ". Mid: " + mid);
                if (numbers[mid] == searchValue) {
                    return new int[]{i+1, mid+1};
                } else if (searchValue < numbers[mid]) {
                    System.out.println("Bring high down to search below middle index");
                    high = mid - 1;
                    System.out.println("High is now: " + high);
                } else if (searchValue > numbers[mid]) {
                    System.out.println("Bring low up to search above middle index");
                    low = mid + 1;
                    System.out.println("Low is now: " + low);
                }
            }
        }
        throw new RuntimeException("Should not reach this.");
    } 

    public int[] solution1_bruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        throw new RuntimeException("We shouldn't reach this.");
    }

}
