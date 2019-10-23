package com.jwcrain.sandcastle.craingraph;

import java.util.ArrayList;

public class Node<T> {
    private ArrayList<Node<T>> adjacentNodes = new ArrayList<>();
    private T data;
    private boolean visited = false;
    private boolean active = false;

    public Node(T data) {
        this.data = data;
    }

    public ArrayList<Node<T>> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public void addAdjacentNode(Node<T> node) {
        this.adjacentNodes.add(node);
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
