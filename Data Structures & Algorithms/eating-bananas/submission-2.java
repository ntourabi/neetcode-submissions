class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return solution1_bruteForce(piles, h);
    }

    public int solution1_bruteForce(int[] piles, int h) {
        int k = 1; //start with a rate of 1.
        while (true) {
            System.out.println("k=" + Integer.toString(k) + "##########################");
            long hoursForCurrentK = 0;
            for (int i = 0; i < piles.length; i++) {
                hoursForCurrentK += (piles[i] / k); //add an hour for each pile eaten
                System.out.println(Long.toString(piles[i]) + " took this many hours: " + Long.toString(piles[i] / k));
                if (piles[i] % k != 0) hoursForCurrentK++; //add one hour if eating any remainder.
                System.out.println("Added hour for remainder?:" + Boolean.toString(piles[i] % k != 0));
            }
            if (hoursForCurrentK <= h) return k;
            k++;
        }
    }
}
