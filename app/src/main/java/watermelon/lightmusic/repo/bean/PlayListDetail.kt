package watermelon.lightmusic.repo.bean

data class PlayListDetail(
    val code: String,
    val playlist: Playlist,
    val privileges: List<Privilege>,
    val relatedVideos: Any,
    val resEntrance: Any,
    val sharedPrivilege: Any,
    val urls: Any
) {
    data class Playlist(
        val adType: String,
        val backgroundCoverId: Long,
        val backgroundCoverUrl: String,
        val cloudTrackCount: String,
        val commentCount: String,
        val commentThreadId: String,
        val coverImgId: Long,
        val coverImgId_str: String,
        val coverImgUrl: String,
        val createTime: Long,
        val creator: Creator,
        val description: String,
        val englishTitle: String,
        val gradeStatus: String,
        val highQuality: Boolean,
        val historySharedUsers: Any,
        val id: Long,
        val name: String,
        val newImported: Boolean,
        val officialPlaylistType: String,
        val opRecommend: Boolean,
        val ordered: Boolean,
        val playCount: Long,
        val privacy: String,
        val remixVideo: Any,
        val shareCount: String,
        val sharedUsers: Any,
        val specialType: String,
        val status: String,
        val subscribed: Boolean,
        val subscribedCount: String,
        val subscribers: List<Subscriber>,
        val tags: List<String>,
        val titleImage: Long,
        val titleImageUrl: String,
        val trackCount: String,
        val trackIds: List<TrackId>,
        val trackNumberUpdateTime: Long,
        val trackUpdateTime: Long,
        val tracks: List<Track>,
        val updateFrequency: String,
        val updateTime: Long,
        val userId: String,
        val videoIds: Any,
        val videos: Any
    ) {
        data class Creator(
            val accountStatus: String,
            val anchor: Boolean,
            val authStatus: String,
            val authenticationTypes: String,
            val authority: String,
            val avatarDetail: AvatarDetail,
            val avatarImgId: Long,
            val avatarImgIdStr: String,
            val avatarImgId_str: String,
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
            val experts: Any,
            val followed: Boolean,
            val gender: String,
            val mutual: Boolean,
            val nickname: String,
            val province: String,
            val remarkName: Any,
            val signature: String,
            val userId: String,
            val userType: String,
            val vipType: String
        ) {
            data class AvatarDetail(
                val identityIconUrl: String,
                val identityLevel: String,
                val userType: String
            )
        }

        data class Subscriber(
            val accountStatus: String,
            val anchor: Boolean,
            val authStatus: String,
            val authenticationTypes: String,
            val authority: String,
            val avatarDetail: Any,
            val avatarImgId: Long,
            val avatarImgIdStr: String,
            val avatarImgId_str: String,
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
            val experts: Any,
            val followed: Boolean,
            val gender: String,
            val mutual: Boolean,
            val nickname: String,
            val province: String,
            val remarkName: Any,
            val signature: String,
            val userId: Long,
            val userType: String,
            val vipType: String
        )

        data class TrackId(
            val alg: String,
            val at: Long,
            val id: String,
            val rcmdReason: String,
            val sc: Any,
            val t: String,
            val uid: String,
            val v: String
        )

        data class Track(
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
            val hr: Hr,
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
            val originSongSimpleData: OriginSongSimpleData,
            val pop: String,
            val pst: String,
            val publishTime: Long,
            val resourceState: Boolean,
            val rt: String,
            val rtUrl: Any,
            val rtUrls: List<Any>,
            val rtype: String,
            val rurl: Any,
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
                val vd: String
            )

            data class Hr(
                val br: String,
                val fid: String,
                val size: String,
                val vd: String
            )

            data class L(
                val br: String,
                val fid: String,
                val size: String,
                val vd: String
            )

            data class M(
                val br: String,
                val fid: String,
                val size: String,
                val vd: String
            )

            data class OriginSongSimpleData(
                val albumMeta: AlbumMeta,
                val artists: List<Artist>,
                val name: String,
                val songId: String
            ) {
                data class AlbumMeta(
                    val id: String,
                    val name: String
                )

                data class Artist(
                    val id: String,
                    val name: String
                )
            }

            data class Sq(
                val br: String,
                val fid: String,
                val size: String,
                val vd: String
            )
        }
    }

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
        val paidBigBang: Boolean,
        val payed: String,
        val pc: Any,
        val pl: String,
        val plLevel: String,
        val playMaxBrLevel: String,
        val playMaxbr: String,
        val preSell: Boolean,
        val realPayed: String,
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
}