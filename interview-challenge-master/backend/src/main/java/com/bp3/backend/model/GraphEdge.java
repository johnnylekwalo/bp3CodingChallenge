package com.bp3.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphEdge {
    GraphNode from;
    GraphNode to;


    public GraphEdge(GraphNode from, GraphNode to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphEdge graphEdge = (GraphEdge) o;
        return Objects.equals(from, graphEdge.from) && Objects.equals(to, graphEdge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
