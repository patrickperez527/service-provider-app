/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.np.onei.servicesapp.adapters;

import android.content.Context;
import android.graphics.Typeface;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.np.onei.utils.FontObjectSingleton;
import com.squareup.picasso.Picasso;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.models.CategoryModel;


import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView
        .Adapter<CategoryRecyclerViewAdapter
        .DataObjectHolder> {
    ArrayList<String>Imagess=new ArrayList<String>();
    ArrayList<String>ImagessNameList=new ArrayList<String>();

   Context cntext;
    Typeface sonictonicfonts;
    private static String LOG_TAG = "CategoryRecyclerViewAdapter";
    private ArrayList<CategoryModel> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        ImageView imgct;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            imgct=(ImageView)itemView.findViewById(R.id.imgct);

            //Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public CategoryRecyclerViewAdapter(Context cnt, ArrayList<CategoryModel> myDataset) {
        ImagessNameList.add("Coworing-Adheri East");
        ImagessNameList.add("Coworing-Delhi");
        ImagessNameList.add("Coworing-Noida");
        ImagessNameList.add("Coworing-Meerut");
        ImagessNameList.add("Coworing-Gorkhapur");
        ImagessNameList.add("Coworing-Varansi");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/tru5.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/tru6.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/true3.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/true4.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/tue1.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/tue2.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/tue2.png");
        Imagess.add("http://demo.lannettechnology.net/test/imagbanner/tue2.png");
        mDataset = myDataset;
        cntext=cnt;


    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
       // cntext=parent.getContext();
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        sonictonicfonts = FontObjectSingleton.fontGet(cntext);  //Typeface.createFromAsset(cntext.getAssets(), "fonts/avenir_light.ttf");
      holder.label.setText(ImagessNameList.get(position));
        holder.label.setTypeface(sonictonicfonts);

       // holder.dateTime.setText(mDataset.get(position).getmText2());
       //holder.dateTime.setTypeface(sonictonicfonts);

        Picasso.with(cntext)
                .load(Imagess.get(position))
                .placeholder(R.drawable.logosmall) //this is optional the image to display while the url image is downloading
                .error(R.drawable.logosmall)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(holder.imgct);


    }

    /*public void addItem(CategoryModel dataObj, int index) {
        ImagessNameList.add(index, dataObj);
        notifyItemInserted(index);
    }*/

    public void deleteItem(int index) {
        ImagessNameList.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return ImagessNameList.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}