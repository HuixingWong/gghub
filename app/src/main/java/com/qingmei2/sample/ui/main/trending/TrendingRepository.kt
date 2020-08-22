package com.qingmei2.sample.ui.main.trending

import androidx.paging.DataSource
import com.qingmei2.architecture.core.base.repository.BaseRepositoryBoth
import com.qingmei2.sample.base.Results
import com.qingmei2.sample.entity.TrendingRepo
import com.qingmei2.sample.ui.main.trending.dataSource.LocalDataSource
import com.qingmei2.sample.ui.main.trending.dataSource.RemoteDataSource
import javax.inject.Inject

class TrendingRepository @Inject constructor
(val local: LocalDataSource, val remote: RemoteDataSource):
        BaseRepositoryBoth<RemoteDataSource, LocalDataSource>(remote, local){

    suspend fun fetchTrending(language: String? = null, since: String? = null,
                              spoken: String? = null): Results<List<TrendingRepo>>{
        return remoteDataSource.queryTrendings(language, since, spoken)
    }
    fun  fetchTrendingSourceFactory(): DataSource.Factory<Int, TrendingRepo>{
        return localDataSource.fetchQueryTrendingFactory()
    }

    suspend fun clearAndInsertNewData(items: List<TrendingRepo>){
        localDataSource.clearOldAndInsertNewData(items)
    }

    suspend fun insertNewPageData(items: List<TrendingRepo>){
        localDataSource.insertNewData(items)
    }

}