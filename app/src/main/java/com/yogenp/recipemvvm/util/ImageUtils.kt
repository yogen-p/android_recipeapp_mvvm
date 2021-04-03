package com.yogenp.recipemvvm.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@Composable
fun loadImage(
    url: String,
    @DrawableRes defaultImage: Int
): MutableState<Bitmap?>{

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object: CustomTarget<Bitmap>(){
            /**
             * The method that will be called when the resource load has finished.
             *
             * @param resource the loaded resource.
             */
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            /**
             * A **mandatory** lifecycle callback that is called when a load is cancelled and its resources
             * are freed.
             *
             *
             * You **must** ensure that any current Drawable received in [.onResourceReady] is no longer used before redrawing the container (usually a View) or changing its
             * visibility.
             *
             * @param placeholder The placeholder drawable to optionally show, or null.
             */
            override fun onLoadCleared(placeholder: Drawable?) {}
        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object: CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }
            override fun onLoadCleared(placeholder: Drawable?) {}
        })

    return bitmapState
}