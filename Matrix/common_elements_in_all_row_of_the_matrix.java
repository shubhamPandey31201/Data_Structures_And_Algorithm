// Time complexity will be O(n^m) and space complexity will be O(n) for hashMap
// we use hashMap to store the element of first row as key and its occurence in each row as value
// first we store all the element of first row in hashmap and keeping value as 1
// the from second row onward we search for each element if there exist such key in hashmap or not and also for dublicate element we check if current row==keyValue or not 
// if yes we increment the count
// at last we traverse through all the keys and check if keyValue is equal to the row of matrix or not
import java.util.*;
public class Solution
{
    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat)
    {
        int row=mat.size();
        int column=mat.get(0).size();
        HashMap<Integer,Integer> elementFrequency=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<column;i++){ // adding all the element of first row into hashmap
            if(!elementFrequency.containsKey(mat.get(0).get(i))){
                elementFrequency.put(mat.get(0).get(i),1);
            }
        }
        
        for(int i=1;i<row;i++){
            for(int j=0;j<column;j++){
                if(elementFrequency.containsKey(mat.get(i).get(j)) && elementFrequency.get(mat.get(i).get(j))==i){//checking if current element is there in hashmap or not and also check if i==keyValue of current element or not to avoid dublicate element count
                    elementFrequency.put(mat.get(i).get(j),i+1);
                }
                
            }
        }
        for(int e: elementFrequency.keySet()){
            if(elementFrequency.get(e)==row){ // if frequency is equal to row length
                ans.add(e);
            }
        }

        return ans;
        // Write your code here.
    }
}
