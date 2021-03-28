package com.yogenp.recipemvvm.repository

import com.yogenp.recipemvvm.domain.model.Recipe
import com.yogenp.recipemvvm.network.RecipeNetworkService
import com.yogenp.recipemvvm.network.model.RecipeDTOMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeNetworkService,
    private val mapper: RecipeDTOMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.getById(token = token, id))
    }
}