package com.shurikus.boostnoteandroid.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {
    abstract val layoutRes: Int
    abstract val navigatorRes: Int

    protected var navigator: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { restoreState(it) }
        retainInstance = true
    }

    open protected fun restoreState(state: Bundle) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        navigator = Navigation.findNavController(requireActivity(), navigatorRes)
        return inflater.inflate(layoutRes, container, false)
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(@StringRes message: Int) {
        showToast(getString(message))
    }
}