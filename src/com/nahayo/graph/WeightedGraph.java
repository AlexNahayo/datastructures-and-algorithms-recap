package com.nahayo.graph;

import com.nahayo.Path;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Stack;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();
        public Node(String label) {
            this.label = label;
        }
        @Override
        public String toString() {
            return label;
        }
        public void addEdge(Node to, int weight) {
           edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "=>" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        //undirected graph approach. -
        // need to add an edge from A -> B.
        fromNode.addEdge(toNode, weight);
        // need to add an edge from B -> A.
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty()) {
                System.out.println(node +" is connected to "+ edges);
            }
        }
    }

    private class NodeEntry {
        private Node node;

        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public boolean hasCycle() {
        // Tracks all nodes that have already been visited during DFS
        Set<Node> visited = new HashSet<>();

        // Run DFS from each node to ensure disconnected graphs are handled
        for (var node : nodes.values()) {
            // Only start DFS from unvisited nodes
            if (!visited.contains(node) && hasCycle(node, null, visited)) {
                // A cycle was found; no need to continue searching
                return true;
            }
        }

        // No cycles were found in any component of the graph
        return false;
    }

    /**
     * Performs a depth-first search to detect cycles.
     *
     * @param node    the current node being visited
     * @param parent  the node we arrived from (used to avoid backtracking)
     * @param visited set of nodes already visited in the DFS
     */
    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        // Mark the current node as visited
        visited.add(node);

        // Explore all adjacent nodes
        for (var edge : node.getEdges()) {
            Node neighbor = edge.to;

            // Skip the edge leading back to the parent node
            if (neighbor == parent)
                continue;

            // If the neighbor was already visited, or a cycle is found downstream,
            // then the graph contains a cycle
            if (visited.contains(neighbor) || hasCycle(neighbor, node, visited))
                return true;
        }

        // No cycle detected from this path
        return false;
    }

    public Path getShortestDistance(String from, String to) {

        // Look up the starting node
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        // Look up the destination node
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        // Stores the shortest known distance from the start node to every node
        Map<Node, Integer> distances = new HashMap<>();
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);

        // Distance from the start node to itself is zero
        distances.put(fromNode, 0);

        // Stores the previous node in the shortest path for each node
        // (used later to reconstruct the path)
        Map<Node, Node> previousNodes = new HashMap<>();

        // Keeps track of nodes whose shortest distance is already finalized
        Set<Node> visited = new HashSet<>();

        // Priority queue that always processes the node with the smallest distance
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );

        // Start the algorithm with the starting node
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {

            // Remove the node with the smallest known distance
            var current = queue.remove().node;

            // Skip if this node was already processed
            if (visited.contains(current))
                continue;

            // Mark this node as visited (its shortest distance is now final)
            visited.add(current);

            // Relax edges: try to improve distances to neighboring nodes
            for (var edge : current.getEdges()) {

                // Ignore neighbors that were already finalized
                if (visited.contains(edge.to))
                    continue;

                // Calculate distance to the neighbor through the current node
                var newDistance = distances.get(current) + edge.weight;

                // If a shorter path is found, update distance and path
                if (newDistance < distances.get(edge.to)) {
                    distances.put(edge.to, newDistance);
                    previousNodes.put(edge.to, current);

                    // Push the neighbor into the queue with updated priority
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        // Reconstruct the shortest path from the destination node
        return buildPath(toNode, previousNodes);
    }

    private static Path buildPath(Node toNode, Map<Node, Node> previousNodes) {

        // Stack is used to reverse the path order (destination → source)
        Stack<Node> stack = new Stack<>();

        // Start from the destination node
        // The destination itself will not appear as a key in previousNodes
        stack.push(toNode);

        // Follow the chain of previous nodes back to the start
        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        // Build the path in correct order (source → destination)
        var path = new Path();
        while (!stack.isEmpty()) {
            path.add(stack.pop().label);
        }

        return path;
    }

}


// This version of the code is the standard None OO approach.
//public class WeightedGraph {
//
//    private class Node {
//        private String label;
//        public Node(String label) {
//            this.label = label;
//        }
//        @Override
//        public String toString() {
//            return label;
//        }
//    }
//
//    private class Edge {
//        private Node from;
//        private Node to;
//        private int weight;
//
//        public Edge(Node from, Node to, int weight) {
//            this.from = from;
//            this.to = to;
//            this.weight = weight;
//        }
//
//        @Override
//        public String toString() {
//            return from + "=>" + to;
//        }
//
//    }
//
//    private Map<String, Node> nodes = new HashMap<>();
//
//    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();
//
//    public void addNode(String label) {
//        var node = new Node(label);
//        nodes.putIfAbsent(label, node);
//        adjacencyList.putIfAbsent(node, new ArrayList<>());
//    }
//
//    public void addEdge(String from, String to, int weight) {
//        var fromNode = nodes.get(from);
//        if (fromNode == null)
//            throw new IllegalArgumentException();
//        var toNode = nodes.get(to);
//        if (toNode == null)
//            throw new IllegalArgumentException();
//
//        //undirected graph approach. -
//        // need to add an edge from A -> B.
//        adjacencyList.get(fromNode).add(
//                new Edge(fromNode, toNode, weight));
//        // need to add an edge from B -> A.
//        adjacencyList.get(toNode).add(
//                new Edge(toNode, fromNode, weight));
//    }
//
//    public void print() {
//        for (var source : adjacencyList.keySet()) {
//            var targets = adjacencyList.get(source);
//            if (!targets.isEmpty()) {
//                System.out.println(source +" is connected to "+ targets);
//            }
//        }
//    }
//}
