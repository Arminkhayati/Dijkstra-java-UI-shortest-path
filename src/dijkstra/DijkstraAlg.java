package dijkstra;

import java.awt.*;
import java.util.*;
import java.util.List;

public class DijkstraAlg {

    public static List<Node> nodes; // Baraye paint kardan node ha dar canvas dar shorooe barname estefadeh mishe.
    public LinkedList<Node> nodeQueue;
    public MyCanvas canvas;

    public DijkstraAlg(){
        nodes = new ArrayList<>();
    }

    public void start() throws InterruptedException {

        Node currentNode;
        while (!nodeQueue.isEmpty()){
            currentNode = nodeQueue.pollFirst();

            for (int i = 0; i < currentNode.adjList.size(); i++) {
                Node adjNode = currentNode.adjList.get(i);
                int edgeWeight = currentNode.edgeWeight.get(i);
                currentNode.color = Color.YELLOW;
                canvas.repaint();
                Thread.currentThread().sleep(1000);

                if(!adjNode.visited){
                    adjNode.color = Color.green;
                    canvas.repaint();
                    Thread.currentThread().sleep(1000);

                    if(adjNode.weight == Integer.MAX_VALUE){
                        adjNode.weight = currentNode.weight + edgeWeight;
                        if(!nodeQueue.contains(adjNode))
                            nodeQueue.add(adjNode);
                    }else{
                        int weight = currentNode.weight + edgeWeight;
                        if(weight < adjNode.weight){
                            adjNode.weight = weight;
                            if(!nodeQueue.contains(adjNode))
                                nodeQueue.add(adjNode);
                        }
                    }
                    adjNode.color = Color.CYAN;
                    canvas.repaint();
                }
            }

            currentNode.visited = true;
            currentNode.color = Color.PINK;
            canvas.repaint();
            Thread.currentThread().sleep(1000);
            nodeQueue.sort(Comparator.comparing(Node::getWeight));
        }

    }

    public void initialize(){
        Node node1 = init();
        node1.weight = 0;
        nodeQueue = new LinkedList<>();
        nodeQueue.add(node1);
    }
    private Node init(){
        Node node1 = new Node(160,300);
        Node node2 = new Node(340,330);
        Node node3 = new Node(320,210);
        Node node4 = new Node(490,190);
        Node node5 = new Node(410,50);
        Node node6 = new Node(230,100);

        node1.adjList.add(node2);node1.adjList.add(node3);node1.adjList.add(node6);
        node1.edgeWeight.add(7);node1.edgeWeight.add(9);node1.edgeWeight.add(14);

        node2.adjList.add(node1);node2.adjList.add(node3);node2.adjList.add(node4);
        node2.edgeWeight.add(7);node2.edgeWeight.add(10);node2.edgeWeight.add(15);

        node3.adjList.add(node1);node3.adjList.add(node2);node3.adjList.add(node4);node3.adjList.add(node6);
        node3.edgeWeight.add(9);node3.edgeWeight.add(10);node3.edgeWeight.add(11);node3.edgeWeight.add(2);

        node4.adjList.add(node2);node4.adjList.add(node3);node4.adjList.add(node5);
        node4.edgeWeight.add(15);node4.edgeWeight.add(11);node4.edgeWeight.add(6);

        node5.adjList.add(node4);node5.adjList.add(node6);
        node5.edgeWeight.add(6);node5.edgeWeight.add(9);

        node6.adjList.add(node1);node6.adjList.add(node3);node6.adjList.add(node5);
        node6.edgeWeight.add(14);node6.edgeWeight.add(2);node6.edgeWeight.add(9);

        nodes.add(node1);nodes.add(node2);nodes.add(node3);nodes.add(node4);nodes.add(node5);nodes.add(node6);
        return node1;
    }

    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }

}
