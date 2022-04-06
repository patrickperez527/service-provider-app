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
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.models.TechPendingListItems;
import com.np.onei.servicesapp.ui.DetailReqActivity;
import com.np.onei.utils.ApplicationController;

import java.util.List;

public class EnquiryHistoryAdapter extends RecyclerView
        .Adapter<EnquiryHistoryAdapter
        .DataObjectHolder> {
   Context cntext;
   ApplicationController obj;
    Typeface sonictonicfonts;
    private static String LOG_TAG = "CategoryRecyclerViewAdapter";
    private List<TechPendingListItems> mDataset;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
           {
        TextView odrId,servicename,tech,Works,payment;


        public DataObjectHolder(View itemView) {
            super(itemView);
            odrId = (TextView) itemView.findViewById(R.id.odrId);
            servicename = (TextView) itemView.findViewById(R.id.servicename);
            tech = (TextView) itemView.findViewById(R.id.tech);
            Works = (TextView) itemView.findViewById(R.id.Works);
            payment = (TextView) itemView.findViewById(R.id.payment);


            //Log.i(LOG_TAG, "Adding Listener");

        }


    }


    public EnquiryHistoryAdapter(Context cnt, List<TechPendingListItems> myDataset) {
        mDataset = myDataset;
        cntext=cnt;
        obj=(ApplicationController)cntext.getApplicationContext();
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.enquiry_history_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
       // cntext=parent.getContext();
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

     // TextView cname,odrId,wrks,pro_area_name,servicename,cadres,cmob;
     //   holder.cname.setText(mDataset.get(position).getCFirstName()+" "+mDataset.get(position).getCLastName());
        holder.odrId.setText(mDataset.get(position).getEId()+"   "+mDataset.get(position).getECreated()+" ");
//        holder.wrks.setText(mDataset.get(position).getDetails());
//        holder.pro_area_name.setText(mDataset.get(position).getProName());
//        holder.servicename.setText(mDataset.get(position).getSName());
//        holder.cadres.setText(mDataset.get(position).getCAddress());
//        holder.cmob.setText(mDataset.get(position).getCPhone());


        holder.odrId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.setCustomerName(mDataset.get(position).getCFirstName()+" "+mDataset.get(position).getCLastName());
                obj.setReqId(mDataset.get(position).getEId());
                obj.setWorkingDetails(mDataset.get(position).getDetails());
                obj.setProfessionalArea(mDataset.get(position).getProName());
                obj.setServiceName(mDataset.get(position).getSName());
                obj.setCustomerAddress(mDataset.get(position).getCAddress());
                obj.setCustomerMob(mDataset.get(position).getCPhone());
                cntext.startActivity(new Intent(cntext, DetailReqActivity.class));
            }
        });
    }

    public void addItem(TechPendingListItems dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}