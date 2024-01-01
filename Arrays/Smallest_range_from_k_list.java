// time complexity will be O(nm) // this is like linear only cause we just have to traverse all element only once since it is 2d array time complexity is O(n)
// this is one of the toughest question
// we need to return a range that is min such that atleast one element from each list should fall into that range
//first we make a min priority queue
// we add all first elements of the list , their index and list index in the priority queue
// we update max every time with the element we add in the queue
// initially our ans range will be -100000 to 100000 according to the constraint in the given question
// then we take the min element from the queue
// check if the difference between the min and max is lesser than ranges in the ans or not
// if its lesser than ans is updated with min value and max value
// after that in list that contained min element of the queue the index of min element is increased and next to min element is added in the queue
// adding new element also required comparing with max element
// and this process is continued until either of any three list is exhausted
// return the ans

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heapElements= new PriorityQueue<>((a,b)->(a[0]-b[0])); // min heap priority queue
        int max=Integer.MIN_VALUE;
        int[] ans={-100000,100000}; // largest range according to question
        for(int i=0;i<nums.size();i++){
            int firstElementOfEachList=nums.get(i).get(0); // ejecting all first element of the list
        
            int[] minHeapRecord={firstElementOfEachList,0,i}; // 1st index contains the index of the elements in the respective list and 2nd index consist the index of the list
            heapElements.add(minHeapRecord);
            max=Math.max(max,firstElementOfEachList); // finding max of current element and max itself
        }
        while(true){
            int [] min=heapElements.poll(); // ejecting min element data from the queue
            if(max-min[0]<ans[1]-ans[0]){ // checking if max-min range is smaller than current ans range
                ans[0]=min[0];
                ans[1]=max;
            }
            min[1]++; // increasing the index in the list containing min element
            List<Integer> currentList= nums.get(min[2]); // ejecting the list containing min element
            if(min[1]==currentList.size()){ // break with index is equal to either of the list 

                break;
            }
            min[0]=nums.get(min[2]).get(min[1]); // adding next min to array
            max=Math.max(max,min[0]);// since new min element is about to be added it is compared with max value
            heapElements.add(min); // adding min array to the queue
            
            
        }
        return ans;
    }
}