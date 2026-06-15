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
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null){
            return new ArrayList<Integer>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> lq = new LinkedList<>();

        List<Integer> v = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        Integer lv = 0;

        q.offer(root);
        lq.offer(lv);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            lv = lq.poll();

            v.add(curr.val);
            l.add(lv);

            if (curr.left != null){
                q.offer(curr.left);
                lq.offer(lv+1);
            }

            if (curr.right != null){
                q.offer(curr.right);
                lq.offer(lv+1);
            }
        }

        List<Integer> out = new ArrayList<>();
        int m = 0;

        for (int i = 0; i < v.size(); i++){
            if (l.get(i) != m){
                out.add(v.get(i-1));
                m = l.get(i);
            }
        }

        out.add(v.get(v.size()-1));

        return out;
    }
}
