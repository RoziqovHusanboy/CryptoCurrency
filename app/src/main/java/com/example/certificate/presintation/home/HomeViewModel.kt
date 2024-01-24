package com.example.appforcertificate.presintation.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appforcertificate.data.model.ConvertData
import com.example.appforcertificate.domain.repo.ConvertRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val convertRepo: ConvertRepo
):ViewModel() {

    val state = MutableLiveData<List<ConvertData>>()
    val error = MutableLiveData(false)
    val loading = MutableLiveData(false)

    init {
        getConvert()
    }


    @SuppressLint("SuspiciousIndentation")
    fun getConvert() = viewModelScope.launch {
        loading.postValue(true)
        error.postValue(false)
        try {
            state.postValue(convertRepo.getConvert())
        }catch (e:Exception){
            error.postValue(true)
        }finally {
            loading.postValue(false)
        }


    }

}