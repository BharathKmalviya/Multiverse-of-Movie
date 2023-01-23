package com.multiverseofmovie.extensions

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

// this binding adapter is to show or hide view from both xml and code
@BindingAdapter("app:isVisible", requireAll = true)
fun View.setIsVisible(value: Boolean) {
    this.isVisible = value
}