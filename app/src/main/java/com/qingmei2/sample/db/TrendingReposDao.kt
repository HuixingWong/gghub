package com.qingmei2.sample.db

import androidx.paging.DataSource
import androidx.room.*
import com.qingmei2.sample.entity.TrendingRepo

@Dao
interface TrendingReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repos: List<TrendingRepo>)

    @Query("SELECT * FROM trending_repos")
    fun queryRepos(): DataSource.Factory<Int, TrendingRepo>

    @Query("DELETE FROM trending_repos")
    suspend fun deleteAllTrendings()


}