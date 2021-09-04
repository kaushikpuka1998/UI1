package com.kgstrivers.newassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_groceries.*

class GroceriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groceries)

        var bundle = intent.getStringExtra("imgurl")

        var bundle2 = intent.getStringExtra("name")

        nameclicked.setText(bundle2)

        Picasso.with(this).load(bundle).fit().centerCrop().into(passimage)

        //Toast.makeText(this,bundle,Toast.LENGTH_LONG).show()

        backfr.setOnClickListener {

            super.onBackPressed()
        }
        favorite.setOnClickListener {

            favorite.animate().apply {
                duration = 7000
                rotationBy(360f)

            }
            favorite.setBackgroundResource(R.drawable.redfav)
        }


    }
}


