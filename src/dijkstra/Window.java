package dijkstra;

import dijkstra.MyCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    JPanel contentPane ;
    MyCanvas canvas ;
    JButton startbtn;

    public Window(){
        setBounds(100, 100, 800, 650);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        DijkstraAlg alg = new DijkstraAlg();
        alg.initialize();
        canvas = new MyCanvas();
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(30, 50, 720, 500);
        contentPane.add(canvas);
        alg.setCanvas(canvas);

        startbtn = new JButton("Start");
        startbtn.setBounds(350,580,100,30);
        startbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                try{
                    alg.start();
                } catch (InterruptedException e){e.printStackTrace();}

            }
        });
        contentPane.add(startbtn);




    }

}
