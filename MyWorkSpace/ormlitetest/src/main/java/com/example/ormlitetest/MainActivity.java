package com.example.ormlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("morong","student");
        UserDao dao = new UserDao(this);
        dao.addUser(user);
        Aticle aticle = new Aticle();
        aticle.setTitle("ha ha ha");
        aticle.setUser(user);
        ArticleDao articleDao = new ArticleDao(this);
        articleDao.addAticle(aticle);
    }
}
