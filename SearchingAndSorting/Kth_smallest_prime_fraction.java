//Time complexity is O(NlogN)
// here we need to find the k-th smallest prime fraction from the given sorted array 
// since  contraint is 1 <= k <= arr.length * (arr.length - 1) / 2 
// our low = be arr[0]/arr[n-1] and high=1 
// since arr[0] is smallest element and arr[n-1] is the largest element so fraction of these element will from the smallest fraction
// so we apply binary search between these range and find if count of fraction = k or not 
// if yes return the numerator and denumerator obtained
// if count<k low=mid;
// if count>k high=mid;

class Solution {
    public static int[] countNumeratorDenum(int[] arr, double mid){
        // there will be two pointer i and j 
        // initially i =0 and j=1 
        // initially j!=0 because arr[i]/arr[j]=1 
        // for calculating count we fix j and for each i we find the 
        //arr[i]/arr[j]<=mid which is also written as arr[i]<=mid*arr[j]

        
        int i=0;
        int count[]=new int[3];
        count[0]=0;// contains count of fration lesser or equal to mid
        count[1]=arr[0];//first element // numerator closer to mid
        count[2]=arr[arr.length-1];//last element // denumerator closer to mid
        for(int j=1;j<arr.length;j++){
            while(arr[i]<=arr[j]*mid){// when fraction i.e arr[i]/arr[j]<=mid we increase i
                i++;
            }
            count[0]+=i;// count is incremented
            // for next j the fration of current i-1 / j will automatically be smaller than mid 
            if(i>0 && arr[i-1]*count[2]>arr[j]*count[1]){// for calculating fration closer to mid 
// i.e arr[i-1]/arr[j]>count[1]/count[2] i.e arr[i-1]*count2>=arr[j]*count[1]
// if so update
                count[1]=arr[i-1];
                count[2]=arr[j];
            }


        }
        return count;
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        double low=arr[0]/arr[n-1];// smallest fraction
        double high=1; // according to constraint given fraction should not be greater than 1 
        while(low<=high){
            double mid=low+(high-low)/2;
            int[] count=countNumeratorDenum(arr,mid); // finding the number of fraction which is less than or equal to mid and Numerator and denumerator of a fration that is closest to the mid 
    // at count[0] contains count of fration less or equal to mid
    // count[1] contain the numerator of the fraction closest to the mid
    // count [2] countains the denumerator of the fraction closest to the mid
            if(count[0]<k){ // when count is lesser than k
                low=mid;
            }
            else if(count[0]>k){ // when count is greater than k
                high=mid;
            }
            else{ // when count == k , we obtained our answer and we return the numerator and denumerator of the fraction 
                int [] ans=new int[2];
                ans[0]=count[1]; // adding numerator to the answer
                ans[1]=count[2]; // adding denumerator to the answer
                return ans;
            }
        }
        return null;
        
        
    }
}