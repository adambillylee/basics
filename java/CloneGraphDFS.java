import java.util.HashMap;

/**
 * Created by adamli on 4/26/16.
 */
public class CloneGraphDFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return helper(node, visited);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
        if (visited.containsKey(node))
            return visited.get(node);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(node, newNode);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode newNeighbor = helper(neighbor, visited);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}
