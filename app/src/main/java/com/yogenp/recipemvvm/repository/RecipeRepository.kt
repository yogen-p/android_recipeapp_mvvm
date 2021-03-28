package com.yogenp.recipemvvm.repository

import com.yogenp.recipemvvm.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe
}