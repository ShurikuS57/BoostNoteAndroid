package com.shurikus.boostnoteandroid.ui.drawer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.presentation.drawer.NavigationDrawerPresenter
import com.shurikus.boostnoteandroid.ui.base.BaseFragment
import com.shurikus.boostnoteandroid.ui.main.MainActivity
import com.shurikus.boostnoteandroid.ui.storage.storageactivity.StorageActivity
import kotlinx.android.synthetic.main.fragment_nav_drawer.*

class NavigationDrawerFragment : BaseFragment(), NavigationDrawerView {
    override val layoutRes = R.layout.fragment_nav_drawer
    override val navigatorRes = R.id.main_nav_host
    private var mainActivity: MainActivity? = null

    @InjectPresenter
    lateinit var presenter: NavigationDrawerPresenter

//    @ProvidePresenter
//    fun providePresenter(): NavigationDrawerPresenter {
//        return Toothpick
//                .openScope(DI.MAIN_ACTIVITY_SCOPE)
//                .getInstance(NavigationDrawerPresenter::class.java)
//    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = activity as MainActivity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        storageManagerButton.setOnClickListener {
            presenter.onStorageManagerClicked()
        }
    }

    override fun goToStorageManagerScreen() {
        mainActivity?.startActivity(Intent(requireActivity(), StorageActivity::class.java))
    }
}