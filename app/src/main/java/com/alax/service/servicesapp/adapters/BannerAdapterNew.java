package com.np.onei.servicesapp.adapters;

/**
 * Created by Lannet1 on 4/4/2019.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.np.onei.servicesapp.R;

import java.util.ArrayList;


public class BannerAdapterNew extends PagerAdapter {
    Context context;
  //  int images[];
    LayoutInflater layoutInflater;

    private ArrayList<String> bannerImg=new ArrayList<String>();
    public BannerAdapterNew(Context context, ArrayList<String> bannerImg1) {
        this.context = context;
        this.bannerImg = bannerImg1;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bannerImg.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.banner_slider_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        Picasso.with(context)
                .load(bannerImg.get(position))
                .placeholder(R.drawable.logosmall) //this is optional the image to display while the url image is downloading
                .error(R.drawable.logosmall)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(imageView);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}