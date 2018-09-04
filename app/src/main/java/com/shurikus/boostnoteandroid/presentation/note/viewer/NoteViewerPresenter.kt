package com.shurikus.boostnoteandroid.presentation.note.viewer

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.google.gson.Gson
import com.shurikus.boostnoteandroid.Const
import com.shurikus.boostnoteandroid.entity.NoteEntity
import com.shurikus.boostnoteandroid.ui.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class NoteViewerPresenter @Inject constructor(
        private val gson: Gson
) : BasePresenter<NoteViewerView>() {
    fun onViewCreated(arguments: Bundle?) {
        val noteData = arguments?.getString(Const.ARG_NOTE_DATA_JSON)
        if (noteData != null) {
            viewState.showMarkdownNote(gson.fromJson(noteData, NoteEntity::class.java).content)
        }
    }
}