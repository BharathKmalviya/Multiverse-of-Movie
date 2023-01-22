package com.multiverseofmovie.extensions

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isVisible", requireAll = true)
fun View.setIsVisible(value: Boolean) {
    this.isVisible = value
}