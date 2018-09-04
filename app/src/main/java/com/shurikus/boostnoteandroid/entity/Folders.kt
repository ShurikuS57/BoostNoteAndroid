package com.shurikus.boostnoteandroid.entity

import com.google.gson.annotations.SerializedName


data class Folders(
        @SerializedName("folders") val folders: List<Folder>?,
        @SerializedName("version") val version: String?
) {

    data class Folder(
            @SerializedName("key") val key: String?,
            @SerializedName("color") val color: String?,
            @SerializedName("name") val name: String?
    )
}