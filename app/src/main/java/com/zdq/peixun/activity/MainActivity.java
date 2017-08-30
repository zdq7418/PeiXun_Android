package com.zdq.peixun.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.hss01248.dialog.StyledDialog;
import com.zdq.peixun.R;
import com.zdq.peixun.bean.Peixun;
import com.zdq.peixun.presenter.SearchPresenter;
import com.zdq.peixun.utils.JsonTools;
import com.zdq.peixun.view.SearchView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SearchView,View.OnClickListener {

    private EditText searchkey;
    private Button search;
    private SearchPresenter searchPresenter=new SearchPresenter(this);
    private Dialog styledDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        search= (Button) findViewById(R.id.search);
        searchkey= (EditText) findViewById(R.id.searchkey);
        search.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public String getSearch() {
        return searchkey.getText().toString();
    }

    @Override
    public void toResultActivity(String list) {
        Intent intent=new Intent(this,ResultActivity.class);
        intent.putExtra("data",list);
        startActivity(intent);
    }

    @Override
    public void showFailedError() {
        Snackbar.make(search, "查询失败，请检查网络", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSnackbar(String mes) {
        Snackbar.make(search, mes, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        styledDialog=StyledDialog.buildLoading( "加载中...").setActivity(MainActivity.this).show();
    }

    @Override
    public void closeLoading() {
        styledDialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.search){
            searchPresenter.search();
        }
    }

    @Override
    protected void onRestart() {
        styledDialog.dismiss();
        super.onRestart();
    }
}
