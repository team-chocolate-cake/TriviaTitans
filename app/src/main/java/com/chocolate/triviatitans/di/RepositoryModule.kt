package com.chocolate.triviatitans.di

import com.chocolate.triviatitans.data.repository.TriviaTitansRepository
import com.chocolate.triviatitans.data.repository.TriviaTitansRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTriviaRepository(triviaRepositoryImpl: TriviaTitansRepositoryImpl): TriviaTitansRepository

}