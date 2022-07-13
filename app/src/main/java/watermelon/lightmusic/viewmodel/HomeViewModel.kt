package watermelon.lightmusic.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import watermelon.lightmusic.base.BaseViewModel
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.repository.HomeRepository
import watermelon.lightmusic.repo.service.PlayListDetailService
import watermelon.lightmusic.util.extension.toast

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 21:00
 */
class HomeViewModel : BaseViewModel() {
    suspend fun getDailyRecommendedSongList() =
        HomeRepository.getDailyRecommendedSongList().catch {
            Log.d("testTag", "HomeViewModel\$getDailyRecommendedSongList: ${it.message}")
            toast("网络连接出错")
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            listOf()
        )

    suspend fun getDailyRecommendedSong() =
        HomeRepository.getDailyRecommendedSong().catch {
            Log.d("testTag", "HomeViewModel\$getDailyRecommendedSong: ${it.message}")
            toast("网络连接出错")
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            DailyRecommendedSong.DailySongAlAndAr()
        )

    suspend fun getPlayListDetail(id:Long) = PlayListDetailService.INSTANCE.getPlayListDetail(id)
}