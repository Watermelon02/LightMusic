package watermelon.lightmusic.repo.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.bean.DailyRecommendedSongList

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/22 09:32
 */
@Database(
    entities = [DailyRecommendedSongList.Recommend::class, DailyRecommendedSong.DailySongAlAndAr::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = arrayOf(
        DailyRecommendedSongList.CreatorTypeConverter::class,
        DailyRecommendedSongList.RecommendTypeConverter::class,
        DailyRecommendedSong.DailySongConverter::class,
        DailyRecommendedSong.DailySongAlListConverter::class
    )
)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao

    companion object {
        private lateinit var database: MusicDatabase

        /**网上很多都是将此方法与getInstance写在一起，但是那样每次获取数据库实例都需要传递context，
         * 又因为数据库访问贯穿整个app的生命周期，于是用该方法在application创建时初始化,
         * 之后获取数据库实例时就不再需要传递context*/
        @JvmStatic
        fun createInstance(context: Context) {
            database = Room.databaseBuilder(
                context.applicationContext,
                MusicDatabase::class.java,
                "musicDatabase"
            ).build()
        }

        @JvmStatic
        @Synchronized
        fun getInstance(): MusicDatabase {
            return database
        }
    }
}