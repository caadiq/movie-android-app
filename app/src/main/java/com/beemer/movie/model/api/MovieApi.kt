package com.beemer.movie.model.api

import com.beemer.movie.model.dto.PosterBannerDto
import com.beemer.movie.model.dto.RankListDto
import com.beemer.movie.model.dto.ReleaseListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/api/movie/poster/banner")
    fun getPosterBanner(): Call<List<PosterBannerDto>>

    @GET("/api/movie/rank/daily")
    fun getDailyRankList(@Query("date") date: String): Call<List<RankListDto>>

    @GET("/api/movie/rank/weekly")
    fun getWeeklyRankList(@Query("startDate") startDate: String, @Query("endDate") endDate: String): Call<List<RankListDto>>

    @GET("/api/movie/release/recent")
    fun getRecentReleaseList(@Query("limit") limit: Int): Call<List<ReleaseListDto>>

    @GET("/api/movie/release/coming")
    fun getComingReleaseList(@Query("limit") limit: Int): Call<List<ReleaseListDto>>
}