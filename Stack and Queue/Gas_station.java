// Time complexity is O(n)
// this question ask if fuel is enough to cover all the stations or not and if it is possible from where do we start so that we can cover all the stations
// first we calculate total gas and total cost if total cost is > than total gas that means gas is not enough to cover entire stations
// so returned -1;
// for starting station 
//we maintain two vairable that is remaining gas and start 
// remaining gas contains sum of difference of gas and cost 
// if remaning gas is negative remaning gas is updated to zero and  start is i+1 index 
// 
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        // calculating total gas and total cost
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) { // checking if total cost is > than total gas or not 
            return -1;
        }
        int remainingGas = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            remainingGas += gas[i] - cost[i];// calculating remaning gas 
            // and whenever remaningGas is non zero we update remaning gas as 0 and start as i+1
            if (remainingGas < 0) {
                remainingGas = 0;
                start = i + 1;

            }

        }
        return start;

    }
}