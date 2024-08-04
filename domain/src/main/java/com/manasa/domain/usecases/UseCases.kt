package com.manasa.domain.usecases


import com.manasa.core.entities.ResultData
import com.manasa.domain.entities.FeatureEntity
import com.manasa.domain.repositories.IFeatureRepository
import javax.inject.Inject

interface UseCase<R> {
    suspend fun execute(): R
}

interface UseCaseWithRequest<T, R> {
    suspend fun execute(t: T? = null): R
}

// Example feature use case
class GetFeatureUseCase @Inject constructor(val featureRepository: IFeatureRepository): UseCase<ResultData<FeatureEntity>> {

    override suspend fun execute(): ResultData<FeatureEntity> {
       return featureRepository.getFeature()
    }


}