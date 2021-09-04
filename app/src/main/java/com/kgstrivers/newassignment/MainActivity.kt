package com.kgstrivers.newassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kgstrivers.newassignment.Model.ExclusiveModel
import com.kgstrivers.newassignment.Model.GroceriesModel
import com.kgstrivers.newassignment.Recyclerviewadapter.BestSellingAdapter
import com.kgstrivers.newassignment.Recyclerviewadapter.ExclusiveAdapter
import com.kgstrivers.newassignment.Recyclerviewadapter.GroceriesAdapter
import com.kgstrivers.newassignment.Recyclerviewadapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var exclusiveadapter: ExclusiveAdapter
    lateinit var groceriesAdapter: GroceriesAdapter
    lateinit var  bestSellingAdapter: BestSellingAdapter
    lateinit var  viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initrecycleview()

        createData()

        createData1()

        createData2()

        createData3()
    }

    private  fun createData()
    {
        val item = ArrayList<ExclusiveModel>()


        val res1 = ExclusiveModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/banana.png","Organic Bananas","7 pcs,","$ 4.99")
        val res2 = ExclusiveModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/apple2.png","Red Apple","1 Kg","$ 4.99")
        val res3 = ExclusiveModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/ginger.png","Ginger","8 Pcs,","$ 6.23")

        item.add(res1)
        item.add(res2)
        item.add(res3)



        exclusiveadapter.listdata(item)
        exclusiveadapter.notifyDataSetChanged()
    }

    private  fun createData2()
    {
        val item = ArrayList<GroceriesModel>()


        val res1 =GroceriesModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/pulse.png","Pulses","#FAF3DD")
        val res2 = GroceriesModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/rice2.png","Rices","#ECFFDC")
        val res3 = GroceriesModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/redbellpaper.png","Red Bellpaper","#FDCBDA")

        item.add(res1)
        item.add(res2)
        item.add(res3)



        groceriesAdapter.listdata(item)
        groceriesAdapter.notifyDataSetChanged()
    }

    private  fun createData3()
    {
        val item = ArrayList<ExclusiveModel>()


        val res1 =ExclusiveModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/redbellpaper.png","Red Bell Paper","","$ 4.99")
        val res2 = ExclusiveModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/apple2.png","Red Apple","","$ 4.99")
        val res3 = ExclusiveModel("https://fooddataapi.s3.ap-south-1.amazonaws.com/assignment/ginger.png","Ginger","","$ 6.23")

        item.add(res1)
        item.add(res3)
        item.add(res2)




        bestSellingAdapter.listdata(item)
        bestSellingAdapter.notifyDataSetChanged()
    }

    private  fun createData1()
    {
        val item = ArrayList<Int>()

        item.add(R.drawable.banner)
        item.add(R.drawable.ginger)
        item.add(R.drawable.redbellpaper)
        item.add(R.drawable.apple2)

        viewPagerAdapter.listdata(item)
    }

    private fun initrecycleview()
    {
        exclusiverecycle.apply { layoutManager= LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.HORIZONTAL,false)

            exclusiveadapter = ExclusiveAdapter()
            adapter = exclusiveadapter

        }

        groceriesrecycle.apply { layoutManager= LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.HORIZONTAL,false)

            groceriesAdapter = GroceriesAdapter()
            adapter = groceriesAdapter

        }

        bestselling.apply { layoutManager= LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.HORIZONTAL,false)

            bestSellingAdapter = BestSellingAdapter()
            adapter = bestSellingAdapter
        }


        imag.apply { layoutManager= LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.HORIZONTAL,false)

            viewPagerAdapter = ViewPagerAdapter()
            adapter = viewPagerAdapter
        }





    }
}