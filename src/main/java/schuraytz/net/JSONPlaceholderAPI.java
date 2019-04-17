package schuraytz.net;

import com.google.gson.Gson;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//public class JSONPlaceholderAPI {
public interface JSONPlaceholderAPI {

    @GET("/users")
    //Call<UserList> getUserList();
    Observable<UserList> getUserList();

    @GET("/photos")
    Observable<PhotoList> getPhotoList();

    @GET("/albums")
    Observable<AlbumList> getAlbumList();

/*    public UserList getUserList() throws IOException {

        URL url = new URL("https://jsonplaceholder.typicode.com/users"); // in a url, when you type 'https', you're identifying the port (80)
        URLConnection connection = url.openConnection();


        //OutputStream out = socket.getOutputStream();
        /////// no longer need this part b/c the URL knows how to speak HTTP
        //it's inefficient to continuously write to the disk. So now we tell it to send what we've written;
            *//*
                OutputStream out = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(out);
                writer.write("GET /index.html\n\n");
                writer.flush();  *//*   //what I've written so far is still just sitting in memory, b/c you might continue writing more,

        //InputStream in = socket.getInputStream();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        UserList list = gson.fromJson(reader, UserList.class);

        return list;
    }

    public PhotoList getPhotoList() throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/photos"); // in a url, when you type 'https', you're identifying the port (80)
        URLConnection connection = url.openConnection();

        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        PhotoList photos = gson.fromJson(reader, PhotoList.class);

        return photos;

    }*/
}
