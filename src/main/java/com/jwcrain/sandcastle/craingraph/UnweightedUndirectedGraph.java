package com.jwcrain.sandcastle.craingraph;

public class UnweightedUndirectedGraph<T> extends Graph<T> {
    public void addEdge(Node<T> source, Node<T> target) {
        Edge<T> forwardEdge = new Edge<>(target);
        source.addEdge(forwardEdge);

        Edge<T> backwardEdge = new Edge<>(source);
        target.addEdge(backwardEdge);
    }
}
