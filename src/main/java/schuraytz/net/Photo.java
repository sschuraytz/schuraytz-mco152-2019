package schuraytz.net;

public class Photo {

    private String url;
    private int albumId;
    private String title;
    private String thumbnailUrl;

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "url='" + url + '\'' +
                ", albumId=" + albumId +
                ", title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }


}
