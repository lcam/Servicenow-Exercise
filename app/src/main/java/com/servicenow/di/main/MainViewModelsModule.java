package com.servicenow.di.main;

import androidx.lifecycle.ViewModel;

import com.servicenow.di.application.ViewModelKey;
import com.servicenow.ui.ReviewViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel.class)
    public abstract ViewModel bindProfileViewModel(ReviewViewModel viewModel);
}
