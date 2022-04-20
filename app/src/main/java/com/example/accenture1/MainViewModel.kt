package com.example.accenture1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accenture1.model.Gamemaster
import com.example.accenture1.model.GamemasterName
import com.example.accenture1.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Gamemaster>> = MutableLiveData()
    val myResponseInput: MutableLiveData<Response<GamemasterName>> = MutableLiveData()

    fun pushGamemaster(gamemasterName: GamemasterName){
        viewModelScope.launch {
            val response = repository.pushGamemaster(gamemasterName )
            myResponseInput.value = response
        }
    }

    fun getGamemaster(){
        viewModelScope.launch {
            val response = repository.getGamemaster()
            myResponse.value = response
        }
    }
}