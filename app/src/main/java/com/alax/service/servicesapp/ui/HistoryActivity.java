package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.adapters.HistoryAdapter;
import com.np.onei.servicesapp.adapters.HistoryListAdapter;
import com.np.onei.servicesapp.intfc.HistoryListInterface;
import com.np.onei.servicesapp.models.CategoryModel;
import com.np.onei.servicesapp.models.HistoryUserItemsDatum;
import com.np.onei.servicesapp.repositrys.HistoryUserRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements HistoryListInterface {

    private TextView headertxt;
    private ImageView bck;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List results;
    HistoryUserRepositry HURObj;
    ApplicationController obj;
    private ImageView filterableclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        obj=(ApplicationController)getApplicationContext();
        HURObj=new HistoryUserRepositry(HistoryActivity.this, RetrofitRequrest.ProgressForDriver(HistoryActivity.this),this);
        headertxt=(TextView)findViewById(R.id.headertxt);
        bck=(ImageView) findViewById(R.id.bck);
        headertxt.setText("History List");
        headertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        HURObj.Histry(obj.getuId());


        filterableclick=(ImageView)findViewById(R.id.filterableclick);
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(HistoryActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);



    }

    @Override
    public void HistoryListSuccess(List<HistoryUserItemsDatum> msg) {
        List<HistoryUserItemsDatum> noRepeat = new ArrayList<HistoryUserItemsDatum>();
        for (HistoryUserItemsDatum event : msg) {
            boolean isFound = false;
            // check if the event name exists in noRepeat
            for (HistoryUserItemsDatum e : noRepeat) {
                if (e.getEId().equals(event.getEId()) || (e.equals(event))) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) noRepeat.add(event);
        }
        mAdapter = new HistoryListAdapter(this,noRepeat);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void RequestProgressShow(ProgressDialog pd) {

    }

    @Override
    public void RequestProgressFinish(ProgressDialog pd) {

    }
}
