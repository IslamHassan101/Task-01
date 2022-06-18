package com.islam.task_01.features.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.islam.task_01.data.Restaurant
import com.islam.task_01.databinding.RestaurantListItemBinding

class RestaurantsAdapter :
  ListAdapter<Restaurant, RestaurantsAdapter.RestaurantViewHolder>(RestaurantComparator()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
    val binding =
      RestaurantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RestaurantViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
    val currentItem = getItem(position)
    if (currentItem != null) {
      holder.bind(currentItem)
    }
  }

  class RestaurantViewHolder(private val binding: RestaurantListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(restaurant: Restaurant) {
      binding.apply {
        Glide.with(itemView).load(restaurant.logo).into(imgRestPlaceholder)

        restaurantName.text = restaurant.name
        restaurantType.text = restaurant.type
        restaurantAddress.text = restaurant.address
      }
    }
  }


  class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
      oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
      oldItem == newItem
  }

}