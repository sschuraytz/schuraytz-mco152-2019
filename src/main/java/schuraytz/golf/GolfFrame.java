package schuraytz.golf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GolfFrame extends JFrame {

    public GolfFrame() {
        setTitle("Touro Golf");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //first, we need a panel
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout()); //lays out all our components in a way that allows up to expand & contract
        //BorderLayout is the name of the class that holds the logic that enables us to do above

        JLabel north = new JLabel(new ImageIcon("flax.png"));
        north.setBackground(Color.BLUE);
        north.setOpaque(true);
        root.add(north, BorderLayout.NORTH);

        JLabel south = new JLabel("SOUTH");
        south.setBackground(Color.CYAN);
        south.setOpaque(true);
        root.add(south, BorderLayout.SOUTH);

        JLabel west = new JLabel("WEST");
        west.setBackground(Color.GREEN);
        west.setOpaque(true);
        root.add(west, BorderLayout.WEST);


        JButton center = new JButton("CENTER");
        center.setBackground(Color.RED);
        center.setOpaque(true);
        root.add(center, BorderLayout.CENTER);

        center.addActionListener(this::printClick);

        //ActionListener is an interface

        setContentPane(root);

    }

    public void printClick(ActionEvent actionEvent) {

        System.out.println("CLICK");
    }
}
