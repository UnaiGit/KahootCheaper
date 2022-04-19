package com.example.accenture1.service

import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @POST("/v3/d0e03a0b-ce2a-4dc6-87f2-db26d00fd6a7/")
    suspend fun createGame(@Body requestBody: RequestBody): Response<ResponseBody>

    @GET("/v3/d0e03a0b-ce2a-4dc6-87f2-db26d00fd6a7/")
    suspend fun getGame(): Response<ResponseBody>

}