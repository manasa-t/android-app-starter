package com.manasa.data.repositoryimpl

import com.manasa.core.entities.ResultData
import com.manasa.data.datasources.remote.FeatureRemoteDatasource
import com.manasa.domain.entities.FeatureEntity
import com.manasa.domain.repositories.IFeatureRepository
import javax.inject.Inject

class FeatureRepository @Inject constructor(private val featureRemoteDatasource: FeatureRemoteDatasource): IFeatureRepository {

    override fun getFeature(): ResultData<FeatureEntity> {
       return featureRemoteDatasource.getFeatureEntity()
    }


}