package com.one.hiltdummy.Hilt;

import com.one.hiltdummy.MainActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.hilt.DefineComponent;
import dagger.hilt.android.components.ApplicationComponent;

//@DefineComponent(parent = ApplicationComponent.class) @Component(modules = HiltModule.class)
public interface CustomComponent {
    /*public static void inject(MainActivity activity);
    @DefineComponent.Builder
    interface Builder{
        @BindsInstance
        Builder url(@Named("url") String url);
        CustomComponent build();
    }*/
}
