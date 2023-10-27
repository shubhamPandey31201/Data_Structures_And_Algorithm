// time complexity O(n)
// We use chaining techique
// we first store the maximum impact of each character in hashmap
// if maxIdx and current index of character is matched then we make partition
// we also maintain firstIdx in order to count the element in the partition
// for counting element in the partition we use maxIdx-firstIdx

class Solution {
    public List<Integer> partitionLabels(String s) {
        // storing the maximum impact the character has in HashMap
        HashMap<Character,Integer> impactIdx=new HashMap<>();
        for(int i=0;i<s.length();i++){
            impactIdx.put(s.charAt(i),i);
        }
        int firstIdx=-1;
        int maxIdx=0;
        // to store the element in the partition
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            // update maxIdx with current maxIdx and currentCharacter maxIdx
            maxIdx=Math.max(maxIdx,impactIdx.get(s.charAt(i)));
            if(maxIdx==i){ // when index == maximum index
                int charCount=maxIdx-firstIdx;
                result.add(charCount);
                firstIdx=maxIdx;

            }
        }
        return result;
        
    }
}