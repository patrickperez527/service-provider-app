package com.np.onei.servicesapp.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.np.onei.servicesapp.R;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    private List<String> dataset;
    private NiceSpinner niceSpinner;
    private LinearLayout s1,s2,s3,s4,s5;
    private TextView st1,st2,st3,st4,st5;
    private TextView headertxt;
    private ImageView bck;
    private Button applybn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        s1=(LinearLayout)findViewById(R.id.s1);
        s2=(LinearLayout)findViewById(R.id.s2);
        s3=(LinearLayout)findViewById(R.id.s3);
        s4=(LinearLayout)findViewById(R.id.s4);
        s5=(LinearLayout)findViewById(R.id.s5);

        st1=(TextView)findViewById(R.id.st1);
        st2=(TextView)findViewById(R.id.st2);
        st3=(TextView)findViewById(R.id.st3);
        st4=(TextView)findViewById(R.id.st4);
        st5=(TextView)findViewById(R.id.st5);
        headertxt=(TextView)findViewById(R.id.headertxt);
        bck=(ImageView) findViewById(R.id.bck);
        applybn=(Button)findViewById(R.id.applybn);

        headertxt.setText("Filter ");
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

        applybn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
        st1.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
        st2.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
        st3.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
        st4.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
        st5.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
        s1.setBackgroundResource(R.drawable.star_radius);
        s2.setBackgroundResource(R.drawable.star_radius);
        s3.setBackgroundResource(R.drawable.star_radius);
        s4.setBackgroundResource(R.drawable.star_radius);
        s5.setBackgroundResource(R.drawable.star_radius);
        niceSpinner= (NiceSpinner) findViewById(R.id.nice_spinner);
        dataset= new LinkedList<>(Arrays.asList("CABINS", "MEETING ROOMS", "FLEXIBLE SEATS", "FIXED SEATS", "VIRTUAL OFFICES","BULK MEETING HOUSE","NATIONAL PASS"));
        niceSpinner.attachDataSource(dataset);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setBackgroundResource(R.drawable.selected_star_radius);
                s2.setBackgroundResource(R.drawable.star_radius);
                s3.setBackgroundResource(R.drawable.star_radius);
                s4.setBackgroundResource(R.drawable.star_radius);
                s5.setBackgroundResource(R.drawable.star_radius);
                st1.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.whitecolor));
                st2.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st3.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st4.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st5.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setBackgroundResource(R.drawable.star_radius);
                s2.setBackgroundResource(R.drawable.selected_star_radius);
                s3.setBackgroundResource(R.drawable.star_radius);
                s4.setBackgroundResource(R.drawable.star_radius);
                s5.setBackgroundResource(R.drawable.star_radius);
                st1.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st2.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.whitecolor));
                st3.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st4.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st5.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setBackgroundResource(R.drawable.star_radius);
                s2.setBackgroundResource(R.drawable.star_radius);
                s3.setBackgroundResource(R.drawable.selected_star_radius);
                s4.setBackgroundResource(R.drawable.star_radius);
                s5.setBackgroundResource(R.drawable.star_radius);
                st1.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st2.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st3.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.whitecolor));
                st4.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st5.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setBackgroundResource(R.drawable.star_radius);
                s2.setBackgroundResource(R.drawable.star_radius);
                s3.setBackgroundResource(R.drawable.star_radius);
                s4.setBackgroundResource(R.drawable.selected_star_radius);
                s5.setBackgroundResource(R.drawable.star_radius);

                st1.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st2.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st3.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st4.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.whitecolor));
                st5.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setBackgroundResource(R.drawable.star_radius);
                s2.setBackgroundResource(R.drawable.star_radius);
                s3.setBackgroundResource(R.drawable.star_radius);
                s4.setBackgroundResource(R.drawable.star_radius);
                s5.setBackgroundResource(R.drawable.selected_star_radius);
                st1.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st2.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st3.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st4.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.blackColor));
                st5.setTextColor(ContextCompat.getColor(FilterActivity.this, R.color.whitecolor));
            }
        });
    }
}
