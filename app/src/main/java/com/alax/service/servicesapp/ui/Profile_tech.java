package com.np.onei.servicesapp.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.repositrys.SignupRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

public class Profile_tech extends AppCompatActivity  {

    SignupRepositry SrepObj;
    TextView headertxt;
    ImageView bck;

    EditText nam,addres,pas;
    Button sigup;
    ApplicationController obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_tech);
        obj=(ApplicationController)getApplicationContext();
        sigup = (Button) findViewById(R.id.sigupbtn);
        nam = (EditText) findViewById(R.id.nam);
        addres = (EditText) findViewById(R.id.addres);
        pas = (EditText) findViewById(R.id.pas);
        nam.setText(obj.getTFirstName());
        addres.setText(obj.getTAddress());

        pas.setText(obj.getcPass());

        headertxt = (TextView) findViewById(R.id.headertxt);
        bck = (ImageView) findViewById(R.id.bck);
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
    }
}
