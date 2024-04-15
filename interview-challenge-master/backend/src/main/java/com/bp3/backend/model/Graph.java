package com.bp3.backend.model;

import java.util.List;

public class Graph{
    List<GraphNode> nodes;

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void removeNode(int key) {
        GraphNode nodeToRemove = null;
        for (GraphNode node : nodes) {
            if (node.id == key) {
                nodeToRemove = node;
                break;
            }
        }

        if (nodeToRemove != null) {
            nodes.remove(nodeToRemove);
            for (GraphNode node : nodes) {
                removeAdjacentNode(node, nodeToRemove);
            }
        }
    }

    private void removeAdjacentNode(GraphNode node, GraphNode nodeToRemove) {
        if (node.adjacentNodes.contains(nodeToRemove)) {
            node.adjacentNodes.remove(nodeToRemove);
        }
        for (GraphNode adjacentNode : node.adjacentNodes) {
            removeAdjacentNode(adjacentNode, nodeToRemove);
        }
    }
}
