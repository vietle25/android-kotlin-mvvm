package com.viettech.baseproject.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.viettech.baseproject.utils.AutoClearValue

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

/**
 * The file defines extension functions for app's Fragment.
 */
fun Fragment.hideKeyboard() {
    val ime = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    ime.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun <T : Any> Fragment.autoCleared(): AutoClearValue<T> = AutoClearValue(this)
