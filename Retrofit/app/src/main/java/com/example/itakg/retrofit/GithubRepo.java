package com.example.itakg.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubRepo {
    @GET("/users/{user}/repos")
    Call<List<PublicRepo>> githubRepo(@Path("user") String user);
}
