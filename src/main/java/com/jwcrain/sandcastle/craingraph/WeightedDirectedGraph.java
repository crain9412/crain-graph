package com.jwcrain.sandcastle.craingraph;

public class WeightedDirectedGraph<T> extends WeightedGraph<T> {
    public void addEdge(Node<T> node, Node<T> nodeTwo, long weight) {
        Edge<T> edge = new Edge<>(nodeTwo).withWeight(weight);
        node.addEdge(edge);
    }
}
