package com.kgstrivers.newassignment.Recyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kgstrivers.newassignment.Model.ExclusiveModel
import com.kgstrivers.newassignment.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.bestselling.view.*
import kotlinx.android.synthetic.main.exclusive_item.view.*

class BestSellingAdapter: RecyclerView.Adapter<BestSellingAdapter.MyHolder>() {


    class MyHolder(view:View):RecyclerView.ViewHolder(view)
    {
        var imageview = view.bestsellingitemimg
        var name = view.bestsellingitemname
        val price = view.bestsellingelementprice


        fun bind(data: ExclusiveModel){


            Picasso.with(itemView.context).load(data.imgurl).fit().centerCrop()
                .placeholder(R.drawable.no_image)
                .into(imageview);
            name.setText(data.name)
            price.setText(data.price)

        }
    }


    var list = ArrayList<ExclusiveModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bestselling,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {


        return list.size
    }


    fun listdata(item:ArrayList<ExclusiveModel>) {

        this.list = item
    }
}