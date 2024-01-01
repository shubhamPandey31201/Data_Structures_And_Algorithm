// this question can be solve by applying logic of two sum
// time complexity is O(n)
// this question simply ask the number of boats required to rescue people 
// where array of people weight is given and limit is given that a boat can hold
// and a boat can only hold atmost of 2 people 
// steps to follow is 
// first sort the array
// take i pointer to the start of the array 
// take j pointer to the end of the array
// calculate sum if element at ith and jth index
// check if sum is <= limit then increase the count and increase i and decrease j pointer
// if sum>limit increse boat and decrease j

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // first sort the array
        int i=0;
        int j=people.length-1;
        int boatCount=0;
        while(i<=j){
            int sum=people[i]+people[j]; // sum of highest and lowest weight people
            if(sum<=limit){ // when two people can be added
                boatCount++;
                i++;
                j--;

            }
            else{
                boatCount++; // when only one people can be added 
                j--;        // people having highest weight can be only be added
            }

        }
        return boatCount;
        
    }
}