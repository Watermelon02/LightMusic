package watermelon.lightmusic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import watermelon.lightmusic.base.BaseApp
import watermelon.lightmusic.databinding.FragmentHomeBinding
import watermelon.lightmusic.databinding.FragmentHomeDailySongBinding
import watermelon.lightmusic.repo.bean.DailyRecommendedSong

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/23 10:22
 */
class HomeDailySongFragment(
    var dailySongAlAndAr: DailyRecommendedSong.DailySongAlAndAr,
    var position: Int
) : Fragment() {
    private var binding: FragmentHomeDailySongBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeDailySongBinding.inflate(inflater, container, false)
        initDailySongList()
        return binding!!.root
    }

    fun refresh() {
        if (position + 14 < dailySongAlAndAr.al.size) position += 12 else position -= 10
        initDailySongList()
    }

    fun initDailySongList() {
        if (dailySongAlAndAr.al.isNotEmpty()&&binding!=null) {
            Glide.with(BaseApp.appContext).load(dailySongAlAndAr.al[position].picUrl)
                .into(binding!!.fragmentHomeDailySongPic1)
            Glide.with(BaseApp.appContext).load(dailySongAlAndAr.al[position + 1].picUrl)
                .into(binding!!.fragmentHomeDailySongPic2)
            Glide.with(BaseApp.appContext).load(dailySongAlAndAr.al[position + 2].picUrl)
                .into(binding!!.fragmentHomeDailySongPic3)
            binding!!.fragmentHomeDailySongName1.text = dailySongAlAndAr.al[position].name
            binding!!.fragmentHomeDailySongName2.text = dailySongAlAndAr.al[position + 1].name
            binding!!.fragmentHomeDailySongName3.text = dailySongAlAndAr.al[position + 2].name
        }
    }
}