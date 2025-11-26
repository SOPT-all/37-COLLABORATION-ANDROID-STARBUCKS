package sopt.org.starbucks.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import sopt.org.starbucks.data.service.MyHomeMenuService
import sopt.org.starbucks.data.service.MyMenuService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideMyMenuService(retrofit: Retrofit): MyMenuService = retrofit.create(MyMenuService::class.java)

    @Provides
    @Singleton
    fun provideMyHomeMenuService(
        retrofit: Retrofit
    ): MyHomeMenuService = retrofit.create(MyHomeMenuService::class.java)
}
