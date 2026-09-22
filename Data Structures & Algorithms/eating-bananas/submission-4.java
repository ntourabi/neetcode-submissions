class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return solution2_binarySearch(piles, h);
    }

    //If you plot hours taken against rate for a fixed int[] piles, you'll see an asymptotic curve.
    //At piles.length, the hours taken never changes (flattened curve).
    //H can never go below piles.length.

    //k will be between 1 and max(piles.length).

    public int solution2_binarySearch(int[] piles, int h) {
        int kLow = 1;
        int kHigh = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > kHigh) kHigh = piles[i];
        }
        int bestK = kHigh;

        while (kLow <= kHigh) {
            int kMid = (kLow + kHigh) / 2;
            System.out.println("kLow="+Integer.toString(kLow)+", kHigh="+Integer.toString(kHigh)+", kMid="+Integer.toString(kMid));
            long hoursTaken = 0;
            for (int i = 0; i < piles.length; i++) {
                hoursTaken += piles[i] / kMid; //How many hours to eat this pile without remainder?
                if (piles[i] % kMid != 0) hoursTaken++; //Add an hour if eating any remainder.
            }
            System.out.println("k="+Integer.toString(kMid)+" took in total: "+Long.toString(hoursTaken));
            if (hoursTaken <= h) {
                kHigh = kMid-1;
                bestK = kMid;
                System.out.println("Took less time than h. Can we make a slower k rate work?");
            } else {
                kLow = kMid+1;
                System.out.println("We took too long. Pick a faster k rate.");
            }
        }
        return bestK;
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
