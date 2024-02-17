//Time complexity is O(n)
// make a 2d array position and Time if double type
//initialize the value in array by calculating time 
// calculating time is remaning distance/ speed gives the time
// then sorting 2d array based on position using comparator
//no after sorting we start from last to check the number of fleet
// condition of making is fleet is current car reaching time should be <= previous car reaching time
// if it does not satisfy increase the fleet count also update the previous reaching time with current Reaching time 


class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] positionAndTime = new double[n][2];// 2d array that contains posistino of car and its time to reach the target
        for (int i = 0; i < n; i++) {
            positionAndTime[i][0] = position[i] * 1d; // position is given in the array
            positionAndTime[i][1] = (target - position[i] * 1d) / speed[i];// calculating time to reach the target
            // remaning distance/ speed gives the time
        }
        Arrays.sort(positionAndTime, (a, b) -> (Double.compare(a[0], b[0]))); // then sort the 2d array based upon the position of the array
        int numOfFleet = 1;// initialise carFleet as 1
        double forwardSpeed = positionAndTime[n - 1][1]; // it is equal to the time of last car
        for (int i = n - 2; i >= 0; i--) {
            if (forwardSpeed < positionAndTime[i][1]) { // if previous car speed is faster than current car that means it cant make a fleet 
            // that is when another fleet is formed 
                numOfFleet++;
                forwardSpeed = positionAndTime[i][1];// update with current car time 

            }

        }
        return numOfFleet;

    }
}