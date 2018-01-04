package com.example.itakg.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by itakg on 12/12/2017.
 */

public class PublicRepoAdapter extends BaseAdapter {
    List<PublicRepo> list;
    Context context;

    public PublicRepoAdapter(List<PublicRepo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1=inflater.inflate(R.layout.single_row,viewGroup,false);
        TextView textView=view1.findViewById(R.id.repos);
        PublicRepo repo=list.get(i);
        textView.setText(repo.getRepo());
        return view1;
    }


}
