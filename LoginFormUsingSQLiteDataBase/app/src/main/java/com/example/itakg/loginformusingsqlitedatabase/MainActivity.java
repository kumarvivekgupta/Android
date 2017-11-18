package com.example.itakg.loginformusingsqlitedatabase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user_name;
    private EditText password;
    private EditText detail;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name= (EditText) findViewById(R.id.UserName);
        password= (EditText) findViewById(R.id.password);
        detail= (EditText) findViewById(R.id.detail);
        dataBase=new DataBase(this);

    }
    public void submitClicked(View view)
    {
        String userName=user_name.getText().toString();
        String pass=password.getText().toString();

        long id=dataBase.insert_data(userName,pass);
        if(id<0)
        {
            Toast.makeText(MainActivity.this,"UNSUCCESSFUL!!",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(MainActivity.this,"SUCCESSFUL!!",Toast.LENGTH_LONG).show();
        }
    }
    public void viewDetails(View view)
    {
        String data=dataBase.getAllData();
        Toast.makeText(MainActivity.this,data+" ",Toast.LENGTH_LONG).show();
    }
    public void individualDetails(View view)
    {
       int id=Integer.parseInt(detail.getText().toString());
        String details=dataBase.getIndividualData(id);
        Toast.makeText(MainActivity.this,details+" ",Toast.LENGTH_LONG).show();

    }
    public void update(View view)
    {
        dataBase.updateName("srijan","utkarsh");
    }
    public void delete(View view)
    {
dataBase.deleteRow("utkarsh");
    }
}
