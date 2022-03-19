package com.example.anproject3.database

import android.content.Context
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.anproject3.model.*
import io.reactivex.Completable
import io.reactivex.Single

@Database(entities = [Classic::class, Pop::class, Rock::class], version = 1)
abstract class ClassicDatabase : RoomDatabase() {
    abstract fun musicDAO(): MusicDAO

    companion object {
        private var newMusicDB: ClassicDatabase? = null

        fun getDB(context: Context): ClassicDatabase {
            return newMusicDB ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClassicDatabase::class.java,
                    "classicDatabase")
                    .build()
                newMusicDB = instance
                instance
            }
        }
    }
}

interface MusicDAO {
    @Insert(onConflict = REPLACE)
    fun insertClassic(): Completable

    @Insert(onConflict = REPLACE)
    fun insertAllClassic(): Completable

    @Query("SELECT * FROM Classic ORDER BY collectionName")
    fun getClassicByName(): Single<Classic>

    @Query("SELECT * FROM Classic")
    fun getAllClassic(): Single<Classic>

    @Delete
    fun deleteClassic(): Completable
}