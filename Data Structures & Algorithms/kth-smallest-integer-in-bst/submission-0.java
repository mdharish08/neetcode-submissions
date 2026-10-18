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

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode,int[]> map = new HashMap<>();
        populateMap(root,map);
        return kthSmallest(0,root,k,map);
    }

    private int kthSmallest(int parent ,TreeNode node,int k ,Map<TreeNode,int[]> map){
        if(node == null){
            return -1;
        }
        int[] val = map.get(node);
        int currentIndex = parent + val[0] + 1;
        if(currentIndex == k){
            return node.val;
        }else if(k > currentIndex){
            return kthSmallest(currentIndex,node.right,k,map);
        }
        return kthSmallest(parent,node.left,k,map);   
    }

    private int populateMap(TreeNode node, Map<TreeNode,int[]> map){
        if(node == null){
            return 0;
        }
        int left = populateMap(node.left,map) , right = populateMap(node.right, map);

        map.put(node, new int[] {left , right});
        return left + right + 1;
    }
}
