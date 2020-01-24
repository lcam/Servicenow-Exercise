package com.servicenow.di.application;

import com.servicenow.di.main.MainModule;
import com.servicenow.di.main.MainViewModelsModule;
import com.servicenow.ui.ReviewListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class}
    )
    abstract ReviewListActivity contributeReviewListActivity();
}