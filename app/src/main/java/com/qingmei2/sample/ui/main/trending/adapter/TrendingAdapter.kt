package com.qingmei2.sample.ui.main.trending.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.qingmei2.sample.R
import com.qingmei2.sample.entity.TrendingRepo
import de.hdodenhof.circleimageview.CircleImageView

class TrendingAdapter: ListAdapter<TrendingRepo, TrendingAdapter.TrendingViewHolder>(TrendingDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rtendings_repo, parent, false))
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.binds(getItem(position))
    }


    class TrendingViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private val btnAvatar: ConstraintLayout = view.findViewById(R.id.btnAvatar)

        private val tvOwnerName: TextView = view.findViewById(R.id.tvOwnerName)
        private val ivLanguageColor: CircleImageView = view.findViewById(R.id.ivLanguageColor)

        private val tvLanguage: TextView = view.findViewById(R.id.tvLanguage)
        private val tvRepoName: TextView = view.findViewById(R.id.tvRepoName)
        private val tvRepoDesc: TextView = view.findViewById(R.id.tvRepoDesc)
        private val tvStar: TextView = view.findViewById(R.id.tvStar)
        private val tvIssue: TextView = view.findViewById(R.id.tvIssue)
        private val tvFork: TextView = view.findViewById(R.id.tvFork)
        fun binds(item: TrendingRepo){
            ivAvatar.load(item.avatar)
            tvOwnerName.text = item.author
            tvLanguage.text = item.language
            tvRepoName.text = item.name
            tvRepoDesc.text = item.description
            tvStar.text = item.stars.toString()
            tvFork.text = item.forks.toString()
        }
    }

    private class TrendingDiffCallBack: DiffUtil.ItemCallback<TrendingRepo>(){

        override fun areItemsTheSame(oldItem: TrendingRepo, newItem: TrendingRepo): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: TrendingRepo, newItem: TrendingRepo): Boolean {
            return oldItem.url == newItem.url
        }

    }



}