package com.shurikus.boostnoteandroid.model.interator.note

import com.shurikus.boostnoteandroid.model.repository.note.NoteRepository
import javax.inject.Inject

class NoteListInteractor @Inject constructor(
        private val noteRepository: NoteRepository
) {

    fun loadFolder() = noteRepository.loadFolders()

    fun loadNotes(key: String?) = noteRepository
            .loadNotes()
            .map {
                return@map it.filter {
                    it.folder == key
                }
            }
}