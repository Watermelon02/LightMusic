package watermelon.lightmusic.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import watermelon.lightmusic.fragment.HomeFragment

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/5/30 10:43
 */
class ContainerFragmentAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2
    private val homeFragment = HomeFragment()

    override fun createFragment(position: Int): Fragment {
        //预加载navigation界面的数据
        return when (position) {
            0 -> homeFragment
            else -> HomeFragment()
        }
    }

}