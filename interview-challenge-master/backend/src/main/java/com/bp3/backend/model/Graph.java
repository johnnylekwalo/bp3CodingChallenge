package com.bp3.backend.model;

import jakarta.servlet.ServletOutputStream;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

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

    public void constructGraphNodes(ArrayList<NodeModel> nodeList) {
        // Create nodes
        for (NodeModel nodeModel : nodeList) {
            nodes.add(new GraphNode(parseInt(nodeModel.getId()),nodeModel));
        }

        // Create edges

    }

    public void constructGraph(ArrayList<EdgeModel> edges, Graph graph) {
        for (EdgeModel edge : edges) {
            GraphNode fromNode = getGraph(edge.from, graph);
            GraphNode toNode = getGraph(edge.to, graph);
            fromNode.to.add(toNode);
            toNode.from.add(fromNode);
        }
    }
    public Graph() {
        this.nodes = new ArrayList<>();
    }





    public void deleteNode(GraphNode node) {
        System.out.println("deleteNode:" + node.getNode().name);
        nodes.remove(node);

        // Remove connections to the deleted node for all other nodes
        for (GraphNode n : nodes) {
            n.from.remove(node);
            n.to.remove(node);
            connectAdjacentNodes(n);
        }
    }

    public void connectAdjacentNodes(GraphNode node) {
        System.out.println("connectAdjacentNodes :" +node.id);
        System.out.println("connectAdjacentNodes node.to.size():" +node.to.size());
        System.out.println("connectAdjacentNodes node.from.size():" +node.from.size());
        for (GraphNode adjNode : node.from) {
            for (GraphNode toNode : adjNode.to) {
                if (!node.to.contains(toNode) && toNode != node) {
                    node.to.add(toNode);
                    connectAdjacentNodes(toNode);
                }
            }
        }

        for (GraphNode adjNode : node.to) {
            for (GraphNode fromNode : adjNode.from) {
                if (!node.from.contains(fromNode) && fromNode != node) {
                    node.from.add(fromNode);
                    connectAdjacentNodes(fromNode);
                }
            }
        }
    }
    public ArrayList<NodeModel> deconstructNodes(Graph graph) {
        ArrayList<NodeModel> nodeList = new ArrayList<>();
        for (GraphNode node : nodes) {
            nodeList.add(node.getNode());
        }
        return nodeList;
    }

    public ArrayList<EdgeModel> deconstructEdges() {
        ArrayList<EdgeModel> edges = new ArrayList<>();
        for (GraphNode node : nodes) {
            System.out.println("node.id :"+ node.node.id);
            for (GraphNode toNode : node.to) {
                System.out.println("node.to :"+ toNode.node.id);
                edges.add(new EdgeModel(String.valueOf(node.node.id),String.valueOf(toNode.node.id)));
            }
            for (GraphNode fromNode : node.from) {
                System.out.println("node.from :"+ fromNode.node.id);
//                edges.add(new EdgeModel(String.valueOf(node.id),String.valueOf(toNode.id)));
            }
        }
        return edges;
    }

    public GraphNode getGraph(String id , Graph graph){
        GraphNode graphNodeById = null;
        for(GraphNode graphNode: graph.getNodes()){
            int idFromInt = Integer.parseInt(id);
            if(idFromInt==graphNode.getId()){
                graphNodeById = graphNode;
                return graphNodeById;
            }
        }
        return graphNodeById;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}
