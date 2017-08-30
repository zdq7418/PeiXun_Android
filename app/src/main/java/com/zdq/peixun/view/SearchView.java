package com.zdq.peixun.view;

import com.zdq.peixun.bean.Peixun;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public interface SearchView {
    String getSearch();
    void toResultActivity(String keyWord);
    void showFailedError();
    void showSnackbar(String mes);
    void showLoading();
    void closeLoading();
}
