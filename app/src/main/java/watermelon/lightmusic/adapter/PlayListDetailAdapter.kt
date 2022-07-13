package watermelon.lightmusic.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import watermelon.lightmusic.base.BaseApp
import watermelon.lightmusic.databinding.ItemHomePlaylistDetailBinding
import watermelon.lightmusic.repo.bean.PlayListDetail

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/24 20:11
 */
class PlayListDetailAdapter(var tracks: List<PlayListDetail.Playlist.Track>) : RecyclerView.Adapter<PlayListDetailAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemHomePlaylistDetailBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomePlaylistDetailBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(BaseApp.appContext).load(tracks[position].al.picUrl).into(holder.binding.itemHomePlaylistDetailPic)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }
}