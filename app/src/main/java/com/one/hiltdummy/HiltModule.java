package com.one.hiltdummy;

import com.one.hiltdummy.carTestExample.Engine;
import com.one.hiltdummy.carTestExample.Wheels;

import javax.inject.Singleton;

import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.Module;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class HiltModule {

    @Provides
    @Singleton
    public static Wheels provideWheels(){return new Wheels();}
    @Provides
    @Singleton
    public static Engine provideEngine(){return new Engine();}
}
