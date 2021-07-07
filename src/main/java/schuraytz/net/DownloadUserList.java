package schuraytz.net;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.*;

public class DownloadUserList {

    // raw request to a web server; if you want to send messages to each other, you could use sockets as well
    public static void main(String[] args) throws IOException {

        PhotoFrame frame = new PhotoFrame();
        frame.setVisible(true);

        /*Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        JSONPlaceholderAPI api = retrofit.create(JSONPlaceholderAPI.class);


        Call<PhotoList> call = api.getPhotoList();
        Response<PhotoList> response = call.execute();
        PhotoList list = response.body();
        System.out.println(list);*/

        //can no longer use this b/c it's not longer a class so you can't instantiate it
        // JSONPlaceholderAPI api = new JSONPlaceholderAPI();  // main  throws IOException

   /*     UserList list = api.getUserList();
        System.out.println(list);
*/
       /* PhotoList photo = api.getPhotoList();
        System.out.println(photo);*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //use retrofit to create an API
        JSONPlaceholderAPI api = retrofit.create(JSONPlaceholderAPI.class);

        /*Observable<PhotoList> observable = api.getPhotoList();
        observable.subscribe ( list -> {System.out.println(list);} );*/

        // subscribe to what it 's returning and pipe that to System.out.println
        //make it easier to read/shorter
        Disposable disposable = api.getPhotoList().subscribe(
                new Consumer<PhotoList>() {
                    @Override
                    public void accept(PhotoList photos) throws Exception {
                        System.out.println(photos);
                    }
                }
            );

      /*  AlbumList album = api.getAlbumList();
        System.out.println(album);*/
    }
}

// connect to the server on the right port - this is TCP, the web doesn't just run on TCP
// we've connected to the computer, but haven't yet told it what we want
//Socket socket = new Socket("www.yahoo.com", 80);

//rather than use a socket, let's use a URL; had to give it a host name & a port
// URL url = new URL("https://touro.edu\n\n"); // in a url, when you type 'https', you're identifying the port (80)


// System.out.println(list);

/*        String line = null;
        while ( (line = reader.readLine() ) != null) {
            System.out.println(line);
        }*/
