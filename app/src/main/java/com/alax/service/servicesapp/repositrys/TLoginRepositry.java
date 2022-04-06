package com.np.onei.servicesapp.repositrys;

import android.app.ProgressDialog;
import android.content.Context;

import com.np.onei.servicesapp.intfc.LoginInterface;
import com.np.onei.servicesapp.intfc.TLoginInterface;
import com.np.onei.servicesapp.models.CLoginWrapper;
import com.np.onei.servicesapp.models.TLoginWrapper;
import com.np.onei.servicesapp.services.APIs;
import com.np.onei.utils.SingletonObjectAccess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TLoginRepositry {
    Context cnt;
    ProgressDialog pd;
    TLoginInterface LI;

    public TLoginRepositry(Context cnt, ProgressDialog pd, TLoginInterface LI) {
        this.cnt = cnt;
        this.pd = pd;
        this.LI = LI;
    }
    public void CloginInvok(String email,String pas){
        LI.RequestProgressShow(pd);
        APIs apiservice= SingletonObjectAccess.getApiService();
        Call<TLoginWrapper> call=apiservice.getTlogin(email,pas);
        call.enqueue(new Callback<TLoginWrapper>() {
            @Override
            public void onResponse(Call<TLoginWrapper> call, Response<TLoginWrapper> response) {
                if(response.body().getResponse().get(0).getStatus().equals("1"))
                {
                    LI.SingupSuccess(response.body().getResponse());
                    LI.RequestProgressFinish(pd);
                }else
                {
                    LI.RequestProgressFinish(pd);
                    LI.SignupFailed(response.body().getResponse().get(0).getMessage());
                }
            }

            @Override
            public void onFailure(Call<TLoginWrapper> call, Throwable t) {
                LI.SignupFailed(t.toString());
            }
        });


    }
}
