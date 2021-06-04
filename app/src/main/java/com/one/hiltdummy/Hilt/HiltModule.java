package com.one.hiltdummy.Hilt;

import com.one.hiltdummy.carTestExample.Engine;
import com.one.hiltdummy.carTestExample.Wheels;
import com.squareup.moshi.Moshi;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.Module;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class HiltModule {
    String url="https://jsonplaceholder.typicode.com/";

    @Provides
    @Singleton
    public static Wheels provideWheels(){return new Wheels();}
    @Provides
    @Singleton
    public static Engine provideEngine(){return new Engine();}
    @Singleton
    @Provides
    public Moshi provideMoshi(){
        return new Moshi.Builder().build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(Moshi converter){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create(converter))
                .build();
        return retrofit;
    }

}
