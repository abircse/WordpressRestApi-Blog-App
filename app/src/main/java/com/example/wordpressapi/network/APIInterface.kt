package com.nexgen.tbl.base.network

import BaseDataModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("posts")
    fun loadPosts() : Call<List<BaseDataModel>>

}