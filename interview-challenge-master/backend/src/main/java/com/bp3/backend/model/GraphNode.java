package com.bp3.backend.model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int id;

    NodeModel node;
    List<GraphNode> adjacentNodes = new ArrayList<>();


    public GraphNode(int id) {
        this.id = id;
        this.adjacentNodes = new ArrayList<>();
    }

    public GraphNode(int id, NodeModel node) {
        this.id = id;
        this.node = node;
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

    public List<GraphNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<GraphNode> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
