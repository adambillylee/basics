import java.util.Random;

public class RandomNumberWithArbitraryDistr {
    int randomWithGivenDistr(int nums[], int dist[], Random ran) {
        int sumDist[] = new int[dist.length];
        sumDist[0] = dist[0];

        for (int i = 1; i < dist.length; i++) {
            sumDist[i] = sumDist[i - 1] + dist[i];
        }

        // get random number from 1 to largest sum of dist
        int rand = ran.nextInt(sumDist[dist.length-1]) + 1;

        // do a binary search, look for index of closest ceiling of random number in dist sum
        int index = findCeilIndex(sumDist, rand, 0, sumDist.length - 1);

        // use index to get number
        return nums[index];
    }


    private int findCeilIndex(int[] sumDist, int rand, int start, int end) {
        int mid = start + (end - start) / 2;

        while (start + 1 < end) {
            if (rand > sumDist[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (rand <= sumDist[start]) {
            return start;
        } else {
            return end;
        }
    }
}
