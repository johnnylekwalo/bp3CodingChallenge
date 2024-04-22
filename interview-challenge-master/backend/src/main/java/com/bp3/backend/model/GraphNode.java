package com.bp3.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
    int id;

    NodeModel node;
    List<GraphNode> from;
    List<GraphNode> to;




    public GraphNode(int id, NodeModel node) {
        this.id = id;
        this.node = node;
        this.from = new ArrayList<>();
        this.to = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodeModel getNode() {
        return node;
    }

    public void setNode(NodeModel node) {
        this.node = node;
    }

    public List<GraphNode> getFrom() {
        return from;
    }

    public void setFrom(List<GraphNode> from) {
        this.from = from;
    }

    public List<GraphNode> getTo() {
        return to;
    }

    public void setTo(List<GraphNode> to) {
        this.to = to;
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
