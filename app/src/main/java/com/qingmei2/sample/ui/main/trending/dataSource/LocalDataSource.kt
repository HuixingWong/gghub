package com.qingmei2.sample.ui.main.trending.dataSource

import androidx.room.withTransaction
import com.qingmei2.architecture.core.base.repository.ILocalDataSource
import com.qingmei2.sample.db.UserDatabase
import com.qingmei2.sample.entity.TrendingRepo
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val db: UserDatabase) : ILocalDataSource{

    suspend fun fetchQueryTrendingFactory(): List<TrendingRepo>{
        return db.trendingDao().queryRepos()
    }

    suspend fun clearOldAndInsertNewData(newPage: List<TrendingRepo>){
        db.withTransaction {
            db.trendingDao().deleteAllTrendings()
            insertDataInternal(newPage)
        }
    }

    private suspend fun insertDataInternal(newPage: List<TrendingRepo>){
        db.trendingDao().insert(newPage)
    }

}