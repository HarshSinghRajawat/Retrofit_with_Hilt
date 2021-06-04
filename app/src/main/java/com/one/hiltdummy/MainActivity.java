package com.one.hiltdummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.one.hiltdummy.Retrofit.Data;
import com.one.hiltdummy.Retrofit.RetroNetworkInterface;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    private RecyclerView recyclerView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar bar=findViewById(R.id.progressBar);

        recyclerView=findViewById(R.id.list);
        GridLayoutManager mGrid=new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(mGrid);
        recyclerView.setHasFixedSize(true);


        RetroNetworkInterface mService=retrofit.create(RetroNetworkInterface.class);
        Call<List<Data>> list=mService.getToDoItems();

        list.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                MyAdapter myAdapter=new MyAdapter(MainActivity.this,response.body());
                recyclerView.setAdapter(myAdapter);
                bar.setVisibility(View.GONE);
                Log.d(TAG, response.code()+"");
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });
    }
}