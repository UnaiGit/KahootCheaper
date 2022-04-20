package com.example.accenture1.api

import com.example.accenture1.model.Gamemaster
import com.example.accenture1.model.GamemasterName
import retrofit2.Response

import retrofit2.http.*

interface APIService {

    //Recover ID generated on backend should be "d0e03a0b-ce2a-4dc6-87f2-db26d00fd6a7/ROOMID"
    @GET("d0e03a0b-ce2a-4dc6-87f2-db26d00fd6a7")
    suspend fun getGamemaster(): Response<Gamemaster>

    //Send Gamemaster name created by User
    @POST("d0e03a0b-ce2a-4dc6-87f2-db26d00fd6a7")
    suspend fun pushGamemaster(
        @Body gamemasterName: GamemasterName
    ): Response<GamemasterName>


}
