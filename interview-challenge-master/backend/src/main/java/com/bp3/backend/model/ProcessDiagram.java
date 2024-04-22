package com.bp3.backend.model;

import com.bp3.backend.NodeType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.bp3.backend.NodeType.HUMAN_TASK;
import static com.bp3.backend.NodeType.SERVICE_TASK;
import static java.lang.Integer.parseInt;

public class ProcessDiagram {
    private ArrayList<NodeModel> nodes = new ArrayList<>();
    private ArrayList<EdgeModel> edges = new ArrayList<>();

    public ArrayList<NodeModel> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<NodeModel> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<EdgeModel> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<EdgeModel> edges) {
        this.edges = edges;
    }


    public ProcessDiagram filterHumanTasks(ProcessDiagram processDiagram){


        //Build Tree
        ArrayList<NodeModel> nodes = processDiagram.getNodes();
        ArrayList<EdgeModel> edgeModels = processDiagram.getEdges();



//        Graph graph = new Graph();
        Graph graph = constructGraph(nodes, edgeModels);

        // Print the graph
        System.out.println("Constructed Graph:");
        graph.printGraph();



        //remove service task
        for(NodeModel nodeModel:processDiagram.nodes){
            if(nodeModel.type.equals(NodeType.HUMAN_TASK)){
                // Remove node 2 and its adjacent edges recursively
                graph.deleteNode(Integer.parseInt(nodeModel.id));

            }
        }

        System.out.println("After Graph:");
        graph.printGraph();


        ProcessDiagram processDiagram1 = new ProcessDiagram();
        ArrayList<EdgeModel> edgeModels1 = graph.getEdges();
        ArrayList<NodeModel> nodeModels1 = new ArrayList<>();
        for ( GraphNode graphNode:
                graph.getNodes()) {
            nodeModels1.add(graphNode.node);
        }
        processDiagram1.setEdges(edgeModels1);
        processDiagram1.setNodes(nodeModels1);

        return processDiagram1;
    }

    private static Graph constructGraph(List<NodeModel> nodes, ArrayList<EdgeModel> edges) {
        Graph graph = new Graph();

        // Adding nodes
        for (NodeModel node : nodes) {
            graph.addNode(Integer.parseInt(node.id),node);
        }

        // Adding edges
        for (EdgeModel edge : edges) {
            graph.addEdge(Integer.parseInt(edge.from), Integer.parseInt(edge.to));
        }

        return graph;
    }

    @Override
    public String toString() {
        return "ProcessDiagram{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
