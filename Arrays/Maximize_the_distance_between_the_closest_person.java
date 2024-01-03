//Time complexity is O(n)
//when have been given array of seats where 1 represent seat is occupied and 0 represent seat is unoccupied
//now we have to return the maximum distance when a new person is give to seat  between his closest person
// there will be three case
// first when first seat is empty 
// when last seat is empty
// in middle of two occupied seat 
// will find the distance for each case 
// whichever will be maximum will be the answer
class Solution {
    public int maxDistToClosest(int[] seats) {
        int i=0;
        int j=1;// for segmenting between two occupied seats j will traverse 
        // between i and j there will be empty seats
        int n=seats.length;
        int resultDistance=Integer.MIN_VALUE;
        int count=0;

        while(j<n){
            while(j<n-1 && seats[j]==0){ // n-1 because last seat will checked if it is occupied or not
                j++;
            }
            if(seats[j]==0){ // if last seat is empty
                count=j-i;
                
                
            }
            if(seats[i]==0){// if first seat is empty
                count=j-i;
                
               
            }
            else if(seats[i]==1 && seats[j]==1){ // middle seat will maximize the answer
                count=(j-i)/2;
                
            }
            resultDistance=Math.max(resultDistance,count);
            // shifting for next segment
            i=j;
            j++;




        }
        return resultDistance;
        
        
    }
}