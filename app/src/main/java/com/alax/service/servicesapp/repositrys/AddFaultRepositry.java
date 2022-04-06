package com.np.onei.servicesapp.repositrys;

import android.app.ProgressDialog;
import android.content.Context;

import com.np.onei.servicesapp.intfc.AddFaultInterface;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.models.AddFaultWrapper;
import com.np.onei.servicesapp.models.CLoginWrapper;
import com.np.onei.servicesapp.models.FaultListWrapper;
import com.np.onei.servicesapp.services.APIs;
import com.np.onei.utils.SingletonObjectAccess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFaultRepositry {
    Context cnt;
    ProgressDialog pd;
    AddFaultInterface LI;

    public AddFaultRepositry(Context cnt, ProgressDialog pd, AddFaultInterface LI) {
        this.cnt = cnt;
        this.pd = pd;
        this.LI = LI;
    }
    public void addfault(String eid,String cid,String tid, String faultDetails){
        LI.RequestProgressShow(pd);
        APIs apiservice= SingletonObjectAccess.getApiService();
        Call<AddFaultWrapper> call=apiservice.addfaultbyTech( eid, cid, tid,  faultDetails);
        call.enqueue(new Callback<AddFaultWrapper>() {
            @Override
            public void onResponse(Call<AddFaultWrapper> call, Response<AddFaultWrapper> response) {
                if(response.body().getResponse().getStatus().equals("1"))
                {
                    LI.AddFaultSuccess(response.body().getResponse().getMessage());
                    LI.RequestProgressFinish(pd);
                }else
                {
                    LI.RequestProgressFinish(pd);
                    LI.AddFaultFailed(response.body().getResponse().getMessage());
                }
            }

            @Override
            public void onFailure(Call<AddFaultWrapper> call, Throwable t) {
                LI.AddFaultFailed(t.toString());
            }
        });


    }


}
