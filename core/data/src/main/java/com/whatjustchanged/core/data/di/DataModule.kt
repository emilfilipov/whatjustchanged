package com.whatjustchanged.core.data.di

import com.whatjustchanged.core.data.ConfigManager
import com.whatjustchanged.core.data.DefaultConfigManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindConfigManager(
        defaultConfigManager: DefaultConfigManager
    ): ConfigManager
}
