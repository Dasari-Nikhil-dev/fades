package com.example.fades.ui.theme.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fades.ui.theme.data.FadesRepository
import com.example.libfades.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel: ViewModel() {
    private  val repo = FadesRepository()

    private val _tags = MutableLiveData<List<Tag>>()
    val tags: LiveData<List<Tag>> = _tags

    fun updateTags() = viewModelScope.launch(Dispatchers.IO){
            _tags.postValue(repo.getTagResponse())
        }

}
