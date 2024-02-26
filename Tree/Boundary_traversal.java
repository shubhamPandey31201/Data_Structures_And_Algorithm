//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

// time complexity is O(N)
// first add right nodes
// first add left boundary node
// then add leaf boundary nodes 
// then add right boundary nodes
// for adding left boundary check if node->left!=null 
// node-> left==null means there will be a probability of it being a leaf node
// if node->left!=null then add that node into the answer array and recursively move to left node of current node
// also if node->left==null there is possibility of having right node to it and it still can form left boundary
// for leave nodes first go to left most then check 
// check if(node->left==null && node->right==null) then add the node 
// then go to right node and check for leaf node again
// for right boundary first check if node.right!=null then go to last node and while backtracking check add the nodes to answer
// also if(node.right==null ) check if node.left exist or not then again add right boundary of it
class Solution
{
    void leftBoundary(Node node,ArrayList<Integer> ans){// for left boundary
        if(node==null) return;
       
        if(node.left!=null){ // for left boundary
            ans.add(node.data);// adding leftmost nodes to answer array except leaf nodes
            leftBoundary(node.left,ans);// traversing leftmost nodes 
        }
        else if(node.right!=null){// if last nodes has right nodes then again check for left boundary for that node
            ans.add(node.data);// add that node
            leftBoundary(node.right,ans);// make recursive call again
        }
        
    }
    void leafBoundary(Node node,ArrayList<Integer> ans){// for leaf boundary
        if(node==null) return;
        leafBoundary(node.left,ans);// go to leftmost
        if(node.left==null && node.right==null) ans.add(node.data);// leaf node condition
        leafBoundary(node.right,ans);// go right node and check for leaf condition
    }
    void rightBoundary(Node node,ArrayList<Integer> ans){// for right boundary
        if(node==null) return;
        if(node.right!=null){// for excluding right leaft
            rightBoundary(node.right,ans);// going to right most node
            ans.add(node.data);// and then adding it to the answer array
            
            
        }
        else if(node.left!=null){// there may be left branch attached to rightmost node that will form right boundary as well
            rightBoundary(node.left,ans);// so traversing left whenever rightmost node has left branch of it as well
            ans.add(node.data); // and adding it to answer array
            
        }
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    if(node==null) return ans;// when node is null
	    ans.add(node.data);
	    if(node.left==null && node.right==null) return ans;// when there is single node that mean it is leaf nodes itself and is added to the answer already so return
	    leftBoundary(node.left,ans);// leftBoundary
	    
	    leafBoundary(node,ans);// leafBoundary
	    rightBoundary(node.right,ans);//rightBoundary
	    return ans;
	    
	}
}
