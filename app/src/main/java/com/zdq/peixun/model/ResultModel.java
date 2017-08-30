package com.zdq.peixun.model;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public interface ResultModel {
    public void search(String searchkey,Integer page,Integer pageSize, ResultListener searchListener);
}
