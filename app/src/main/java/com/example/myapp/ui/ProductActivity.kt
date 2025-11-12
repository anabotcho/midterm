package com.example.myapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private val productPrice = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddToCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            intent.putExtra("price", productPrice)
            startActivity(intent)
        }
    }
}
