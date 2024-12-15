package com.example.coffeshop.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeshop.Adapter.ListItemAdapter
import com.example.coffeshop.R
import com.example.coffeshop.ViewModel.MainViewModel
import com.example.coffeshop.databinding.ActivityListBinding

class ListActivity : BaseActivity() {
    private val viewModel=MainViewModel()
    private lateinit var binding:ActivityListBinding
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListBinding.inflate(layoutInflater)
        context=this@ListActivity
        setContentView(binding.root)

        binding.menuBtn.setOnClickListener {
            startActivity(
                Intent(this@ListActivity,MainActivity::class.java)
            )
        }
        binding.titleText.text=intent.getStringExtra("title")
        val i=intent.getIntExtra("id",0)
        when(i){
            1->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_1
                )
            )
            2->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_2
                )
            )
            3->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_3
                )
            )
            4->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_4
                )
            )
            5->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_5
                )
            )
            6->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_6
                )
            )
            7->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_7
                )
            )
            8->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_8
                )
            )
            9->binding.coffeeImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_9
                )
            )
        }

        binding.progressBar.visibility= View.VISIBLE
        viewModel.loadFiltered(i).observe(this){item ->

            if(item.isEmpty()){
                binding.emptyTxt.visibility=View.VISIBLE
            }else{
                binding.emptyTxt.visibility=View.GONE
                binding.view.layoutManager=LinearLayoutManager(
                    this@ListActivity,
                    LinearLayoutManager.VERTICAL,false
                )
                binding.view.adapter=ListItemAdapter(item)
                binding.progressBar.visibility=View.GONE
            }
        }
    }
}