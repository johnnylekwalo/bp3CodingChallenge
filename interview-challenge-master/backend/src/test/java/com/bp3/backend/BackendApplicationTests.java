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
        NodeModel node1 = new NodeModel("1","ServiceTask",NodeType.HUMAN_TASK);
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


        ProcessDiagram processDiagram1 = processDiagram.filterHumanTasks(processDiagram);

        System.out.println("processDiagram1.toString() :"+ processDiagram1.toString());

    }

    @Test
    public void removeNonHumanTask2(){
        NodeModel node0 = new NodeModel("0","Start",NodeType.START);
        NodeModel node1 = new NodeModel("1","A",NodeType.HUMAN_TASK);
        NodeModel node2 = new NodeModel("2","B",NodeType.HUMAN_TASK);
        NodeModel node3 = new NodeModel("3","C",NodeType.SERVICE_TASK);
        NodeModel node4 = new NodeModel("4","D",NodeType.HUMAN_TASK);
        NodeModel node5 = new NodeModel("5","End",NodeType.END);

        //iterate through edges
        EdgeModel edge0 = new EdgeModel(node0.getId(), node1.getId());
        EdgeModel edge1 = new EdgeModel(node1.getId(), node2.getId());
        EdgeModel edge2 = new EdgeModel(node2.getId(), node3.getId());
        EdgeModel edge3 = new EdgeModel(node3.getId(), node4.getId());
        EdgeModel edge4 = new EdgeModel(node4.getId(), node5.getId());

        ProcessDiagram processDiagram = new ProcessDiagram();
        processDiagram.getNodes().add(node0);
        processDiagram.getNodes().add(node1);
        processDiagram.getNodes().add(node2);
        processDiagram.getNodes().add(node3);
        processDiagram.getNodes().add(node4);
        processDiagram.getNodes().add(node5);

        processDiagram.getEdges().add(edge0);
        processDiagram.getEdges().add(edge1);
        processDiagram.getEdges().add(edge2);
        processDiagram.getEdges().add(edge3);
        processDiagram.getEdges().add(edge4);


        ProcessDiagram processDiagram1 = processDiagram.filterHumanTasks(processDiagram);
        System.out.println("processDiagram1 :"+ processDiagram1.toString());
    }

}
