package com.example.accenture1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.accenture1.databinding.ActivityMainBinding
import com.example.accenture1.service.APIService
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Retrofit

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener()
    }

    fun rawJSON(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .build()

        val service = retrofit.create(APIService::class.java)

        val jsonObject = JSONObject()

        var gamemasterName = ""
        jsonObject.put("gamemaster",gamemasterName)

        val jsonObjectString = jsonObject.toString()

        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        CoroutineScope(Dispatchers.IO).launch {
        val response = service.createGame(requestBody)

        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {
                val gson = GsonBuilder().setPrettyPrinting().create()
                val prettyJson = gson.toJson(
                    JsonParser.parseString(
                        response.body()
                            ?.string()
                    )
                )
                Log.d("Pretty Printed JSON", prettyJson)
            } else {
                Log.e("RETROFIT_ERROR", response.code().toString())
            }
        }
        }
    }

    fun getJSON(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .build()

        val service = retrofit.create(APIService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response
        }
    }
}

