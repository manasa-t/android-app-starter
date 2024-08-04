package com.manasa.domain.repositories

import com.manasa.core.entities.ResultData
import com.manasa.domain.entities.FeatureEntity

interface IFeatureRepository {

    fun getFeature(): ResultData<FeatureEntity>
}