// Time complexity is O(N^2)
// This question we aim to turn into histogram question and solve the maximum area histogram
// to reduce it to histogram we add the value from previous row of the matrix
// but if the current value is 0 we don't add rather substitute it with 0 itself
// after each row traversal we call areaHistogram funtion to get the maximum area as of now
// at the end we travesed all the row and got the maximum area
// maximum area is returned
// since the matrix is given in char array
// we convert the values into int

class Solution {
    // largest rectangle problem(histogram problem) function
    public int areaHistogram(int[] heights,int n){
        int[] leftNextSmaller=new int[n];
        Stack<Integer> lst=new Stack<>();
        lst.push(0);
        leftNextSmaller[0]=-1;
        for(int i=1;i<n;i++){ // finding left smaller
            while(lst.size()>0 && heights[lst.peek()]>=heights[i]){
                lst.pop();
            }
            if(lst.size()==0){
                leftNextSmaller[i]=-1;
            }
            else{
                leftNextSmaller[i]=lst.peek();

            }
            lst.push(i);
        }
        int[] rightNextSmaller=new int[n];
        Stack<Integer> rst=new Stack<>();
        rst.push(n-1);
        rightNextSmaller[n-1]=n;
        for(int i=n-2;i>=0;i--){// finding large smaller
            while(rst.size()>0  && heights[rst.peek()]>=heights[i]){
                rst.pop();
            }
            if(rst.size()==0){
                rightNextSmaller[i]=n;
            }
            else{
                rightNextSmaller[i]=rst.peek();
            }
            rst.push(i);
        }
        int maxArea=0;

        for(int i=0;i<n;i++){// calculating maxArea
            int width=rightNextSmaller[i]-leftNextSmaller[i]-1;
            int length=heights[i];
            int area=width*length;
            maxArea=Math.max(maxArea,area);

        }
        return maxArea;
        

    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix[0].length;
        int[] rowHistogram=new int[n];
        for(int i=0;i<n;i++){// converting first row of matrix into histogram array
            rowHistogram[i]=matrix[0][i]-'0';
        }
        int maxArea=areaHistogram(rowHistogram,n);
        for(int i=1;i<matrix.length;i++){// converting rowise into histrogram array
            for(int j=0;j<n;j++){
                if(matrix[i][j]-'0'==1){// when current value is 1 it is added to the previous histogram value
                    rowHistogram[j]=rowHistogram[j]+1;

                }
                else{// else 0 is substituted
                    rowHistogram[j]=0;
                }
            }
            maxArea=Math.max(maxArea,areaHistogram(rowHistogram,n));
        }
        return maxArea;
        
    }
}