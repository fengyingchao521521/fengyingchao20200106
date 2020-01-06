package com.bw.fyc.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.fyc.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther: 封英超
 *@Date: 2020/1/6
 *@Time:10:03
 *@Description:${DESCRIPTION}
 *
 */public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.MyViewHadle> {

    private List<String> list;

    public ClassifyAdapter(List<String> category) {

        this.list = category;
    }

    @NonNull
    @Override
    public MyViewHadle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item1, null);
        return new MyViewHadle(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHadle holder, int position) {
        String s = list.get(position);
        holder.tv.setText(s);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onitemClickListener.OnitemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHadle extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;

        public MyViewHadle(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public void setOnitemClickListener(ClassifyAdapter.onitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    onitemClickListener onitemClickListener;

    public interface onitemClickListener {
        void OnitemClick(int postion);
    }

}
