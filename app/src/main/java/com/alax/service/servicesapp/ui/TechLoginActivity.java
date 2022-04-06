package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.TechMainActivity;
import com.np.onei.servicesapp.intfc.ForgotPassCallBack;
import com.np.onei.servicesapp.intfc.ForgotPassResultCallBack;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.intfc.TLoginInterface;
import com.np.onei.servicesapp.models.TLoginResponse;
import com.np.onei.servicesapp.repositrys.PasswordFogotRepositry;
import com.np.onei.servicesapp.repositrys.TLoginRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import java.util.List;

public class TechLoginActivity extends AppCompatActivity implements TLoginInterface , ForgotPassCallBack, ForgotPassResultCallBack, SignupInterface {

    Button logn;
    TextView reg,loginasservice,pasfotgot;
    TLoginRepositry TLObj;
    EditText uid,pas;
    ApplicationController obj;
    ForgotPassCallBack fgotPass;
    ForgotPassResultCallBack fgtresult;
    PasswordFogotRepositry pfrObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.techlogin);
        obj=(ApplicationController)getApplicationContext();
        fgtresult=this;
        fgotPass=this;
        pfrObject=new PasswordFogotRepositry(TechLoginActivity.this, RetrofitRequrest.ProgressForDriver(TechLoginActivity.this),this);
        TLObj=new TLoginRepositry(TechLoginActivity.this, RetrofitRequrest.ProgressForDriver(TechLoginActivity.this),this);
        reg=(TextView)findViewById(R.id.reg);
        pasfotgot=(TextView)findViewById(R.id.pasfotgot);
        uid=(EditText) findViewById(R.id.uid);
        pas=(EditText) findViewById(R.id.pas);
        loginasservice=(TextView)findViewById(R.id.loginasservice);
        logn=(Button)findViewById(R.id.logn);
        logn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TLObj.CloginInvok(uid.getText().toString(),pas.getText().toString());
//                startActivity(new Intent(TechLoginActivity.this, TechMainActivity.class));
//                finish();
            }
        });
        pasfotgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fgotPass.PasswordReturn(TechLoginActivity.this,fgtresult);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechLoginActivity.this, TechSignupActivity.class));

            }
        });

        loginasservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TechLoginActivity.this, LoginActivity.class));

            }
        });
    }

    @Override
    public void SingupSuccess(List<TLoginResponse> msg) {
        obj.setTloginObject(msg);
        obj.setTuId(msg.get(0).getTId());
        obj.setTFirstName(msg.get(0).getTechName());
        obj.setTLastName(msg.get(0).getLastName());
        obj.setTPhone(msg.get(0).getTPhone());
        obj.setTMail(msg.get(0).getTEmail());
        obj.setTAddress(msg.get(0).getTAddress());
        obj.setTpass(msg.get(0).getTpass());
        startActivity(new Intent(TechLoginActivity.this, TechMainActivity.class));
        finish();
    }

    @Override
    public void SingupSuccess(String msg) {

    }

    @Override
    public void SignupFailed(String msg) {

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
    public void forgotPasswordSuccess(String msg) {
        pfrObject.invokedForgotCall(msg,"T");
    }

    @Override
    public void forgotPasswordError(String msg) {

    }
}
