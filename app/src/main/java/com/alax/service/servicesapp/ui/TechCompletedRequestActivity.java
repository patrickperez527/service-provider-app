package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.adapters.TechAcceptedJobsAdapter;
import com.np.onei.servicesapp.adapters.TechCompletedJobsAdapter;
import com.np.onei.servicesapp.intfc.TechAcceptJobListInterface;
import com.np.onei.servicesapp.models.TechAcceptListItems;
import com.np.onei.servicesapp.repositrys.TechAcceptJobListRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import java.util.List;

public class TechCompletedRequestActivity extends AppCompatActivity implements TechAcceptJobListInterface {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ApplicationController obj;
    TextView headertxt;
    TechAcceptJobListRepositry TPJRObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tech_pending_req);
        obj = (ApplicationController) getApplicationContext();
        TPJRObj=new TechAcceptJobListRepositry(TechCompletedRequestActivity.this,RetrofitRequrest.ProgressForDriver(TechCompletedRequestActivity.this),this);
        headertxt=(TextView) findViewById(R.id.headertxt);
        headertxt.setText("Complete Jobs");
        headertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(TechCompletedRequestActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        TPJRObj.getSericeListNoonPIDCompleted(obj.getTuId());
    }


    @Override
    protected void onResume() {
        super.onResume();
        TPJRObj.getSericeListNoonPID(obj.getTuId());
    }

    @Override
    public void getTechJobPendigSuccess(List<TechAcceptListItems> msg) {
        mAdapter = new TechCompletedJobsAdapter(this,msg);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void SignupFailed(String msg) {
    Toast.makeText(TechCompletedRequestActivity.this,""+msg,Toast.LENGTH_LONG).show();

    }

    @Override
    public void RequestProgressShow(ProgressDialog pd) {

        pd.setMessage("Please wait...");
        pd.show();
    }

    @Override
    public void RequestProgressFinish(ProgressDialog pd) {

        pd.dismiss();
    }
}
