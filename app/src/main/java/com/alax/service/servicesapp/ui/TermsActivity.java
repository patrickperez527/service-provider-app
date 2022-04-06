package com.np.onei.servicesapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.np.onei.servicesapp.R;

public class TermsActivity extends AppCompatActivity {
	
	LinearLayout bck;
	WebView wv;
	TextView hearweb;
    AppCompatActivity manual_child;
    TextView number_edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.mytc);
        wv = (WebView)findViewById(R.id.viewpages);
        wv.loadUrl("file:///android_asset/termscond_24.html");

	}

}
