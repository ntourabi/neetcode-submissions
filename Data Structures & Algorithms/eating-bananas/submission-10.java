class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        //We have a number of hours h.
        //What's the minimum eating speed that finishes all bananas in h?

        //Start from the fastest rate possible
        // which gives us the minimum hours (piles.length).
        int minRate = 1;
        int maxRate = -1;
        for (int p : piles) {
            maxRate = Math.max(p, maxRate);
        }

        //Now we see how far we can decrease the rate
        // while keeping calculated hours <= h. 
        // h = f(r)
        // piles.length <= h <= 1,000,000,000
        // 1 <= rate <= max(piles)
        // So our lower is 1, and our upper is max(piles).
        // We then search for the smallest rate while (calcH <= h).
        int lastValid = maxRate;
        while (minRate <= maxRate) {
            int midRate = (minRate + maxRate) / 2;
            long dh = eat(piles, midRate); //How many hours did our midrate take us
            if (dh <= h) {
                lastValid = midRate;
                maxRate = midRate - 1; //Met the deadline.
            } else if (dh > h) minRate = midRate + 1; //Ate too slow? Incr.
        }

        return lastValid;
    }

    //Returns hours taken to eat piles[] at given rate.
    private long eat(int[] piles, int rate) {
        long hours = 0;
        for (int p : piles) {
            hours += p / rate;
            if (p % rate != 0) hours++;
        }
        return hours;
    }
}
