package com.example.myfinanceapp.api

import com.example.myfinanceapp.data.apidata.Price
import com.example.myfinanceapp.data.apidata.complex_data.ComplexData
import com.example.myfinanceapp.data.apidata.quote.Quote
import com.example.myfinanceapp.data.apidata.timeseries.TimeSeries
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface StockDataApi {

    @POST("/complex_data")
    suspend fun getComplexData(@Query("symbols") symbols : Array<String>,
                               @Query("apikey") key : String,
                               @Query("methods") methods : Array<String>,
                               @Query("dp") dp : String = "2") : Response<ComplexData>

    @GET("/price")
    suspend fun getPrice(@Query("symbol") symbol: String,
                         @Query("apikey") key: String,
                         @Query("dp") dp : String = "2") : Response<Price>

    @GET("/quote")
    suspend fun getQuote(@Query("symbol") symbol: String,
                         @Query("apikey") key: String,
                         @Query("dp") dp: String = "2"): Response<Quote>

    @GET("time_series")
    suspend fun getTimeSeries(@Query("symbol") symbol: String,
                              @Query("interval") interval: String,
                              @Query("outputsize") outputSize : String,
                              @Query("date") date: String,
                              @Query("apikey") key: String,
                              @Query("dp") dp: String = "2",
                              @Query("type") type: String = "") : Response<TimeSeries>
}