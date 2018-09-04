package com.shurikus.boostnoteandroid.model.data.local

import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shurikus.boostnoteandroid.entity.Folders
import com.shurikus.boostnoteandroid.entity.NoteEntity
import com.shurikus.boostnoteandroid.parser.NoteParser
import io.reactivex.Single
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject

class RawAppData @Inject constructor(
        private val assets: AssetManager,
        private val gson: Gson
) {

    fun getFolders(): Single<Folders> = fromAsset("boostnote/boostnote.json")

    fun getNotes(): Single<MutableList<NoteEntity>> {
        val notes: MutableList<NoteEntity> = ArrayList()
        assets.list("boostnote/notes")?.forEach {
            notes.add(NoteParser.parse(loadData("boostnote/notes/" + it.toString())))
        }
        return Single.just(notes)
    }

    private inline fun <reified T> fromAsset(pathToAsset: String) = Single.defer {
        assets.open(pathToAsset).use { stream ->
            Single.just<T>(gson.fromJson(InputStreamReader(stream), object : TypeToken<T>() {}.type))
        }
    }

    private fun loadData(inFile: String): String {
        var contents = ""

        try {
            val stream = assets.open(inFile)

            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            contents = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return contents

    }
}