package com.example.ormlitetest;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by romg on 2017/9/6.
 */

public class UserDao {

    private Context context;
    private Dao<User,Integer> userDaoOpen;
    private OrmDatabaseOpenhelper helper;
    public UserDao(Context context){
        this.context = context;
        try {
            helper = OrmDatabaseOpenhelper.getOrmHelper(context);
            userDaoOpen = helper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户
     */

    public void addUser(User user){
        try {
            userDaoOpen.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
