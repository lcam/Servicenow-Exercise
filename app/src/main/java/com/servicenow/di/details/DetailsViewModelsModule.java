package com.servicenow.di.details;

import androidx.lifecycle.ViewModel;

import com.servicenow.di.application.ViewModelKey;
import com.servicenow.ui.Details.DetailsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class DetailsViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel.class)
    public abstract ViewModel bindDetailsViewModel(DetailsViewModel viewModel);
}
