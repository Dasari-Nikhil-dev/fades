package com.example.fades.ui.theme.feed

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fades.ui.theme.data.FadesRepository
import com.example.libfades.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private  val repo = FadesRepository()

    private  val _feed = MutableLiveData<List<Image>>()

    val feed: LiveData<List<Image>> = _feed

    fun updateFeed(feedType: String) {
        viewModelScope.launch(Dispatchers.IO){
            when(feedType) {
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                "else" -> { Log.e("Feed","Feed has to be Either Hot or Top") }
            }
        }
    }
}
