package dijkstra;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MyCanvas extends Canvas {


    public MyCanvas(){
        setBackground (Color.WHITE);
        setSize(300, 300);
    }

    @Override
    public void repaint() {
        super.repaint();
        paint(this.getGraphics());

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        List<Node> nodes = DijkstraAlg.nodes;
        for (int i = 0 ; i < nodes.size() ; i++) {
            Node node = nodes.get(i);
            for (int j = 0 ; j < node.adjList.size() ; j++) {
                Node adjNode = node.adjList.get(j);
                Integer edgeWeight = node.edgeWeight.get(j);
                Font font = new Font("DejaVu Sans Mono", Font.BOLD, 15);
                g2.setFont(font);
                g2.setColor(Color.CYAN);
                int edgeWeightX = (node.point.x + adjNode.point.x) / 2;
                int edgeWeightY = (node.point.y + adjNode.point.y) / 2;
                g2.drawLine(node.point.x + 25, node.point.y + 25, adjNode.point.x + 25, adjNode.point.y + 25);
                g2.setColor(adjNode.color);
                g2.fillOval(adjNode.point.x, adjNode.point.y, 50, 50);
                g2.setColor(Color.DARK_GRAY);
                g2.drawString(edgeWeight.toString(), edgeWeightX,edgeWeightY + 30);
                if(adjNode.weight == Integer.MAX_VALUE)
                    g2.drawString("∞", adjNode.point.x + 20, adjNode.point.y + 30);
                else
                    g2.drawString(adjNode.weight.toString(), adjNode.point.x + 20, adjNode.point.y + 30);

            }
        }
    }
}
