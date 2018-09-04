package com.shurikus.boostnoteandroid.parser

import com.shurikus.boostnoteandroid.entity.NoteEntity

class NoteParser {
    companion object {
        private const val FIELD_CREATE_AT = "createdAt:"
        private const val FIELD_UPDATE_AT = "updatedAt:"
        private const val FIELD_TYPE = "type:"
        private const val FIELD_FOLDER = "folder:"
        private const val FIELD_TITLE = "title:"
        private const val FIELD_IS_STARRED = "isStarred:"
        private const val FIELD_IS_TRASHED = "isTrashed:"

        fun parse(string: String): NoteEntity {
            val createdAt = parseString(string, FIELD_CREATE_AT)
            val updatedAt = parseString(string, FIELD_UPDATE_AT)
            val type = parseString(string, FIELD_TYPE)
            val folder = parseString(string, FIELD_FOLDER)
            val title = parseString(string, FIELD_TITLE)
            val content = Regex("(?:content:.)'''([\\s\\S]*?)'''").find(string)?.groupValues?.getOrNull(1)
            val isStarred = parseBoolean(string, FIELD_IS_STARRED)
            val isTrashed = parseBoolean(string, FIELD_IS_TRASHED)

            return NoteEntity(
                    createdAt = createdAt,
                    updatedAt = updatedAt,
                    type = type,
                    folder = folder,
                    title = title,
                    content = content,
                    isStarred = isStarred,
                    isTrashed = isTrashed
            )
        }

        private fun parseString(string: String, fieldName: String): String? {
            return Regex("(?:$fieldName.)\"([\\s\\S]*?)\"").find(string)?.groupValues?.getOrNull(1)
        }

        private fun parseBoolean(string: String, fieldName: String): Boolean? {
            return Regex("(?:$fieldName).(false|true|)").find(string)?.groupValues?.getOrNull(1)?.toBoolean()
        }
    }
}