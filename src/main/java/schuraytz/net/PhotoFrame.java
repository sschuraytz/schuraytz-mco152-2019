package schuraytz.net;

import io.reactivex.disposables.Disposable;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PhotoFrame extends JFrame {

    private final JPanel controls = new JPanel();
    private PhotoList photoList;
    private int photoCounter = 1;
    private final JLabel photoCounterLabel = new JLabel("1");
    private final JLabel imageLabel = new JLabel();
    private final JLabel imageTitleLabel = new JLabel();
    private final JButton leftButton = new BasicArrowButton(BasicArrowButton.WEST);
    private final JButton rightButton = new BasicArrowButton(BasicArrowButton.EAST);
    private final JList titleList = new JList();

    public PhotoFrame() {
        setTitle("PHOTOS");
        setSize(1200, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        root.add(imageTitleLabel, BorderLayout.NORTH);
        root.add(imageLabel, BorderLayout.CENTER);
        controls.add(leftButton);
        controls.add(photoCounterLabel);
        controls.add(rightButton);
        root.add(controls, BorderLayout.SOUTH);

        setContentPane(root);

        rightButton.addActionListener(actionEvent -> {
            if (photoCounter < photoList.size()) {
                photoCounter++;
                loadPicAndTitle();
            }
        });

        leftButton.addActionListener(actionEvent -> {
            if (photoCounter > 1) {
                photoCounter--;
                loadPicAndTitle();
            }
        });

        JsonPlaceholderClient client = new JsonPlaceholderClient();
        Disposable disposable = client.getPhotoList()
                .subscribe(photos -> {
                    photoList = photos;
                    loadPicAndTitle();
                    root.add(listScrollerSetUp(), BorderLayout.EAST);
                }
                );
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //dispose disposable when closing the window
                disposable.dispose();
            }

    });
    }

    public void loadPicAndTitle() {
        String photoUrl = photoList.get(photoCounter - 1).getUrl();
        String photoTitle = photoList.get(photoCounter - 1).getTitle();
        try {
            imageLabel.setIcon(new ImageIcon(new URL(photoUrl)));
            imageTitleLabel.setText(photoTitle);
            photoCounterLabel.setText(String.valueOf(photoCounter));
            titleList.setSelectedIndex(photoCounter - 1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String[] loadTitles() {
        ArrayList<String> photoTitles = new ArrayList<>();
        for (Photo photo : photoList) {
            photoTitles.add(photo.getTitle());
        }
        String[] photoTitlesArray = photoTitles.toArray(new String[0]);
        return photoTitlesArray;
    }

    public JScrollPane listScrollerSetUp() {
        titleList.setListData(loadTitles());
        titleList.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()){
                JList source = (JList) event.getSource();
                photoCounter = source.getSelectedIndex() + 1;
                loadPicAndTitle();
            }
        });
        JScrollPane listScroller = new JScrollPane(titleList);
        return listScroller;
    }

    public static void main(String[] args) {
        new PhotoFrame().setVisible(true);
    }
}
