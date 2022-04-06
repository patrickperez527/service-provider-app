package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.intfc.EnqryInterface;
import com.np.onei.servicesapp.intfc.ProfessionalAreaInterface;
import com.np.onei.servicesapp.intfc.ServiceDropDownInterface;
import com.np.onei.servicesapp.models.Professional_Item;
import com.np.onei.servicesapp.models.ServiceDropDownItem;
import com.np.onei.servicesapp.repositrys.EnqryRepositry;
import com.np.onei.servicesapp.repositrys.GETProfessionalDropdownRepositry;
import com.np.onei.servicesapp.repositrys.GETBusinessDropdownRepositry;
import com.np.onei.servicesapp.repositrys.GETServiceDropdownRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import java.util.ArrayList;
import java.util.List;

public class EnqryFormActivity extends AppCompatActivity implements ServiceDropDownInterface, EnqryInterface , ProfessionalAreaInterface {

    GETServiceDropdownRepositry SrepObj;
    EditText fname,mob,mail,dtails;
    Button eqrybtn;
    TextView headertxt;
    MaterialSpinner spinner,professionalLs;
    ArrayAdapter adapter;
    ArrayList<String>serviceLs;
    ArrayList<String>serviceLsID;
    ArrayList<String>professionalIDLs;

    ArrayList<String>professionalNameLs;
    String SelectedproferssionalId="";
    String SID="";
    EnqryRepositry ENQRObj;
    GETProfessionalDropdownRepositry PRObj;
    ApplicationController obj;

    ImageView bck;

    LinearLayout bck1,hdrlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enry_form);
        obj=(ApplicationController)getApplicationContext();
        SrepObj=new GETServiceDropdownRepositry(EnqryFormActivity.this, RetrofitRequrest.ProgressForDriver(EnqryFormActivity.this),this);
        ENQRObj=new EnqryRepositry(EnqryFormActivity.this, RetrofitRequrest.ProgressForDriver(EnqryFormActivity.this),this);
        PRObj=new GETProfessionalDropdownRepositry(EnqryFormActivity.this, RetrofitRequrest.ProgressForDriver(EnqryFormActivity.this),this);

        bck=(ImageView)findViewById(R.id.bck);
        bck1=(LinearLayout) findViewById(R.id.bck1);
        hdrlay=(LinearLayout) findViewById(R.id.hdrlay);
        eqrybtn=(Button)findViewById(R.id.eqrybtn);
        fname=(EditText)findViewById(R.id.fname);
        mail=(EditText)findViewById(R.id.mail);
        mob=(EditText)findViewById(R.id.mob);
        dtails=(EditText)findViewById(R.id.dtails);
        headertxt=(TextView) findViewById(R.id.headertxtnew);
        bck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Toast.makeText(EnqryFormActivity.this,"Hi",Toast.LENGTH_LONG).show();
            }
        });
        headertxt.setText("Enquiry Form");

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Toast.makeText(EnqryFormActivity.this,"Hello",Toast.LENGTH_LONG).show();
            }
        });

        fname.setText(obj.getcFirstName()+" "+obj.getcLastName());
        mail.setText(obj.getcMail());
        mob.setText(obj.getcPhone());
        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        professionalLs = (MaterialSpinner) findViewById(R.id.professionalLs);

        PRObj.getProfessionalList();

        eqrybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ENQRObj.getEnqry(SelectedproferssionalId,SID,"0",obj.getuId(),dtails.getText().toString(),"1",fname.getText().toString(),mail.getText().toString(),mob.getText().toString());
            }
        });
        professionalLs.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                SelectedproferssionalId= professionalIDLs.get(position);
                SrepObj.getSericeList(SelectedproferssionalId);
            }
        });

        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                SID= serviceLsID.get(position);
               // SelectedproferssionalId= professionalIDLs.get(position);
            }
        });
    }



    @Override
    public void Success(List<ServiceDropDownItem> sObj) {
        serviceLsID= new ArrayList<>();
        serviceLs= new ArrayList<>();

        for(int i=0;i<sObj.size();i++) {
            serviceLs.add(sObj.get(i).getSName());
            serviceLsID.add(sObj.get(i).getSId());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, serviceLs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

    @Override
    public void Failed(String msg) {

    }

    @Override
    public void SingupSuccess(String msg) {
Toast.makeText(EnqryFormActivity.this,""+msg,Toast.LENGTH_LONG).show();
finish();
    }

    @Override
    public void SignupFailed(String msg) {
        Toast.makeText(EnqryFormActivity.this,""+msg,Toast.LENGTH_LONG).show();
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
    public void ProfessionalAreaList(List<Professional_Item> sObj) {

        professionalNameLs= new ArrayList<>();
        professionalIDLs= new ArrayList<>();
        for(int i=0;i<sObj.size();i++) {
            professionalNameLs.add(sObj.get(i).getProName());
            professionalIDLs.add(sObj.get(i).getProId());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, professionalNameLs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        professionalLs.setAdapter(adapter);
    }
}
