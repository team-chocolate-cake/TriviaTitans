package com.chocolate.triviatitans.di

import android.content.Context
import androidx.room.Room
import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.data.local.TriviaDao
import com.chocolate.triviatitans.data.local.TriviaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideTriviaDataBase(
        @ApplicationContext appContext: Context,
    ): TriviaDatabase {
        return Room.databaseBuilder(
            appContext, TriviaDatabase::class.java,
            "TriviaDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDefaultPlayerData(): LocalPlayerDataDto {
        return LocalPlayerDataDto(
            id = 1,
            bonus = 0,
            deleteTwoAnswers = 0,
            changeQuestion = 0,
            hearts = 0,
            easyScore = 0,
            mediumScore = 0,
            hardScore = 0
        )
    }


    @Provides
    @Singleton
    fun provideTriviaDao(
        triviaDatabase: TriviaDatabase
    ): TriviaDao {
        return triviaDatabase.triviaDao
    }
}
