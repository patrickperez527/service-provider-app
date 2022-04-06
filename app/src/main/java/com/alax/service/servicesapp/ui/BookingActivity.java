package com.np.onei.servicesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.np.onei.servicesapp.R;

public class BookingActivity extends AppCompatActivity {


    private TextView headertxt;
    private ImageView bck;
    private Button bkg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);
        bkg=(Button)findViewById(R.id.bkg);
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
        });
        bkg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingActivity.this, BookingSuccessActivity.class));
            }
        });
    }
}
