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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        inOrderHelper(root,out);
        return out;
    }
    public void inOrderHelper(TreeNode node, List<Integer> arr){
        if (node != null){
            inOrderHelper(node.left,arr);
            arr.add(node.val);
            inOrderHelper(node.right,arr);
        }
    }
}