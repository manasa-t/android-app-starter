package com.manasa.appstarter.mainScreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manasa.core.entities.ResultData
import com.manasa.core.entities.State
import com.manasa.domain.entities.FeatureEntity
import com.manasa.domain.usecases.GetFeatureUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: GetFeatureUseCase) : ViewModel() {

    private val _featureState = MutableStateFlow<State<FeatureEntity>>(State.loading())
    val featureState : StateFlow<State<FeatureEntity>> = _featureState.asStateFlow()

    init {
        getFeature()
    }

    private fun getFeature(){
        viewModelScope.launch {
            when (val result = useCase.execute()) {
                is ResultData.Success -> {
                    val data = result.value
                    _featureState.value = State.success(data)
                }
                is ResultData.Failure -> {
                    _featureState.value = State.error(result.message, result.code)
                }
                else -> {
                    _featureState.value = State.error("Please try again!")
                }
            }
        }
    }
}