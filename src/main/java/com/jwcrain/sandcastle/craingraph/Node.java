package com.jwcrain.sandcastle.craingraph;

import java.util.ArrayList;

public class Node<T> {
    private ArrayList<Edge<T>> edges = new ArrayList<>();
    private T data;
    private boolean visited = false;
    private boolean active = false;

    public Node(T data) {
        this.data = data;
    }

    public ArrayList<Edge<T>> getEdges() {
        return this.edges;
    }

    public void addEdge(Edge<T> node) {
        this.edges.add(node);
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
