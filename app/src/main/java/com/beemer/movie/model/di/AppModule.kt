package com.beemer.movie.model.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.beemer.movie.model.dao.BookmarkDao
import com.beemer.movie.model.dao.SearchHistoryDao
import com.beemer.movie.model.database.Database
import com.beemer.movie.model.repository.BookmarkRepository
import com.beemer.movie.model.repository.MovieRepository
import com.beemer.movie.model.repository.SearchHistoryRepository
import com.beemer.movie.model.service.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitService.getRetrofit()

    @Provides
    @Singleton
    fun provideMovieRepository(retrofit: Retrofit): MovieRepository = MovieRepository(retrofit)

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database = Room.databaseBuilder(context, Database::class.java, "database").build()

    @Provides
    @Singleton
    fun provideSearchHistoryDao(database: Database): SearchHistoryDao = database.searchHistoryDao()

    @Provides
    @Singleton
    fun provideBookmarkDao(database: Database): BookmarkDao = database.bookmarkDao()

    @Provides
    @Singleton
    fun provideSearchHistoryRepository(dao: SearchHistoryDao): SearchHistoryRepository = SearchHistoryRepository(dao)

    @Provides
    @Singleton
    fun provideBookmarkRepository(dao: BookmarkDao): BookmarkRepository = BookmarkRepository(dao)
}