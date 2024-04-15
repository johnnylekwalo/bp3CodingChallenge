package com.bp3.backend.model;

import com.bp3.backend.Edge;
import com.bp3.backend.Node;
import com.bp3.backend.NodeType;

import java.util.Objects;

public class NodeModel implements Node {
    String id;
    String name;
    NodeType type;

    public NodeModel(String id, String name, NodeType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public NodeType getType() {
        return type;
    }

    @Override
    public void setType(NodeType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        NodeModel node = (NodeModel) o;
        return this.id.equals(node.id);
    }


}
