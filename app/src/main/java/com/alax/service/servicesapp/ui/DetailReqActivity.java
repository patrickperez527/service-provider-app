package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.adapters.HistoryAdapter;
import com.np.onei.servicesapp.intfc.AcceptReqInterface;
import com.np.onei.servicesapp.models.CategoryModel;
import com.np.onei.servicesapp.repositrys.TechAcceptReqRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import java.util.ArrayList;

public class DetailReqActivity extends AppCompatActivity implements AcceptReqInterface {

    ApplicationController obj;
    Button acceptBtn;
    TechAcceptReqRepositry TARObj;
    TextView cname,odrId,wrks,pro_area_name,servicename,cadres,cmob,headertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_req_details);
        TARObj=new TechAcceptReqRepositry(DetailReqActivity.this, RetrofitRequrest.ProgressForDriver(DetailReqActivity.this),this);
        acceptBtn=(Button)findViewById(R.id.acceptBtn);

        obj=(ApplicationController)getApplicationContext();
        headertxt=(TextView) findViewById(R.id.headertxt);
        headertxt.setText("Request Details");
        headertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TARObj.acceptReq(obj.getReqId(),obj.getTuId());
            }
        });
        cname = (TextView) findViewById(R.id.cname);
        odrId = (TextView) findViewById(R.id.odrId);
        wrks = (TextView) findViewById(R.id.wrks);
        pro_area_name = (TextView) findViewById(R.id.pro_area_name);
        servicename = (TextView) findViewById(R.id.servicename);
        cadres = (TextView) findViewById(R.id.cadres);
        cmob = (TextView) findViewById(R.id.cmob);

        cname.setText(obj.getCustomerName());
        odrId.setText(obj.getReqId());
        wrks.setText(obj.getWorkingDetails());
        pro_area_name.setText(obj.getProfessionalArea());
        servicename.setText(obj.getServiceName());
        cadres.setText(obj.getCustomerAddress());
        cmob.setText(obj.getCustomerMob());

    }

    @Override
    public void AcceptReqSuccess(String msg) {
        Toast.makeText(DetailReqActivity.this,""+msg,Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void AcceptReqFailed(String msg) {
        Toast.makeText(DetailReqActivity.this,""+msg,Toast.LENGTH_LONG).show();
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
