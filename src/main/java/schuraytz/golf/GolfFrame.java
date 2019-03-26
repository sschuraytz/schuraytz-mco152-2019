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

        //JButton center = new JButton("CENTER");
        GolfCourseComponent golfCourseComponent = new GolfCourseComponent();
        root.add(golfCourseComponent, BorderLayout.CENTER);

        //ActionListener is an interface

        setContentPane(root);

    }

    public void printClick(ActionEvent actionEvent) {

        System.out.println("CLICK");
    }
}
