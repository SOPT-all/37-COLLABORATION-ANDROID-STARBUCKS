package sopt.org.starbucks.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sopt.org.starbucks.data.datasource.DummyDataSource
import sopt.org.starbucks.data.datasourceimpl.DummyDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDummyDataSource(dummyDataSourceImpl: DummyDataSourceImpl): DummyDataSource
}
