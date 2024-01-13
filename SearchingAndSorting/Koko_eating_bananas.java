//Time complexity is O(nlogn)
// this question is based upon rate 
//here piles.length <= h <=10^9
// therefore low=1 and high = max of array
// apply binary search between low and high 
// for each mid value find temp hours and check if temp hours <= h
// if temp hour<= h && tempHour >0 high=mid-1 
// else temp hour < h && tempHour<0 low=mid+1
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        // calculating max
        for (int n : piles) if (max < n) max = n;

        if (h == piles.length) return max; 
        while (min <= max) {
            int tempH = 0, mid = min+(max-min)/2; // calculating mid
            for (int n : piles) {
                // calculating temp hours
                // for calculating mid we should get ceil value of division

                tempH += n / mid;// it gives floor value
                if (n % mid > 0) tempH++; // for Math.ceil value  
                // for example 4/3 is 1.33 its ceil value will be 2 
                 // where 4/3 = 1 and since 4%3 >0 we increase it by 1 hence 2.
            }
            if (tempH <= h && tempH > 0) { // tempH>0 is imp
                max = mid - 1;
            } else if (tempH > h || tempH < 0) { // tempH<0 is imp
                min = mid + 1;
            }
        }
        return min;
    }
}