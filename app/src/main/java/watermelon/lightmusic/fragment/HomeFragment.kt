package watermelon.lightmusic.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import watermelon.lightmusic.adapter.PlayListDetailAdapter
import watermelon.lightmusic.adapter.RecommendedSongListAdapter
import watermelon.lightmusic.adapter.RecommendedSongViewPagerAdapter
import watermelon.lightmusic.databinding.FragmentHomeBinding
import watermelon.lightmusic.repo.bean.DailyRecommendedSong
import watermelon.lightmusic.repo.bean.PlayListDetail
import watermelon.lightmusic.repo.service.VisitorLoginService
import watermelon.lightmusic.util.extension.safeFlow
import watermelon.lightmusic.util.network.ApiGenerator
import watermelon.lightmusic.view.SongListLayoutManager
import watermelon.lightmusic.viewmodel.HomeViewModel
import java.util.concurrent.locks.ReentrantLock

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 20:50
 */
class HomeFragment : Fragment() {
    private val viewModel = HomeViewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        safeFlow {
            ApiGenerator.getApiService(VisitorLoginService::class).visitorLogin()
        }
        initHomeDailyRecommendedSongList()
        initHomeDailyRecommendedSong()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initHomeDailyRecommendedSongList() {
        binding.homeDailyRecommendedSongList.layoutManager =
            SongListLayoutManager(requireContext()).apply {
                this.orientation = LinearLayoutManager.HORIZONTAL
            }
        binding.homeDailyRecommendedSongList.adapter = RecommendedSongListAdapter(
            listOf(), requireContext()
        ){id,color->
            lifecycleScope.launch {
                initHomePlayList(viewModel.getPlayListDetail(id).playlist.tracks)
            }
            Log.d("testTag", "initHomeDailyRecommendedSongList: $color")
            binding.homePlaylistDetailColorfulBackground.setColor(color)
        }
        safeFlow {
            viewModel.getDailyRecommendedSongList().collectLatest {
                (binding.homeDailyRecommendedSongList.adapter as RecommendedSongListAdapter).dailyRecommendedSongList =
                    it
                binding.homeDailyRecommendedSongList.adapter!!.notifyDataSetChanged()
            }
        }
    }

    private fun initHomePlayList(tracks: List<PlayListDetail.Playlist.Track>) {
        if (binding.homePlaylistDetailVp.adapter == null){
            binding.homePlaylistDetailVp.adapter = PlayListDetailAdapter(tracks)
            binding.homePlaylistDetailVp
        }else{
            (binding.homePlaylistDetailVp.adapter as PlayListDetailAdapter).tracks = tracks
            binding.homePlaylistDetailVp.adapter!!.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initHomeDailyRecommendedSong() {
        binding.homeDailyRecommendedSong.adapter =
            RecommendedSongViewPagerAdapter(DailyRecommendedSong.DailySongAlAndAr(), this)
        safeFlow {
            viewModel.getDailyRecommendedSong().collectLatest {
                (binding.homeDailyRecommendedSong.adapter as RecommendedSongViewPagerAdapter).dailySongAlAndAr =
                    it
                for (fragment in (binding.homeDailyRecommendedSong.adapter as RecommendedSongViewPagerAdapter).homeDailySongFragments){
                    fragment.dailySongAlAndAr = it
                }
                (binding.homeDailyRecommendedSong.adapter as RecommendedSongViewPagerAdapter).init()
            }
        }
    }
}