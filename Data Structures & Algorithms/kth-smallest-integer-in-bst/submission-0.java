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
        ArrayList<Integer> out = new ArrayList<Integer>();
        inOrder(root, out);
        return out.get(k-1);
    }

    public void inOrder(TreeNode node, ArrayList<Integer> nums){
        if (node != null){
            inOrder(node.left, nums);
            nums.add(node.val);
            inOrder(node.right, nums);            
        }
    }
}
