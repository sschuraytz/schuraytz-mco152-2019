//issue: if the window is resized, the ball changes location

package schuraytz.golf;

import schuraytz.physics.Projectile;

import javax.swing.*;
import java.awt.*;


public class GolfFrame extends JFrame {

    private JPanel controls = new JPanel();
    private GolfCourseComponent golfCourseComponent = new GolfCourseComponent();

    private JLabel powerLabel = new JLabel("Power");
    private JTextField powerTextField = new JTextField("",5);
    private JLabel angleLabel = new JLabel("Angle");
    private JTextField angleTextField = new JTextField("",5);
    private JButton goButton = new JButton("GO");
    private JLabel errorMessage = new JLabel();

    public GolfFrame() {
        setTitle("Touro Golf");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        root.add(golfCourseComponent, BorderLayout.CENTER);

        setContentPane(root);
        createControlPanel();
        animateBall();

        root.add(controls, BorderLayout.SOUTH);
    }


    public void createControlPanel() {
        controls.add(powerLabel);
        controls.add(powerTextField);
        controls.add(angleLabel);
        controls.add(angleTextField);
        controls.add(goButton);
        controls.add(errorMessage);
    }

    public void animateBall() {
        goButton.addActionListener(event -> {
            if (isValid(powerTextField) && isValid(angleTextField)) {
                Projectile projectile = new Projectile(
                        Double.parseDouble(powerTextField.getText()),
                        Double.parseDouble(angleTextField.getText()));
                golfCourseComponent.setGolfBall(projectile);
                errorMessage.setText("");
            }
            else {
                errorMessage.setText("NUMBERS ONLY!");
            }
        });
    }

    public boolean isValid(JTextField tf) {
        try {
            Integer.parseInt(tf.getText());
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
