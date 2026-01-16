package com.nahayo.graph;

import java.util.ArrayList;
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
