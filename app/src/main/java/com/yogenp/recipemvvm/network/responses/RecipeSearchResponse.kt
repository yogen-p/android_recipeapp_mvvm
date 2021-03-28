package com.yogenp.recipemvvm.network.responses

import com.google.gson.annotations.SerializedName
import com.yogenp.recipemvvm.network.model.RecipeNetworkEntity

class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeNetworkEntity>,
)