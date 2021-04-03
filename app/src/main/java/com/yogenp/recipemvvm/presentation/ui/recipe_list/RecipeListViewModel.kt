package com.yogenp.recipemvvm.presentation.ui.recipe_list

import android.app.DownloadManager
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogenp.recipemvvm.domain.model.Recipe
import com.yogenp.recipemvvm.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
): ViewModel(){

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())
    val query = mutableStateOf("Noodles")

    init {
        newSearch()
    }

    private fun newSearch(){
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = "soup"
            )
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
    }
}