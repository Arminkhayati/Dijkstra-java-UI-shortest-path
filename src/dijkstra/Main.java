package dijkstra;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{
                    Window frame = new Window();
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                }catch(Exception e){e.printStackTrace();}
            }
        });

    }
}
