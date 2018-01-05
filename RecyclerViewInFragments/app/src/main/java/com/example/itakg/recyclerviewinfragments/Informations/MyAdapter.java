package com.example.itakg.recyclerviewinfragments.Informations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.itakg.recyclerviewinfragments.R;

/**
 * Created by itakg on 11/8/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRecyclerView> {
    String number[] = new String[10];
    Context context;
    ItemClicked itemClicked;
    int count;
    View view;
    public MyAdapter(String number[], Context context,int count) {
        this.number = number;
        this.context = context;
        this.count=count;
    }

    public void setitemClicked(ItemClicked itemClicked) {
        this.itemClicked = itemClicked;
    }

    @Override
    public MyRecyclerView onCreateViewHolder(ViewGroup parent, int viewType) {
        if(count==1)
        {
         view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);}
        else if(count==2){
            view = LayoutInflater.from(context).inflate(R.layout.single_row2, parent, false);
        }
        else
        {
            view = LayoutInflater.from(context).inflate(R.layout.single_row3, parent, false);
        }
        MyRecyclerView recyclerView = new MyRecyclerView(view, context);
        return recyclerView;
    }

    @Override
    public void onBindViewHolder(MyRecyclerView holder, int position) {

        holder.textView.setText(number[position]);
    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    class MyRecyclerView extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView textView;

        public MyRecyclerView(View itemView, Context context) {
            super(itemView);
            this.context = context;
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClicked != null) {
                itemClicked.clicked(number[getPosition()]);
            }
        }
    }

    public interface ItemClicked {
        public void clicked(String n);
    }
}
