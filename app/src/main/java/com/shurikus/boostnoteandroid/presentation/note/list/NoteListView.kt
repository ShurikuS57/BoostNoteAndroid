package com.shurikus.boostnoteandroid.presentation.note.list

import android.os.Bundle
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.shurikus.boostnoteandroid.ui.base.BaseView
import com.shurikus.boostnoteandroid.ui.note.list.adapter.NotesAdapter

@StateStrategyType(AddToEndSingleStrategy::class)
interface NoteListView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showNotesAdapter(notesAdapter: NotesAdapter)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToNoteViewScreen(arg: Bundle?)

    fun showEmptyNotesPlaceHolder()

    fun hideEmptyNotesPlaceHolder()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToSnippetViewerScreen(bundle: Bundle)

    fun showNoSupportTypeNoteError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMenu()
}