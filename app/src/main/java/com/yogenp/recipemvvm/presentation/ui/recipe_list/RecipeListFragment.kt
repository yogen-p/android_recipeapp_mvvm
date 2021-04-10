package com.yogenp.recipemvvm.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yogenp.recipemvvm.presentation.components.FoodCategoryChip
import com.yogenp.recipemvvm.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value
                val query = viewModel.query.value
                val selectedCategory = viewModel.selectedCategory.value
//                val query = remember { mutableStateOf("Noodles") }

                Column {

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = 8.dp,
                        color = Color.White
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(8.dp),
                                    value = query,
                                    onValueChange = {
                                        viewModel.onQueryChanged(it)
                                    },
                                    label = { Text(text = "Search") },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Search
                                    ),
                                    keyboardActions = KeyboardActions(onSearch = {
                                        viewModel.newSearch()
                                    }),
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "Search"
                                        )
                                    },
                                    textStyle = TextStyle(color = Color.Black),
                                    colors = TextFieldDefaults.textFieldColors(
                                        backgroundColor = Color.White
                                    )
                                )
                            }

                            val scrollState = rememberScrollState()
                            LazyRow(modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp, bottom = 8.dp)
                                .horizontalScroll(scrollState),
                            ) {
                                lifecycleScope.launch { scrollState.scrollTo(viewModel.categoryScrollPosition) }
                                itemsIndexed(items = getAllFoodCategories()) { _, category ->
                                    FoodCategoryChip(
                                        category = category.value,
                                        isSelected = selectedCategory == category,
                                        onSelectedCategoryChanged = {
                                            viewModel.onChangeCategoryScrollPosition(scrollState.value)
                                            viewModel.onSelectedCategoryChanged(it)
                                        },
                                        onExecuteSearch = viewModel::newSearch
                                    )
                                }
                            }
                        }
                    }

                    LazyColumn {
                        itemsIndexed(
                            items = recipes
                        ) { _, recipe ->
                            RecipeCard(recipe = recipe) {
                            }

                        }
                    }
                }
            }
        }

    }
}