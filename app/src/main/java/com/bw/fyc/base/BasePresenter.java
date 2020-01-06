package com.bw.fyc.base;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:9:11
 *@Description:${DESCRIPTION}
 *
 */public abstract class BasePresenter<V> {
    protected V view;

    public void actach(V view) {
        this.view = view;
    }

    public void datach() {
        view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

}
