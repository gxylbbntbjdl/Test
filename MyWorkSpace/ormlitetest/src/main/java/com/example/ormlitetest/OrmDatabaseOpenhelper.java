package com.example.ormlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by romg on 2017/9/6.
 */
public class OrmDatabaseOpenhelper extends OrmLiteSqliteOpenHelper{

    private static final String TABLE_NAME = "sqlite-test.db";
    private Map<String,Dao> daos = new HashMap<String,Dao>();
    private OrmDatabaseOpenhelper(Context context){
        super(context, TABLE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.clearTable(connectionSource,User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource,User.class,true);
            TableUtils.clearTable(connectionSource,User.class);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

            private static OrmDatabaseOpenhelper ormHelperInstance;
        public static OrmDatabaseOpenhelper getOrmHelper(Context context) {

            if (ormHelperInstance == null) {
                synchronized (OrmDatabaseOpenhelper.class) {
                    if (ormHelperInstance == null) {
                        ormHelperInstance = new OrmDatabaseOpenhelper(context);
                    }
                }
            }
            return ormHelperInstance;
        }

        public synchronized Dao getDao(Class clazz) throws SQLException{
            Dao dao = null;
            String clazzName = clazz.getSimpleName();
            if(daos.containsKey(clazzName)){
                dao = daos.get(clazzName);
            }
            if(dao == null){
                dao = super.getDao(clazz);
                daos.put(clazzName,dao);
            }
            return dao;
        }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        for (String key:daos.keySet()){
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}


























