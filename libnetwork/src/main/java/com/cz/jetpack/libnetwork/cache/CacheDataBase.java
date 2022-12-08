package com.cz.jetpack.libnetwork.cache;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

public abstract class CacheDataBase extends RoomDatabase {
    static {
        // 内存数据库
        //Room.inMemoryDatabaseBuilder();
//        Room.databaseBuilder();
    }
}
