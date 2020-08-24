package com.qingmei2.sample.ui.main.trending

import com.qingmei2.architecture.core.base.repository.BaseRepositoryBoth
import com.qingmei2.sample.base.Results
import com.qingmei2.sample.entity.TrendingRepo
import com.qingmei2.sample.entity.request.TrendingRequestData
import com.qingmei2.sample.ui.main.trending.dataSource.LocalDataSource
import com.qingmei2.sample.ui.main.trending.dataSource.RemoteDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingRepository @Inject constructor
(local: LocalDataSource, remote: RemoteDataSource):
        BaseRepositoryBoth<RemoteDataSource, LocalDataSource>(remote, local){

    fun fetchTrending(trendingRequestData: TrendingRequestData) = flow {
        val trendings = remoteDataSource.queryTrendings(trendingRequestData)
        if (trendings is Results.Success){
            emit(trendings.data)
            clearAndInsertNewData(trendings.data)
        }else{
            fetchLocalTrending()?.let {
                emit(it)
            }
        }
    }

    suspend fun  fetchLocalTrending(): List<TrendingRepo>{
        return localDataSource.fetchQueryTrendingFactory()
    }

    suspend fun clearAndInsertNewData(items: List<TrendingRepo>){
        localDataSource.clearOldAndInsertNewData(items)
    }

}