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
    private final JLabel PHOTO_COUNTER_LABEL = new JLabel("1");
    private final JLabel IMAGE_LABEL = new JLabel();
    private final JLabel IMAGE_TITLE_LABEL = new JLabel();
    private final JButton LEFT_BUTTON = new BasicArrowButton(BasicArrowButton.WEST);
    private final JButton RIGHT_BUTTON = new BasicArrowButton(BasicArrowButton.EAST);
    private final JList TITLE_LIST = new JList();

    public PhotoFrame() {
        setTitle("PHOTOS");
        setSize(1200, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        root.add(IMAGE_TITLE_LABEL, BorderLayout.NORTH);
        root.add(IMAGE_LABEL, BorderLayout.CENTER);
        controls.add(LEFT_BUTTON);
        controls.add(PHOTO_COUNTER_LABEL);
        controls.add(RIGHT_BUTTON);
        root.add(controls, BorderLayout.SOUTH);

        setContentPane(root);

        RIGHT_BUTTON.addActionListener(actionEvent -> {
            if (photoCounter < photoList.size()) {
                photoCounter++;
                loadPicAndTitle();
            }
        });

        LEFT_BUTTON.addActionListener(actionEvent -> {
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
                //dispose disposable when closing the  window
                disposable.dispose();
            }

    });
    }

    public void loadPicAndTitle() {
        String photoUrl = photoList.get(photoCounter - 1).getUrl();
        String photoTitle = photoList.get(photoCounter - 1).getTitle();
        try {
            IMAGE_LABEL.setIcon(new ImageIcon(new URL(photoUrl)));
            IMAGE_TITLE_LABEL.setText(photoTitle);
            PHOTO_COUNTER_LABEL.setText(String.valueOf(photoCounter));
            TITLE_LIST.setSelectedIndex(photoCounter - 1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Object[] loadTitles() {
        ArrayList<String> photoTitles = new ArrayList<>();
        for (Photo photo : photoList) {
            photoTitles.add(photo.getTitle());
        }
        Object[] photoTitlesArray = photoTitles.toArray();
        return photoTitlesArray;
    }

    public JScrollPane listScrollerSetUp() {
        TITLE_LIST.setListData(loadTitles());
        TITLE_LIST.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()){
                JList source = (JList) event.getSource();
                photoCounter = source.getSelectedIndex() + 1;
                loadPicAndTitle();
            }
        });
        JScrollPane listScroller = new JScrollPane(TITLE_LIST);
        return listScroller;
    }

    public static void main(String[] args) {
        new PhotoFrame().setVisible(true);
    }
}
