package com.zdq.peixun.model;

import com.zdq.peixun.bean.Peixun;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public interface SearchListener {
    void searchSuccess(String list);

    void searchFailed();

    void showSnackbar(String mes);


}
