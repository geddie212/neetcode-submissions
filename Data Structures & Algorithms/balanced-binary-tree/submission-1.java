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
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = balancedHelper(root.left, 0);
        if (left == -1){
            return false;
        }
        int right = balancedHelper(root.right, 0);
        if (right == -1){
            return false;
        }
        if (left - right >= -1 && left - right <= 1){
            return true;
        }
        return false;
    }

    public int balancedHelper(TreeNode node, int height){
        if (node == null){
            return height;
        }
        else {
            height++;
            int right = balancedHelper(node.right, height);
            if (right == -1){
                return -1;
            }
            int left = balancedHelper(node.left, height);
            if (left == -1){
                return -1;
            }
            if (left - right >= -1 && left - right <= 1){
                if (left > right){
                    return left;
                }
                else {
                    return right;
                }
            }
            else {
                return -1;
            }
        }
    }
}
