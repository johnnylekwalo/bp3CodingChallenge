package com.bp3.backend.model;

public class ProcessDiagram {
    private NodeModel[] nodes;
    private EdgeModel[] edges;

    public NodeModel[] getNodes() {
        return nodes;
    }

    public void setNodes(NodeModel[] nodes) {
        this.nodes = nodes;
    }

    public EdgeModel[] getEdges() {
        return edges;
    }

    public void setEdges(EdgeModel[] edges) {
        this.edges = edges;
    }
}
