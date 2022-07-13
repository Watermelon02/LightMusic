package watermelon.lightmusic.repo.service

import retrofit2.http.GET
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.bean.DailyRecommendedSongList
import watermelon.lightmusic.util.network.ApiGenerator

/**
 * description ： HomeFragment中用到的service
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/21 21:26
 */
interface HomeService {
    @GET("/recommend/resource")
    suspend fun getDailyRecommendedSongList(): DailyRecommendedSongList

    @GET("/recommend/songs")
    suspend fun getDailyRecommendedSong(): DailyRecommendedSong

    companion object {
        val INSTANCE by lazy { ApiGenerator.getApiService(HomeService::class) }
    }
}