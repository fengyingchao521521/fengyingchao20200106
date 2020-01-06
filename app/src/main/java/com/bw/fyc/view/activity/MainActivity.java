package com.bw.fyc.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.fyc.R;
import com.bw.fyc.base.BaseActivity;
import com.bw.fyc.contract.IClassifyContract;
import com.bw.fyc.model.bean.ClassifyBean;
import com.bw.fyc.model.bean.CommodityBean;
import com.bw.fyc.presenter.ClassifyPresenter;
import com.bw.fyc.view.adapter.ClassifyAdapter;
import com.bw.fyc.view.adapter.CommodityAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ClassifyPresenter> implements IClassifyContract.IView {


    @BindView(R.id.recyclerView1)
    RecyclerView mrecyclerView1;
    @BindView(R.id.recyclerView2)
    RecyclerView mrecyclerView2;

    @Override
    protected void initData() {
        //商品1
        mPresenter.getClassifyData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ClassifyPresenter providePresenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClassifySuccess(ClassifyBean classifyBean) {
        List<String> category = classifyBean.getCategory();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerView1.setLayoutManager(linearLayoutManager);

        //适配器
        ClassifyAdapter classifyAdapter = new ClassifyAdapter(category);
        mrecyclerView1.setAdapter(classifyAdapter);

        mrecyclerView1.setAdapter(classifyAdapter);

        classifyAdapter.setOnitemClickListener(new ClassifyAdapter.onitemClickListener() {
            @Override
            public void OnitemClick(int postion) {
                EventBus.getDefault().post(classifyAdapter.getItemCount());
            }
        });

    }

    @Override
    public void onClassifyFailure(Throwable throwable) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onCommoditySuccess(CommodityBean commodityBean) {
        List<CommodityBean.DataBean> data = commodityBean.getData();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mrecyclerView2.setLayoutManager(gridLayoutManager);

        CommodityAdapter commodityAdapter = new CommodityAdapter(data);
        mrecyclerView2.setAdapter(commodityAdapter);


    }

    @Override
    public void onCommodityFailure(Throwable throwable) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void ongetClassify(String category){
        mPresenter.getCommodityData(category);
    }

}
