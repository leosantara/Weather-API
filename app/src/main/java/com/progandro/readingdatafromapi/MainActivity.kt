package com.progandro.readingdatafromapi

import android.net.http.HttpException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.progandro.readingdatafromapi.databinding.ActivityMainBinding
import com.progandro.readingdatafromapi.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        GlobalScope.launch(Dispatchers.IO){
            val response = try{
                RetrofitInstance.api.getCurrentWeather("-7.795580", "110.369492", "36d38ea2926714eeda638f01b699af0e")
            }catch (e:IOException){
                return@launch
            }
            if (response.isSuccessful && response.body()!= null){
                withContext(Dispatchers.Main){
                    binding.textView.text = "Kota : ${response.body()!!.name}"
                    binding.textView2.text = "Cuaca : ${response.body()!!.weather.get(0).main}"
                    binding.textView3.text = "Deskripsi : ${response.body()!!.weather.get(0).description}"
                }
            }
        }
    }
}