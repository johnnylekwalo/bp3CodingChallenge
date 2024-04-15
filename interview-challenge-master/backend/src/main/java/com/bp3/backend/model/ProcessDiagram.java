package com.bp3.backend.model;

import java.util.ArrayList;
import java.util.List;

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


        List<GraphNode> graphNodes = new ArrayList<>();
        for(NodeModel node:nodes){
            GraphNode graphNode = new GraphNode(parseInt(node.getId()), node);
            graphNodes.add(graphNode);
        }
        Graph graph = new Graph(graphNodes);

        for( EdgeModel edgeModel : edgeModels){
            String idFrom = edgeModel.getFrom();
            String idTo = edgeModel.getTo();

            //get The graph nodes
            GraphNode graphFrom = getGraph(idFrom , graph);
            GraphNode graphTo = getGraph(idTo, graph);

            // if not in list already add to adjacent
            List<GraphNode> adjacentNodesFrom = graphFrom.getAdjacentNodes();
            if(!adjacentNodesFrom.contains(graphTo)){
                adjacentNodesFrom.add(graphTo);
            }

            List<GraphNode> adjacentNodesTo = graphTo.getAdjacentNodes();
            if(!adjacentNodesTo.contains(graphFrom)){
                adjacentNodesTo.add(graphFrom);
            }

        }


        //remove service task
        for(NodeModel nodeModel:processDiagram.nodes){
            if(nodeModel.type.equals(SERVICE_TASK)){
                graph.removeNode(Integer.parseInt(nodeModel.id));
            }
        }

        //Graph back to processDiagram
        ProcessDiagram processDiagram1 = new ProcessDiagram();
        ArrayList<EdgeModel> edgeModels1 = new ArrayList<>();
        ArrayList<NodeModel> nodeModels1 = new ArrayList<>();
        for(GraphNode graphNode :graph.getNodes()) {
            NodeModel nodeModel;
            nodeModel = graphNode.getNode();
            for(GraphNode graphNodeAdjacent : graphNode.adjacentNodes) {
                EdgeModel edgeModel = new EdgeModel(nodeModel.getId(),String.valueOf(graphNodeAdjacent.getId()));
                edgeModels1.add(edgeModel);
            }
            nodeModels1.add(nodeModel);
        }
        processDiagram1.setEdges(edgeModels1);
        processDiagram1.setNodes(nodeModels1);

        return processDiagram1;
    }


}
