package com.yogenp.recipemvvm.di

import com.yogenp.recipemvvm.network.RecipeNetworkService
import com.yogenp.recipemvvm.network.model.RecipeDTOMapper
import com.yogenp.recipemvvm.repository.RecipeRepository
import com.yogenp.recipemvvm.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeNetworkService: RecipeNetworkService,
        recipeDTOMapper: RecipeDTOMapper
    ): RecipeRepository{
        return RecipeRepositoryImpl(recipeNetworkService, recipeDTOMapper)
    }
}