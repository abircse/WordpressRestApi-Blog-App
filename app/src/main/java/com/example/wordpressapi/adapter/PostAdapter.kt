package com.example.wordpressapi.adapter

import BaseDataModel
import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wordpressapi.PostDetailsActivity
import com.example.wordpressapi.R


class PostAdapter(private val context: Context, private val postlist: List<BaseDataModel>?) :
    RecyclerView.Adapter<PostAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.custom_post,
            parent,
            false
        )
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val baseDataModel = postlist!![position]
        holder.posttitle.text = baseDataModel.title.rendered
        holder.postshort.text = baseDataModel.excerpt.rendered

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.postshort.text = Html.fromHtml(baseDataModel.excerpt.rendered, Html.FROM_HTML_MODE_COMPACT)
        } else {
            holder.postshort.text = HtmlCompat.fromHtml(baseDataModel.excerpt.rendered, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }

        holder.itemView.setOnClickListener {
            val a = Intent(context, PostDetailsActivity::class.java)
            a.putExtra("content", baseDataModel.content.rendered)
            a.putExtra("title", baseDataModel.title.rendered)
            context.startActivity(a)

        }
    }

    override fun getItemCount(): Int {
        return postlist?.size ?: 0
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val posttitle: TextView
        val postshort: TextView


        init {
            posttitle = itemView.findViewById(R.id.textView)
            postshort = itemView.findViewById(R.id.short_post)

        }
    }

}