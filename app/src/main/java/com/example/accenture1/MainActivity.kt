package com.example.accenture1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.accenture1.model.GamemasterName
import com.example.accenture1.repository.Repository
import com.example.accenture1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //POST
        binding.btnStart.setOnClickListener(){
            val myGamemaster = GamemasterName(binding.etName.toString())
            viewModel.pushGamemaster(myGamemaster)
            viewModel.myResponse.observe(this, Observer { response ->
                if(response.isSuccessful){
                    Log.d("Main", response.body().toString())
                }else{
                    Log.d("Response", response.errorBody().toString())
                }
            })
        }


        //GET
        viewModel.getGamemaster()

        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body()?.id.toString())
            }else{
                Log.d("Response", response.errorBody().toString())
            }
        })

    }


    private fun toastError(){
        val errorMessage = "There was a problem. Try to create the game later"
        var toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        return toast
    }
}

