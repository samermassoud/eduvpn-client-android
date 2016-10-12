package net.tuxed.vpnconfigimporter.inject;

import android.content.Context;

import net.tuxed.vpnconfigimporter.EduVPNApplication;
import net.tuxed.vpnconfigimporter.service.ConfigurationService;
import net.tuxed.vpnconfigimporter.service.ConnectionService;
import net.tuxed.vpnconfigimporter.service.PreferencesService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application module providing the different dependencies
 * Created by Daniel Zolnai on 2016-10-07.
 */
@Module
public class ApplicationModule {

    private final EduVPNApplication _application;

    public ApplicationModule(EduVPNApplication application) {
        _application = application;
    }

    @Provides
    @Singleton
    protected Context provideApplicationContext() {
        return _application.getApplicationContext();
    }

    @Provides
    @Singleton
    protected ConfigurationService provideConfigurationService(Context context) {
        return new ConfigurationService(context);
    }

    @Provides
    @Singleton
    protected PreferencesService providePreferencesService(Context context) {
        return new PreferencesService(context);
    }

    @Provides
    @Singleton
    protected ConnectionService provideConnectionService(Context context, PreferencesService preferencesService) {
        return new ConnectionService(context, preferencesService);
    }
}