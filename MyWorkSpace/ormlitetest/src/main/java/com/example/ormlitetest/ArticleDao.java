package com.example.ormlitetest;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by romg on 2017/9/6.
 */

public class ArticleDao {

    private Dao<Aticle,Integer> aticleDaopen;
    private OrmDatabaseOpenhelper openhelper;
    private Context context;
    public ArticleDao(Context context){
        this.context = context;
        try {
            openhelper = OrmDatabaseOpenhelper.getOrmHelper(context);
            aticleDaopen = openhelper.getDao(Aticle.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAticle(Aticle aticle){
        try {
            aticleDaopen.create(aticle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *通过id获取一篇Aticle
     * @param id
     * @return
     */
    public Aticle getAticleWithUser(int id){
        Aticle aticle = null;
        try {
            aticle = aticleDaopen.queryForId(id);
            openhelper.getDao(User.class).refresh(aticle.getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aticle;
    }

    /**
     * 通过Id得到一篇文章
     * @param id
     * @return
     */
    public Aticle get(int id)
    {
        Aticle article = null;
        try
        {
            article = aticleDaopen.queryForId(id);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return article;
    }

    /**
     * 通过UserId获取所有的文章
     * @param userId
     * @return
     */
    public List<Aticle> listByUserId(int userId)
    {
        try
        {
            return aticleDaopen.queryBuilder().where().eq("user_id", userId).query();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     */
    public void close(){

    }
}
