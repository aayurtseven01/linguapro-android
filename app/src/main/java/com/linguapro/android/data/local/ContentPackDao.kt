package com.linguapro.android.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContentPackDao {
    @Query("SELECT contentVersion FROM content_packs WHERE id = :id LIMIT 1")
    suspend fun installedVersion(id: String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun recordInstalledPack(pack: ContentPackEntity)
}
