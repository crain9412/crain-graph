package com.jwcrain.sandcastle;

import com.jwcrain.sandcastle.craingraph.Graph;
import com.jwcrain.sandcastle.craingraph.Node;
import com.jwcrain.sandcastle.craingraph.UnweightedDirectedGraph;
import org.junit.Test;


import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testUnweightedDirectedGraph() {
        UnweightedDirectedGraph<String> graph = new UnweightedDirectedGraph<>();

        Node<String> steel = new Node<>("steel");
        Node<String> piston = new Node<>("piston");
        Node<String> engine = new Node<>("engine");
        Node<String> chassis = new Node<>("chassis");
        Node<String> leather = new Node<>("leather");
        Node<String> seat = new Node<>("seat");

        graph.addNode(steel);
        graph.addNode(piston);
        graph.addNode(engine);
        graph.addNode(chassis);
        graph.addNode(leather);
        graph.addNode(seat);

        graph.addEdge(steel, piston);
        graph.addEdge(piston, engine);
        graph.addEdge(steel, chassis);
        graph.addEdge(leather, seat);

        Node<String> engineSearch = graph.search(piston, "engine", Graph.SearchMethod.BREADTH);
        Node<String> seatSearch = graph.search(leather, "seat", Graph.SearchMethod.DEPTH);
        Node<String> seatNullSearch = graph.search(steel, "seat", Graph.SearchMethod.DEPTH);
        Node<String> chassisNullSearch = graph.search(seat, "chassis", Graph.SearchMethod.BREADTH);

        assertNull(seatNullSearch);
        assertNull(chassisNullSearch);
        assertEquals(engineSearch.getData(), "engine");
        assertEquals(seatSearch.getData(), "seat");
        assertFalse(graph.hasBackEdges());
    }

    @Test
    public void testUnweightedDirectedGraphWithBackEdge() {
        UnweightedDirectedGraph<String> graph = new UnweightedDirectedGraph<>();

        Node<String> rock = new Node<>("rock");
        Node<String> paper = new Node<>("paper");
        Node<String> scissors = new Node<>("scissors");

        graph.addNode(rock);
        graph.addNode(paper);
        graph.addNode(scissors);

        graph.addEdge(paper, rock);
        graph.addEdge(scissors, paper);
        graph.addEdge(rock, scissors);

        assertTrue(graph.hasBackEdges());
    }
}
