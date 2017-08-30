package com.zdq.peixun.model;

import com.zdq.peixun.bean.Peixun;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public interface ResultListener {
    void searchSuccess(List<Peixun> list);

    void searchFailed();

    void showSnackbar(String mes);


}
