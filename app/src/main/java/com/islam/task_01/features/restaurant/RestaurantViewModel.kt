package com.islam.task_01.features.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islam.task_01.api.RestaurantApi
import com.islam.task_01.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RestaurantViewModel @Inject constructor(api: RestaurantApi) : ViewModel() {

  private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
  val restaurants: LiveData<List<Restaurant>> = restaurantLiveData

  init {
    viewModelScope.launch {
      val restaurants = api.getRestaurant()
      delay(2000)
      restaurantLiveData.value = restaurants
    }
  }


}