package com.np.onei.servicesapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.intfc.MakePayInterface;
import com.np.onei.servicesapp.models.CLoginResponse;
import com.np.onei.servicesapp.repositrys.MakePaymentRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.servicesapp.ui.BankFormActivity;
import com.np.onei.servicesapp.ui.ContactUsActivity;
import com.np.onei.servicesapp.ui.EnqryFormActivity;
import com.np.onei.servicesapp.ui.HistoryActivity;
import com.np.onei.servicesapp.ui.LoginActivity;
import com.np.onei.servicesapp.ui.NotificationActivity;
import com.np.onei.servicesapp.ui.PaymentActivity;
import com.np.onei.servicesapp.ui.ProfileActivity;
import com.np.onei.servicesapp.ui.Profile_tech;
import com.np.onei.utils.ApplicationController;
import com.np.onei.utils.SingletonObjectAccess;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MakePayInterface {


    TextView namelogin,profilebtn;
    ApplicationController obj;
    List<CLoginResponse> Clobj=new ArrayList<>();
    LinearLayout enryfrmbtn,histryls,notify,logoutbtn;
    MakePaymentRepositry MPRObj;
    private SharedPreferences loginRememebr;
    private SharedPreferences.Editor rem;
    ImageView cotact;
    int selectpaymentMode=1;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        loginRememebr = getSharedPreferences(
                String.format("%s_preferences", getPackageName()),
                Context.MODE_PRIVATE);
        rem = loginRememebr.edit();
        obj=(ApplicationController)getApplicationContext();
        MPRObj=new MakePaymentRepositry(MainActivity.this, RetrofitRequrest.ProgressForDriver(MainActivity.this),this);
        namelogin=(TextView)findViewById(R.id.namelogin);
        profilebtn=(TextView)findViewById(R.id.profilebtn);
        enryfrmbtn=(LinearLayout) findViewById(R.id.enryfrmbtn);
        logoutbtn=(LinearLayout) findViewById(R.id.logoutbtn);
        notify=(LinearLayout) findViewById(R.id.notify);
        histryls=(LinearLayout) findViewById(R.id.histryls);
        cotact=(ImageView) findViewById(R.id.cotact);

        cotact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            }
        });

        enryfrmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnqryFormActivity.class));
            }
        });
        histryls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });
        Clobj=obj.getCloginObject();
        namelogin.setText(Clobj.get(0).getCFirstName()+" "+Clobj.get(0).getCLastName());
        MPRObj.getCompletePendingJobs(obj.getuId());

    }

    @Override
    public void PaySuccess(String amount,String rid,String serviceCharges) {

        String storerid=loginRememebr.getString("rid", "0");
        if(! storerid.equals(rid)) {
            try {


            dialog= SingletonObjectAccess.DialogObjectReturn(MainActivity.this);
            //  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.payment_popup);
            final RadioButton[] radiobuttionpaymode = {null};
            Button ok = (Button) dialog.findViewById(R.id.pay);
            TextView ridtxt = (TextView) dialog.findViewById(R.id.rid);
            LinearLayout close = (LinearLayout) dialog.findViewById(R.id.close);
            TextView paytxt = (TextView) dialog.findViewById(R.id.paytxt);
            TextView charges = (TextView) dialog.findViewById(R.id.charges);
            TextView total = (TextView) dialog.findViewById(R.id.total);
            RadioGroup paymode = (RadioGroup) dialog.findViewById(R.id.paymode);

            ridtxt.setText("Customer request: # " + rid);
            paytxt.setText("Due Payment: " + amount);
            charges.setText("Service Charge: " + serviceCharges);
            int totalVal = Integer.parseInt(amount) + Integer.parseInt(serviceCharges);
            obj.setTotalPaymentAmount("" + totalVal);
            total.setText("NGN " + totalVal);
           /* if (loginRememebr.getString("paymode", "0").equals("1") && loginRememebr.getString("rid", "0").equals(rid)) {

                ok.setText("Waiting...");
                // ok.setClickable(false);
                ok.setEnabled(false);
            } else {

                ok.setClickable(false);
            }*/
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finish();
                }
            });
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    obj.setAmount(amount);
                    obj.setRid(rid);
                    obj.setServiceCharges(serviceCharges);
                    int selectedId = paymode.getCheckedRadioButtonId();
                    radiobuttionpaymode[0] = (RadioButton) dialog.findViewById(selectedId);

                    obj.setReqId(rid);
                    if (radiobuttionpaymode[0].getText().equals("Bank Payment")) {
                        rem.putString("paymode", "1");

                        rem.putString("rid", rid);
                        rem.apply();
                        rem.commit();
                        //Toast.makeText(MainActivity.this,radiobuttionpaymode[0].getText(),Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, BankFormActivity.class));
                        dialog.dismiss();
                    } else if (radiobuttionpaymode[0].getText().equals("Online Payment")) {
                        rem.putString("paymode", "2");
                        rem.putString("rid", rid);
                        rem.apply();
                        rem.commit();
                        //Toast.makeText(MainActivity.this,radiobuttionpaymode[0].getText(),Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, PaymentActivity.class));
                        dialog.dismiss();
                    } else {
                        Toast.makeText(MainActivity.this, "Please select payment mode!!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MPRObj.getCompletePendingJobs(obj.getuId());
    }

    @Override
    public void PayFailed(String msg) {

    }

    @Override
    public void RequestProgressShow(ProgressDialog pd) {

    }

    @Override
    public void RequestProgressFinish(ProgressDialog pd) {

    }

}