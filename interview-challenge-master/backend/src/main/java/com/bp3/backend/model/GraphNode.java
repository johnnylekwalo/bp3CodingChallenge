package com.bp3.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
    int id;

    NodeModel node;
    List<GraphEdge> outgoingEdges;
    List<GraphEdge> incomingEdges;




    public GraphNode(int id, NodeModel node) {
        this.id = id;
        this.node = node;
        this.outgoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return id == graphNode.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
