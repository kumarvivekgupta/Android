package com.example.itakg.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by itakg on 8/29/2017.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.RecyclerViewHolder> {
    String num[];
    Context c;


    public MyRecyclerView(String[] num, Context context) {
        this.num = num;
        c=context;
    }



    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view,c);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.number.setText(num[position]);

    }

    @Override
    public int getItemCount() {
        return num.length;
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Context context1;
        TextView number;
        public RecyclerViewHolder(View itemView,Context context) {
            super(itemView);
            context1=context;
            number= (TextView) itemView.findViewById(R.id.numbers);
            number.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context1,"Position"+getPosition(),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context1,Main2Activity.class);
            String s=String.valueOf(getPosition());
            intent.putExtra("Position",s);
            context1.startActivity(intent);

        }
    }
}
