package com.nahayo.graph;


import java.util.*;

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

    public void traverseDepthFirstRec(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        //visit the root node
        System.out.println(root);
        visited.add(root);

        //recursively visit all the neighbours of the root node.
        for (var node : adjacencyList.get(root))
            if(!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }

    public void traverseDepthFirst(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            var current = stack.pop();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            //look at unvisited neighbours.
            for (var neighbour : adjacencyList.get(current)) {
                if(!visited.contains(neighbour))
                    stack.push(neighbour);
            }
        }
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        //visit the root node
        System.out.println(root);
        visited.add(root);

        //recursively visit all the neighbours of the root node.
        for (var node : adjacencyList.get(root))
            if(!visited.contains(node))
                traverseDepthFirst(node, visited);
    }
}
