package com.jwcrain.sandcastle.craingraph;

public class WeightedUndirectedGraph<T> extends WeightedGraph<T> {
    public void addEdge(Node<T> source, Node<T> target, long weight) {
        Edge<T> forwardEdge = new Edge<>(target).withWeight(weight);
        source.addEdge(forwardEdge);

        Edge<T> backwardEdge = new Edge<>(source).withWeight(weight);
        target.addEdge(backwardEdge);
    }
}
