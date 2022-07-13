package watermelon.lightmusic.repo.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.bean.PlayListDetail
import watermelon.lightmusic.repo.databse.MusicDatabase
import watermelon.lightmusic.repo.service.HomeService
import watermelon.lightmusic.repo.service.PlayListDetailService
import java.util.concurrent.atomic.AtomicInteger

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/21 19:36
 */
object HomeRepository {
    private var getRemoteSongList = AtomicInteger(0)
    suspend fun getDailyRecommendedSongList() =
        flow {
            val localSongList =
                MusicDatabase.getInstance().musicDao().queryDailyRecommendedSongList()
            if (localSongList.isNotEmpty()) emit(localSongList)
            //获取歌单
            val remoteSongList = HomeService.INSTANCE.getDailyRecommendedSongList()
            if (remoteSongList.code == "200") {
                //保存到本地
                MusicDatabase.getInstance().musicDao().deleteLastDailyRecommendSongList()
                MusicDatabase.getInstance().musicDao()
                    .insertDailyRecommendSongList(remoteSongList.recommend)
            }
        }.flowOn(Dispatchers.IO)


    suspend fun getDailyRecommendedSong() =
        flow {
            val localSongAlAndAr =
                MusicDatabase.getInstance().musicDao().queryDailySongAlAndAr()
            if (localSongAlAndAr != null) emit(
                localSongAlAndAr
            )
            //获取歌单
            val remoteSong = HomeService.INSTANCE.getDailyRecommendedSong()
            if (remoteSong.code == "200") {
                val remoteSongAl = ArrayList<DailyRecommendedSong.Data.DailySong.Al>()
                val remoteSongAr = ArrayList<List<DailyRecommendedSong.Data.DailySong.Ar>>()
                for (i in remoteSong.data.dailySongs) {
                    remoteSongAl.add(i.al)
                    remoteSongAr.add(i.ar)
                }
                val remoteSongAlAndAr =
                    DailyRecommendedSong.DailySongAlAndAr(al = remoteSongAl, ar = remoteSongAr)
                emit(
                    remoteSongAlAndAr
                )
                //保存到本地
                MusicDatabase.getInstance().musicDao().deleteLastDailySongAlAndAr()
                MusicDatabase.getInstance().musicDao().insertDailySongAlAndAr(remoteSongAlAndAr)
            }
        }.flowOn(Dispatchers.IO)
}
