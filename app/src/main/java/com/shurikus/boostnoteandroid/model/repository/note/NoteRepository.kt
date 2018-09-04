package com.shurikus.boostnoteandroid.model.repository.note

import com.shurikus.boostnoteandroid.model.data.local.RawAppData
import com.shurikus.boostnoteandroid.model.system.SchedulersProvider
import javax.inject.Inject

class NoteRepository @Inject constructor(
        private val rawAppData: RawAppData,
        private val schedulers: SchedulersProvider
) {

    fun loadFolders() = rawAppData.getFolders()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())

    fun loadNotes() = rawAppData.getNotes()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())

}