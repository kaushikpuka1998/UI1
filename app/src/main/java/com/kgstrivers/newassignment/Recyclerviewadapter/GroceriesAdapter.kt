package com.kgstrivers.newassignment.Recyclerviewadapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.kgstrivers.newassignment.GroceriesActivity
import com.kgstrivers.newassignment.Model.GroceriesModel
import com.kgstrivers.newassignment.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.exclusive_item.view.*
import kotlinx.android.synthetic.main.groceresitem.view.*

class GroceriesAdapter: RecyclerView.Adapter<GroceriesAdapter.Myviewholder>() {


    class Myviewholder(view:View):RecyclerView.ViewHolder(view)
    {
        var imageview = view.groceriesimg
        var name = view.groceriesname
        val card = view.groceriescard

        var imgurlstore = ""
        var nameclicked = ""
        fun bind(data: GroceriesModel){


            imgurlstore = data.imgurl.toString()
            nameclicked =data.name.toString()
            Picasso.with(itemView.context).load(data.imgurl).fit().centerCrop()
                .placeholder(R.drawable.no_image)
                .into(imageview);
            name.setText(data.name)

            card.setCardBackgroundColor(Color.parseColor(data.col))




        }

        init {
            view.setOnClickListener {
                    view-> val pos:Int =  adapterPosition

                //Toast.makeText(itemView.context,"Item Cliked $pos",Toast.LENGTH_LONG).show()

                val intent = Intent(view.context,GroceriesActivity::class.java)


                intent.putExtra("imgurl",imgurlstore)
                intent.putExtra("name",nameclicked)
                view.context.startActivity(intent)





            }
        }


    }
    var list =  ArrayList<GroceriesModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.groceresitem,parent,false)

        return GroceriesAdapter.Myviewholder(view)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {


        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {

        return list.size
    }
    fun listdata(item:ArrayList<GroceriesModel>) {

        this.list = item
    }

}