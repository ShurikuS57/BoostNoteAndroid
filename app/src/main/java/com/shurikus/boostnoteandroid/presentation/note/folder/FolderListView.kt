package com.shurikus.boostnoteandroid.presentation.note.folder

import android.os.Bundle
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.shurikus.boostnoteandroid.ui.base.BaseView
import com.shurikus.boostnoteandroid.ui.note.folder.adapter.FolderAdapter

@StateStrategyType(AddToEndSingleStrategy::class)
interface FolderListView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showFolderAdapter(folderAdapter: FolderAdapter)

    fun showEmptyFoldersPlaceHolder()

    fun hideEmptyFoldersPlaceHolder()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToNoteListScreen(bundle: Bundle)

}