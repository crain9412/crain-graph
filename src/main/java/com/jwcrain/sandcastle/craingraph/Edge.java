package com.jwcrain.sandcastle.craingraph;

public class Edge<T> {
    private Node<T> node;
    private long weight = 0L;

    public Edge(Node<T> node) {
        this.node = node;
    }

    public Edge<T> withWeight(long weight) {
        this.weight = weight;
        return this;
    }

    public Node<T> getNode() {
        return node;
    }

    public long getWeight() {
        return weight;
    }
}
