package watermelon.lightmusic.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.renderscript.RenderScript
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import watermelon.lightmusic.repo.bean.DailyRecommendedSongList
import watermelon.lightmusic.databinding.ItemHomeDailyRecommendedSongListBinding

/**
 * description ： 每日推荐歌单adapter
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 21:29
 */
class RecommendedSongListAdapter(
    var dailyRecommendedSongList: List<DailyRecommendedSongList.Recommend>,
    private val context: Context,
    val swipeListener: (id: Long,color:Int) -> Unit
) :
    RecyclerView.Adapter<RecommendedSongListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHomeDailyRecommendedSongListBinding, var color: Int = Color.WHITE) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeDailyRecommendedSongListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(dailyRecommendedSongList[position].picUrl)
            .addListener(object : RequestListener<Drawable> {
                //获取图片主色调
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Palette.from(resource?.toBitmap()!!).generate {
                        holder.color = it?.getMutedColor(Color.WHITE)!!
                    }
                    return false
                }

            })
            .into(holder.binding.itemHomeDailyRecommendedSongListPic)
        holder.binding.itemHomeDailyRecommendedSongListName.text =
            dailyRecommendedSongList[position].name
        /*holder.binding.itemHomeDailyRecommendedSongListPlayCount.text =
            dailyRecommendedSongList[position].playcount.toString()*/
        holder.binding.itemHomeDailyRecommendedSongListColorfulCard.swipeListener = {
            swipeListener.invoke(dailyRecommendedSongList[position].id,holder.color)
        }
    }

    override fun getItemCount(): Int {
        return dailyRecommendedSongList.size
    }

}