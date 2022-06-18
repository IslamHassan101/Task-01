package com.islam.task_01.features.restaurant

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.islam.task_01.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

  private val viewModel: RestaurantViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityRestaurantBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val restaurantAdapter = RestaurantsAdapter()

    binding.apply {
      restaurantRecyclerView.apply {
        adapter = restaurantAdapter
        layoutManager = LinearLayoutManager(this@RestaurantActivity)
      }
      viewModel.restaurants.observe(this@RestaurantActivity) { restaurant ->
        restaurantAdapter.submitList(restaurant)
      }
    }
  }
}