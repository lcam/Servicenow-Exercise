package com.servicenow.di.application;

import com.servicenow.di.details.DetailsModule;
import com.servicenow.di.details.DetailsViewModelsModule;
import com.servicenow.di.main.MainModule;
import com.servicenow.di.main.MainViewModelsModule;
import com.servicenow.ui.Details.DetailsActivity;
import com.servicenow.ui.Main.ReviewListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class}
    )
    abstract ReviewListActivity contributeReviewListActivity();

    @ContributesAndroidInjector(
            modules = {DetailsViewModelsModule.class, DetailsModule.class}
    )
    abstract DetailsActivity contributeDetailsActivity();
}