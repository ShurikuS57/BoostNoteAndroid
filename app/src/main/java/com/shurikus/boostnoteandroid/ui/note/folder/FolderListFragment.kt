package com.shurikus.boostnoteandroid.ui.note.folder

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.presentation.note.folder.FolderListPresenter
import com.shurikus.boostnoteandroid.presentation.note.folder.FolderListView
import com.shurikus.boostnoteandroid.ui.base.BaseFragment
import com.shurikus.boostnoteandroid.ui.main.MainActivity
import com.shurikus.boostnoteandroid.ui.note.folder.adapter.FolderAdapter
import kotlinx.android.synthetic.main.fragment_folder_list.*
import toothpick.Toothpick

class FolderListFragment : BaseFragment(), FolderListView {
    override val layoutRes = R.layout.fragment_folder_list
    override val navigatorRes = R.id.main_nav_host

    @InjectPresenter
    lateinit var presenter: FolderListPresenter

    @ProvidePresenter
    fun providePresenter(): FolderListPresenter {
        return Toothpick
                .openScope(DI.APP_SCOPE)
                .getInstance(FolderListPresenter::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadFolders()
        toolbar.setNavigationOnClickListener {
            presenter.onMenuPressed()
        }
    }

    override fun showFolderAdapter(folderAdapter: FolderAdapter) {
        recyclerView.adapter = folderAdapter
    }

    override fun showEmptyFoldersPlaceHolder() {
        //TODO need implement
    }

    override fun hideEmptyFoldersPlaceHolder() {
        //TODO need implement
    }

    override fun showMenu() {
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).showNavMenu()
        }
    }

    override fun goToNoteListScreen(bundle: Bundle) {
        navigator?.navigate(R.id.action_folderListFragment_to_noteListFragment, bundle)
    }
}