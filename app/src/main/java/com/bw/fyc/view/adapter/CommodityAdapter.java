package com.bw.fyc.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.fyc.R;
import com.bw.fyc.model.bean.CommodityBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:10:03
 *@Description:${DESCRIPTION}
 *
 */public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.MyViewHandle> {

    private List<CommodityBean.DataBean> data;

    public CommodityAdapter(List<CommodityBean.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHandle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item2, null);
        return new MyViewHandle(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHandle holder, int position) {
        CommodityBean.DataBean dataBean = data.get(position);

        holder.textView.setText(dataBean.getGoods_name());

        Glide.with(holder.image)
                .load(dataBean.getGoods_thumb())
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHandle extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.text_View)
        TextView textView;

        public MyViewHandle(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
