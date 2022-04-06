package com.np.onei.servicesapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.np.onei.servicesapp.intfc.PendingJobCompleteInterface;
import com.np.onei.servicesapp.repositrys.PendingJobCompleteRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.servicesapp.ui.ContactUsActivity;
import com.np.onei.servicesapp.ui.LoginActivity;
import com.np.onei.servicesapp.ui.Profile_tech;
import com.np.onei.servicesapp.ui.SignupActivity;
import com.np.onei.servicesapp.ui.TechAcceptRequestActivity;
import com.np.onei.servicesapp.ui.TechCompletedRequestActivity;
import com.np.onei.servicesapp.ui.TechPendingRequestActivity;
import com.np.onei.utils.ApplicationController;

public class TechMainActivity extends AppCompatActivity implements PendingJobCompleteInterface {


    LinearLayout techjobListpending,completebtn,anlysisServicebtn,conatc;
    PendingJobCompleteRepositry PCRObj;
    ApplicationController obj;
    TextView cmpjob,penjob,techprofilebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tech_home_activity);
        obj=(ApplicationController)getApplicationContext();
        cmpjob=(TextView)findViewById(R.id.cmpjob);
        penjob=(TextView)findViewById(R.id.penjob);
        techprofilebtn=(TextView)findViewById(R.id.techprofilebtn);
        PCRObj=new PendingJobCompleteRepositry(TechMainActivity.this, RetrofitRequrest.ProgressForDriver(TechMainActivity.this),this);
        PCRObj.getCompletePendingJobs(obj.getTuId());
        techjobListpending=(LinearLayout)findViewById(R.id.techjobListpending);
        anlysisServicebtn=(LinearLayout)findViewById(R.id.anlysisServicebtn);
        conatc=(LinearLayout)findViewById(R.id.conatc);
        completebtn=(LinearLayout)findViewById(R.id.completebtn);
        conatc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechMainActivity.this,ContactUsActivity.class));
            }
        });
        completebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechMainActivity.this, TechCompletedRequestActivity.class));

            }
        });
        techprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechMainActivity.this, Profile_tech.class));

            }
        });
        techjobListpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechMainActivity.this, TechPendingRequestActivity.class));

            }
        });
        anlysisServicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechMainActivity.this, TechAcceptRequestActivity.class));

            }
        });
    }

    @Override
    public void PendingJobSuccess(String msg) {
        penjob.setText("Pending Job: "+msg);
    }

    @Override
    public void CompleteJobSuccess(String msg) {

        cmpjob.setText("Complete Job: "+msg);
    }

    @Override
    public void RequestForPayment(String amount) {

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