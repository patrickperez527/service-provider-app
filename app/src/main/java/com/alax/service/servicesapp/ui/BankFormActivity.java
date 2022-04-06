package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.np.onei.servicesapp.repositrys.BankFormSubmitRepositroy;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

public class BankFormActivity extends AppCompatActivity implements SignupInterface {

    Button updatebtn;
    private TextView headertxt,servicecharge,totalamt;
    private ImageView bck;
    EditText nam,addres,pas;
    ApplicationController obj;
    TextView amoubt;
    private SharedPreferences loginRememebr;
    private SharedPreferences.Editor rem;
    BankFormSubmitRepositroy BNKFRMREP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_from);
        obj=(ApplicationController)getApplicationContext();
        loginRememebr = getSharedPreferences(
                String.format("%s_preferences", getPackageName()),
                Context.MODE_PRIVATE);
        rem = loginRememebr.edit();
        BNKFRMREP=new BankFormSubmitRepositroy(BankFormActivity.this, RetrofitRequrest.ProgressForDriver(BankFormActivity.this),this);
        updatebtn=(Button)findViewById(R.id.updatebtn);
        nam = (EditText) findViewById(R.id.nam);
        addres = (EditText) findViewById(R.id.addres);
        pas = (EditText) findViewById(R.id.pas);
        servicecharge = (TextView) findViewById(R.id.servicecharge);
        totalamt = (TextView) findViewById(R.id.totalamt);
        servicecharge.setText("Service Charge: "+obj.getServiceCharges());
        totalamt.setText("Total Amount: NGN"+obj.getTotalPaymentAmount());
        amoubt = (TextView) findViewById(R.id.amoubt);
        amoubt.setText(" Amount: NGN"+obj.getAmount());
       // nam.setText(obj.getcFirstName());
       // addres.setText(obj.getcAddress());
        headertxt=(TextView)findViewById(R.id.headertxt);
       // pas.setText(obj.getcPass());
        bck=(ImageView) findViewById(R.id.bck);
        headertxt.setText("Bank Form");
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
             //BankFormSubmit(@Field("reqid") String reqid,
                // @Field("uid") String uid,
                // @Field("bank_name") String bank_name,
                // @Field("account_name") String account_name,
                // @Field("account_number") String account_number,
                // @Field("amount") String amount);
                int total=Integer.parseInt(obj.getAmount())+Integer.parseInt(obj.getServiceCharges());
                BNKFRMREP.submitBankDetsils(obj.getRid(),obj.getuId(),nam.getText().toString(),addres.getText().toString(),pas.getText().toString(),""+total);
            }
        });
    }

    @Override
    public void SingupSuccess(String msg) {
        rem.putString("rid",obj.getRid());
        rem.apply();
        rem.commit();
      //  Toast.makeText(BankFormActivity.this,""+msg,Toast.LENGTH_LONG).show();
        startActivity(new Intent(BankFormActivity.this,SatisfyActivity.class));
        finish();
    }

    @Override
    public void SignupFailed(String msg) {
        Toast.makeText(BankFormActivity.this,""+msg,Toast.LENGTH_LONG).show();
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
