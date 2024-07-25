package com.example.lovecat4.api

import com.example.lovecat4.data.catModel
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY="live_hWWnm5Qlh1WtmOo3lNeWiCuycBAbP1tUD2VSLbtbxcwXwMQ6ZjaeuzUAYWSMZPbB"
interface CatService {
@GET("v1/images/search?api_key=$API_KEY")
suspend fun getImages(
    @Query("limit")num:Int=1
): catModel
}
