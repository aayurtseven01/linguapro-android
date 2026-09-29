package com.linguapro.android.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content_packs")
data class ContentPackEntity(
    @PrimaryKey val id: String,
    val schemaVersion: Int,
    val contentVersion: String,
    val installedAtEpochMillis: Long
)
