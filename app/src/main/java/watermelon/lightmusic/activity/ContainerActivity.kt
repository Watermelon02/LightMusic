package watermelon.lightmusic.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayoutMediator
import watermelon.lightmusic.R
import watermelon.lightmusic.adapter.ContainerFragmentAdapter
import watermelon.lightmusic.base.BaseActivity
import watermelon.lightmusic.databinding.ActivityContainerBinding

class ContainerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.containerVp.adapter = ContainerFragmentAdapter(this)
        TabLayoutMediator(binding.containerTab, binding.containerVp) { tab, position ->
            when (position) {
                0 -> tab.text = "发现"
                1 -> tab.text = "我的"
                2 -> tab.text = "播客"
            }
        }.attach()
    }

}