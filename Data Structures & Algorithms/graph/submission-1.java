class Graph {
    HashMap<Integer, List<Integer>> adj;

    public Graph() {
        this.adj = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
            if (!this.adj.containsKey(src)){
                List<Integer> edge = new ArrayList<>();
                edge.add(dst);
                this.adj.put(src,edge);
            }
            else{
                boolean dupVal = false;
                List<Integer> edges = this.adj.get(src);
                for (int i = 0; i<edges.size(); i++){
                    if (edges.get(i) == dst){
                        dupVal = true;
                        break;
                    }
                }
                if (!dupVal){
                    edges.add(dst);
                }
            }
    }

    public boolean removeEdge(int src, int dst) {
        if (src == dst){
            return false;
        }
        if (!this.adj.containsKey(src)){
            return false;
        }
        boolean dupVal = false;
        List<Integer> edges = this.adj.get(src);
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i)==dst){
                edges.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        if (src == dst){
            return true;
        }
        if(!this.adj.containsKey(src)){
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if (node == dst){
                return true;
            }
            List<Integer> edges = this.adj.get(node);
            if (edges != null){
                for (int edge : edges){
                    if(!visited.contains(edge)){
                        queue.offer(edge);
                        visited.add(edge);
                    }
                }
            }
        }
        return false;
    }
}
