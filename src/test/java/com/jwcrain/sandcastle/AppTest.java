package com.jwcrain.sandcastle;

import com.jwcrain.sandcastle.craingraph.Graph;
import com.jwcrain.sandcastle.craingraph.Node;
import org.junit.Test;


import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testDirectedGraph() {
        Graph<String> graph = new Graph<>(Graph.GraphType.DIRECTED);

        Node<String> animal = new Node<>("animal");
        Node<String> mammal = new Node<>("mammal");
        Node<String> cat = new Node<>("cat");
        Node<String> dog = new Node<>("dog");
        Node<String> retriever = new Node<>("retriever");
        Node<String> poodle = new Node<>("poodle");

        graph.addNode(animal);
        graph.addNode(mammal);
        graph.addNode(cat);
        graph.addNode(dog);
        graph.addNode(retriever);
        graph.addNode(poodle);

        graph.addEdge(animal, mammal);

        graph.addEdge(mammal, dog);
        graph.addEdge(mammal, cat);

        graph.addEdge(dog, retriever);
        graph.addEdge(dog, poodle);

        /* Infinite loop potential for fun */
        graph.addEdge(poodle, animal);

        Node<String> poodleBreadth = graph.search(dog, "poodle", Graph.SearchMethod.BREADTH);
        Node<String> dogBreadth = graph.search(mammal, "dog", Graph.SearchMethod.BREADTH);
        Node<String> catDepth = graph.search(animal, "cat", Graph.SearchMethod.DEPTH);
        Node<String> nullBreadth = graph.search(animal, "null", Graph.SearchMethod.BREADTH);
        Node<String> nullDepth = graph.search(animal, "null", Graph.SearchMethod.DEPTH);

        assertEquals(poodleBreadth.getData(), "poodle");
        assertEquals(dogBreadth.getData(), "dog");
        assertEquals(catDepth.getData(), "cat");
        assertNull(nullBreadth);
        assertNull(nullDepth);
        assertTrue(graph.hasBackEdges());
    }

}
