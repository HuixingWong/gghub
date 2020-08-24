package com.qingmei2.sample.ui.main.trending.dataSource

import com.qingmei2.architecture.core.base.repository.IRemoteDataSource
import com.qingmei2.sample.base.Results
import com.qingmei2.sample.entity.TrendingRepo
import com.qingmei2.sample.entity.request.TrendingRequestData
import com.qingmei2.sample.http.service.ServiceManager
import com.qingmei2.sample.utils.processApiResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val serviceManager: ServiceManager)
    : IRemoteDataSource{

    suspend fun queryTrendings(trendingRequestData: TrendingRequestData): Results<List<TrendingRepo>> {
        return processApiResponse {
            serviceManager.trendingService.fetchTrendingRepos(trendingRequestData.language,
                    trendingRequestData.since, trendingRequestData.spokenLanguage) }
    }

}