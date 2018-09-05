package com.shurikus.boostnoteandroid.presentation.note.list

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.google.gson.Gson
import com.shurikus.boostnoteandroid.Const
import com.shurikus.boostnoteandroid.model.interator.note.NoteListInteractor
import com.shurikus.boostnoteandroid.ui.base.BasePresenter
import com.shurikus.boostnoteandroid.ui.note.list.NoteListFragment
import com.shurikus.boostnoteandroid.ui.note.list.adapter.NotesAdapter
import javax.inject.Inject

@InjectViewState
class NoteListPresenter @Inject constructor(
        private val noteListInteractor: NoteListInteractor,
        private val gson: Gson
) : BasePresenter<NoteListView>() {

    fun onViewCreated(arguments: Bundle?) {
        val folderId = arguments?.getString(NoteListFragment.ARG_FOLDER_ID)
        if (folderId != null) {
            loadNotes(folderId)
        } else {
            viewState.showEmptyNotesPlaceHolder()
        }
    }

    private fun loadNotes(folderId: String) {
        disposable.add(noteListInteractor
                .loadNotes(folderId)
                .subscribe({
                    if (it != null && it.isNotEmpty()) {
                        viewState.showNotesAdapter(NotesAdapter(it) {note ->
                            val bundle = Bundle()
                            bundle.putString(Const.ARG_NOTE_DATA_JSON, gson.toJson(note))
                            when (note.type) {
                                Const.NoteType.MARKDOWN_NOTE.toString() -> viewState.goToNoteViewScreen(bundle)
                                Const.NoteType.SNIPPET_NOTE.toString() -> viewState.goToSnippetViewerScreen(bundle)
                                else -> viewState.showNoSupportTypeNoteError()
                            }
                        })
                    } else {
                        viewState.showEmptyNotesPlaceHolder()
                    }
                },{
                }))
    }

    fun onMenuPressed() {
        viewState.showMenu()
    }
}