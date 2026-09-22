class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int nextptr2 = 1;
        for (int ptr1 = 0; ptr1 < numbers.length; ptr1++) 
        {
            for (int ptr2 = nextptr2; ptr2 < numbers.length; ptr2++) 
            {
                if (numbers[ptr1] + numbers[ptr2] == target) return new int[]{ptr1+1, ptr2+1};
            }
            nextptr2++;
        }
        return null; //since theres always a valid solution, this should never happen
    }
}
