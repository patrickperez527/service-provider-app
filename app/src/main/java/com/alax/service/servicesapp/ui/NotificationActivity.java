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
import com.np.onei.servicesapp.adapters.NotificationAdpater;
import com.np.onei.servicesapp.intfc.NotifyListInterface;
import com.np.onei.servicesapp.models.CategoryModel;
import com.np.onei.servicesapp.models.HistoryUserItemsDatum;
import com.np.onei.servicesapp.models.NotificationListItems;
import com.np.onei.servicesapp.repositrys.NotificationListRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity implements NotifyListInterface {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList results;
    private TextView headertxt;
    private ImageView bck;
    NotificationListRepositry NLRObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        NLRObj=new NotificationListRepositry(NotificationActivity.this, RetrofitRequrest.ProgressForDriver(NotificationActivity.this),this);
        headertxt=(TextView)findViewById(R.id.headertxt);
        bck=(ImageView) findViewById(R.id.bck);
        headertxt.setText("Notifications");
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

        NLRObj.getListNotifiaction();
        results = new ArrayList<CategoryModel>();


        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(NotificationActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


    }

    @Override
    public void NotifyListSuccess(List<NotificationListItems> msg) {
        mAdapter = new NotificationAdpater(this,msg);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void RequestProgressShow(ProgressDialog pd) {

    }

    @Override
    public void RequestProgressFinish(ProgressDialog pd) {

    }
}
