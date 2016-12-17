package com.greendaoexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Query<MyObject> myObjectsQuery;
    private TextAdapter adapter;
    List<MyObject> list = new ArrayList<>();
    MyObjectDao myObjectDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TextAdapter();
        recyclerView.setAdapter(adapter);

        saveToDb();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                add();

            }
        });
    }

    public void add() {
        MyObject myObject = new MyObject(list.size() + 1L, Integer.toString(list.size() + 1));
        list.add(myObject);
        adapter.notifyDataSetChanged();
        myObjectDao.insert(myObject);
        updateItems();
    }

    public void saveToDb() {
        // get the note DAO
        DaoSession daoSession = ((App) getApplicationContext()).getDaoSession();
        myObjectDao = daoSession.getMyObjectDao();
        // query all notes, sorted a-z by their text
        myObjectsQuery = myObjectDao.queryBuilder().build();
        updateItems();
    }

    private void updateItems() {
        List<MyObject> notes = myObjectsQuery.list();
        list = notes;
        adapter.setNumbers(notes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
