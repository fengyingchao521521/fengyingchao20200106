package com.bw.fyc.utile;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bw.fyc.model.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:9:18
 *@Description:${DESCRIPTION}
 *
 */public class NetUtil {
    private static String BASE_URl = "http://";
    private final OkHttpClient okHttpClient;
    private final Api aPi;
    private final Retrofit retrofit;

    private NetUtil() {
        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //okhttp
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        //
        retrofit = new Retrofit.Builder()
                //公共的URL
                .baseUrl(BASE_URl)
                //公共的okhttp
                .client(okHttpClient)
                //支持
                .addConverterFactory(GsonConverterFactory.create())
                //支持Rx
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        aPi = retrofit.create(Api.class);


    }

    public Api getaPi() {
        return aPi;
    }

    public static NetUtil getInstance() {
        return SinghtHadel.NUT_UTL;
    }

    private static class SinghtHadel {
        private static NetUtil NUT_UTL = new NetUtil();
    }

    //网络
    public boolean gethasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }

    }

}
