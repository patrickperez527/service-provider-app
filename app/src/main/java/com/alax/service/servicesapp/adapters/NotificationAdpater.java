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

import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.models.CategoryModel;
import com.np.onei.servicesapp.models.NotificationListItems;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdpater extends RecyclerView
        .Adapter<NotificationAdpater
        .DataObjectHolder> {
   Context cntext;
    Typeface sonictonicfonts;
    private static String LOG_TAG = "CategoryRecyclerViewAdapter";
    private List<NotificationListItems> mDataset;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
             {
        TextView status,textTitle,msg;


        public DataObjectHolder(View itemView) {
            super(itemView);
            status = (TextView) itemView.findViewById(R.id.status);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            msg = (TextView) itemView.findViewById(R.id.msg);

        }


    }


    public NotificationAdpater(Context cnt, List<NotificationListItems> myDataset) {
        mDataset = myDataset;
        cntext=cnt;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
       // cntext=parent.getContext();
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

       holder.status.setText(mDataset.get(position).getNCreated());
       holder.textTitle.setText(mDataset.get(position).getNTitle());
       holder.msg.setText(mDataset.get(position).getNMessage());

    }

    public void addItem(NotificationListItems dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        int sizeret=0;
        try {
            sizeret= mDataset.size();
        }catch (Exception e)
        {
            e.printStackTrace();
            sizeret=0;
        }
        return sizeret;
    }


}