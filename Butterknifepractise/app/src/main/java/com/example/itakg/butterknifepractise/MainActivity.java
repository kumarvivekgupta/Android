package com.example.itakg.butterknifepractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)TextView textView;
    int count=0;
    @BindView(R.id.spinner)Spinner spinner;
    @BindArray(R.array.cities) String cities[] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities);
        spinner.setAdapter(adapter);


    }

    @OnClick({R.id.count,R.id.button})
    public void text(View view)
    {
        count++;

        switch (view.getId())
        {
            case R.id.count: textView.setText(String.valueOf(spinner.getItemAtPosition(count)));
                break;
            case R.id.button:  textView.setText("Naimish verma");
                break;

        }

    }
}
