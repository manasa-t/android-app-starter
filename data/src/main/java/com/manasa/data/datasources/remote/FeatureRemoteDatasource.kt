package com.manasa.data.datasources.remote

import com.manasa.core.baseclasses.BaseRemoteDatasource
import com.manasa.core.entities.ResultData
import com.manasa.data.network.FeatureApiService
import com.manasa.domain.entities.FeatureEntity
import javax.inject.Inject

class FeatureRemoteDatasource : BaseRemoteDatasource() {

    fun getFeatureEntity(): ResultData<FeatureEntity> {

        return ResultData.success(FeatureEntity("Manasa", "Compose UI"))
   }
}