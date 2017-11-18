package com.example.itakg.materialdesigntest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by itakg on 9/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private LayoutInflater inflator;
    private Context context;
    private ItemCickedInView inView;

    ArrayList<Information> list = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Information> data) {
        this.context
                = context;
        inflator = LayoutInflater.from(context);
        this.list = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.single_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    public void getView(ItemCickedInView inView)
    {
        this.inView=inView;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = list.get(position);
        holder.title.setText(current.title);
        holder.imv.setImageResource(current.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imv;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.dummytext);
            imv = itemView.findViewById(R.id.dummyimage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inView.itemClicked(getPosition() );
                }
            });
        }


    }
    public interface ItemCickedInView
    {
        public void itemClicked(int position);
    }
}
