package com.zdq.peixun.view;

import com.zdq.peixun.bean.Peixun;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public interface ResultView {
    String getSearch();
    Integer getPage();
    Integer getPageSize();
    void setAdapter(List<Peixun> list);
    void showFailedError();
    void showSnackbar(String mes);
    void showLoading();
    void closeLoading();
}
