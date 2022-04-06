package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.repositrys.CustProfileRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

public class ProfileActivity extends AppCompatActivity implements SignupInterface {

    CustProfileRepositry CPR;
    Button updatebtn;
    private TextView headertxt;
    private ImageView bck;
    EditText nam,addres,pas;
    ApplicationController obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        obj=(ApplicationController)getApplicationContext();
        CPR=new CustProfileRepositry(ProfileActivity.this, RetrofitRequrest.ProgressForDriver(ProfileActivity.this),this);
        updatebtn=(Button)findViewById(R.id.updatebtn);
        nam = (EditText) findViewById(R.id.nam);
        addres = (EditText) findViewById(R.id.addres);
        pas = (EditText) findViewById(R.id.pas);
        nam.setText(obj.getcFirstName());
        addres.setText(obj.getcAddress());
        headertxt=(TextView)findViewById(R.id.headertxt);
        pas.setText(obj.getcPass());
        bck=(ImageView) findViewById(R.id.bck);
        headertxt.setText("Profile");
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
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CPR.updateProfile(obj.getuId(),nam.getText().toString(),addres.getText().toString(),pas.getText().toString());
            }
        });
    }

    @Override
    public void SingupSuccess(String msg) {
        obj.setcFirstName(nam.getText().toString());
        obj.setcAddress(addres.getText().toString());
        obj.setcPass(pas.getText().toString());
        Toast.makeText(ProfileActivity.this,""+msg,Toast.LENGTH_LONG).show();
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void SignupFailed(String msg) {
        Toast.makeText(ProfileActivity.this,""+msg,Toast.LENGTH_LONG).show();
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
