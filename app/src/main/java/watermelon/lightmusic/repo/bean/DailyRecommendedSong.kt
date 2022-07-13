package watermelon.lightmusic.repo.bean

import androidx.room.*
import com.google.gson.reflect.TypeToken
import watermelon.lightmusic.util.local.GsonInstance

/**每日推荐歌曲*/
data class DailyRecommendedSong(
    val code: String,
    val `data`: Data
) {
    data class Data(
        val dailySongs: List<DailySong>,
        val orderSongs: List<Any>,
        val recommendReasons: List<RecommendReason>
    ) {
        data class DailySong(
            val a: Any,
            val al: Al,
            val alg: String,
            val alia: List<String>,
            val ar: List<Ar>,
            val cd: String,
            val cf: String,
            val copyright: String,
            val cp: String,
            val crbt: Any,
            val djId: String,
            val dt: String,
            val entertainmentTags: Any,
            val fee: String,
            val ftype: String,
            val h: H,
            val hr: Any,
            val id: String,
            val l: L,
            val m: M,
            val mark: String,
            val mst: String,
            val mv: String,
            val name: String,
            val no: String,
            val noCopyrightRcmd: Any,
            val originCoverType: String,
            val originSongSimpleData: Any,
            val pop: String,
            val privilege: Privilege,
            val pst: String,
            val publishTime: Long,
            val reason: String,
            val resourceState: Boolean,
            val rt: String,
            val rtUrl: Any,
            val rtUrls: List<Any>,
            val rtype: String,
            val rurl: Any,
            val s_ctrp: String,
            val s_id: String,
            val single: String,
            val songJumpInfo: Any,
            val sq: Sq,
            val st: String,
            val t: String,
            val tagPicList: Any,
            val tns: List<String>,
            val v: String,
            val version: String
        ) {
            data class Al(
                val id: String,
                val name: String,
                val pic: Long,
                val picUrl: String,
                val pic_str: String,
                val tns: List<Any>
            )

            data class Ar(
                val alias: List<Any>,
                val id: String,
                val name: String,
                val tns: List<Any>
            )

            data class H(
                val br: String,
                val fid: String,
                val size: String,
                val sr: String,
                val vd: String
            )

            data class L(
                val br: String,
                val fid: String,
                val size: String,
                val sr: String,
                val vd: String
            )

            data class M(
                val br: String,
                val fid: String,
                val size: String,
                val sr: String,
                val vd: String
            )

            data class Privilege(
                val chargeInfoList: List<ChargeInfo>,
                val cp: String,
                val cs: Boolean,
                val dl: String,
                val dlLevel: String,
                val downloadMaxBrLevel: String,
                val downloadMaxbr: String,
                val fee: String,
                val fl: String,
                val flLevel: String,
                val flag: String,

                val freeTrialPrivilege: FreeTrialPrivilege,
                val id: String,
                val maxBrLevel: String,
                val maxbr: String,
                val payed: String,
                val pl: String,
                val plLevel: String,
                val playMaxBrLevel: String,
                val playMaxbr: String,
                val preSell: Boolean,
                val rscl: Any,
                val sp: String,
                val st: String,
                val subp: String,
                val toast: Boolean
            ) {
                data class ChargeInfo(
                    val chargeMessage: Any,
                    val chargeType: String,
                    val chargeUrl: Any,
                    val rate: String
                )

                data class FreeTrialPrivilege(
                    val listenType: Any,
                    val resConsumable: Boolean,
                    val userConsumable: Boolean
                )
            }

            data class Sq(
                val br: String,
                val fid: String,
                val size: String,
                val sr: String,
                val vd: String
            )
        }

        data class RecommendReason(
            val reason: String,
            val songId: String
        )
    }

    class DailySongConverter {
        @TypeConverter
        fun objectToJson(`object`: List<List<Data.DailySong.Ar>>): String {
            return GsonInstance.instance.toJson(`object`)
        }

        @TypeConverter
        fun jsonToObject(json: String?): List<List<Data.DailySong.Ar>> {
            val type = object : TypeToken<List<List<Data.DailySong.Ar>>>() {}.type
            return GsonInstance.instance.fromJson(json, type)
        }
    }

    class DailySongAlListConverter {
        @TypeConverter
        fun objectToJson(`object`: List<Data.DailySong.Al>): String {
            return GsonInstance.instance.toJson(`object`)
        }

        @TypeConverter
        fun jsonToObject(json: String?): List<Data.DailySong.Al> {
            val type = object : TypeToken<List<Data.DailySong.Al>>() {}.type
            return GsonInstance.instance.fromJson(json, type)
        }
    }
    @Entity(tableName = "daily_song")
    open class DailySongAlAndAr(
        @PrimaryKey val id: Long = 0,
        val al: List<Data.DailySong.Al> = listOf(),
        val ar: List<List<Data.DailySong.Ar>> = listOf()
    )
}