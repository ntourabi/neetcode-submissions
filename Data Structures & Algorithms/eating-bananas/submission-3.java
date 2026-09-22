class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return solution1_bruteForce(piles, h);
    }

    public int solution1_bruteForce(int[] piles, int h) {
        int k = 1; //start with a rate of 1.
        while (true) {
            long hoursForCurrentK = 0;
            for (int i = 0; i < piles.length; i++) {
                hoursForCurrentK += (piles[i] / k); //add an hour for each pile eaten
                if (piles[i] % k != 0) hoursForCurrentK++; //add one hour if eating any remainder.
            }
            if (hoursForCurrentK <= h) return k;
            k++;
        }
    }
}
