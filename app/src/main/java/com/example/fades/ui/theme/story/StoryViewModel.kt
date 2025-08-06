package com.example.fades.ui.theme.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fades.ui.theme.data.FadesRepository
import com.example.libfades.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {
    private  val repo =  FadesRepository()

    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    fun fetchTagsGallery(tagName: String) = viewModelScope.launch(Dispatchers.IO) {
        _images.postValue(repo.getTagsGallery(tagName))
    }

}