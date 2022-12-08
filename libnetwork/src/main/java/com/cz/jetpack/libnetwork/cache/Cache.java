package com.cz.jetpack.libnetwork.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "cache")
public class Cache implements Serializable {
    //表里的映射字段名称，不指定和java字段明相同
//    @ColumnInfo(name = "key")
    @PrimaryKey
    @NonNull
    public String key;

    public byte[] data;
}
