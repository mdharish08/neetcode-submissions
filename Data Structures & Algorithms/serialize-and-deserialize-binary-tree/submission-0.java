/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {


    private void serialize(StringBuilder str,TreeNode node){
        if(node == null){
            str.append("N*");
            return;
        }
        str.append(node.val + "*");
        serialize(str, node.left);
        serialize(str, node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(str,root);
        return str.toString(); 
    }

    private TreeNode deserialize(String[] data ,AtomicInteger i){
        if(i.get() >= data.length){
            return null;
        }

        if(data[i.get()].equals("N")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[i.get()]));
        i.incrementAndGet();
        node.left = deserialize(data, i);
        i.incrementAndGet();
        node.right = deserialize(data, i);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        return deserialize(data.split("\\*"), new AtomicInteger(0));
    }
}
