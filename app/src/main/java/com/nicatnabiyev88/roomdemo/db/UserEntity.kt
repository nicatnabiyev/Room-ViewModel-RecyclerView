package com.nicatnabiyev88.roomdemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo")
data class UserEntity(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "name")
    val name:String,

    @ColumnInfo(name = "email")
    val email:String
)