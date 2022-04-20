package com.example.accenture1.repository

import com.example.accenture1.api.RetrofitInstance
import com.example.accenture1.model.Gamemaster
import com.example.accenture1.model.GamemasterName
import retrofit2.Response

class Repository {

    suspend fun getGamemaster(): Response<Gamemaster> {
        return RetrofitInstance.api.getGamemaster()
    }

    suspend fun pushGamemaster(gamemasterName: GamemasterName): Response<GamemasterName>{
        return RetrofitInstance.api.pushGamemaster(gamemasterName)
    }

}