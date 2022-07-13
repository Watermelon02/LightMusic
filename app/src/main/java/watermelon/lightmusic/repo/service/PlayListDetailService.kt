package watermelon.lightmusic.repo.service

import retrofit2.http.GET
import retrofit2.http.Query
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.bean.DailyRecommendedSongList
import watermelon.lightmusic.repo.bean.PlayListDetail
import watermelon.lightmusic.util.network.ApiGenerator

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/24 17:40
 */
interface PlayListDetailService {
    @GET("/playlist/detail")
    suspend fun getPlayListDetail(@Query("id")id:Long): PlayListDetail

    companion object {
        val INSTANCE by lazy { ApiGenerator.getApiService(PlayListDetailService::class) }
    }
}