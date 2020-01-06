package com.bw.fyc.contract;

import com.bw.fyc.model.bean.ClassifyBean;
import com.bw.fyc.model.bean.CommodityBean;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:9:17
 *@Description:${DESCRIPTION}
 *
 */public interface IClassifyContract {
    interface IView {
        //生活商品1
        void onClassifySuccess(ClassifyBean classifyBean);

        void onClassifyFailure(Throwable throwable);

        //生活商品2
        void onCommoditySuccess(CommodityBean commodityBean);

        void onCommodityFailure(Throwable throwable);

    }

    interface IPresenter {
        //商品1
        void getClassifyData();

        //商品2
        void getCommodityData(String category);


    }

    interface IModel {
        //商品1
        void getClassifyData(IModelCallBack iModelCallBack);

        //商品2
        void getCommodityData(String category, IModelCallBack iModelCallBack);

        interface IModelCallBack {
            //生活商品1
            void onClassifySuccess(ClassifyBean classifyBean);

            void onClassifyFailure(Throwable throwable);

            //生活商品2
            void onCommoditySuccess(CommodityBean commodityBean);

            void onCommodityFailure(Throwable throwable);

        }


    }
}
