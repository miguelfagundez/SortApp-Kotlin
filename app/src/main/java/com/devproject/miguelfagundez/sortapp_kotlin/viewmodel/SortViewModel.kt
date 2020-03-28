package com.devproject.miguelfagundez.sortapp_kotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.devproject.miguelfagundez.sortapp_kotlin.model.SortDataModel
import com.devproject.miguelfagundez.sortapp_kotlin.model.SortModel

/********************************************
 * SortViewModel - ViewModel component
 * Class that manage and store UI data
 * @author: Miguel Fagundez
 * @date: March 27th, 2020
 * @version: 1.0
 * *******************************************/
class SortViewModel(application: Application) : AndroidViewModel(application) {

    // It is used to sort asc or desc
    var isAscending = true
    // It is used to avoid sorting many times
    // if it is not necessary
    var isChanged = true
    // Connecting with model layer
    val dataModel = SortDataModel()
    // List of friends (UI data)
    val listBlocks = MutableLiveData<MutableList<SortModel>>()

    init {
        listBlocks?.value = dataModel.dataModel()
    }

}