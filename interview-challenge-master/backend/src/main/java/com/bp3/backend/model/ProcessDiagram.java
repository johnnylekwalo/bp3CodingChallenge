package com.bp3.backend.model;

import com.bp3.backend.NodeType;

import java.util.ArrayList;
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
    public ProcessDiagram filterHumanTasks(ProcessDiagram processDiagram){


        //Build Tree
        ArrayList<NodeModel> nodes = processDiagram.getNodes();
        ArrayList<EdgeModel> edgeModels = processDiagram.getEdges();


//        List<GraphNode> graphNodes = new ArrayList<>();
//        for(NodeModel node:nodes){
//            GraphNode graphNode = new GraphNode(parseInt(node.getId()), node);
//            graphNodes.add(graphNode);
//        }
        Graph graph = new Graph();
        graph.constructGraphNodes(nodes);
        graph.constructGraph(edgeModels,graph);



        //remove service task
        for(NodeModel nodeModel:processDiagram.nodes){
            if(nodeModel.type.equals(NodeType.HUMAN_TASK)){
                GraphNode graphToBeDeleted = getGraph(nodeModel.id, graph);
                graph.deleteNode(graphToBeDeleted);
            }
        }

        System.out.println("Final Final"+graph.nodes.toString());

       System.out.println("After DELETE "+ graph.nodes.size());
        ProcessDiagram processDiagram1 = new ProcessDiagram();
        ArrayList<EdgeModel> edgeModels1 = graph.deconstructEdges();
        ArrayList<NodeModel> nodeModels1 = graph.deconstructNodes(graph);
        processDiagram1.setEdges(edgeModels1);
        processDiagram1.setNodes(nodeModels1);

        return processDiagram1;
    }

    @Override
    public String toString() {
        return "ProcessDiagram{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
