package com.qingmei2.sample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qingmei2.sample.entity.ReceivedEvent
import com.qingmei2.sample.entity.Repo
import com.qingmei2.sample.entity.TrendingRepo

@Database(
        entities = [ReceivedEvent::class, Repo::class, TrendingRepo::class],
        version = 2
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userReceivedEventDao(): UserReceivedEventDao

    abstract fun userReposDao(): UserReposDao

    abstract fun trendingDao(): TrendingReposDao
}