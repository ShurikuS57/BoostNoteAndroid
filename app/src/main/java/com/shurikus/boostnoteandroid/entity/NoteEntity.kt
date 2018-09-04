package com.shurikus.boostnoteandroid.entity

data class NoteEntity(
        val createdAt: String?,
        val updatedAt: String?,
        val type: String?,
        val folder: String?,
        val title: String?,
        val content: String?,
        val isStarred: Boolean?,
        val isTrashed: Boolean?)