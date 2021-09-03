package com.nicatnabiyev88.roomdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nicatnabiyev88.roomdemo.db.RoomAppDb
import com.nicatnabiyev88.roomdemo.db.UserEntity

class MainActivityViewModel(app:Application): AndroidViewModel(app) {
    lateinit var allUsers: MutableLiveData<List<UserEntity>>

    init {
        allUsers = MutableLiveData()
        getAllUsers()
    }

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity>>{
        return allUsers
    }

    fun getAllUsers(){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        val list = userDao?.getAllUserInfo()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.insertUser(entity)
        getAllUsers()
    }

    fun updatetUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.updateUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }
}