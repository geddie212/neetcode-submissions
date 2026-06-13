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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(0, preorder.length-1,0,inorder.length-1,preorder, inorder);
    }

    public TreeNode createTree(int pS, int pE, int iS, int iE, int[] preOrder, int[] postOrder){
        if (pS > pE || iS > iE || preOrder.length == 0){
            return null;
        }
        Integer split = null;
        for (int i = iS; i<=iE ;i++){
            if (preOrder[pS] == postOrder[i]){
                split = i;
                break;
            }
        }
        if (split == null){
            return null;
        }
        TreeNode node = new TreeNode(postOrder[split]);

        node.left = createTree(pS+1,pS+split-iS,iS,split-1, preOrder,postOrder);
        node.right = createTree(pS+split-iS+1,pE,split+1,iE,preOrder,postOrder);

        return node;
    }
}
