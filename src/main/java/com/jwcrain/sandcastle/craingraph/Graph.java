package com.jwcrain.sandcastle.craingraph;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Graph implements breadth first search and depth first search, commmon to all graphs
DirectedGraph implements topological sort and finding back edges, commonly used on DAGs
WeightedGraph implements Dijkstras
I've decided to have WeightedDirected graph extend WeightedGraph and not DirectedGraph because I think it's more common to want to do shorted path than topological sort on a Weighted Directed Graph.
 */

public abstract class Graph<T> {
    protected ArrayList<Node<T>> nodes = new ArrayList<>();

    public enum SearchMethod {
        BREADTH,
        DEPTH
    }

    public void addNode(Node<T> node) {
        nodes.add(node);
    }

    public Node<T> search(Node<T> current, T target, SearchMethod method) {
        LinkedList<Node<T>> linkedList = new LinkedList<>();

        linkedList.add(current);

        while(!linkedList.isEmpty()) {
            if (method.equals(SearchMethod.BREADTH)) {
                current = linkedList.pollLast();
            } else {
                current = linkedList.pop();
            }

            if (current.getData().equals(target)) {
                setAllNodesUnvisited();
                return current;
            }

            if (current.isVisited()) {
                continue;
            }

            current.setVisited(true);

            for (Edge<T> edge : current.getEdges()) {
                linkedList.push(edge.getNode());
            }
        }

        setAllNodesUnvisited();

        return null;
    }

    private void setAllNodesUnvisited() {
        for (Node<T> node : nodes) {
            node.setVisited(false);
        }
    }
}