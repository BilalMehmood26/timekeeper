package com.usaclean.timekeeper.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager

fun postDelayed(ms: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        action.invoke()
    }, ms)
}

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

fun View.setKeyboardHideOnClickListener() {
    setOnClickListener {
        it.hideKeyboard()
    }
}

fun View?.gone() {
    this?.let { it.visibility = View.GONE }
}

fun View?.visible() {
    this?.let { it.visibility = View.VISIBLE }
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.isVisible(flag: Boolean) {
    visibility = if (flag) View.VISIBLE else View.GONE
}

fun goneViews(vararg views: View) {
    views.forEach { it.gone() }
}

fun visibleViews(vararg views: View) {
    views.forEach { it.visible() }
}

fun invisibleViews(vararg views: View) {
    views.forEach { it.inVisible() }
}