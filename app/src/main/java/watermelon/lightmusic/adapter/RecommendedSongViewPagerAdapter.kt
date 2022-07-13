package watermelon.lightmusic.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import watermelon.lightmusic.fragment.HomeDailySongFragment
import watermelon.lightmusic.repo.bean.DailyRecommendedSong

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/23 10:17
 */
class RecommendedSongViewPagerAdapter(
    var dailySongAlAndAr: DailyRecommendedSong.DailySongAlAndAr,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    val homeDailySongFragments = listOf(
        HomeDailySongFragment(dailySongAlAndAr, 0), HomeDailySongFragment(dailySongAlAndAr, 3),
        HomeDailySongFragment(dailySongAlAndAr, 6),
        HomeDailySongFragment(dailySongAlAndAr, 9)
    )

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return homeDailySongFragments[position]
    }

    fun refresh(){
        for (fragment in homeDailySongFragments) fragment.refresh()
    }

    fun init(){
        for (fragment in homeDailySongFragments) fragment.initDailySongList()
    }
}