package watermelon.lightmusic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import watermelon.lightmusic.databinding.ItemHomeDailyRecommendedSongBinding
import watermelon.lightmusic.repo.bean.DailyRecommendedSong

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 21:29
 */
class RecommendedSongAdapter(var dailyRecommendedSong: DailyRecommendedSong.DailySongAlAndAr, private val context: Context) :
    RecyclerView.Adapter<RecommendedSongAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHomeDailyRecommendedSongBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeDailyRecommendedSongBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(dailyRecommendedSong.al[position].picUrl).into(holder.binding.itemHomeDailyRecommendedSongPic)
        holder.binding.itemHomeDailyRecommendedSongName.text = dailyRecommendedSong.al[position].name
    }

    override fun getItemCount(): Int {
        return dailyRecommendedSong.al.size
    }

}