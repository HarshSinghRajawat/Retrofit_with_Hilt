package com.one.hiltdummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.one.hiltdummy.carTestExample.Car;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Inject
    Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car.Drive();
    }
}