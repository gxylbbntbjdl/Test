package com.example.myapp2;

/**
 * Created by romg on 2017/9/1.
 */

public class MyFangXing<T> {

    private T t;
    public MyFangXing(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }

    public String showType(){
        System.out.println("T的实际类型是：  "+ t.getClass().getName());
        return t.getClass().getName();
    }
}
