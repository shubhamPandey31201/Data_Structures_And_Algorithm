// time complexity is O(n.logn)
//we need to find  the minimum weight limit that can be transported in d days
// whenever minimization problem comes think of binary search first
// here  since 1<=days<=weights.length
// so for low value will be the maximum weight in the array for n days
// and high will be the sum of array for 1 days
// we calculate mid each time 
// for each mid(temp limit) value we calculate days if calculated days is greater then low=mid-1 else mid+1


class Solution {
    public static boolean daysCount(int []weight,int limit,int days){
        int dayCount=1;// every time count starts with 1
        int sum=0;
        // finding temp days count
        for(int e:weight){
            if(sum+e > limit){
                
                dayCount++;
                sum=e;

            }
            else{
                sum+=e;
            }

        }
        return dayCount<=days; // return true or false 
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;

        int sum=0;
        // finding sum and max
        for(int e:weights){
            max=Math.max(max,e);
            sum+=e;
        }
        if(days==weights.length){
            return max;
        }
        int low=max;
        int high=sum;
        int minWeight=0;
        while(low<=high){
            int mid=low+(high-low)/2; // handling overflow

            if(daysCount(weights,mid,days)==true){ // when tempDays<=days
                minWeight=mid;


                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return minWeight; 

        
    }
}