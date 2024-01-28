// time complexity is O(nlogn)
// applying merge sort algorithm
// we use recursion
// we first divide and then conquer by merging two array

class Solution {
    public static int[] mergeArr(int[] leftFirstHalf, int[] rightSecondHalf){
        int i=0;
        int j=0;
        int k=0;
        int [] result=new int[leftFirstHalf.length+rightSecondHalf.length];
        while(i<leftFirstHalf.length && j<rightSecondHalf.length){
            if(leftFirstHalf[i]<rightSecondHalf[j]){ // when element in lsa is smaller than element in Rsa 
                result[k]=leftFirstHalf[i];
                i++;
                k++;
            }
            else{ // when element in Rsa is smaller than element in Lsa 
                result[k]=rightSecondHalf[j];
                j++;
                k++;
            }
        }
        while(i<leftFirstHalf.length){ // when left array is not exhausted
            result[k]=leftFirstHalf[i];
            i++;
            k++;

        }
        while(j<rightSecondHalf.length){ // when right array is not exhausted
            result[k]=rightSecondHalf[j];
            j++;
            k++;

        }
        return result;
    }
    public static int[] mergeSort(int[] nums,int l,int r){
        if(l==r){ // when there is only one element 
            int [] a=new int[1];
            a[0]=nums[l];
            return a;
        }
        int mid=(l+r)/2;
        int [] leftFirstHalf=mergeSort(nums,l,mid);// left sorted half 
        int [] rightSecondHalf=mergeSort(nums,mid+1,r);// right sorted half
        int [] mergedArr=mergeArr(leftFirstHalf,rightSecondHalf); // merging both half
        return mergedArr;

    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int [] finalResult=mergeSort(nums,l,r);
        return finalResult;
        
    }
}