package com.yogenp.recipemvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class RecipeListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
//        return view

        val view = ComposeView(requireContext())
        view.apply {
            setContent {
                Text(text = "Hello Compose Fragment!")
            }
        }

        return view
    }
}