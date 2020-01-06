package com.bw.fyc.model;

import com.bw.fyc.model.bean.ClassifyBean;
import com.bw.fyc.model.bean.CommodityBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:9:29
 *@Description:${DESCRIPTION}
 *
 */public interface Api {

    @GET("blog.zhaoliang5156.cn/baweiapi/category")
    Observable<ClassifyBean> getClassifbean();

    @GET("blog.zhaoliang5156.cn/baweiapi/category")
    Observable<CommodityBean> getCommoditybean(@Query("category") String category, @Query("page") int page, @Query("count") int count);
}
