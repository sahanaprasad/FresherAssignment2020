package Assignment3;

import Assignment3.Exception.NodeDoesNotExist;
import Assignment3.Node;

import java.util.*;

public class GraphOperation {
    Scanner input = new Scanner(System.in);
    Map<Integer, Node> graph = new HashMap<>();

    public void addNode() {
        System.out.println("enter the node ID");
        int id = input.nextInt();
        System.out.println("enter the node name");
        String name = input.next();
        Node n = new Node(id, name);
        System.out.println("node successfully created");
        graph.put(id, n);
    }

    public boolean CheckCycle(int pid, int cid) throws NodeDoesNotExist {
        List<Integer> Descendants = getDescendants(cid);
        return Descendants.contains(pid);
    }

    public void addDependency() throws NodeDoesNotExist {
        System.out.println("enter the parent ID");
        int pid = input.nextInt();
        System.out.println("enter the child ID");
        int cid = input.nextInt();


        Set<Map.Entry<Integer, Node>> st = graph.entrySet();
        if(CheckCycle(pid,cid))
        {
            System.out.println("Dependency creates a cycle,hence cannot be added");
        }
        else{

            graph.get(pid).children.put(cid, graph.get(cid));
            graph.get(cid).parents.put(pid, graph.get(pid));
            System.out.println("Dependency Added");

        }
    }

    public void getImmediateParent(int cid) throws NodeDoesNotExist {
        if(graph.containsKey(cid))
        {
            System.out.println(graph.get(cid).parents);
        }
        else{
            throw new NodeDoesNotExist("Node does not exist");

        }

    }
    public void deleteDependency(int pid, int cid) {
        graph.get(pid).children.remove(cid, graph.get(cid));
        graph.get(cid).parents.remove(pid, graph.get(pid));
    }

    public void deleteNode() {
        System.out.println("enter the Node ID to be deleted");
        int id = input.nextInt();

        System.out.println(graph.get(id).children.keySet());
        Set setChildren = (graph.get(id).children.keySet());
        for (Object i : setChildren) {
            graph.get(i).parents.remove(id, graph.get(id));
        }
        Set setParent = (graph.get(id).parents.keySet());
        for (Object i : setParent) {
            graph.get(i).children.remove(id, graph.get(id));
        }
        System.out.println("Node successfully deleted");

    }

    public void getImmediateChildren(int pid) throws NodeDoesNotExist {
        if(graph.containsKey(pid)){
            System.out.println(graph.get(pid).children);
        }
        else throw new NodeDoesNotExist("Node does not exist");
    }

    public List<Integer> getAncestors(int cid) throws NodeDoesNotExist {
        if(graph.containsKey(cid)){
        List<Integer> Ancestors = new ArrayList<>();
        if (graph.get(cid).parents.isEmpty()) {
            return Ancestors;
        }
        for (Integer ids : graph.get(cid).parents.keySet()) {

               Ancestors.add(ids);
               Ancestors.addAll(getAncestors(ids));
        }
        System.out.println(Ancestors);
        return Ancestors;
        }
        else throw new NodeDoesNotExist("Node does not exist");
    }

    public List<Integer> getDescendants(int pid) throws NodeDoesNotExist {
        if(graph.containsKey(pid)){
        List<Integer> Descendants = new ArrayList<>();
        if (graph.get(pid).children.isEmpty()) {
            return Descendants;
        }
        for (Integer ids : graph.get(pid).children.keySet()) {

                Descendants.add(ids);
                Descendants.addAll(getDescendants(ids));

        }
        System.out.println(Descendants);
        return Descendants;
        }
        else throw new NodeDoesNotExist("Node does not exist");

    }


}
