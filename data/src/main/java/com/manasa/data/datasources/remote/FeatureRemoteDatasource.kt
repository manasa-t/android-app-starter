package com.manasa.data.datasources.remote

import com.manasa.core.baseclasses.BaseRemoteDatasource
import com.manasa.core.entities.ResultData
import com.manasa.domain.entities.FeatureEntity

class FeatureRemoteDatasource: BaseRemoteDatasource() {

    fun getFeatureEntity(): ResultData<FeatureEntity> {
      //  getData {  }
        return ResultData.success(FeatureEntity("Manasa", "Compose UI"))
    }
}