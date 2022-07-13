package watermelon.lightmusic.repo.bean

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import watermelon.lightmusic.util.local.GsonInstance

/**每日推荐歌单*/
data class DailyRecommendedSongList(
    val code: String = "404",
    val featureFirst: Boolean =false,
    val haveRcmdSongs: Boolean=false,
    val recommend: List<Recommend> = listOf()
) {
    @Entity(tableName = "recommend")
    data class Recommend(
        val alg: String,
        val copywriter: String,
        val createTime: Long,
        val creator: Creator,
        @PrimaryKey
        val id: Long,
        val name: String,
        val picUrl: String,
        val playcount: Long,
        val trackCount: String,
        val type: String,
        val userId: Long
    ) {
        data class Creator(
            val accountStatus: String,
            val authStatus: String,
            val authority: String,
            val avatarImgId: Long,
            val avatarImgIdStr: String,
            val avatarUrl: String,
            val backgroundImgId: Long,
            val backgroundImgIdStr: String,
            val backgroundUrl: String,
            val birthday: String,
            val city: String,
            val defaultAvatar: Boolean,
            val description: String,
            val detailDescription: String,
            val djStatus: String,
            val expertTags: Any,
            val followed: Boolean,
            val gender: String,
            val mutual: Boolean,
            val nickname: String,
            val province: String,
            val remarkName: String,
            val signature: String,
            val userId: Long,
            val userType: String,
            val vipType: String
        )
    }
    class RecommendTypeConverter{
        @TypeConverter
        fun objectToJson(`object`: List<Recommend>): String {
            return GsonInstance.instance.toJson(`object`)
        }

        @TypeConverter
        fun jsonToObject(json: String?): List<Recommend> {
            val type = object : TypeToken<List<Recommend>>() {}.type
            return GsonInstance.instance.fromJson(json, type)
        }
    }
    class CreatorTypeConverter{
        @TypeConverter
        fun objectToJson(`object`: Recommend.Creator): String {
            return GsonInstance.instance.toJson(`object`)
        }

        @TypeConverter
        fun jsonToObject(json: String?): Recommend.Creator {
            val type = object : TypeToken<Recommend.Creator>() {}.type
            return GsonInstance.instance.fromJson(json, type)
        }
    }
}