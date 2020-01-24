package com.servicenow.di.main;

import androidx.lifecycle.ViewModel;

import com.servicenow.di.application.ViewModelKey;
import com.servicenow.ui.Main.ReviewViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel.class)
    public abstract ViewModel bindReviewViewModel(ReviewViewModel viewModel);
}
