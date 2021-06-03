package com.one.hiltdummy.carTestExample;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    String TAG="Car";
    @Inject
    public Car(Engine engine,Wheels wheels){

    }

    public void Drive(){
        Log.d(TAG, "Driving............");
    }
}
