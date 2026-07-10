class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1){
            return true;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
            if (!graph.containsKey(prerequisites[i][1])){
                List<Integer> edges = new ArrayList<>();
                edges.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1],edges);
            }
            else{
                List<Integer> edges = graph.get(prerequisites[i][1]);
                edges.add(prerequisites[i][0]);
            }
        }
        for (int key: graph.keySet()){
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(key);
            while(!queue.isEmpty()){
                int curr = queue.poll();
                List<Integer> edges = graph.get(curr);
                if (edges != null){
                    for (int edge: edges){
                        if (edge == key){
                            return false;
                        }
                        if (!visited.contains(edge)) {
                            visited.add(edge);
                            queue.offer(edge);
                        }
                    }
                }
            }
        }
        return true;
    }
}
