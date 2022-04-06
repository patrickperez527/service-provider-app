package com.np.onei.servicesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.np.onei.servicesapp.R;

public class SplashActivity extends AppCompatActivity {

    private TextView headertxt;
    private ImageView bck;
    private Button bkg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spl);

        Thread spl=new Thread(){
            public void run() {
                try{
                    sleep(3000);

                    Intent indexscreen = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(indexscreen);
                    finish();
                }
                catch(Exception e)
                {

                }

            };
        };
        spl.start();
    }
}
