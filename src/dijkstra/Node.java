package dijkstra;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Node {

    public Point point;
    public Boolean visited;
    public Integer weight;
    public List<Node> adjList;
    public List<Integer> edgeWeight;
    public Color color;
    public Node(int x , int y){
        point = new Point(x,y);
        visited = false;
        weight = Integer.MAX_VALUE;
        adjList = new ArrayList<Node>();
        edgeWeight = new ArrayList<Integer>();
        color = Color.CYAN;
    }
    public Integer getWeight(){return weight;}


}
