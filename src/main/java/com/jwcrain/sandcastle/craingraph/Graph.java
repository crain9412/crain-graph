package com.jwcrain.sandcastle.craingraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<T> {
    private ArrayList<Node<T>> vertices = new ArrayList<>();
    public enum GraphType {
        DIRECTED,
        UNDIRECTED
    }
    public enum SearchMethod {
        BREADTH,
        DEPTH
    }
    private GraphType type;

    public Graph(GraphType type) {
        this.type = type;
    }

    public void addNode(Node<T> node) {
        vertices.add(node);
    }

    public void addEdge(Node<T> node, Node<T> nodeTwo) {
        node.addAdjacentNode(nodeTwo);
        if (type.equals(GraphType.UNDIRECTED)) {
            nodeTwo.addAdjacentNode(node);
        }
    }

    public void setAllNodesUnvisited() {
        for (Node<T> node : vertices) {
            node.setVisited(false);
        }
    }

    public void setAllNodesInactive() {
        for (Node<T> node : vertices) {
            node.setActive(false);
        }
    }

    public Node<T> search(Node<T> current, T target, SearchMethod method) {
        LinkedList<Node<T>> linkedList = new LinkedList<>();

        //System.out.printf("\nStarting %s search for %s with node %s\n", method.toString(), target, current.getData());
        linkedList.add(current);

        while(!linkedList.isEmpty()) {
            if (method.equals(SearchMethod.BREADTH)) {
                current = linkedList.pollLast();
            } else {
                current = linkedList.pop();
            }

           // System.out.printf("Continuing %s search with node %s\n", method.toString(), current.getData());

            if (current.getData().equals(target)) {
                //System.out.printf("Found %s which matches target %s\n", current.getData(), target);

                setAllNodesUnvisited();

                return current;
            }

            if (current.isVisited()) {
               // System.out.printf("%s already visited, continuing\n", current.getData());
                continue;
            }

            current.setVisited(true);

            for (Node<T> adjacent : current.getAdjacentNodes()) {
                linkedList.push(adjacent);
            }
        }

        setAllNodesUnvisited();

        return null;
    }

    public boolean hasBackEdges() {
        for(Node<T> current : vertices) {
            LinkedList<Node<T>> linkedList = new LinkedList<>();

            linkedList.add(current);

            while(!linkedList.isEmpty()) {
                current = linkedList.pop();

                if (current.isActive()) {
                    //System.out.printf("Found back edge %s\n", current.getData());

                    setAllNodesInactive();
                    return true;
                }

                current.setActive(true);

                //System.out.printf("Set %s active\n", current.getData());

                for (Node<T> adjacent : current.getAdjacentNodes()) {
                    linkedList.push(adjacent);
                }
            }
        }

        setAllNodesInactive();

        return false;
    }

    public List<Node<T>> topologicalSort(Node<T> current) {
        if (type.equals(GraphType.UNDIRECTED)) {
            return null;
        }

        if (hasBackEdges()) {
            return null;
        }

        return null;
    }
}
