package com.example.coffeshop.Activity

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.coffeshop.Model.ItemsModel
import com.example.coffeshop.R
import com.example.coffeshop.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail)
        context = this

        bundle()
    }

    private fun bundle() {
        binding.apply {

            item=intent.getParcelableExtra("object")!!
            titleTxt.text=item.title
            subtitleTxt.text=item.extra
            descriptionTxt.text=item.descrition
            priceTxt.text="$"+item.price

            Glide.with(context)
                .load(item.picUrl[0])
                .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                .into(binding.img)

        backBtn.setOnClickListener{ finish() }

            sizeBtn1.setOnClickListener {
                sizeBtn1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.orange_stroke_bg))
                sizeBtn2.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeBtn3.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeBtn1.setTextColor(getResources().getColor(R.color.orange))
                sizeBtn2.setTextColor(getResources().getColor(R.color.white))
                sizeBtn3.setTextColor(getResources().getColor(R.color.white))

            }

            sizeBtn2.setOnClickListener {
                sizeBtn2.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.orange_stroke_bg))
                sizeBtn3.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeBtn1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeBtn2.setTextColor(getResources().getColor(R.color.orange))
                sizeBtn3.setTextColor(getResources().getColor(R.color.white))
                sizeBtn1.setTextColor(getResources().getColor(R.color.white))

            }

            sizeBtn3.setOnClickListener {
                sizeBtn3.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.orange_stroke_bg))
                sizeBtn2.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeBtn1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeBtn3.setTextColor(getResources().getColor(R.color.orange))
                sizeBtn2.setTextColor(getResources().getColor(R.color.white))
                sizeBtn1.setTextColor(getResources().getColor(R.color.white))

            }

        }
    }
}