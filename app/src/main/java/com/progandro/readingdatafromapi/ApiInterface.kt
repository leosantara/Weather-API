package com.progandro.readingdatafromapi

import com.progandro.readingdatafromapi.model.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather?")
    suspend fun getCurrentWeather(
        @Query("lat") lat : String,
        @Query("lon") lon : String,
        @Query("appid") apiKey : String,
    ):Response<CurrentWeather>

//    @GET("forecast?")
//    suspend fun getForecast(
//        @Query ("q") city: String,
//        @Query("units") units : String,
//        @Query("appid") apiKey : String,
//    ) :Response<Forecast>
//
//
//    @GET("air_pollution?")
//    suspend fun getPollution(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("units") units : String,
//        @Query("appid") apiKey : String
//    ): Response<PollutionData>

}