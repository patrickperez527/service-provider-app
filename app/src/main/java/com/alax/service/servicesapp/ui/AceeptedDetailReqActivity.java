package com.np.onei.servicesapp.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.adapters.FaultListAdapter;
import com.np.onei.servicesapp.adapters.TechPendingJobsAdapter;
import com.np.onei.servicesapp.intfc.AcceptReqInterface;
import com.np.onei.servicesapp.intfc.AddFaultInterface;
import com.np.onei.servicesapp.intfc.FaultAnalysisItemRemove;
import com.np.onei.servicesapp.intfc.FaultListInterface;
import com.np.onei.servicesapp.intfc.SubmitFaultAnalysisInterface;
import com.np.onei.servicesapp.models.FaultListItems;
import com.np.onei.servicesapp.repositrys.AddFaultRepositry;
import com.np.onei.servicesapp.repositrys.FaultListRepositry;
import com.np.onei.servicesapp.repositrys.RemoveFaultListRepositry;
import com.np.onei.servicesapp.repositrys.TechAcceptReqRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import java.util.List;

public class AceeptedDetailReqActivity extends AppCompatActivity implements AcceptReqInterface , SubmitFaultAnalysisInterface , AddFaultInterface , FaultListInterface , FaultAnalysisItemRemove {

    ApplicationController obj;
    TextView acceptBtn,cncel;
    TechAcceptReqRepositry TARObj;
    AddFaultRepositry AFRobj;
    SubmitFaultAnalysisInterface SFI;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FaultListRepositry FLRObj;
    RemoveFaultListRepositry RFRObj;
    TextView cname,odrId,wrks,pro_area_name,servicename,cadres,cmob,headertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accept_req_details_fault_analysis);
        SFI=this;

        AFRobj=new AddFaultRepositry(AceeptedDetailReqActivity.this, RetrofitRequrest.ProgressForDriver(AceeptedDetailReqActivity.this),this);
        TARObj=new TechAcceptReqRepositry(AceeptedDetailReqActivity.this, RetrofitRequrest.ProgressForDriver(AceeptedDetailReqActivity.this),this);
        FLRObj=new FaultListRepositry(AceeptedDetailReqActivity.this, RetrofitRequrest.ProgressForDriver(AceeptedDetailReqActivity.this),this);
        RFRObj=new RemoveFaultListRepositry(AceeptedDetailReqActivity.this, RetrofitRequrest.ProgressForDriver(AceeptedDetailReqActivity.this),this);
        acceptBtn=(TextView)findViewById(R.id.acceptBtn);
        mRecyclerView = (RecyclerView)findViewById(R.id.faultlist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(AceeptedDetailReqActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        obj=(ApplicationController)getApplicationContext();
        headertxt=(TextView) findViewById(R.id.headertxt);
        headertxt.setText("Accepted Details");
        headertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TARObj.acceptReq(obj.getReqId(),obj.getTuId());

                final Dialog dialog = new Dialog(AceeptedDetailReqActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.fault_popup);
                TextView ok=(TextView)dialog.findViewById(R.id.submit);
                LinearLayout close=(LinearLayout)dialog.findViewById(R.id.close);
                EditText txtDetail=(EditText) dialog.findViewById(R.id.faulttxt);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AFRobj.addfault(obj.getReqId(),obj.getcId(),obj.getTuId(),txtDetail.getText().toString().trim());
                        SFI.getFaultAnalysisList();
                        txtDetail.setText("");
                       // dialog.dismiss();
                    }
                });



                dialog.show();
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
        FLRObj.getListFaults(obj.getReqId(),obj.getcId(),obj.getTuId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        FLRObj.getListFaults(obj.getReqId(),obj.getcId(),obj.getTuId());

    }

    @Override
    public void AcceptReqSuccess(String msg) {
        Toast.makeText(AceeptedDetailReqActivity.this,""+msg,Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void AcceptReqFailed(String msg) {
        Toast.makeText(AceeptedDetailReqActivity.this,""+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void AddFaultSuccess(String msg) {
        Toast.makeText(AceeptedDetailReqActivity.this,""+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void AddFaultFailed(String msg) {
        Toast.makeText(AceeptedDetailReqActivity.this,""+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void faultListSuccess(List<FaultListItems> msg) {
        mAdapter = new FaultListAdapter(this,msg,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void faultListFailed(String msg) {

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

    @Override
    public void getFaultAnalysisList() {
        FLRObj.getListFaults(obj.getReqId(),obj.getcId(),obj.getTuId());
        Toast.makeText(AceeptedDetailReqActivity.this,"Show Fault Analysis Data",Toast.LENGTH_LONG).show();
    }

    @Override
    public void removeFaultItems(String fId) {
        RFRObj.getRemoveItem(obj.getReqId(),obj.getcId(),obj.getTuId(),fId);
        FLRObj.getListFaults(obj.getReqId(),obj.getcId(),obj.getTuId());
    }
}
