// similar to capacity to ship package
//Time complexity is O(nlogn)
//we need to find  the minimum sum  to divide into k Subarray
// whenever minimization problem comes think of binary search first
// here  since 1<=k<=nums.length
// so for low value will be the maximum sum in the array for k subarrays
// and high will be the sum of array for 1 days
// we calculate mid each time 
// for each mid(temp limit) value we calculate k subarrays if calculated subarrays is greater then low=mid-1 else mid+1
import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int max=Integer.MIN_VALUE;
        int sum=0;
        // finding max and sum of array
        for(int i=0;i<boards.size();i++){
            sum+=boards.get(i);
            max=Math.max(max,boards.get(i));
        }
        int low=max;
        int high=sum;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            int tempK=1;
            sum=0;
            // calculating tempK 

            for(int i=0;i<boards.size();i++){
                if(sum+boards.get(i)>mid){
                    tempK++;
                    sum=boards.get(i);
                }
                else{
                    sum+=boards.get(i);
                }
            }

            if(tempK<=k){
                ans=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
}