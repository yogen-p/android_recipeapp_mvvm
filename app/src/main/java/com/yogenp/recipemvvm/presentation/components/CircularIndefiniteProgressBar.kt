package com.yogenp.recipemvvm.presentation.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun CircularIndefiniteProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val constraintSet = myDecoupledConstraints(
                if (minWidth < 600.dp)
                    0.1f    // Portrait
                else
                    0.7f    // Landscape
            )

            ConstraintLayout(
                modifier = Modifier.fillMaxSize(),
                constraintSet = constraintSet
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.layoutId("progressBar")
                )
                Text(
                    text = "Cooking...",
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.layoutId("progressText")
                )
            }
        }
    }
}

private fun myDecoupledConstraints(verticalBias: Float): ConstraintSet{
    return ConstraintSet {
        val guideline = createGuidelineFromTop(verticalBias)
        val progressBar = createRefFor("progressBar")
        val progressText = createRefFor("progressText")

        constrain(progressBar){
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(progressText){
            top.linkTo(progressBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}