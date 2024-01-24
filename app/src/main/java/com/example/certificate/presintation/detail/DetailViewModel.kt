package com.example.certificate.presintation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appforcertificate.data.model.ConvertData
import com.example.appforcertificate.domain.repo.ConvertRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo: ConvertRepo
):ViewModel() {
    val id = MutableLiveData<Int>()
    val detail = MutableLiveData<List<ConvertData>>()

    init {

    }

    fun setDetail(id: Int){
       this.id.postValue(id)
        getConvert()
    }

    fun getConvert() = viewModelScope.launch {
      detail.postValue(repo.getConvert())
    }


}