package com.manasa.appstarter.di

import com.manasa.data.datasources.remote.FeatureRemoteDatasource
import com.manasa.data.repositoryimpl.FeatureRepository
import com.manasa.domain.repositories.IFeatureRepository
import com.manasa.domain.usecases.GetFeatureUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRemoteFeatureDataSource(): FeatureRemoteDatasource{
        return FeatureRemoteDatasource()
    }

    @Provides
    fun provideFeatureRepository( featureRemoteDatasource: FeatureRemoteDatasource): IFeatureRepository {
        return FeatureRepository(featureRemoteDatasource)
    }

    @Provides
    fun provideFeatureUseCase(featureRepository: IFeatureRepository): GetFeatureUseCase{
        return GetFeatureUseCase(featureRepository)
    }

//    @Provides
//    fun provideRetrofit(): Retrofit{
//
//    }
}