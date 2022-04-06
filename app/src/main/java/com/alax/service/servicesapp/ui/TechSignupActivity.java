package com.np.onei.servicesapp.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.TechMainActivity;
import com.np.onei.servicesapp.intfc.BusinessInterface;
import com.np.onei.servicesapp.intfc.ProfessionalAreaInterface;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.models.BusinessItems;
import com.np.onei.servicesapp.models.Professional_Item;
import com.np.onei.servicesapp.repositrys.GETBusinessDropdownRepositry;
import com.np.onei.servicesapp.repositrys.GETProfessionalDropdownRepositry;
import com.np.onei.servicesapp.repositrys.SignupRepositry;
import com.np.onei.servicesapp.repositrys.TLoginRepositry;
import com.np.onei.servicesapp.repositrys.TechnicianSignupRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;

import java.util.ArrayList;
import java.util.List;

public class TechSignupActivity extends AppCompatActivity implements ProfessionalAreaInterface, BusinessInterface, SignupInterface {

    ArrayList<String> serviceLsIDPRO;
    ArrayList<String>serviceLsNamePRO;
    String SelectedSIdPRO;
    ArrayList<String> serviceLsIDBus;
    ArrayList<String>serviceLsNameBus;
    String SelectedSIdBus;
    Button sigup;
    MaterialSpinner professionalLs,BusinessList;
    GETProfessionalDropdownRepositry PRObj;
    GETBusinessDropdownRepositry BRObj;
    TechnicianSignupRepositry TSRObj;
    EditText fname,lname,mob,adrs,mail,pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tech_signup);

        sigup=(Button)findViewById(R.id.sigup);

        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        mob=(EditText)findViewById(R.id.mob);
        adrs=(EditText)findViewById(R.id.adrs);
        mail=(EditText)findViewById(R.id.mail);
        pas=(EditText)findViewById(R.id.pas);

        professionalLs = (MaterialSpinner) findViewById(R.id.professionalLs);
        BusinessList = (MaterialSpinner) findViewById(R.id.BusinessList);
        PRObj=new GETProfessionalDropdownRepositry(TechSignupActivity.this, RetrofitRequrest.ProgressForDriver(TechSignupActivity.this),this);
        BRObj=new GETBusinessDropdownRepositry(TechSignupActivity.this, RetrofitRequrest.ProgressForDriver(TechSignupActivity.this),this);
        TSRObj=new TechnicianSignupRepositry(TechSignupActivity.this, RetrofitRequrest.ProgressForDriver(TechSignupActivity.this),this);
        PRObj.getProfessionalList();

        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TSRObj.TechinvokedSignup(SelectedSIdBus,SelectedSIdPRO,fname.getText().toString(),lname.getText().toString(),mob.getText().toString()
                        ,adrs.getText().toString(),mail.getText().toString(),pas.getText().toString());

            }
        });
        professionalLs.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                SelectedSIdPRO= serviceLsIDPRO.get(position);

            }
        });
        BusinessList.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                SelectedSIdBus= serviceLsIDBus.get(position);

            }
        });
    }

    @Override
    public void ProfessionalAreaList(List<Professional_Item> sObj) {

        serviceLsNamePRO= new ArrayList<>();
        serviceLsIDPRO= new ArrayList<>();
        for(int i=0;i<sObj.size();i++) {
            serviceLsNamePRO.add(sObj.get(i).getProName());
            serviceLsIDPRO.add(sObj.get(i).getProId());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, serviceLsNamePRO);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        professionalLs.setAdapter(adapter);
        BRObj.getSericeListNoonPID();
    }

    @Override
    public void BusinessNameList(List<BusinessItems> sObj) {


        serviceLsNameBus= new ArrayList<>();
        serviceLsIDBus= new ArrayList<>();
        for(int i=0;i<sObj.size();i++) {
            serviceLsNameBus.add(sObj.get(i).getBName());
            serviceLsIDBus.add(sObj.get(i).getBId());


        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, serviceLsNameBus);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        BusinessList.setAdapter(adapter);
    }

    @Override
    public void SingupSuccess(String msg) {
        final Dialog dialog = new Dialog(TechSignupActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.successmsg_getusername);
        Button ok=(Button)dialog.findViewById(R.id.logn);
        TextView usname=(TextView)dialog.findViewById(R.id.usname);
        usname.setText("Your UserName: "+msg);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TechSignupActivity.this, TechLoginActivity.class));
                finish();
                dialog.dismiss();
            }
        });
        dialog.show();
        Toast.makeText(TechSignupActivity.this,""+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void SignupFailed(String msg) {
        Toast.makeText(TechSignupActivity.this,""+msg,Toast.LENGTH_LONG).show();
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
