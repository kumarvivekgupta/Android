package com.example.itakg.firebaseloginapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button button;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

    }
    protected void onStart() {
                super.onStart();
                 FirebaseUser currentUser = mAuth.getCurrentUser();
                 Toast.makeText(this, "Already In", Toast.LENGTH_SHORT).show();
             }


             public void registerMe(View view)
             {
                 final String myEmail = email.getText().toString();
                         final String myPass = pass.getText().toString();


                         mAuth.createUserWithEmailAndPassword(myEmail, myPass)
                                 .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()) {
                         // Sign in success, update UI with the signed-in user's information
                       Log.i("TAG", "createUserWithEmail:success");

                     Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                       } else {
              // If sign in fails, display a message to the user.
               Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();


                  }
                     // ...
                    }
                 });


             }
}
