package top.blesslp.com.sample;

import android.app.Application;

import http.logging.HttpLogger;
import http.logging.HttpLoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import top.blesslp.http.RetrofitWrapper;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitWrapper instance = RetrofitWrapper.getInstance();
        HttpLoggingInterceptor tag = new HttpLoggingInterceptor(new HttpLogger("TAG"));
        tag.level(HttpLoggingInterceptor.Level.BODY);
        instance.setOkClient(new OkHttpClient.Builder()
                .addInterceptor(tag)
                .build());

        instance.setRetrofit(new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build());

        instance.init();


    }
}

