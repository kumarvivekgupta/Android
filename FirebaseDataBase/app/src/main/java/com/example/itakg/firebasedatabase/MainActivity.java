package com.example.itakg.firebasedatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText name,username,age;
    RadioButton male,female;
    RadioGroup gender;
    Button button;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference rootRef=db.getReference();
    DatabaseReference myRef=rootRef.child("USERS");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        username= (EditText) findViewById(R.id.username);
        age= (EditText) findViewById(R.id.age);
        male= (RadioButton) findViewById(R.id.male);
        female= (RadioButton) findViewById(R.id.female);
        gender= (RadioGroup) findViewById(R.id.gender);
        button= (Button) findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName=name.getText().toString();
                String myUser=username.getText().toString();
                String myAge=age.getText().toString();
                int i=gender.getCheckedRadioButtonId();
                RadioButton rb= (RadioButton) findViewById(i);
                String myGender=rb.getText().toString();

                HashMap<String,String> hm=new HashMap<String, String>();
                hm.put("Name",myName);
                hm.put("UserName",myUser);
                hm.put("Age",myAge);
                hm.put("Gender",myGender);
                myRef.push().setValue(hm).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Registered Successfully!!",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Something went wrong!!",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}
























