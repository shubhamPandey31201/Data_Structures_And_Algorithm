// time complexity will be O(nlogn) when sorting is done
// question requires the minimum number of platform required for the given array of arrival and departure time
// here minimum of platform will be equal to the maximum number of train in the sation at a particular time
// so we will calculate maximum number of train at a particular time and that will be our answer
// first we will sort both the at and dt array
// when keep i pointer to the first element of at and j pointer to the first element of the dt
// then we check for each departure time how many train has lesser arrival time
// if above condition exist that means trainCount will be increased and i++
// else platform will be release then traincount will be decreased and will check for another departure time j++

import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        // sorting arrays
        Arrays.sort(at);
        Arrays.sort(dt);

        int i=0;// pointer for at array
        int j=0;// pointer for dt array
        int trainCount=0;// current trainCount
        int maxTrainCount=Integer.MIN_VALUE; // ans
        
        
        while(i<n && j<n){ // when either of the train reaches to end it should stop
            if(dt[j]>=at[i]){ // when arrival time is lesser than departure time that means a free platform is required for that departure time
                trainCount++; 
                i++; // checking for the arrival of another train
            }
            else{
                // checking for other departure time
                j++; // when departure time is greater than arrival time that means a platform will be free 
                trainCount--;   // so train count is decremented

            }
            maxTrainCount=Math.max(trainCount,maxTrainCount);// updating maxTrainCount every time with currentTrainCount
            

        }
        return maxTrainCount;
    }
}