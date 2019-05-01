package schuraytz.net;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoFrame extends JFrame {

    private final JPanel controls = new JPanel();
    private JLabel photoCounterLabel = new JLabel("1");
    private PhotoList photoList;
    int photoCounter = 1;
    private final JLabel imageLabel = new JLabel();
    private final JButton leftButton = new BasicArrowButton(BasicArrowButton.WEST);
    private final JButton rightButton = new BasicArrowButton(BasicArrowButton.EAST);


    public PhotoFrame() throws MalformedURLException {
        setTitle("PHOTOS");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        root.add(imageLabel, BorderLayout.CENTER);
        root.add(controls, BorderLayout.SOUTH);
        controls.add(leftButton);
        controls.add(photoCounterLabel);
        controls.add(rightButton);
        root.add(controls, BorderLayout.SOUTH);

        setContentPane(root);

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                photoCounter++;
                photoCounterLabel.setText(String.valueOf(photoCounter));
                loadPic();
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (photoCounter > 1) {
                    photoCounter--;
                    photoCounterLabel.setText(String.valueOf(photoCounter));
                   loadPic();
                }
            }
        });


        JsonPlaceholderClient client = new JsonPlaceholderClient();
        Disposable disposable = client.getPhotoList()
                .subscribe(new Consumer<PhotoList>() {
                    @Override
                    public void accept(PhotoList photos) throws Exception {
                        photoList = photos;
                        loadPic();
                    }
                }
                );
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //dispose disposable when closing the  window
                disposable.dispose();
            }

    });
    }


    public void loadPic() {
        String photoUrl = photoList.get(photoCounter - 1).getUrl();
        try {
            imageLabel.setIcon(new ImageIcon(new URL(photoUrl)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws MalformedURLException {
        new PhotoFrame().setVisible(true);
    }

}
