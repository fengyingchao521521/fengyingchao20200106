package com.bw.fyc.model;

import com.bw.fyc.contract.IClassifyContract;
import com.bw.fyc.model.bean.ClassifyBean;
import com.bw.fyc.model.bean.CommodityBean;
import com.bw.fyc.utile.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:9:17
 *@Description:${DESCRIPTION}
 *
 */public class ClassifyModel implements IClassifyContract.IModel {
    @Override
    public void getClassifyData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getaPi().getClassifbean()
                //子线程联网
                .subscribeOn(Schedulers.io())
                //主线程观察
                .observeOn(AndroidSchedulers.mainThread())
                //接口回调
                .subscribe(new Observer<ClassifyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        iModelCallBack.onClassifySuccess(classifyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onClassifyFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCommodityData(String category, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getaPi().getCommoditybean(category, 1, 10)
                //子线程联网
                .subscribeOn(Schedulers.io())
                //主线程观察
                .observeOn(AndroidSchedulers.mainThread())
                //接口回调
                .subscribe(new Observer<CommodityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommodityBean commodityBean) {
                        iModelCallBack.onCommoditySuccess(commodityBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onCommodityFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
