package com.servicenow.di.main;

import com.servicenow.ui.ReviewAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    static ReviewAdapter provideReviewAdapter() {
        return new ReviewAdapter();
    }
}
