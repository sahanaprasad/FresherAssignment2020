package assignment3.model;

import java.util.HashMap;
import java.util.Map;

public class Node {
  int id;
  String name;
  public Map<Integer, String> information;
  public Map<Integer, Node> children;
  public Map<Integer, Node> parents;

  public Node(int id, String name) {
    this.id = id;
    this.name = name;
    information = new HashMap<>();
    children = new HashMap<>();
    parents = new HashMap<>();

  }
    @Override
    public String toString() {
        return "Node [id=" + id + ", name=" + name +  "]";
    }
}
