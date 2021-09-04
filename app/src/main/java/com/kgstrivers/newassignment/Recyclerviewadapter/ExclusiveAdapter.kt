package com.kgstrivers.newassignment.Recyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kgstrivers.newassignment.Model.ExclusiveModel
import com.kgstrivers.newassignment.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.exclusive_item.view.*

class ExclusiveAdapter: RecyclerView.Adapter<ExclusiveAdapter.MyViewHolder>() {

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        var imageview = view.exclusiveitemimg
        var name = view.elementname
        val pcs= view.elementpcs
        val price = view.elementprice


        fun bind(data:ExclusiveModel){


            Picasso.with(itemView.context).load(data.imgurl).fit().centerCrop()
                .placeholder(R.drawable.no_image)
                .into(imageview);
            name.setText(data.name)
            pcs.setText(data.pcs)
            price.setText(data.price)




        }
    }


    var list =  ArrayList<ExclusiveModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exclusive_item,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(list.get(position))

    }

    override fun getItemCount(): Int {

        return list.size
    }


    fun listdata(item:ArrayList<ExclusiveModel>) {

        this.list = item
    }
}