package schuraytz.net;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonPlaceholderClient {

    private final JSONPlaceholderAPI api;

    public JsonPlaceholderClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //use retrofit to create an API
        api = retrofit.create(JSONPlaceholderAPI.class);
    }

    Observable<PhotoList> getPhotoList() {
        return api.getPhotoList();
    }
}
