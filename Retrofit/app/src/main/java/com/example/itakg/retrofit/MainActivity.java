package com.example.itakg.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        uname = (EditText) findViewById(R.id.userName);

    }

    public void getAllRepos(View view) {
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttpbuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();
        GithubRepo repo = retrofit.create(GithubRepo.class);
        Call<List<PublicRepo>> call = repo.githubRepo(uname.getText().toString());
        call.enqueue(new Callback<List<PublicRepo>>() {
            @Override
            public void onResponse(Call<List<PublicRepo>> call, Response<List<PublicRepo>> response) {
                List<PublicRepo> list = response.body();
                if (list == null) {
                    Toast.makeText(MainActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                } else {
                    listView.setAdapter(new PublicRepoAdapter(list, MainActivity.this));
                    // Log.i("Repos: ", "" + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PublicRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
