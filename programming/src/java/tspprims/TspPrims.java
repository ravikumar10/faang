package src.java.tspprims;

public class TspPrims {
    public static void main(String[] args) {
        int [][] graph = {
                { 0, 0, 1, 0,0, 0, 1, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 1, 0,0 },
                { 0, 0, 1, 0,0, 0, 1, 0, 1,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 1, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,1, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 1, 0, 0,0 }
        };
//        int [] primsResult = primsFlow(graph)
    }

//    public int[] primsFlow() {
//
//        int[] res = new int[graph.size];
//        boolean[] visited = new boolean[graph.size];
//        int[] weights = new int[graph.size];
//        int sum = 0;
//
//        for (int i = 0; i < graph.size; ++i) {
//
//            weights[i] = Integer.MAX_VALUE;
//        }
//
//        weights[0] = 0;
//        res[0] = -1;
//
//        for (int i = 0; i < graph.size; ++i) {
//
//            int next = minVal(visited, weights);
//            visited[next] = true;
//
//            for (int j = 0; j < graph.size; ++j) {
//
//                if (graph.getWeight(next, j) > 0 && !visited[j] && graph.getWeight(next, j) < weights[j]) {
//
//                    res[j] = next;
//                    weights[j] = graph.getWeight(next, j);
//
//                }
//            }
//
//        }
}
