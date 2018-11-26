package com.facil.reparalo.reparalofacil.dagger.modules;

import android.content.Context;

import com.facil.reparalo.reparalofacil.preferences.services.PreferencesService;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PreferencesModule {

    @Provides
    PreferencesService getPreferencesComponent(Context context){
        return new PreferencesService().setContext(context);
    }

}
