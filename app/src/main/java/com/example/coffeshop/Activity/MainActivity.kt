package com.example.coffeshop.Activity

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.example.coffeshop.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBlurEffect()
        setVariable()

    }

    private fun setVariable() {
        binding.apply {
            btnIceDrink.setOnClickListener{ startListActivity(2,"Ice Drink") }
            btnHotDrink.setOnClickListener{ startListActivity(3,"Hot Drink") }
            btnHotCoffee.setOnClickListener{ startListActivity(1,"Hot Coffee") }
            btnIceCoffee.setOnClickListener{ startListActivity(4,"Ice Coffee") }
            btnBrewingCoffee.setOnClickListener{ startListActivity(5,"Brewing Coffee") }
            btnShake.setOnClickListener{ startListActivity(6,"Shake") }
            btnRestaurant.setOnClickListener{ startListActivity(7,"Restaurant") }
            btnBreakfast.setOnClickListener{ startListActivity(8,"Breakfast") }
            btnCake.setOnClickListener{ startListActivity(9,"Cake") }

        }
    }

    private fun startListActivity(id:Int,title:String){
        val intent=Intent(this, ListActivity::class.java)
        intent.putExtra("id",id)
        intent.putExtra("title",title)
        startActivity(intent)
    }

    private fun setBlurEffect() {
        val radius=10f
        val decorView=this.window.decorView
        val rootView=decorView.findViewById<View>(R.id.content)as ViewGroup
        val windowBackground=decorView.background
        binding.blurView.setupWith(
            rootView,
            RenderScriptBlur(this)

        )
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

        binding.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binding.blurView.setClipToOutline(true)
    }
}


