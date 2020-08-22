package com.qingmei2.sample.ui.main.trending.dataSource

import com.qingmei2.architecture.core.base.repository.IRemoteDataSource
import com.qingmei2.sample.base.Results
import com.qingmei2.sample.entity.TrendingRepo
import com.qingmei2.sample.http.service.ServiceManager
import com.qingmei2.sample.utils.processApiResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val serviceManager: ServiceManager)
    : IRemoteDataSource{

    suspend fun queryTrendings(language: String? = null, since: String? = null,
                               spoken: String? = null): Results<List<TrendingRepo>> {
        return processApiResponse {
            serviceManager.trendingService.fetchTrendingRepos(language, since, spoken) }
    }

}