package com.nahayo.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private class Node {
        private String label;
        public Node(String label) {
            this.label = label;
        }
        @Override
        public String toString() {
            return label;
        }
    }

    //using Map here instead of standard list.
    //as we need to check if Node exists before adding it.
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        //directed graph approach.
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;
        //goes through adjacency list and removes all connections associated with the node in question
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        //here we remove Node keys with exist in adjacencyList and in nodes.
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null){
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source +" is connected to "+ targets);
            }
        }
    }

}
