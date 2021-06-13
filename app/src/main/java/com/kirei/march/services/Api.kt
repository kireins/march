package com.kirei.march.services

import com.kirei.march.models.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface Api {


    @GET("photos")
    fun getRecentPhotos(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int,
        @Query("order_by") order: String
    ) : Call<MutableList<Photo>>

}