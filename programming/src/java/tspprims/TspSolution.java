package src.java.tspprims;

import java.util.*;

public class TspSolution {
    class node1 {

        // Stores destination vertex in adjacency list
        String dest;

        // Stores weight of a vertex in the adjacency list
        double weight;

        // Constructor
        node1(String a, double b)
        {
            dest = a;
            weight = b;
        }
    }
    static class Graph {

        // Number of vertices in the graph
        int V;

        // List of adjacent nodes of a given vertex
//        LinkedList<node1>[] adj;


        Map<String, LinkedList<node1>> adj = new HashMap<>();

        // Constructor
        Graph(int e, List<String> vertex)
        {
            V = e;
            for(String k : vertex) {
                adj.put(k, new LinkedList<>());
            }
        }
    }

    // class to represent a node in PriorityQueue
    // Stores a vertex and its corresponding
    // key value
    class node {
        public node(String vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        String vertex;
        double key;
    }

    // Comparator class created for PriorityQueue
    // returns 1 if node0.key > node1.key
    // returns 0 if node0.key < node1.key and
    // returns -1 otherwise
    class comparator implements Comparator<node> {

        @Override
        public int compare(node node0, node node1)        {

            return Double.compare(node0.key, node1.key);
        }
    }

    // method to add an edge
    // between two vertices
    void addEdge(Graph graph, String src, String dest, double weight)
    {

        node1 node0 = new node1(dest, weight);
        node1 node = new node1(src, weight);

        graph.adj.get(src).add(node0);
        graph.adj.get(dest).add(node);
    }

    // method used to find the mst
    Map<String, String> prims_mst(Graph graph, String startKey)
    {

        // Whether a vertex is in PriorityQueue or not
        Boolean[] mstset = new Boolean[graph.V];

        Map<String, Boolean> mstSet1 = new HashMap<>();

        node[] e = new node[graph.V];

        Map<String, node> e1 = new HashMap<>();

        // Stores the parents of a vertex

        Map<String, String> parent1 = new HashMap<>();


        for (String key :graph.adj.keySet()) {


            parent1.put(key, "-1");
            mstSet1.put(key, false);
            e1.put(key, new node(key, Integer.MAX_VALUE));
        }

        node startNode = e1.get(startKey);
        startNode.key = 0;
        e1.put(startKey, startNode);
        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<node> queue = new TreeSet<node>(new comparator());

        queue.addAll(e1.values());

        // Loops until the queue is not empty
        while (!queue.isEmpty()) {

            // Extracts a node with min key value
            node node0 = queue.pollFirst();

            // Include that node into mstset
//            mstset[node0.vertex] = true;
            mstSet1.put(node0.vertex, true);
            // For all adjacent vertex of the extracted vertex V

            for (node1 iterator : graph.adj.get(node0.vertex)) {

                // If V is in queue
                if (mstSet1.get(iterator.dest) == false) {
                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex

                    node destNode = e1.get(iterator.dest);
                    if(destNode.key > iterator.weight) {
                        queue.remove(destNode);
                        destNode.key = iterator.weight;
                        queue.add(destNode);

                        parent1.put(iterator.dest, node0.vertex);
                    }

                }
            }


        }

        // Prints the vertex pair of mst

        for(String k : parent1.keySet()) {
            System.out.println(parent1.get(k) + " "
                    + "-"
                    + " " + k);
        }

        return parent1;

    }

    private static void dfs(Map<String, String> mst, Map<String, Boolean> visited, String s) {
        visited.put(s, true);
        System.out.println(s+" ");

        if(mst.containsKey(s)) {
            String nextVertex = mst.get(s);
            if (!visited.containsKey(nextVertex)) {
                dfs(mst, visited, nextVertex);

            }
        }

    }

    private static double getWeights(String startV, String destV) {
        int x1 = Integer.parseInt(startV.split(":")[0]);
        int y1 = Integer.parseInt(startV.split(":")[1]);
        int x2 = Integer.parseInt(destV.split(":")[0]);
        int y2 = Integer.parseInt(destV.split(":")[1]);

        double xDiff = Math.abs(x2-x1);
        double yDiff = Math.abs(y2-y1);
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }

    private static List<String> processGraph(int[][] graph) {
        List<String> vertex = new ArrayList<>();
        for(int i= 0; i<graph.length; i++) {
            for(int j =0 ; j< graph[0].length; j++){
                if(graph[i][j] == 1) {
                    String key = i+":"+j;
                    vertex.add(key);
                }
            }
        }

        return vertex;
    }


    // Start point
    public static void main(String[] args)
    {
        // 1.graph
        int [][] graphInput = {
                { 0, 0, 1, 0,0, 0, 1, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 1, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 1, 0,0 },
                { 0, 0, 1, 0,0, 0, 1, 0, 1,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 1, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,1, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 0, 0, 0,0 },
                { 0, 0, 0, 0,0, 0, 1, 0, 0,0 }
        };

        // 2.Get all vertices
        List<String> vertex = processGraph(graphInput);


        // 3.Create Graph
        int V = vertex.size();

        Graph graph = new Graph(V, vertex);

        TspSolution e = new TspSolution();

        // Permute the graph for all the edges between all vertices
        for(String startV: vertex ) {
            for(String destV : vertex) {
                if(startV.equals(destV))
                    continue;
                double weight = getWeights(startV, destV);
                e.addEdge(graph, startV, destV, weight);

            }
        }


        // 4.MST using Prims
        String startV = "0:2";
        Map<String, String> mst = e.prims_mst(graph, startV);
        Map<String, Boolean> visited = new HashMap<>();


        System.out
                .println( "--------------");

        // 5. DFS to create path [Need to be fixed for correct cycle]
        dfs(mst, visited, startV);
        for(String k : mst.values()) {
               if(!visited.containsKey(k))
                    dfs(mst, visited, k);

        }
    }
}
