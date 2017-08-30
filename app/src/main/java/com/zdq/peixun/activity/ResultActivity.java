package com.zdq.peixun.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zdq.peixun.R;
import com.zdq.peixun.bean.Peixun;
import com.zdq.peixun.model.Result;
import com.zdq.peixun.presenter.ResultPresenter;
import com.zdq.peixun.presenter.SearchPresenter;
import com.zdq.peixun.view.ResultView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements ResultView {
    private Toolbar toolbar;
    String data="";
    private LRecyclerView recyclerView;
    private CommonAdapter<Peixun> commonAdapter;
    private ResultPresenter searchPresenter=new ResultPresenter(this);
    private List<Peixun> peixunList=new ArrayList<>();
    private int page=1;
    private int pagesize=20;
    private Gson gson=new Gson();
    private  LRecyclerViewAdapter mLRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        toolbar = (Toolbar) findViewById(R.id.mydata_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        if (intent!=null){
            data=intent.getStringExtra("data");
        }
        recyclerView= (LRecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview

       searchPresenter.search();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getSearch() {
        return data;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getPageSize() {
        return pagesize;
    }

    @Override
    public void setAdapter(List<Peixun> list) {
        if (peixunList==null||peixunList.size()==0){
            peixunList=list;
            commonAdapter=new CommonAdapter<Peixun>(this,R.layout.base_item,peixunList) {
                @Override
                protected void convert(ViewHolder holder, Peixun peixun, int position) {
                    holder.setText(R.id.baseText, peixun.getName());
                }
            };
            mLRecyclerViewAdapter = new LRecyclerViewAdapter(commonAdapter);
            recyclerView.setAdapter(mLRecyclerViewAdapter);
        }else{
            if (list!=null){
                for (Peixun p:list){
                    peixunList.add(p);
                }
            }else{
                recyclerView.setNoMore(true);
            }

        }

        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                page=page+1;
                searchPresenter.search();
            }
        });
        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                peixunList=new ArrayList<Peixun>();
                page=1;
                searchPresenter.search();
            }
        });
        commonAdapter.notifyDataSetChanged();
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }


    @Override
    public void showFailedError() {
        Snackbar.make(recyclerView, "查询失败，请检查网络", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSnackbar(String mes) {
        Snackbar.make(recyclerView, mes, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }
}
