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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.intfc.FeedBackInterface;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.repositrys.FeedBackRepositry;
import com.np.onei.servicesapp.repositrys.SignupRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

public class SatisfyActivity extends AppCompatActivity implements FeedBackInterface {

        TextView headertxt;
        Button skip,sigupbtn;
        FeedBackRepositry FDBKREP;
         RadioGroup radioGroup,radiogroup2;
         RadioButton radioButton,radioButton2;
         ApplicationController obj;
         EditText msgBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.satisfy_user);
        FDBKREP=new FeedBackRepositry(SatisfyActivity.this,RetrofitRequrest.ProgressForDriver(SatisfyActivity.this),this);
        obj=(ApplicationController)getApplicationContext();
        headertxt=(TextView)findViewById(R.id.headertxt);
        headertxt.setText("Customer Satisfaction");
        sigupbtn=(Button)findViewById(R.id.sigupbtn);
        skip=(Button)findViewById(R.id.skip);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radiogroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        msgBox=(EditText)findViewById(R.id.msg);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SatisfyActivity.this,"Thank you for Using 24-7 Workman",Toast.LENGTH_LONG).show();

                startActivity(new Intent(SatisfyActivity.this,MainActivity.class));
                finish();
            }
        });
        sigupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                int selectedId2 = radiogroup2.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectedId);
                radioButton2 = (RadioButton) findViewById(selectedId2);
                String radiotxt=radioButton.getText().toString();
                String radiotxt2=radioButton2.getText().toString();
                FDBKREP.FeedBackSubmit(obj.getReqId(),radiotxt,radiotxt2,msgBox.getText().toString());


            }
        });

    }

    @Override
    public void success(String msg) {
        Toast.makeText(SatisfyActivity.this,""+msg,Toast.LENGTH_LONG).show();
        startActivity(new Intent(SatisfyActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void failed(String msg) {

    }
}