package com.linguapro.android.data.di

import android.content.Context
import androidx.room.Room
import com.linguapro.android.data.local.LessonDao
import com.linguapro.android.data.local.LessonProgressDao
import com.linguapro.android.data.local.LinguaDatabase
import com.linguapro.android.data.local.ReviewCardDao
import com.linguapro.android.data.local.VocabularyDao
import com.linguapro.android.data.repository.LearningRepository
import com.linguapro.android.data.repository.RoomLearningRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindings {
    @Binds
    @Singleton
    abstract fun bindLearningRepository(implementation: RoomLearningRepository): LearningRepository
}

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LinguaDatabase =
        Room.databaseBuilder(context, LinguaDatabase::class.java, "linguapro.db").build()

    @Provides fun provideLessonDao(database: LinguaDatabase): LessonDao = database.lessonDao()
    @Provides fun provideVocabularyDao(database: LinguaDatabase): VocabularyDao = database.vocabularyDao()
    @Provides fun provideReviewCardDao(database: LinguaDatabase): ReviewCardDao = database.reviewCardDao()
    @Provides fun provideLessonProgressDao(database: LinguaDatabase): LessonProgressDao = database.lessonProgressDao()
}
