package com.facil.reparalo.reparalofacil.dagger;


import android.app.Activity;
import android.app.Application;

import com.facil.reparalo.reparalofacil.dagger.components.DaggerMainActivityComponent;
import com.facil.reparalo.reparalofacil.dagger.components.DaggerNetworkComponent;
import com.facil.reparalo.reparalofacil.dagger.components.DaggerPreferencesComponent;
import com.facil.reparalo.reparalofacil.dagger.components.MainActivityComponent;
import com.facil.reparalo.reparalofacil.dagger.components.NetworkComponent;
import com.facil.reparalo.reparalofacil.dagger.components.PreferencesComponent;
import com.facil.reparalo.reparalofacil.dagger.modules.ContextModule;
import com.facil.reparalo.reparalofacil.dagger.modules.NetworkModule;
import com.facil.reparalo.reparalofacil.dagger.modules.OkHttpClientModule;
import com.facil.reparalo.reparalofacil.dagger.modules.PreferencesModule;

public class MainApplication extends Application {


    private MainActivityComponent mainActivityComponent;
    private NetworkComponent networkComponent;
    private PreferencesComponent  preferencesComponent;
    private ContextModule contextModule;

    public static MainApplication get(Activity activity){
        return (MainApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        contextModule = new ContextModule(this);
        preferencesComponent = DaggerPreferencesComponent.builder()
                                .contextModule(contextModule)
                                .preferencesModule(new PreferencesModule())
                                .build();
        networkComponent = DaggerNetworkComponent.builder()
                .contextModule(contextModule)
                .okHttpClientModule(new OkHttpClientModule())
                .networkModule(new NetworkModule()).build();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .networkComponent(networkComponent)
                .preferencesComponent(preferencesComponent)
                .build();
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }
}
