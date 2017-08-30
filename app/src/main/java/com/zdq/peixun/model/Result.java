package com.zdq.peixun.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zdq.peixun.bean.Peixun;
import com.zdq.peixun.utils.UrlSource;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by ThundeRobot on 2017/7/9.
 */

public class Result implements ResultModel {

    @Override
    public void search(String searchkey, Integer page, Integer pageSize, final ResultListener searchListener) {
        OkHttpUtils
                .post()
                .url(UrlSource.SERVICENAME+UrlSource.FINDALL)
                .addParams("searchkey", searchkey)
                .addParams("page",page.toString())
                .addParams("pagesize", pageSize.toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        searchListener.searchFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson=new Gson();
                        List<Peixun> list=gson.fromJson(response,new TypeToken<List<Peixun>>(){}.getType());
                        searchListener.searchSuccess(list);
                    }
                });
    }
}
