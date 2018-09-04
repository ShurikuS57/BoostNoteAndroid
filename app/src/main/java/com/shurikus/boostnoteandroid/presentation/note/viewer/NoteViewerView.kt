package com.shurikus.boostnoteandroid.presentation.note.viewer

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.shurikus.boostnoteandroid.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface NoteViewerView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMarkdownNote(noteData: String?)

}