package com.np.onei.servicesapp.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.MainActivity;
import com.np.onei.servicesapp.R;
import com.np.onei.utils.ApplicationController;

public class ContactUsActivity extends AppCompatActivity {

    TextView headertxt;
    ImageView mail,pho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        headertxt=(TextView) findViewById(R.id.headertxt);
        headertxt.setText("Contact Us");
        mail=(ImageView)findViewById(R.id.mail);
        pho=(ImageView)findViewById(R.id.pho);
        headertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","servicedesk@247workman.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "For Support");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
        pho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPermissionGranted()){
                    call_action();
                }
            }
        });




    }

    public void call_action(){
        String phnum = "+2348141240001";
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phnum));
        startActivity(callIntent);
    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
