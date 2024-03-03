package com.example.chowcrazeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.adapters.CategoryAdapter
import com.example.chowcrazeapp.adapters.FoodAdapter
import com.example.chowcrazeapp.adapters.RestaurantAdapter
import com.example.chowcrazeapp.models.Category
import com.example.chowcrazeapp.models.Food
import com.example.chowcrazeapp.models.Restaurant
import com.example.chowcrazeapp.ui.FoodDetailActivity
import com.example.chowcrazeapp.ui.RestaurantActivity

class MainActivity : AppCompatActivity() {
    private lateinit var categoryRecylerView: RecyclerView
    private lateinit var restaurantRecyclerView: RecyclerView
    private lateinit var foodRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoryRecylerView = findViewById(R.id.categoryRecyclerView)
        categoryRecylerView.adapter = CategoryAdapter(Category.categories)
        categoryRecylerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        restaurantRecyclerView = findViewById(R.id.restaurantRecyclerView)
        restaurantRecyclerView.adapter = RestaurantAdapter(Restaurant.restaurants){ restaurant ->
            Log.i("Restaurant Clicked", restaurant.name)
            val intent = Intent(this, RestaurantActivity::class.java).apply {
                putExtra("restaurantId", restaurant.id)
            }
            startActivity(intent)
        }
        restaurantRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        foodRecyclerView = findViewById(R.id.foodRecyclerView)
        foodRecyclerView.adapter = FoodAdapter(Food.foods){ food ->
            val intent = Intent(this, FoodDetailActivity::class.java).apply {
                putExtra("foodId", food.id)
            }
            startActivity(intent)
        }
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}