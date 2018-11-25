package com.facil.reparalo.reparalofacil.dagger;


import android.app.Activity;
import android.app.Application;

import com.facil.reparalo.reparalofacil.dagger.components.DaggerMainActivityComponent;
import com.facil.reparalo.reparalofacil.dagger.components.DaggerNetworkComponent;
import com.facil.reparalo.reparalofacil.dagger.components.MainActivityComponent;
import com.facil.reparalo.reparalofacil.dagger.components.NetworkComponent;
import com.facil.reparalo.reparalofacil.dagger.modules.ContextModule;
import com.facil.reparalo.reparalofacil.dagger.modules.MainActivityModule;
import com.facil.reparalo.reparalofacil.dagger.modules.NetworkModule;
import com.facil.reparalo.reparalofacil.dagger.modules.OkHttpClientModule;

public class MainApplication extends Application {


    private MainActivityComponent mainActivityComponent;
    private NetworkComponent networkComponent;

    public static MainApplication get(Activity activity){
        return (MainApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent.builder()
                .contextModule(new ContextModule(this))
                .okHttpClientModule(new OkHttpClientModule())
                .networkModule(new NetworkModule()).build();
        mainActivityComponent = DaggerMainActivityComponent.builder().
                networkComponent(networkComponent)
                .build();
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }
}
