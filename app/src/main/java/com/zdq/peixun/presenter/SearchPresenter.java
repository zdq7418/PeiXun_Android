package com.zdq.peixun.presenter;

import com.zdq.peixun.bean.Peixun;
import com.zdq.peixun.model.Search;
import com.zdq.peixun.model.SearchListener;
import com.zdq.peixun.view.SearchView;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public class SearchPresenter {
    private Search search;
    private SearchView searchView;

    public SearchPresenter(SearchView searchView) {
        this.search = new Search();
        this.searchView = searchView;
    }

    public void search(){
        searchView.showLoading();
        search.search(searchView.getSearch(), new SearchListener() {
            @Override
            public void searchSuccess(String list) {
                searchView.closeLoading();
                searchView.toResultActivity(list);

            }

            @Override
            public void searchFailed() {
                searchView.closeLoading();
                searchView.showFailedError();

            }

            @Override
            public void showSnackbar(String mes) {
                searchView.showSnackbar(mes);
            }


        });
    }
}
