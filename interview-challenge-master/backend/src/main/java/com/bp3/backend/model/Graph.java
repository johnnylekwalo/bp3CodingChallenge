package com.bp3.backend.model;

import com.bp3.backend.Node;
import jakarta.servlet.ServletOutputStream;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Graph{
    Map<Integer, GraphNode> nodeMap;
    List<GraphEdge> edges;

    public Graph() {
        nodeMap = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void addNode(int nodeId , NodeModel nodeModel) {
        if (!nodeMap.containsKey(nodeId)) {
            nodeMap.put(nodeId, new GraphNode(nodeId, nodeModel));
        }
    }

    public void addEdge(int fromId, int toId) {
        GraphNode from = nodeMap.get(fromId);
        GraphNode to = nodeMap.get(toId);
        if (from != null && to != null) {
            GraphEdge edge = new GraphEdge(from, to);
            from.outgoingEdges.add(edge);
            to.incomingEdges.add(edge);
            edges.add(edge);
        }
    }

    public void deleteNode(int nodeId) {
        GraphNode node = nodeMap.get(nodeId);
        if (node != null) {
            // Reconnect incoming and outgoing nodes
            for (GraphEdge incomingEdge : new ArrayList<>(node.incomingEdges)) {
                for (GraphEdge outgoingEdge : new ArrayList<>(node.outgoingEdges)) {
                    GraphNode fromNode = incomingEdge.from;
                    GraphNode toNode = outgoingEdge.to;
                    GraphEdge newEdge = new GraphEdge(fromNode, toNode);
                    fromNode.outgoingEdges.add(newEdge);
                    toNode.incomingEdges.add(newEdge);
                    edges.add(newEdge);
                }
            }

            // Remove the node and its associated edges
            for (GraphEdge incomingEdge : node.incomingEdges) {
                incomingEdge.from.outgoingEdges.remove(incomingEdge);
                edges.remove(incomingEdge);
            }
            for (GraphEdge outgoingEdge : node.outgoingEdges) {
                outgoingEdge.to.incomingEdges.remove(outgoingEdge);
                edges.remove(outgoingEdge);
            }
            nodeMap.remove(nodeId);
        }
    }


//    public List<Integer> getNodes() {
//        return new ArrayList<>(nodeMap.keySet());
//    }

//    public List<List<Integer>> getEdges() {
//        List<List<Integer>> edgeList = new ArrayList<>();
//        for (GraphEdge edge : edges) {
//            List<Integer> e = new ArrayList<>();
//            e.add(edge.from.id);
//            e.add(edge.to.id);
//            edgeList.add(e);
//        }
//        return edgeList;
//    }

    public void printGraph() {
        for (GraphNode node : nodeMap.values()) {
            System.out.print("Node " + node.id + ": ");
            for (GraphEdge edge : node.outgoingEdges) {
                System.out.print("(" + edge.from.id + "->" + edge.to.id + ") ");
            }
            System.out.println();
        }
    }

    private void removeNode(int nodeId) {
        GraphNode node = nodeMap.get(nodeId);
        if (node != null) {
            for (GraphEdge edge : node.outgoingEdges) {
                GraphNode nextNode = edge.to;
                nextNode.incomingEdges.removeIf(e -> e.from == node);
                edges.remove(edge);
            }
            for (GraphEdge edge : node.incomingEdges) {
                GraphNode prevNode = edge.from;
                prevNode.outgoingEdges.removeIf(e -> e.to == node);
                edges.remove(edge);
            }
            nodeMap.remove(nodeId);
        }
    }
}
