package com.bp3.backend;

import com.bp3.backend.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}



    @Test
    public void removeNonHumanTask(){
        NodeModel node0 = new NodeModel("0","Start",NodeType.START);
        NodeModel node1 = new NodeModel("1","ServiceTask",NodeType.SERVICE_TASK);
        NodeModel node2 = new NodeModel("2","End",NodeType.END);

        //iterate through edges
        EdgeModel edge0 = new EdgeModel(node0.getId(), node1.getId());
        EdgeModel edge1 = new EdgeModel(node1.getId(), node2.getId());

        ProcessDiagram processDiagram = new ProcessDiagram();
        processDiagram.getNodes().add(node0);
        processDiagram.getNodes().add(node1);
        processDiagram.getNodes().add(node2);

        processDiagram.getEdges().add(edge0);
        processDiagram.getEdges().add(edge1);

        System.out.println("1st .getNodes().size() :"+ processDiagram.getNodes().size());
        ProcessDiagram processDiagram1 = processDiagram.filterHumanTasks(processDiagram);
        System.out.println("2nd .getNodes().size() :"+ processDiagram1.getNodes().size());


//        AdjacentList process = new AdjacentList(new NodeImpl[] {node0,node1,node2} ,new AdjacentItem[] {edge0,edge1});
//
//        //
//        AdjacentItem edgeRes0 = new AdjacentItem(node0, new NodeImpl[] {node2});
//        AdjacentList processRes = new AdjacentList(new NodeImpl[] {node0,node1,node2}, new AdjacentItem[] {edgeRes0});
//
//        process.isolateNode(node1);
//
//        assertEquals(process, processRes);
//
//        NodeImpl processGatewayNode0 = new NodeImpl("0", "Start", NodeType.START);
//        NodeImpl processGatewayNode1 = new NodeImpl("1", "A", NodeType.SERVICE_TASK);
//        NodeImpl processGatewayNode2 = new NodeImpl("2", "B", NodeType.HUMAN_TASK);
//        NodeImpl processGatewayNode3 = new NodeImpl("3", "G1", NodeType.GATEWAY);
//        NodeImpl processGatewayNode4 = new NodeImpl("4", "C", NodeType.HUMAN_TASK);
//        NodeImpl processGatewayNode5 = new NodeImpl("5", "D", NodeType.HUMAN_TASK);
//        NodeImpl processGatewayNode6 = new NodeImpl("6", "G2", NodeType.GATEWAY);
//        NodeImpl processGatewayNode7 = new NodeImpl("7", "#", NodeType.SERVICE_TASK);
//        NodeImpl processGatewayNode8 = new NodeImpl("8", "end", NodeType.END);
//
//        AdjacentItem edgeGW0 = new AdjacentItem(processGatewayNode0, new NodeImpl[] {processGatewayNode1});
//        AdjacentItem edgeGW1 = new AdjacentItem(processGatewayNode1, new NodeImpl[] {processGatewayNode2});
//        AdjacentItem edgeGW2 = new AdjacentItem(processGatewayNode2, new NodeImpl[] {processGatewayNode3});
//        AdjacentItem edgeGW3 = new AdjacentItem(processGatewayNode3, new NodeImpl[] {processGatewayNode4, processGatewayNode5});
//        AdjacentItem edgeGW4 = new AdjacentItem(processGatewayNode4, new NodeImpl[] {processGatewayNode6});
//        AdjacentItem edgeGW5 = new AdjacentItem(processGatewayNode5, new NodeImpl[] {processGatewayNode6});
//        AdjacentItem edgeGW6 = new AdjacentItem(processGatewayNode6, new NodeImpl[] {processGatewayNode2,processGatewayNode7});
//        AdjacentItem edgeGW8 = new AdjacentItem(processGatewayNode7, new NodeImpl[] {processGatewayNode8});
//
//        NodeImpl[] nodeList =new NodeImpl[] {processGatewayNode0,processGatewayNode1,processGatewayNode2,processGatewayNode3,processGatewayNode4,processGatewayNode5,processGatewayNode6,processGatewayNode7,processGatewayNode8};
//        AdjacentItem[] edgeGWList = new AdjacentItem[] {edgeGW0,edgeGW1,edgeGW2,edgeGW3,edgeGW4,edgeGW5,edgeGW6,edgeGW8};
//        AdjacentList gateWprocess = new AdjacentList(nodeList, edgeGWList);
//        gateWprocess.deleteAdjacentItem(edgeGW3);
    }

}
