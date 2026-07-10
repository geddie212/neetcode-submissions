/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            List<Integer> neighbors = new ArrayList<>();
            for (Node n:curr.neighbors){
                neighbors.add(n.val);
                if (!visited.contains(n.val)){
                    queue.offer(n);
                    visited.add(n.val);
                }
            }
            hm.put(curr.val, neighbors);
        }

        HashMap<Integer,Node> output = new HashMap<>();
        
        for (int key:hm.keySet()){
            Node n = new Node(key);
            output.put(key, n);
        }

        for (int key: output.keySet()){
            Node n = output.get(key);
            for (int neighbor : hm.get(key)){
                n.neighbors.add(output.get(neighbor));
            }
        }

        return output.get(node.val);
        
    }
}