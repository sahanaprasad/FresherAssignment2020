package Assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

    int id;
    String name;
    Map<Integer, String> information;
    Map<Integer, Node>children;
    Map<Integer, Node> parents;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, String> getInformation() {
        return information;
    }

    public Map<Integer, Node> getChildren() {
        return children;
    }

    public Map<Integer, Node> getParents() {
        return parents;
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
        information=new HashMap<>();
       children=new HashMap<>();
        parents=new HashMap<>();

    }
    @Override
    public String toString() {
        return "Node [id=" + id + ", name=" + name +  "]";
    }

}