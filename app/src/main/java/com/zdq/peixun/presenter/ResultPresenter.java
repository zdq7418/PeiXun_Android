package com.zdq.peixun.presenter;

import com.zdq.peixun.bean.Peixun;
import com.zdq.peixun.model.Result;
import com.zdq.peixun.model.ResultListener;
import com.zdq.peixun.model.Search;
import com.zdq.peixun.model.SearchListener;
import com.zdq.peixun.view.ResultView;
import com.zdq.peixun.view.SearchView;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public class ResultPresenter {
    private Result search;
    private ResultView searchView;

    public ResultPresenter(ResultView searchView) {
        this.search = new Result();
        this.searchView = searchView;
    }

    public void search(){
        searchView.showLoading();
        search.search(searchView.getSearch(),searchView.getPage(),searchView.getPageSize(), new ResultListener() {
            @Override
            public void searchSuccess(List<Peixun> list) {
                searchView.setAdapter(list);
                searchView.closeLoading();
            }

            @Override
            public void searchFailed() {
                searchView.showFailedError();
                searchView.closeLoading();
            }

            @Override
            public void showSnackbar(String mes) {
                searchView.showSnackbar(mes);
            }


        });



    }
}
