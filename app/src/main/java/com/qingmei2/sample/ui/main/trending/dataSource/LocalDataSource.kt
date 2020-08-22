package com.qingmei2.sample.ui.main.trending.dataSource

import androidx.paging.DataSource
import androidx.room.withTransaction
import com.qingmei2.architecture.core.base.repository.ILocalDataSource
import com.qingmei2.sample.db.UserDatabase
import com.qingmei2.sample.entity.TrendingRepo

class LocalDataSource constructor(private val db: UserDatabase) : ILocalDataSource{

    fun fetchQueryTrendingFactory(): DataSource.Factory<Int, TrendingRepo>{
        return db.trendingDao().queryRepos()
    }

    suspend fun clearOldAndInsertNewData(newPage: List<TrendingRepo>){
        db.withTransaction {
            db.trendingDao().deleteAllTrendings()
            insertDataInternal(newPage)
        }
    }

    suspend fun insertNewData(newPage: List<TrendingRepo>){
        db.withTransaction {
            insertDataInternal(newPage)
        }
    }

    private suspend fun insertDataInternal(newPage: List<TrendingRepo>){
        db.trendingDao().insert(newPage)
    }

}