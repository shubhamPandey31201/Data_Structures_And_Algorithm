//time complexity is O(N)
// In this question we need to find the median number from the given data Stream
// here for odd size the middle element in sorted array will be median
// and for even size the median will be the sum of two middle element divided by 2
// to solve this problem we make two heap 
// one is left max heap // top element is max 
// and other is right min heap // top element is min
// first step is to check if left max heap is empty or not if yes add num to left max heap 
// if not then check if current num is smaller than top of left max heap or not 
// if yes add it to left max heap 
// else add it to right min heap 
// after adding we need to manage the size of both heap 
// where leftmax heap should not be less than right min heap 
// also right min heap + 1 should not be < left max heap size
// if so manage the size by tranfering the element from one heap to another 
// at last check for even size and odd size of the element and return the median accordingly

class MedianFinder {
    Comparator<Integer> max=new Comparator<>(){ // comparator object for descending order (max heap)
        public int compare(Integer a,Integer b){
            if(a<b){
                return 1;
            }
            return -1;
        }

    };
    Comparator<Integer> min=new Comparator<>(){ // comparator object for ascending order (min heap)
        public int compare(Integer a,Integer b){
            if(a>b){
                return 1;
            }
            return -1;
        }

    };
    
    PriorityQueue<Integer> leftMaxHeap=new PriorityQueue<>(max);
    PriorityQueue<Integer> rightMinHeap=new PriorityQueue<>(min);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

        if(leftMaxHeap.size()==0 || leftMaxHeap.peek()>=num ){ // when heap is empty or current num is less than top of leftmaxheap add num to the leftMaxheap
            leftMaxHeap.add(num);
        }
        else {
            rightMinHeap.add(num); // else add it to rightminHeap
        }
        
        
        if(leftMaxHeap.size()<rightMinHeap.size()){ // leftMaxHeap is less then rightmin heap transfer top of rightMinheap to leftMaxheap to balance size
            leftMaxHeap.add(rightMinHeap.poll());

        }
        else if(rightMinHeap.size()+1<leftMaxHeap.size()){ // incase of off element leftMaxHeap can be greater in size by one in comparison with rightMinheap but not more than one . if so than transfer top element of leftMaxHeap to right min heap
            rightMinHeap.add(leftMaxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        
        if(leftMaxHeap.size()==rightMinHeap.size()){ // even number of element
            return (leftMaxHeap.peek()+rightMinHeap.peek())/2.0;
        }
        return leftMaxHeap.peek()*1.0; // odd number of elements
        

        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */