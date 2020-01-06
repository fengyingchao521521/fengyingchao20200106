package com.bw.fyc.presenter;

import com.bw.fyc.base.BasePresenter;
import com.bw.fyc.contract.IClassifyContract;
import com.bw.fyc.model.ClassifyModel;
import com.bw.fyc.model.bean.ClassifyBean;
import com.bw.fyc.model.bean.CommodityBean;
import com.bw.fyc.utile.NetUtil;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:9:18
 *@Description:${DESCRIPTION}
 *
 */public class ClassifyPresenter extends BasePresenter<IClassifyContract.IView> implements IClassifyContract.IPresenter {

    private ClassifyModel classifyModel;

    @Override
    protected void initModel() {
        classifyModel = new ClassifyModel();
    }

    @Override
    public void getClassifyData() {
        classifyModel.getClassifyData(new IClassifyContract.IModel.IModelCallBack() {
            @Override
            public void onClassifySuccess(ClassifyBean classifyBean) {
                view.onClassifySuccess(classifyBean);
            }

            @Override
            public void onClassifyFailure(Throwable throwable) {
                view.onClassifyFailure(throwable);
            }

            @Override
            public void onCommoditySuccess(CommodityBean commodityBean) {
                view.onCommoditySuccess(commodityBean);
            }

            @Override
            public void onCommodityFailure(Throwable throwable) {
                view.onCommodityFailure(throwable);
            }
        });
    }

    @Override
    public void getCommodityData(String category) {
        classifyModel.getCommodityData(category, new IClassifyContract.IModel.IModelCallBack() {
            @Override
            public void onClassifySuccess(ClassifyBean classifyBean) {
                view.onClassifySuccess(classifyBean);
            }

            @Override
            public void onClassifyFailure(Throwable throwable) {
                view.onClassifyFailure(throwable);
            }

            @Override
            public void onCommoditySuccess(CommodityBean commodityBean) {
                view.onCommoditySuccess(commodityBean);
            }

            @Override
            public void onCommodityFailure(Throwable throwable) {
                view.onCommodityFailure(throwable);
            }
        });
    }
}
