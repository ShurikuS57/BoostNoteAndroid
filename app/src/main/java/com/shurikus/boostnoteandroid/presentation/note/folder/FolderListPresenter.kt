package com.shurikus.boostnoteandroid.presentation.note.folder

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.google.gson.Gson
import com.shurikus.boostnoteandroid.model.interator.note.NoteListInteractor
import com.shurikus.boostnoteandroid.ui.base.BasePresenter
import com.shurikus.boostnoteandroid.ui.note.folder.adapter.FolderAdapter
import com.shurikus.boostnoteandroid.ui.note.list.NoteListFragment
import javax.inject.Inject

@InjectViewState
class FolderListPresenter @Inject constructor(
        private val noteListInteractor: NoteListInteractor,
        private val gson: Gson
) : BasePresenter<FolderListView>() {

    fun loadFolders() {
        disposable.add(noteListInteractor
                .loadFolder()
                .subscribe({
                    if (it.folders != null && !it.folders.isEmpty()) {
                        viewState.showFolderAdapter(FolderAdapter(it.folders) { folder ->
                            val bundle = Bundle()
                            bundle.putString(NoteListFragment.ARG_FOLDER_ID, folder.key)
                            viewState.goToNoteListScreen(bundle)
                        })
                    } else {
                        viewState.showEmptyFoldersPlaceHolder()
                    }
                }, {
                }))
    }

    fun onMenuPressed() {
        viewState.showMenu()
    }

}