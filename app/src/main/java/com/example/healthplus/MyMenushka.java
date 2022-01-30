package com.example.healthplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MyMenushka extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;
    ImageButton myImageButton;

    // Array of images
    int[] covers = new int[]{
            R.drawable.fash4,
            R.drawable.fash3,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_menushka);


        //Toolbar:
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Making the home button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator
                (R.drawable.menuu);

        //  Initializing RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        appList = new ArrayList<>();

        //Adapter
        adapter = new RecyclerViewAdaptery(this, appList);
        manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        // Layout Manager
        recyclerView.setLayoutManager(manager);

        // Adapter
        recyclerView.setAdapter(adapter);

        //Putting Data into recyclerView
        IntializeDataIntoRecyclerView();



    }
    private void IntializeDataIntoRecyclerView() {

        row a = new row(covers[0]);
        appList.add(a);

        a = new row(covers[1]);
        appList.add(a);

       a = new row(covers[2]);
        appList.add(a);

        a = new row(covers[3]);
        appList.add(a);

        a = new row(covers[4]);
        appList.add(a);

        a = new row(covers[5]);
        appList.add(a);
        adapter.notifyDataSetChanged();

    }
    // Handling click on toolbar buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // action bar item clicks here. The action bar will

        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}