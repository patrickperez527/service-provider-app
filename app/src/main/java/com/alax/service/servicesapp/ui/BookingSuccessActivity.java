package com.np.onei.servicesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;

public class BookingSuccessActivity extends AppCompatActivity {

    private TextView headertxt;
    private ImageView bck;
    private Button bkg,donebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_success);
        donebtn=(Button)findViewById(R.id.donebtn);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingSuccessActivity.this, MainActivity.class));
                finish();
            }
        });
       /* bkg=(Button)findViewById(R.id.bkg);
        headertxt=(TextView)findViewById(R.id.headertxt);
        bck=(ImageView) findViewById(R.id.bck);
        headertxt.setText("Booking");
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
        });*/

    }
}
