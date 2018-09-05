package com.shurikus.boostnoteandroid.ui.note.list

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.presentation.note.list.NoteListPresenter
import com.shurikus.boostnoteandroid.presentation.note.list.NoteListView
import com.shurikus.boostnoteandroid.ui.base.BaseFragment
import com.shurikus.boostnoteandroid.ui.main.MainActivity
import com.shurikus.boostnoteandroid.ui.note.list.adapter.NotesAdapter
import com.shurikus.boostnoteandroid.utils.extension.toast
import kotlinx.android.synthetic.main.fragment_note_list.*
import toothpick.Toothpick

class NoteListFragment : BaseFragment(), NoteListView {
    override val layoutRes = R.layout.fragment_note_list
    override val navigatorRes = R.id.main_nav_host

    companion object {
        const val ARG_FOLDER_ID = "folder_id"
    }

    @InjectPresenter
    lateinit var presenter: NoteListPresenter

    @ProvidePresenter
    fun providePresenter(): NoteListPresenter {
        return Toothpick
                .openScope(DI.APP_SCOPE)
                .getInstance(NoteListPresenter::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(arguments)
        toolbar.setNavigationOnClickListener {
            presenter.onMenuPressed()
        }
    }

    override fun showMenu() {
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).showNavMenu()
        }
    }

    override fun showNotesAdapter(notesAdapter: NotesAdapter) {
        recyclerView.adapter = notesAdapter
    }

    override fun showEmptyNotesPlaceHolder() {
        // Todo need implement
    }

    override fun hideEmptyNotesPlaceHolder() {
        // Todo need implement
    }

    override fun showNoSupportTypeNoteError() {
        context?.toast(getString(R.string.error_type_note_not_support))
    }

    override fun goToSnippetViewerScreen(bundle: Bundle) {
        // Todo need implement
        showNoSupportTypeNoteError()
    }

    override fun goToNoteViewScreen(arg: Bundle?) {
        navigator?.navigate(R.id.action_noteListFragment_to_noteViewerFragment, arg)
    }
}