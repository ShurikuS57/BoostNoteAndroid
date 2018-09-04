package com.shurikus.boostnoteandroid.ui.note.viewer

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.presentation.note.viewer.NoteViewerPresenter
import com.shurikus.boostnoteandroid.presentation.note.viewer.NoteViewerView
import com.shurikus.boostnoteandroid.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_note_viewer.*
import ru.noties.markwon.Markwon
import toothpick.Toothpick

class NoteViewerFragment : BaseFragment(), NoteViewerView {
    override val layoutRes = R.layout.fragment_note_viewer
    override val navigatorRes = R.id.main_nav_host

    @InjectPresenter
    lateinit var presenter: NoteViewerPresenter

    @ProvidePresenter
    fun providePresenter(): NoteViewerPresenter {
        return Toothpick
                .openScope(DI.APP_SCOPE)
                .getInstance(NoteViewerPresenter::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(arguments)
    }

    override fun showMarkdownNote(noteData: String?) {
        if (noteData != null) {
            Markwon.setMarkdown(noteText, noteData)
        }
    }
}