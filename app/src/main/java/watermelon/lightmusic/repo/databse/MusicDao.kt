package watermelon.lightmusic.repo.databse

import androidx.room.*
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.bean.DailyRecommendedSongList

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/22 09:32
 */
@Dao
interface MusicDao {
    @Query("SELECT * FROM recommend")
    fun queryDailyRecommendedSongList(): List<DailyRecommendedSongList.Recommend>

    @Insert
    fun insertDailyRecommendSongList(recommend: List<DailyRecommendedSongList.Recommend>)

    @Query("DELETE FROM recommend")
    fun deleteLastDailyRecommendSongList()

    @Query("SELECT * FROM daily_song")
    fun queryDailySongAlAndAr(): DailyRecommendedSong.DailySongAlAndAr

    @Insert
    fun insertDailySongAlAndAr(dailySong: DailyRecommendedSong.DailySongAlAndAr)

    @Query("DELETE FROM daily_song")
    fun deleteLastDailySongAlAndAr()

}