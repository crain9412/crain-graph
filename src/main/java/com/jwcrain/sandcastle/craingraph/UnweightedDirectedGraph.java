package com.jwcrain.sandcastle.craingraph;

import java.util.LinkedList;

public class UnweightedDirectedGraph<T> extends DirectedGraph<T> {
    public void addEdge(Node<T> source, Node<T> target) {
        Edge<T> forwardEdge = new Edge<>(target);
        source.addEdge(forwardEdge);
    }

    public boolean hasBackEdges() {
        for(Node<T> current : nodes ) {
            LinkedList<Node<T>> linkedList = new LinkedList<>();

            linkedList.add(current);

            while(!linkedList.isEmpty()) {
                current = linkedList.pop();

                if (current.isActive()) {
                    setAllNodesInactive();
                    return true;
                }

                current.setActive(true);

                for (Edge<T> edge : current.getEdges()) {
                    linkedList.push(edge.getNode());
                }
            }

            setAllNodesInactive();
        }

        return false;
    }

    public void setAllNodesInactive() {
        for (Node<T> node : nodes) {
            node.setActive(false);
        }
    }
}
