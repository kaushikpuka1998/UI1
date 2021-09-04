package com.kgstrivers.newassignment.Recyclerviewadapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.kgstrivers.newassignment.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.viewpageritem.view.*

class ViewPagerAdapter: RecyclerView.Adapter<ViewPagerAdapter.MyViewholder>() {


    class MyViewholder(view: View):RecyclerView.ViewHolder(view)
    {

        var imageview = view.viewimage

        fun bind(data:Int){


            Picasso.with(itemView.context).load(data).fit().centerCrop()
                .placeholder(R.drawable.no_image)
                .into(imageview);

        }

    }

    var list = ArrayList<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpageritem,parent,false)
        return MyViewholder(view)

    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {

        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun listdata(item:ArrayList<Int>)
    {
        this.list = item
    }
}