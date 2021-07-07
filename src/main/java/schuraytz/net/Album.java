package schuraytz.net;

public class Album {

    private String title;
    private int userId;
    private int id;

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
