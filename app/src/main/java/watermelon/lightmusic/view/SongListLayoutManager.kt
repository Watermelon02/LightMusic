package watermelon.lightmusic.view

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import androidx.core.view.ViewCompat.animate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/24 16:46
 */
class SongListLayoutManager(context: Context) : LinearLayoutManager(context) {
    override fun canScrollHorizontally(): Boolean {
        return true
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        for (i in 0..childCount){
            getChildAt(i)?.let { it ->
                ((it as LinearLayout).getChildAt(1) as ColorfulCard).let {
                    it.animate().y(0f)
                    it.totalDy = 0f
                }
            }
        }
        return super.scrollHorizontallyBy(dx, recycler, state)
    }
}