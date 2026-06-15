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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> v = new LinkedList<>();
        Queue<Integer> l = new LinkedList<>();
        v.offer(root);
        l.offer(0);

        return leveler(v,l);
    }

    public List<List<Integer>> leveler (Queue<TreeNode> v, Queue<Integer> l){
        Integer level = null;
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        while (!v.isEmpty()){
            TreeNode n = v.poll();
            level = l.poll();

            if (out.size() - 1 < level){
                out.add(new ArrayList<Integer>());
            }

            List<Integer> c = out.get(level);
            c.add(n.val);
            out.set(level,c);

            if (n.left != null){
                v.offer(n.left);
                l.offer(level+1);
            }

            if (n.right != null){
                v.offer(n.right);
                l.offer(level + 1);
            }
        }
        return out;
    }
}
