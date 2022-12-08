package com.cz.jetpack.libnetwork.cache;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.cz.jetpack.libcommon.AppGlobals;

//exportSchema 生成数据库描述文件到项目目录下，设置true后需配置javaCompileOptions
@Database(entities = {Cache.class},version = 1,exportSchema = true)
public abstract class CacheDataBase extends RoomDatabase {
    static CacheDataBase database = null;
    static {
        // 内存数据库
        //Room.inMemoryDatabaseBuilder();
        database = Room.databaseBuilder(AppGlobals.getApplication(), CacheDataBase.class, "my_cache")
                // 是否允许在主线程查询
                .allowMainThreadQueries()
                // 设置数据库被创建和打开时的回调
                //.addCallback()
                //sql 日志模式
                //.setJournalMode()
                //数据库升级异常，回滚
                .fallbackToDestructiveMigration()
                //数据库升级异常后 根据指定版本回滚
                //.fallbackToDestructiveMigrationFrom()
                // 数据库版本升级时指定
                //.addMigrations()
                .addMigrations()
                .build();
    }

    public abstract CacheDao getCache();

    public static CacheDataBase get() {
        return null;
    }
}
