package com.np.onei.servicesapp.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.repositrys.SignupRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.SingletonObjectAccess;

public class SignupActivity extends AppCompatActivity implements SignupInterface {

    SignupRepositry SrepObj;
    EditText fname,lname,mob,adrs,mail,pas;
    Button sigup;
    CheckBox tmscondtcheck;
    TextView tc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SrepObj=new SignupRepositry(SignupActivity.this, RetrofitRequrest.ProgressForDriver(SignupActivity.this),this);

        setContentView(R.layout.signup);
        sigup=(Button)findViewById(R.id.sigupbtn);
        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        mob=(EditText)findViewById(R.id.mob);
        adrs=(EditText)findViewById(R.id.adrs);
        mail=(EditText)findViewById(R.id.mail);
        pas=(EditText)findViewById(R.id.pas);
        tc=(TextView)findViewById(R.id.tc);

        tmscondtcheck=(CheckBox)findViewById(R.id.tmscondtcheck);
        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,TermsActivity.class));
                finish();
            }
        });
        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fname.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Mandatory fields",
                            Toast.LENGTH_LONG).show();
                }
               else if(lname.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Mandatory fields",
                            Toast.LENGTH_LONG).show();
                }
                else if(mob.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Mandatory fields",
                            Toast.LENGTH_LONG).show();
                }
                else if(adrs.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Mandatory fields",
                            Toast.LENGTH_LONG).show();
                }
                else if(mail.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Mandatory fields",
                            Toast.LENGTH_LONG).show();
                }
                else if(pas.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Mandatory fields",
                            Toast.LENGTH_LONG).show();
                }
                else if(!tmscondtcheck.isChecked()) {
                    Toast.makeText(SignupActivity.this, "Accepte terms conditions ",
                            Toast.LENGTH_LONG).show();
                }
                else {

                    SrepObj.invokedSignup(fname.getText().toString(), lname.getText().toString(), mob.getText().toString()
                            , adrs.getText().toString(), mail.getText().toString(), pas.getText().toString());
                }
            }
        });
    }

    @Override
    public void SingupSuccess(String msg) {

        Dialog dialog = SingletonObjectAccess.DialogObjectReturn(SignupActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.successmsg_getusername);
        Button ok=(Button)dialog.findViewById(R.id.logn);
        TextView usname=(TextView)dialog.findViewById(R.id.usname);
        usname.setText("UserName: "+msg);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
                dialog.dismiss();
            }
        });
        dialog.show();
        Toast.makeText(SignupActivity.this,""+msg,Toast.LENGTH_LONG).show();

    }

    @Override
    public void SignupFailed(String msg) {
        Toast.makeText(SignupActivity.this,""+msg,Toast.LENGTH_LONG).show();
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
