/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Time complexity is O(N)
 // serialize is encoding tree into string using preorder traversal
 // for serializing we traverse preorder wise and add null whenever node is null
 // and add value with comma separated 
 // we use stringbuilder for concatenation for optimization later we convert it to string and return
 public class Codec {
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) { // base case whenever left and right node is null
           sb.append("null,");
        } else {
            sb.append(node.val+",");// adding value
            buildString(node.left, sb);// leftsub tree recursive call
            buildString(node.right,sb);// rightsub tree recursive call
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // this takes our serialized string
        Queue<String> nodes = new LinkedList<>();
        String arr[]=data.split(",");// split the entire string into array of string seperated by commas
        for(String e:arr){ // add each string into queue of nodes
            nodes.add(e);
        }
        return buildTree(nodes);// this function will build the tree and return root
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll(); // we fetch each node
        if (val.equals("null")) return null; // if string is null that means it return null only
        
        TreeNode node = new TreeNode(Integer.parseInt(val));// create a node 
        node.left = buildTree(nodes); // return other left nodes
        node.right = buildTree(nodes);// return right nodes
        return node;// return parent node
        
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));