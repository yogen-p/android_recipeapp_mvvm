package com.yogenp.recipemvvm.presentation.ui.recipe_list

import com.yogenp.recipemvvm.presentation.ui.recipe_list.FoodCategory.*

enum class FoodCategory(val value: String) {
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    POTATO("Potato"),
    CARROT("Carrot"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut")
}

fun getAllFoodCategories(): List<FoodCategory>{
    return listOf(SOUP, DESSERT, VEGETARIAN, POTATO, CARROT, MILK, VEGAN, PIZZA, DONUT)
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}